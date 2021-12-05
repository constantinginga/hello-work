package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.JobListing;
import work.hello.mediator.MessageListener;

/**
 * The type Update job listing listener.
 */
public class UpdateJobListingListener extends MessageListener
{
  /**
   * Instantiates a new Update job listing listener.
   */
  public UpdateJobListingListener()
  {
    super("updateJobListing", "updateJobListing");
  }

  @Override public void handleResponse(CustomMessage message)
  {
    super.getData().updateJobListing((getGson().fromJson(message.getContent(), JobListing.class)));
  }
}


