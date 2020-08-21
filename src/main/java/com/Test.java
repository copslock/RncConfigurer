package com;

import com.utils.FtpUtils;
import com.utils.SshUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Test {

    private static final Logger LOG = LogManager.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();

        final List<String> strings = SshUtils.connectSsh3();

        FtpUtils.connectViaFtp(strings.get(0), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");
        FtpUtils.connectViaFtp(strings.get(1), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");

        long end = System.nanoTime();

        LOG.debug("time of execution = " + (end-start) + " nanoseconds");
    }
}
