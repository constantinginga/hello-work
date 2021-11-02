package work.hello.model;

import work.hello.model.data.JobListing;
import work.hello.model.data.Application;

import java.util.ArrayList;

public interface MessagingHandler {
     ArrayList<JobListing> getJobListings();
     void applyForJob(Application application);
     void createJobListing(JobListing jobListing);

}
