package work.hello.mediator.listeners;

import work.hello.mediator.MessageListener;
import work.hello.data.Application;
import work.hello.data.CustomMessage;

public class ApplyForJobListener extends MessageListener {
    public ApplyForJobListener() {
        super("applyForJob", "applyForJob");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().applyJobListing(getGson().fromJson(message.getContent(), Application.class));
    }
}
