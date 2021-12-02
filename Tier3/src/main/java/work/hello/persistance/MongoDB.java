package work.hello.persistance;

import work.hello.data.*;

import java.util.ArrayList;

public interface MongoDB {

    void createSavedJobListing(SavedJobListing savedJobListing);

    ArrayList<SavedJobListing> getSavedJobListings();

    void deleteSavedJobListing(String id);

    ArrayList<JobListing> getJobListings();

    JobListing getJobListing(String id);

    ArrayList<Application> getApplications();

    Application getApplication(String id);

    Application updateApplication(Application application);

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

    void uploadApplicationFile(ApplicationFile fromJson);

    String getApplicationFile(String messageId, String content);
}
