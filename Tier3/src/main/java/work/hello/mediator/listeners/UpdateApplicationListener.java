package work.hello.mediator.listeners;

import work.hello.data.Application;
import work.hello.data.CustomMessage;
import work.hello.mediator.MessageListener;


/**
 * The type Update application listener.
 */
public class UpdateApplicationListener extends MessageListener {
    /**
     * Instantiates a new Update application listener.
     */
    public UpdateApplicationListener() {
        super("updateApplication", "updateApplication");
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().updateApplication(getGson().fromJson(message.getContent(), Application.class));
    }
}
