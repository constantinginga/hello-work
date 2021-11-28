package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.mediator.MessageListener;
import work.hello.mediator.MessageListenerRPC;


public class GetAllSavedJobListingListener extends MessageListenerRPC {

    public GetAllSavedJobListingListener() {
        super("getSavedJobListings", "getSavedJobListings");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getSavedJobListings());
    }
}
