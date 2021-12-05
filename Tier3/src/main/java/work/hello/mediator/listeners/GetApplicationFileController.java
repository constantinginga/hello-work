package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListenerRPC;

/**
 * The type Get application file controller.
 */
public class GetApplicationFileController extends MessageListenerRPC {
    /**
     * Instantiates a new Get application file controller.
     */
    public GetApplicationFileController() {
        super(MessageType.getApplicationFile.name(),MessageType.getApplicationFile.name());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getData().getApplicationFile(message.getMessageId(), message.getContent());
    }

}
