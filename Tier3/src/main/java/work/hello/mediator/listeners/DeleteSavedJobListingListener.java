package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListener;

public class DeleteSavedJobListingListener extends MessageListener {

    public DeleteSavedJobListingListener()
    {
        super(MessageType.deletingSavedJobListing.name(),MessageType.deletingSavedJobListing.name());
    }

    @Override
    public void handleResponse(CustomMessage message)
    {
        super.getData().deleteSavedJobListing(message.getContent());
    }
}
