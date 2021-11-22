package work.hello.mediator.listeners;

import work.hello.data.Application;
import work.hello.data.CustomMessage;
import work.hello.mediator.MessageListener;


public class UpdateApplicationListner extends MessageListener {
    public UpdateApplicationListner() {
        super("updateApplication", "updateApplication");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().updateApplication(getGson().fromJson(message.getContent(), Application.class));
    }
}
