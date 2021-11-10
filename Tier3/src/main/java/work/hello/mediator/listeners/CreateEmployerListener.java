package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.model.data.CustomMessage;
import work.hello.model.data.Employer;
import work.hello.model.data.JobSeeker;
import work.hello.model.data.MessageType;

public class CreateEmployerListener extends MessageListenerRPC {
    public CreateEmployerListener() {
        super(MessageType.createEmployer.toString(), MessageType.createEmployer.toString());
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getModel().createEmployer(getGson().fromJson(message.getContent(), Employer.class)).toJson();
    }
}
