package work.hello.mediator.listeners;

import work.hello.mediator.MessageListener;
import work.hello.data.CustomMessage;
import work.hello.data.JobListing;

/**
 * The type Create job listing listener.
 */
public class CreateJobListingListener extends MessageListener {
    /**
     * Instantiates a new Create job listing listener.
     */
    public CreateJobListingListener() {
        super("createJobListing", "createJobListing");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().createJobListing(getGson().fromJson(message.getContent(), JobListing.class));
    }
}
