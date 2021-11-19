package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;
import work.hello.data.Employer;
import work.hello.data.MessageType;

public class CreateEmployerListener extends MessageListenerRPC {
    public CreateEmployerListener() {
        super(MessageType.createEmployer.toString(), MessageType.createEmployer.toString());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getData().createEmployer(getGson().fromJson(message.getContent(), Employer.class)).toJson();
    }
}
