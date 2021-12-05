package work.hello.mediator.listeners;

import org.springframework.amqp.core.Message;
import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.data.User;
import work.hello.mediator.MessageListenerRPC;

import java.awt.*;

/**
 * The type Get job seeker listener.
 */
public class GetJobSeekerListener extends MessageListenerRPC {
    /**
     * Instantiates a new Get job seeker listener.
     */
    public GetJobSeekerListener() {
        super(MessageType.getJobSeeker.name(), MessageType.getJobSeeker.name());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData()
                .getJobSeeker(message.getContent()));

    }
}
