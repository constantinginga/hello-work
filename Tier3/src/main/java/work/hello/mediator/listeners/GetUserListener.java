package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;
import work.hello.data.User;

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
