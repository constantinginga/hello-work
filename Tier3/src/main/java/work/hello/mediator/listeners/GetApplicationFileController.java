package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListenerRPC;

public class GetApplicationFileController extends MessageListenerRPC {
    public GetApplicationFileController() {
        super(MessageType.getApplicationFile.name(),MessageType.getApplicationFile.name());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getData().getApplicationFile(message.getMessageId(), message.getContent());
    }

}
