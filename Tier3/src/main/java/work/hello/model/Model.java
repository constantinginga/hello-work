package work.hello.model;

import work.hello.model.data.Application;
import work.hello.model.data.JobListing;

import java.util.ArrayList;

public interface Model {
    ArrayList<JobListing> getJobListings();
    void applyJobListing(Application application);
    void createJobListing(JobListing jobListing);

}
