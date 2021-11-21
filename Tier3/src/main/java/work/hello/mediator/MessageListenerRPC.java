package work.hello.mediator;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import work.hello.CommonConfigs;
import work.hello.Tier3Application;
import work.hello.data.CustomMessage;
import work.hello.persistance.MongoDB;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public abstract class MessageListenerRPC {
    private MongoDB data;
    private final Gson gson;
    private Connection connection;
    private ConnectionFactory factory;
    private String queueName;
    private String topic;


    public MessageListenerRPC(String queueName, String topic) {
        this.data = Tier3Application.getData();
        gson = new Gson();
        factory = new ConnectionFactory();
        try {
            factory.setPassword(CommonConfigs.RABBIT_PASSWORD);
            factory.setUsername(CommonConfigs.RABBIT_USERNAME);
            factory.useSslProtocol();
            factory.setUri(CommonConfigs.AMQP_URL);
            factory.setPort(CommonConfigs.RABBIT_PORT);
            connection = factory.newConnection();
            this.queueName = queueName;
            this.topic = topic;
            createListener();
        } catch (IOException | TimeoutException | KeyManagementException | NoSuchAlgorithmException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public abstract String handleResponse(CustomMessage message);

    private void createListener() throws IOException, TimeoutException {

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(CommonConfigs.EXCHANGE_NAME, "direct");
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, CommonConfigs.EXCHANGE_NAME, topic);
        channel.basicQos(1);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                    .Builder()
                    .correlationId(delivery.getProperties().getCorrelationId())
                    .build();

            String response = "";

            try {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                CustomMessage customMessage = gson.fromJson(message, CustomMessage.class);
                response = handleResponse(customMessage);

            } catch (RuntimeException e) {
                System.out.println(" [.] " + e);
            } finally {
                channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes(StandardCharsets.UTF_8));
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };

        channel.basicConsume(queueName, false, deliverCallback, (consumerTag -> {
        }));
    }

    public MongoDB getData() {
        return data;
    }

    public Gson getGson() {
        return gson;
    }
}
