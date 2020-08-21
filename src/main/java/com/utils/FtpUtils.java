package com.utils;


import com.jcraft.jsch.*;

import java.io.IOException;

public class FtpUtils {

    public static final String TEST_PATH_TO_FILE_FROM_SERVER = "/ericsson/log/amos/moshell_logfiles/dpleskac/logs_moshell/undo/undo_KITR1_200805-154825.mos";
    public static final String TEST_PATH_TO_FILE_ON_MY_PC = "C:\\Users\\atian\\Desktop\\file.mos";

    public static void main(String[] args) {

        try {
            connectViaFtp(TEST_PATH_TO_FILE_FROM_SERVER, TEST_PATH_TO_FILE_ON_MY_PC);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void connectViaFtp(String fileFromServer, String pathToFileOnMyMyPc) throws IOException, JSchException, SftpException {
        String knownHostsFilename = "C:\\Users\\atian\\.ssh\\known_hosts";

        JSch jsch = new JSch();
        jsch.setKnownHosts( knownHostsFilename );
        String user = "dpleskac";            //CHANGE ME
        String host = "10.4.164.21"; //CHANGE ME
        String passwd = "Oles73Oles73";      //CHANGE ME
        int port = 22;
        Session session = jsch.getSession(user, host, port);
        session.setPassword(passwd);

        session.setConfig("StrictHostKeyChecking", "no");

        session.connect();

        Channel channel = session.openChannel( "sftp" );
        channel.connect();

        ChannelSftp sftpChannel = (ChannelSftp) channel;

        sftpChannel.get(fileFromServer, pathToFileOnMyMyPc);

        sftpChannel.exit();
        session.disconnect();
    }
}
