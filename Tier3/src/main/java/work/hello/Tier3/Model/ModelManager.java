package work.hello.Tier3.Model;

import work.hello.Tier3.persistance.MongoDB;
import work.hello.Tier3.persistance.MongoDBManager;

import java.util.ArrayList;

public class ModelManager implements Model {
    private ArrayList<JobListing> jobListings;
    private MongoDB mongoDB;

    public ModelManager() {
        jobListings = new ArrayList<>();
        mongoDB = new MongoDBManager();

    }

    @Override
    public ArrayList<JobListing> getJobListings() {
        jobListings.add(new JobListing(1,"test"));
        jobListings.add(new JobListing(2,"test1"));
        jobListings.add(new JobListing(3,"test3"));
        return mongoDB.getJobListings();
    }

    @Override
    public void applyJobListing(Application application) {

    }
}
