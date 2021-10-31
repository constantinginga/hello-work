package work.hello.Tier3.persistance;

import work.hello.Tier3.Model.Application;
import work.hello.Tier3.Model.JobListing;

import java.util.ArrayList;

public interface MongoDB {
    ArrayList<JobListing> getJobListings();
    void applyJobListing(Application application);
}
