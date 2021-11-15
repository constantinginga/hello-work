package work.hello.model;

import work.hello.model.data.*;

import java.util.ArrayList;


public interface Model {
    ArrayList<JobListing> getJobListings();

    void applyJobListing(Application application);

    void createJobListing(JobListing jobListing);

    User getUser(User user);

    JobSeeker createJobSeeker(JobSeeker jobSeeker);

    Employer createEmployer(Employer employer);

}
