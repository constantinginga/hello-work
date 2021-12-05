package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;

/**
 * The type Get all applications listner.
 */
public class GetAllApplicationsListner extends MessageListenerRPC {
    /**
     * Instantiates a new Get all applications listner.
     */
    public GetAllApplicationsListner() {
        super("getAllApplications", "getAllApplications");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getApplications());
    }
}
