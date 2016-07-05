/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import Client.App.YouthOnCallClient;
import Client.Model.Jobs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author co075oh
 */
public class JobsControl {
    
    // Define attributes
    String[] columns = {"ID", "Job", "Description", "Pay", "Member", "Youth", "Est. Hours", "Status"};
    
    public void createJob() {
        
    }
    
    public void updateJob(Jobs job) throws IOException {
        Gson jobGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER, YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("updateJob");
            outputStream.println(jobGSON.toJson(job, Jobs.class));
        }
    }
    
    public Jobs retrieveJob(int jobID) throws IOException {
        Jobs job;
        String jobJSON;
        Gson jobGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER, YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveJob");
            outputStream.println(jobID);
            jobJSON = inputStream.nextLine();
            job = jobGSON.fromJson(jobJSON, Jobs.class);
        }
        return job;
    }
    
    public Object[][] retrieveAllJobs() throws IOException {
        List<Jobs> allJobs;
        String allJobsJSON;
        Gson allJobsGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER,YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveAllJobs");
            allJobsJSON = inputStream.nextLine();
            allJobs = allJobsGSON.fromJson(allJobsJSON, new TypeToken<List<Jobs>>(){}.getType());
        }
        
        int i = 0;
        Object[][] jobs = new Object[allJobs.size()][];
        for (Jobs job : allJobs) {
            Object[] individualJob = {
                job.getId(),
                job.getName(),
                job.getDescription(),
                job.getPay(),
                job.getMemberID(),
                job.getYouthID(),
                job.getEstHours(),
                job.getStatus()
            };
            jobs[i] = individualJob;
            i++;
        }
        return jobs;
    }
    
    public String[] retrieveColumns() {
        return columns;
    }

}
