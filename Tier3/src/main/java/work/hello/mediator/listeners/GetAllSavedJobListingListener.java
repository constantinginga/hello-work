package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.mediator.MessageListener;
import work.hello.mediator.MessageListenerRPC;


/**
 * The type Get all saved job listing listener.
 */
public class GetAllSavedJobListingListener extends MessageListenerRPC {

    /**
     * Instantiates a new Get all saved job listing listener.
     */
    public GetAllSavedJobListingListener() {
        super("getSavedJobListings", "getSavedJobListings");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getSavedJobListings());
    }
}
