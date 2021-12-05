package work.hello.model;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;
import work.hello.CommonConfigs;
import work.hello.data.CustomMessage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * The type Rabbit client.
 */
public class RabbitClient implements AutoCloseable {

    private Connection connection;
    private Channel channel;
    private final Gson gson;

    /**
     * Instantiates a new Rabbit client.
     *
     * @throws IOException              the io exception
     * @throws TimeoutException         the timeout exception
     * @throws KeyManagementException   the key management exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws URISyntaxException       the uri syntax exception
     */
    @SneakyThrows
    public RabbitClient()
            throws IOException, TimeoutException, KeyManagementException,
            NoSuchAlgorithmException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPassword(CommonConfigs.RABBIT_PASSWORD);
        factory.setUsername(CommonConfigs.RABBIT_USERNAME);
        factory.useSslProtocol();

        factory.setUri(CommonConfigs.AMQP_URL);
        factory.setPort(CommonConfigs.RABBIT_PORT);

        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(CommonConfigs.EXCHANGE_NAME, "direct");
        gson = new Gson();
    }

    /**
     * Send message and get rpc string.
     *
     * @param customMessage the custom message
     * @param topic         the topic
     * @return the string
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public String sendMessageRPC(CustomMessage customMessage, String topic) throws IOException, InterruptedException {
        String message = gson.toJson(customMessage);
        final String corrId = UUID.randomUUID().toString();

        String replyQueueName = channel.queueDeclare().getQueue();
        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish(CommonConfigs.EXCHANGE_NAME, topic, props, message.getBytes(StandardCharsets.UTF_8));

        final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

        String ctag = channel.basicConsume(replyQueueName, true, (consumerTag, delivery) -> {
            if (delivery.getProperties().getCorrelationId().equals(corrId)) {
                response.offer(new String(delivery.getBody(), StandardCharsets.UTF_8));
            }
        }, consumerTag -> {
        });

        String result = response.take();
        channel.basicCancel(ctag);
        return result;
    }

    /**
     * Send message.
     *
     * @param customMessage the custom message
     * @param topic         the topic
     */
    public void sendMessage(CustomMessage customMessage, String topic) {
        try {
            String message = gson.toJson(customMessage);
            channel.basicPublish(CommonConfigs.EXCHANGE_NAME, topic, null, message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() throws IOException {
        connection.close();
    }
}