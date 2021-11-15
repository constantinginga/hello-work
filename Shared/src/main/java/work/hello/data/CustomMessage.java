package work.hello.data;




public class CustomMessage {

    private String messageId;
    private String content;
    private MessageType type;

    public CustomMessage(String messageId, String content, MessageType type) {
        this.messageId = messageId;
        this.content = content;
        this.type = type;
    }

    public CustomMessage() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}