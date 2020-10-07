package com;

import com.service.FtpService;
import com.service.SshService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.util.List;

public class Test {

    private static final Logger LOG = LogManager.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();

        FileUtils.cleanDirectory(new File("D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands"));

        final List<String> strings = SshService.connectSsh3();

        FtpService.connectViaFtp(strings.get(0), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");
        FtpService.connectViaFtp(strings.get(1), "D:\\Arthur\\My_Projects\\javaProjects\\RncConfigurerParser\\rncCreationCommands");

        long end = System.nanoTime();

        LOG.debug("time of execution = " + (end-start) + " nanoseconds");
    }
}
