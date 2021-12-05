package work.hello.model;

import work.hello.data.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The interface Messaging handler.
 */
public interface MessagingHandler
{
  /**
   * Gets job listings.
   *
   * @return the job listings
   */
  ArrayList<JobListing> getJobListings();

  /**
   * Create saved job listing.
   *
   * @param savedJobListing the saved job listing
   */
  void createSavedJobListing(SavedJobListing savedJobListing);

  /**
   * Gets saved job listings.
   *
   * @return the saved job listings
   */
  ArrayList<SavedJobListing> getSavedJobListings();

  /**
   * Delete saved job listing.
   *
   * @param id the id
   */
  void deleteSavedJobListing(String id);

  /**
   * Gets job listing.
   *
   * @param id the id
   * @return the job listing
   */
  JobListing getJobListing(String id);

  /**
   * Apply for job.
   *
   * @param application the application
   */
  void applyForJob(Application application);

  /**
   * Update application.
   *
   * @param application the application
   */
  void updateApplication(Application application);

  /**
   * Gets applications.
   *
   * @return the applications
   */
  ArrayList<Application> getApplications();

  /**
   * Create job listing.
   *
   * @param jobListing the job listing
   */
  void createJobListing(JobListing jobListing);

  /**
   * Delete job listing boolean.
   *
   * @param id the id
   * @return the boolean
   */
  boolean deleteJobListing(String id);

  /**
   * Gets user.
   *
   * @param email    the email
   * @param password the password
   * @return the user
   * @throws Exception the exception
   */
  User getUser(String email, String password) throws Exception;

  /**
   * Gets user.
   *
   * @param email the email
   * @return the user
   * @throws Exception the exception
   */
  User getUser(String email) throws Exception;

  /**
   * Gets job seeker.
   *
   * @param email the email
   * @return the job seeker
   * @throws Exception the exception
   */
  JobSeeker getJobSeeker(String email) throws Exception;

  /**
   * Gets employer.
   *
   * @param email the email
   * @return the employer
   * @throws Exception the exception
   */
  Employer getEmployer(String email) throws Exception;

  /**
   * Create job seeker job seeker.
   *
   * @param jobSeeker the job seeker
   * @return the job seeker
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  JobSeeker createJobSeeker(JobSeeker jobSeeker)
      throws IOException, InterruptedException;

  /**
   * Update job listing.
   *
   * @param jobListing the job listing
   */
  void updateJobListing(JobListing jobListing);

  /**
   * Create employer employer.
   *
   * @param employer the employer
   * @return the employer
   * @throws IOException          the io exception
   * @throws InterruptedException the interrupted exception
   */
  Employer createEmployer(Employer employer)
      throws IOException, InterruptedException;

    void uploadFile(ApplicationFile applicationFile);

  String getApplicationFile(String id, String name) throws IOException, InterruptedException;

  void updateJobSeeker(JobSeeker newJobSeeker);
}
