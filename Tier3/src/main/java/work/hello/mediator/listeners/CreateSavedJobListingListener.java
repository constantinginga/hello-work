package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.data.SavedJobListing;
import work.hello.mediator.MessageListener;

public class CreateSavedJobListingListener extends MessageListener {

    public CreateSavedJobListingListener() {
        super(MessageType.createSavedJobListing.toString(), MessageType.createSavedJobListing.toString());
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().createSavedJobListing(getGson().fromJson(message.getContent(), SavedJobListing.class));
    }
}
