package work.hello.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Application.
 */
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

    /**
     * Instantiates a new Application.
     *
     * @param Id            the id
     * @param jobId         the job id
     * @param details       the details
     * @param EmployeEmail  the employe email
     * @param status        the status
     * @param EmployerEmail the employer email
     * @param job           the job
     * @param Files         the files
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Gets employee email.
     *
     * @return the employee email
     */
    public String getEmployeeEmail() {
        return employeEmail;
    }

    /**
     * Sets employee email.
     *
     * @param employee the employee
     */
    public void setEmployeeEmail(String employee) {
        employeEmail = employee;
    }

    /**
     * Gets job id.
     *
     * @return the job id
     */
    public int getJobID() {
        return JobId;
    }

    /**
     * Sets job id.
     *
     * @param jobID the job id
     */
    public void setJobID(int jobID) {
        JobId = jobID;
    }

    /**
     * Gets application.
     *
     * @return the application
     */
    public String getApplication() {
        return Details;
    }

    /**
     * Sets application.
     *
     * @param details the details
     */
    public void setApplication(String details) {
        Details = details;
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
        return gson.toJson(this);
    }


    /**
     * From json application.
     *
     * @param json the json
     * @return the application
     */
    public static Application fromJson(String json) {
        Application application = gson.fromJson(json, Application.class);
        return application;
    }

    /**
     * Gets files.
     *
     * @return the files
     */
    public ArrayList<String>  getFiles() {
        return this.Files;
    }

    /**
     * Sets files.
     *
     * @param files the files
     */
    public void setFiles(ArrayList<String> files) {
        this.Files = files;
    }

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    public boolean validate() {
        return getJobID() >= 0 && getJobID() != 0 && getApplication() != null && getApplication().length() > 1;
    }

}
