package com.service;

import com.jcraft.jsch.*;
import com.model.RncModification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SshService {

  @Value("${user}")
  static String user = "dpleskac";

  @Value("${host}")
  static String host = "10.4.164.21";

  @Value("${password}")
  static String password = "Oles73Oles73";

  @Value("${port}")
  static int port = 22;

  private static final Logger LOG = LogManager.getLogger(CreationCommandsOperationService.class);

  public static void main(String[] args) throws Exception {
    long start = System.nanoTime();

    FileParsingService parseCsvFileService = new FileParsingService();
    String pathToCreationCommands = "filesOfChanges/fileOfChanges.csv";
    createFilesInRemote(parseCsvFileService.getAllFileChanges(pathToCreationCommands));

    long end = System.nanoTime();

    LOG.debug("time of execution = " + (end - start) + " nanoseconds");
  }

  public static List<String> createFilesInRemote(List<RncModification> rncNames) throws Exception {
    List<String> files = new ArrayList<>();

    JSch jsch = new JSch();     //CHAN
    Session session = jsch.getSession(user, host, port);
    session.setPassword(password);

    session.setConfig("StrictHostKeyChecking", "no");

    session.connect();

    Channel channel = session.openChannel("shell");

    OutputStream ops = channel.getOutputStream();

    String utf8 = StandardCharsets.UTF_8.name();

    PrintStream ps = new PrintStream(ops, true, utf8);

    channel.connect();
    InputStream input = channel.getInputStream();

    for (RncModification rncModification : rncNames) {
      //commands
      ps.println("amos " + rncModification.getModifications().get(0).getBSC());
      LOG.info("amos " + rncModification.getModifications().get(0).getBSC());

      printResult(input, rncModification.getModifications().get(0).getBSC());

      ps.println("LT ALL");
      LOG.info("LT ALL");

      printResult(input, "Total:");

      ps.println("us+");
      LOG.info("us+");

      printResult(input, "Starting the simulated undo mode");

      ps.println("us?");
      LOG.info("us?");

      printResult(input, "Simulated Undo Mode is active");

      agreeWithConditions(ps, channel.getInputStream(), new StringBuilder("rdel iublink=" + rncModification.getModifications().get(0).getSite()));

      ps.println("us-");
      LOG.info("us-");

      final List<String> strings = printResult(channel.getInputStream(), "To undo, execute command: run /ericsson/log/amos/moshell_logfiles/dpleskac/logs_moshell/undo/");

      if (!strings.isEmpty()) {
        final String pathToFile = extractPathToFiles(strings.get(0).split("\\s"));
        System.out.println(pathToFile);
        files.add(pathToFile);
      }

      ps.println("us+");
      LOG.info("us+");

      printResult(input, "Starting the simulated undo mode", 3000);

      ps.println("us?");
      LOG.info("us?");

      printResult(input, "Simulated Undo Mode is active");

      agreeWithConditions(ps, channel.getInputStream(), new StringBuilder("rdel ExternalEutranCell=" + rncModification.getModifications().get(0).getSite()));

      ps.println("us-");
      LOG.info("us-");

      final List<String> pathToFile = printResult(channel.getInputStream(), "To undo, execute command: run /ericsson/log/amos/moshell_logfiles/dpleskac/logs_moshell/undo/");

      if (!pathToFile.isEmpty()) {
        final String file = extractPathToFiles(pathToFile.get(0).split("\\s"));
        System.out.println(file);
        files.add(file);
      }
    }


    ps.close();

    channel.disconnect();
    session.disconnect();

    return files;
  }

  static List<String> printResult(InputStream input, String comparingString) throws IOException, InterruptedException {
    Thread.sleep(1000);
    List<String> commands = new ArrayList<>();

    while (input.available() > 0) {
      Thread.sleep(150);
      byte[] bytes = new byte[1024];
      int i = input.read(bytes, 0, 1024);
      if (i < 0) break;

      commands.add(new String(bytes, 0, i));
    }

    if (!commands.isEmpty()) {
      final Optional<String> s = commands.stream().filter(e -> e.contains(comparingString)).findAny();
      if (!s.isPresent()) {
        LOG.error("comparing string doesn't found, something went wrong");

        // TODO disconnect from server or perform command again
      } else {
        LOG.info(commands);
      }
    }

    LOG.info(commands);

    return commands;
  }

  public static List<String> printResult(InputStream input, String comparingString, int waitTime) throws IOException, InterruptedException {
    Thread.sleep(waitTime);

    return printResult(input, comparingString);
  }

  static String extractPathToFiles(String[] commands) {

    final String pathToCreationCommands = Arrays.stream(commands)
      .filter(el -> el.contains(".mos"))
      .filter(el -> !el.contains("del"))
      .findFirst().get();

    return pathToCreationCommands;
  }

  static void agreeWithConditions(PrintStream printStream, InputStream inputStream, StringBuilder sb) throws IOException, InterruptedException {
    String checkPhrase = "Are you Sure [y/n]";

    for (; ; ) {
      printStream.println(sb.toString());

      final List<String> strings = SshService.printResult(inputStream, checkPhrase);

      final long count = strings.stream().filter(e -> e.contains(checkPhrase)).count();

      if (count == 0) {
        return;
      }

      boolean contains = false;

      for (int i = 1; i < 3; i++) {
        contains = strings.get(strings.size() - i).contains(checkPhrase);
        if (contains) break;
      }

      if (contains) {
        sb.append("\ny");
      } else {
        LOG.info("did strings read completely? {}", strings.get(strings.size() - 1).contains("Total"));
        printStream.println("\n");
        return;
      }
    }


  }

}
