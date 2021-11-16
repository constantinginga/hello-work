package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.mediator.MessageListener;
import work.hello.mediator.MessageListenerRPC;

public class RemoveJobListingListener extends MessageListener
{
  public RemoveJobListingListener()
  {
    super("RemoveJobListingListener", "RemoveJobListingListener");
  }

  @Override public void handleResponse(CustomMessage message)
  {
    super.getModel().removeJobListing(message.getContent());
  }
}
