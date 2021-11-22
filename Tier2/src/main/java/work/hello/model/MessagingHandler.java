package work.hello.model;

import work.hello.data.*;

import java.io.IOException;
import java.util.ArrayList;

public interface MessagingHandler
{
  ArrayList<JobListing> getJobListings();
  JobListing getJobListing(String id);
  void applyForJob(Application application);
  ArrayList<Application> getApplications();
  void createJobListing(JobListing jobListing);
  boolean deleteJobListing(String id);
  User getUser(String email, String password) throws Exception;

  User getUser(String email) throws Exception;

  JobSeeker createJobSeeker(JobSeeker jobSeeker)
      throws IOException, InterruptedException;

  Employer createEmployer(Employer employer)
      throws IOException, InterruptedException;
}
