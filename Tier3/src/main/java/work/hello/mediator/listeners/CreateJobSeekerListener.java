package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;
import work.hello.data.JobSeeker;
import work.hello.data.MessageType;

public class CreateJobSeekerListener extends MessageListenerRPC {
    public CreateJobSeekerListener() {
        super(MessageType.createJobSeeker.toString(), MessageType.createJobSeeker.toString());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getModel().createJobSeeker(getGson().fromJson(message.getContent(), JobSeeker.class)).toJson();
    }
}
