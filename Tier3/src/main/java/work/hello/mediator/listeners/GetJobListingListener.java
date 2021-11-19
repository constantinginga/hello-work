package work.hello.mediator.listeners;

import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListenerRPC;

public class GetJobListingListener extends MessageListenerRPC
{
  public GetJobListingListener()
  {
    super(MessageType.getJobListing.toString(),
        MessageType.getJobListing.toString());
  }

  @Override public String handleResponse(CustomMessage message)
  {
    return super.getGson()
        .toJson(super.getData().getJobListing(message.getContent()));
  }
}
