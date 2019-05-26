package com.ideathon.devops.automation.services;

import com.ideathon.devops.automation.model.BuildDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Service
public class BuildServices {

    @Value("${clone_command}")
    private String gitClone;

    @Value("${maven_install_command}")
    private String mavenInstallCommand;

    @Value("${pcf_deploy_command}")
    private String pcfDeploy;


    public String build(BuildDetails buildDetails) throws Exception {
        ansibleClone(buildDetails.getGitUrl());
        Thread.sleep(2000);
        ansibleMavenBuild();
        Thread.sleep(4000);
        ansiblePCFdeploy();
        return "Successful";
    }

    private void ansibleClone(String gitUrl) throws Exception{
        Process p = Runtime.getRuntime().exec(gitClone, null, new File("F://"));
        try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
            String line;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }

    }

    private void ansibleMavenBuild() throws Exception{
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File("F://applications//workspaces//ridecell"));
        pb.command("mvn.cmd");
        pb.redirectOutput(new File("F://output1.txt"));
        Process p = pb.start();
        /*Process p = Runtime.getRuntime().exec("git", null, new File("F://devopsRepo/"));
        try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }*/
    }

    private void ansiblePCFdeploy() throws Exception {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cf");
        pb.redirectOutput(new File("F://output.txt"));
        Process p = pb.start();
    }

}
