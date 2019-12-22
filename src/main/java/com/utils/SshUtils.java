package com.utils;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SshUtils {

  private static final String file = "/home/atian/Documents/RehomeMN/rehomingTool/undo_KIER7_191118-105157.log";
  private static final String file2 = "src/main/resources/RncString.txt";

  public static List<String> generateTestData(String command, String host) {
    List<String> lines = new ArrayList<>();
    Runtime runtime = Runtime.getRuntime();

    try {
      Process p = runtime.exec("cat " + file);

      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

      while (reader.ready()) {
        String s = reader.readLine();

        if(!s.isEmpty()) {
          lines.add(s);
        }
      }
    } catch (IOException e) {
      System.out.println("some IOException");
    }

    return lines;
  }

  static List<String> getLinesFromRemoteHost(String connectingHost, List<String> commandToExecute, String some) {
    String defaultProperties = "/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/ssh.properties";
    List<String> lines = new ArrayList<>();
    JSch jsch = new JSch();
    Properties props = new Properties();
    try {
      InputStream is = new FileInputStream(defaultProperties);
      props.load(is);

      Session session;


      session = jsch.getSession(props.getProperty("ssh.login"), connectingHost, 22);
      session.setConfig("StrictHostKeyChecking", "no");

      session.setPassword(props.getProperty("ssh.password"));
      session.connect();

      ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

      channelExec.setCommand("ls /opt/");
      channelExec.connect();

      InputStream in = channelExec.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String line;
      while (reader.ready()) {
        String s = reader.readLine();

        if(!s.isEmpty()) {
          lines.add(s);
        }
      }

      int exitStatus = channelExec.getExitStatus();
      if (exitStatus > 0) {
        System.out.println("Remote script exec error! " + exitStatus);
      }
      //Disconnect the Session
      session.disconnect();
    } catch (JSchException e) {
      System.out.println("JSchException was throwed ");
    } catch (IOException e) {
      System.out.println("IOException was throwed ");
    }

    return lines;
  }

}
