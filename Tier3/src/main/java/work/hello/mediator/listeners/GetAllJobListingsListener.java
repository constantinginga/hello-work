package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;

public class GetAllJobListingsListener extends MessageListenerRPC {
    public GetAllJobListingsListener() {
        super("getAllJobListings", "getAllJobListings");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getJobListings());
    }
}
