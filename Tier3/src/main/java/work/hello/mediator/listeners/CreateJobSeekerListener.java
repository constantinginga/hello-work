package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.model.data.CustomMessage;
import work.hello.model.data.JobListing;
import work.hello.model.data.JobSeeker;
import work.hello.model.data.MessageType;

public class CreateJobSeekerListener extends MessageListenerRPC {
    public CreateJobSeekerListener() {
        super(MessageType.createJobSeeker.toString(), MessageType.createJobSeeker.toString());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getModel().createJobSeeker(getGson().fromJson(message.getContent(), JobSeeker.class)).toJson();
    }
}
