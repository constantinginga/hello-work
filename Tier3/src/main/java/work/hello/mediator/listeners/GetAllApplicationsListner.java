package work.hello.mediator.listeners;

import work.hello.mediator.MessageListenerRPC;
import work.hello.data.CustomMessage;

public class GetAllApplicationsListner extends MessageListenerRPC {
    public GetAllApplicationsListner() {
        super("getAllApplications", "getAllApplications");
    }

    @Override
    public String handleResponse(CustomMessage message) {
        return super.getGson().toJson(super.getData().getApplications());
    }
}
