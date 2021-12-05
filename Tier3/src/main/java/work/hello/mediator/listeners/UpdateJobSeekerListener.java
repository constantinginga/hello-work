package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.JobSeeker;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListener;

/**
 * The type Update job seeker listener.
 */
public class UpdateJobSeekerListener extends MessageListener {
    /**
     * Instantiates a new Update job seeker listener.
     */
    public UpdateJobSeekerListener() {
        super(MessageType.updateJobSeeker.name(), MessageType.updateJobSeeker.name());
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().updateJobSeeker(JobSeeker.fromJson(message.getContent()));
    }
}
