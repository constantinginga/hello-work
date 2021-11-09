package work.hello.mediator.listeners;

import work.hello.mediator.MessageListener;
import work.hello.model.data.Application;
import work.hello.model.data.CustomMessage;
import work.hello.model.data.JobListing;

public class CreateJobListingListener extends MessageListener {
    public CreateJobListingListener() {
        super("createJobListing", "createJobListing");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getModel().createJobListing(getGson().fromJson(message.getContent(), JobListing.class));
    }
}
