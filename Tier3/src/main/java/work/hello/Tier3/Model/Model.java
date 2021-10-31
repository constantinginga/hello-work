package work.hello.Tier3.Model;

import java.util.ArrayList;

public interface Model {
    ArrayList<JobListing> getJobListings();
    void applyJobListing(Application application);

}
