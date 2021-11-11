package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.model.data.CustomMessage;
import work.hello.model.data.User;

public class GetUserListener extends MessageListenerRPC
{
  public GetUserListener()
  {
    super("getUser", "getUser");
  }

  @Override public String handleResponse(CustomMessage message)
  {
    System.out.println(message.getContent());
    return super.getGson().toJson(super.getModel()
        .getUser(getGson().fromJson(message.getContent(), User.class)));
  }
}
