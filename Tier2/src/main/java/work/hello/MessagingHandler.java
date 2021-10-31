package work.hello;

import java.util.ArrayList;

public interface MessagingHandler {
    public ArrayList<JobListing> getJobListings() throws InterruptedException;
}
