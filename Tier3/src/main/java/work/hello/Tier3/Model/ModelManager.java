package work.hello.Tier3.Model;

import java.util.ArrayList;

public class ModelManager implements Model{
    private ArrayList<JobListing> jobListings;
    public ModelManager() {
        jobListings = new ArrayList<>();

    }

    @Override
    public ArrayList<JobListing> getJobListings()  {
        return jobListings;
    }
}
