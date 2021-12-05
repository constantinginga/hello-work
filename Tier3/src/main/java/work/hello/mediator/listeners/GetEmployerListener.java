package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListenerRPC;

/**
 * The type Get employer listener.
 */
public class GetEmployerListener extends MessageListenerRPC
{

    /**
     * Instantiates a new Get employer listener.
     */
    public GetEmployerListener() {
        super(MessageType.getEmployer.name(), MessageType.getEmployer.name());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData()
                .getEmployer(message.getContent()));

    }
}
