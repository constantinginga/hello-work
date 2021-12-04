package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.JobListing;
import work.hello.mediator.MessageListener;

public class UpdateJobListingListener extends MessageListener
{
  public UpdateJobListingListener()
  {
    super("updateJobListing", "updateJobListing");
  }

  @Override public void handleResponse(CustomMessage message)
  {
    super.getData().updateJobListing((getGson().fromJson(message.getContent(), JobListing.class)));
  }
}


