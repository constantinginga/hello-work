package work.hello.persistance;

import work.hello.data.*;

import java.util.ArrayList;

/**
 * The interface Mongo database.
 */
public interface MongoDB {

    /**
     * Create saved job listing in db.
     *
     * @param savedJobListing the saved job listing
     */
    void createSavedJobListing(SavedJobListing savedJobListing);

    /**
     * Gets saved job listings from db.
     *
     * @return the saved job listings
     */
    ArrayList<SavedJobListing> getSavedJobListings();

    /**
     * Delete saved job listings in db.
     *
     * @param id the id of saved job listing
     */
    void deleteSavedJobListing(String id);

    /**
     * Gets job listings.
     *
     * @return the job listings
     */
    ArrayList<JobListing> getJobListings();

    /**
     * Gets job listing with id.
     *
     * @param id the id of job listing
     * @return the job listing
     */
    JobListing getJobListing(String id);

    /**
     * Gets applications from db.
     *
     * @return the applications
     */
    ArrayList<Application> getApplications();

    /**
     * Gets application by id.
     *
     * @param id the id of application
     * @return the application
     */
    Application getApplication(String id);

    /**
     * Update application in db.
     *
     * @param application the updated application
     * @return the updated application
     */
    Application updateApplication(Application application);

    /**
     * Apply to  job listing in db.
     *
     * @param application the application
     */
    void applyJobListing(Application application);

    /**
     * Create job listing in db.
     *
     * @param jobListing the job listing to be created
     */
    void createJobListing(JobListing jobListing);

    /**
     * Update job listing in db.
     *
     * @param jobListing the job listing updated
     * @return the job listing updated
     */
    JobListing updateJobListing(JobListing jobListing);

    /**
     * Gets user from db.
     *
     * @param email    the email of user
     * @param password the password of user
     * @return the user
     */
    User getUser(String email, String password);

    /**
     * Gets job seeker from db.
     *
     * @param email the email of job seeker
     * @return the job seeker
     */
    JobSeeker getJobSeeker(String email);

    /**
     * Gets employer from db.
     *
     * @param email the email of employer
     * @return the employer
     */
    Employer getEmployer(String email);

    /**
     * Create job seeker in db.
     *
     * @param seeker the seeker
     * @return the newly created job seeker
     */
    JobSeeker createJobSeeker(JobSeeker seeker);

    /**
     * Update job seeker in db.
     *
     * @param seeker the job seeker
     * @return the updated job seeker
     */
    JobSeeker updateJobSeeker(JobSeeker seeker);

    /**
     * Delete job seeker in db.
     *
     * @param id the id
     */
    void deleteJobSeeker(String id);

    /**
     * Creates employer in db.
     *
     * @param employer the employer
     * @return the  employer
     */
    Employer createEmployer(Employer employer);

    /**
     * Update employer in db.
     *
     * @param employer the employer
     * @return the updatd employer
     */
    Employer updateEmployer(Employer employer);

    /**
     * Delete employer in db.
     *
     * @param employerId the id of employer
     */
    void deleteEmployer(String employerId);

    /**
     * Remove job listing in db.
     *
     * @param jobId the id of job
     */
    void removeJobListing(String jobId);

    /**
     * Upload application file to db.
     *
     * @param applicationFile the application file
     */
    void uploadApplicationFile(ApplicationFile applicationFile);

    /**
     * Gets application file.
     *
     * @param applicationId the application id
     * @param fileName      the file name
     * @return the application file
     */
    String getApplicationFile(String applicationId, String fileName);
}
