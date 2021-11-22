package work.hello.data;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private int JobId;
    private String Details;
    private static final Gson gson = new Gson();
    private String employeEmail;
    private String employerEmail;
    private Status Status;
    private String Name;
    private Map<String, String> Files;


    public Application(int jobId, String details,String EmployeEmail,String EmployerEmail,String job, Map<String,String> Files) {
        JobId = jobId;
        Details = details;
        employeEmail = EmployeEmail;
        employerEmail = EmployerEmail;
        Status = work.hello.data.Status.Waiting;
        this.Files = Files;
        Name =  job;

    }

    public String getEmployeeEmail() {
        return employeEmail;
    }

    public void setEmployeeEmail(String employee) {
        employeEmail = employee;
    }

    public int getJobID() {
        return JobId;
    }

    public void setJobID(int jobID) {
        JobId = jobID;
    }

    public String getApplication() {
        return Details;
    }

    public void setApplication(String details) {
        Details = details;
    }

    public String toJson() {
        return gson.toJson(this);
    }


    public static Application fromJson(String json) {
        Application application = gson.fromJson(json, Application.class);
        application.Status = work.hello.data.Status.Waiting;
        System.out.println(application.Status);
        return application;
    }

    public Map<String, String> getFiles() {
        return this.Files;
    }

    public void setFiles(Map<String, String> files) {
        this.Files = files;
    }

    public boolean validate() {
        return getJobID() >= 0 && getJobID() != 0 && getApplication() != null && getApplication().length() > 1;
    }

}
