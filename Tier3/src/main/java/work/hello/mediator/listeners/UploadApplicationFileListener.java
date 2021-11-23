package work.hello.mediator.listeners;

import work.hello.data.ApplicationFile;
import work.hello.data.CustomMessage;
import work.hello.data.MessageType;
import work.hello.mediator.MessageListener;

import java.awt.*;

public class UploadApplicationFileListener extends MessageListener {
    public UploadApplicationFileListener() {
        super(MessageType.uploadApplicationFile.name(), MessageType.uploadApplicationFile.name());
    }

    @Override
    public void handleResponse(CustomMessage message) {
        super.getData().uploadApplicationFile(ApplicationFile.fromJson(message.getContent()));
    }
}
