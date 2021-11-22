package work.hello.persistance;

import work.hello.data.*;

import java.util.ArrayList;

public interface MongoDB {
    ArrayList<JobListing> getJobListings();

    JobListing getJobListing(String id);

    ArrayList<Application>getApplications();

    void applyJobListing(Application application);

    void createJobListing(JobListing jobListing);

    JobListing updateJobListing(JobListing jobListing);

    User getUser(String email, String password);

    JobSeeker getJobSeeker(String email);

    Employer getEmployer(String email);

    JobSeeker createJobSeeker(JobSeeker seeker);

    JobSeeker updateJobSeeker(JobSeeker seeker);

    void deleteJobSeeker(String id);

    Employer createEmployer(Employer employer);

    Employer updateEmployer(Employer employer);

    void deleteEmployer(String id);

    void removeJobListing(String id);

}
