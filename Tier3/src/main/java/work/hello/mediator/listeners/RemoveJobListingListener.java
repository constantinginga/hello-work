package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListener;
import work.hello.mediator.MessageListenerRPC;

public class RemoveJobListingListener extends MessageListener
{
  public RemoveJobListingListener()
  {
    super(MessageType.removeJobListing.name(),MessageType.removeJobListing.name() );
  }

  @Override public void handleResponse(CustomMessage message)
  {
    System.out.println("1");
    super.getModel().removeJobListing(message.getContent());
  }
}
