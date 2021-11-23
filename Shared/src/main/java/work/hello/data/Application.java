package work.hello.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private int JobId;
    private String Details;
    private static final Gson gson = new Gson();
    private String employeEmail;
    private String employerEmail;
    private int Status;
    private String Name;
    private int Id;

    private ArrayList<String> Files;

    public Application(int Id,int jobId, String details,String EmployeEmail,int status,String EmployerEmail,String job, ArrayList<String>  Files) {
        JobId = jobId;
        Details = details;
        employeEmail = EmployeEmail;
        employerEmail = EmployerEmail;
        Status = status;
        this.Files = Files;
        Name =  job;
        this.Id = Id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return application;
    }

    public ArrayList<String>  getFiles() {
        return this.Files;
    }

    public void setFiles(ArrayList<String> files) {
        this.Files = files;
    }

    public boolean validate() {
        return getJobID() >= 0 && getJobID() != 0 && getApplication() != null && getApplication().length() > 1;
    }

}
