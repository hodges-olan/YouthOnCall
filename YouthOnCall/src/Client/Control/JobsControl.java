/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import java.io.IOException;

/**
 *
 * @author co075oh
 */
public class JobsControl {
    
    // Define attributes
    String[] columns = {"ID", "Job", "Description", "Pay", "Member", "Youth", "Est. Hours", "Status"};
    
    public void createJob() {
        
    }
    
    public void updateJob() {
        
    }
    
    public void retrieveJob() {
        
    }
    
    public Object[][] retrieveAllJobs() throws IOException {
        Object[][] jobs = {
            {"22", "Mowing and Edging", "Mow and edge both the front and back yard.", "$20", "Olan Hodges", "None", "1 Hour", "Active"},
            {"23", "Carpet cleaning", "Clean carpet in all upstairs rooms", "$40", "Olan Hodges", "None", "2 Hour", "Active"}
        };
        return jobs;
    }
    
    public String[] retrieveColumns() {
        return columns;
    }

}
