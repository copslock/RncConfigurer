package com.service;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.Properties;

public class ConnectionThroughJschExample {
  public static void main(String[] args) throws IOException {
    JSch jsch = new JSch();
    Properties props = new Properties();
    InputStream is = new FileInputStream("/home/atian/Documents/arturProjects/RncConfigurerParser/src/main/resources/ssh.properties");
    props.load(is);

    Session session;

    try {
      session = jsch.getSession(props.getProperty("ssh.login"), "elfdev4.dev.ict", 22);
      session.setConfig("StrictHostKeyChecking", "no");

      session.setPassword(props.getProperty("ssh.password"));
      session.connect();

      ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

      channelExec.setCommand("ls /opt/");
      channelExec.connect();

      InputStream in = channelExec.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
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
  }
}
