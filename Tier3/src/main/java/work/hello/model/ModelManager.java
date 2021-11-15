package work.hello.model;

import work.hello.data.*;
import work.hello.persistance.MongoDB;
import work.hello.persistance.MongoDBManager;

import java.util.ArrayList;

public class ModelManager implements Model {
    private MongoDB mongoDB;

    public ModelManager() {
        mongoDB = new MongoDBManager();

    }

    @Override
    public ArrayList<JobListing> getJobListings() {
        return mongoDB.getJobListings();
    }

    @Override
    public void applyJobListing(Application application) {
        mongoDB.applyJobListing(application);
    }

    @Override
    public void createJobListing(JobListing jobListing) {
        mongoDB.createJobListing(jobListing);
    }

    @Override
    public User getUser(User user) {
        return mongoDB.getUser(user.getEmail(), user.getPassword());
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return mongoDB.createJobSeeker(jobSeeker);
    }

    @Override
    public Employer createEmployer(Employer employer) {
        return mongoDB.createEmployer(employer);
    }
}
