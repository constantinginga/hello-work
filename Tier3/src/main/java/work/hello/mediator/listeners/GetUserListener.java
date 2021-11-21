package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;
import work.hello.data.User;

public class GetUserListener extends MessageListenerRPC {
    public GetUserListener() {
        super("getUser", "getUser");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData()
                .getUser(getGson().fromJson(message.getContent(), User.class).getEmail(), getGson().fromJson(message.getContent(), User.class).getPassword()));
    }
}
