package work.hello.model;

import work.hello.model.data.Application;
import work.hello.model.data.JobListing;
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
}
