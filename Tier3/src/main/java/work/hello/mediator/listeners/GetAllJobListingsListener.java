package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;

/**
 * The type Get all job listings listener.
 */
public class GetAllJobListingsListener extends MessageListenerRPC {
    /**
     * Instantiates a new Get all job listings listener.
     */
    public GetAllJobListingsListener() {
        super("getAllJobListings", "getAllJobListings");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getJobListings());
    }
}
