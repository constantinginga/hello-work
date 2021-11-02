package work.hello.model.data;

import com.google.gson.Gson;

public class JobListing {
    private int JobId;
    private String Details;
    private static final Gson gson = new Gson();

    public JobListing(int jobId, String details) {
        JobId = jobId;
        Details = details;
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public boolean validate(JobListing jobListing) {
        return false;
    }

    public String toJson() {
        return gson.toJson(this);
    }


    public static JobListing fromJson(String json) {
        return gson.fromJson(json, JobListing.class);
    }

}
