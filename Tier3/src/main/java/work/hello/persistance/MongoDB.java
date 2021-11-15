package work.hello.persistance;

import work.hello.data.*;

import java.util.ArrayList;

public interface MongoDB {
    ArrayList<JobListing> getJobListings();

    void applyJobListing(Application application);

    void createJobListing(JobListing jobListing);

    User getUser(String email, String password);

    JobSeeker createJobSeeker(JobSeeker seeker);

    Employer createEmployer(Employer employer);
}
