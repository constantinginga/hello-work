package work.hello;

import java.util.ArrayList;

public interface MessagingHandler {
     ArrayList<JobListing> getJobListings() throws InterruptedException;
     void applyForJob(Application application);

}
