package work.hello.mediator.listeners;

import work.hello.mediator.MessageListener;
import work.hello.data.Application;
import work.hello.data.CustomMessage;

/**
 * The type Apply for job listener.
 */
public class ApplyForJobListener extends MessageListener {
    /**
     * Instantiates a new Apply for job listener.
     */
    public ApplyForJobListener() {
        super("applyForJob", "applyForJob");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().applyJobListing(getGson().fromJson(message.getContent(), Application.class));
    }
}
