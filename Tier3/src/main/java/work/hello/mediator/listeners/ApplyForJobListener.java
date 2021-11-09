package work.hello.mediator.listeners;

import work.hello.mediator.MessageListener;
import work.hello.model.data.Application;
import work.hello.model.data.CustomMessage;

public class ApplyForJobListener extends MessageListener {
    public ApplyForJobListener() {
        super("applyForJob", "applyForJob");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getModel().applyJobListing(getGson().fromJson(message.getContent(), Application.class));
    }
}
