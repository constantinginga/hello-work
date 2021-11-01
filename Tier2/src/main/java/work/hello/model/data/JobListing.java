package work.hello.model.data;

public class JobListing {
    private int JobID;
    private String Details;

    public JobListing(int jobID, String details) {
        JobID = jobID;
        Details = details;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int jobID) {
        JobID = jobID;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public boolean validate(JobListing jobListing)
    {
       return false;
    }

}
