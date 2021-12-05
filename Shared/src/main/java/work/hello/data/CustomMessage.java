package work.hello.data;


/**
 * The type Custom message.
 */
public class CustomMessage {

    private String messageId;
    private String content;
    private MessageType type;

    /**
     * Instantiates a new Custom message.
     *
     * @param messageId the message id
     * @param content   the content
     * @param type      the type
     */
    public CustomMessage(String messageId, String content, MessageType type) {
        this.messageId = messageId;
        this.content = content;
        this.type = type;
    }

    /**
     * Instantiates a new Custom message.
     */
    public CustomMessage() {
    }

    /**
     * Gets message id.
     *
     * @return the message id
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets message id.
     *
     * @param messageId the message id
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(MessageType type) {
        this.type = type;
    }
}