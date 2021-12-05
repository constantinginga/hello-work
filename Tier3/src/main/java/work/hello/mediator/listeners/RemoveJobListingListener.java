package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListener;

/**
 * The type Remove job listing listener.
 */
public class RemoveJobListingListener extends MessageListener
{
  /**
   * Instantiates a new Remove job listing listener.
   */
  public RemoveJobListingListener()
  {
    super(MessageType.removeJobListing.name(),MessageType.removeJobListing.name() );
  }

  @Override public void handleResponse(CustomMessage message)
  {
    System.out.println("1");
    super.getData().removeJobListing(message.getContent());
  }
}
