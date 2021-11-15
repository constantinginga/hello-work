package work.hello.mediator;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import work.hello.CommonConfigs;
import work.hello.Tier3Application;
import work.hello.model.Model;
import work.hello.data.CustomMessage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public abstract class MessageListener {
    private Model model;
    private final Gson gson;
    private Connection connection;
    private ConnectionFactory factory;
    private String queueName;
    private String topic;


    public MessageListener(String queueName, String topic) {
        this.model = Tier3Application.getModel();
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

    public abstract void handleResponse(CustomMessage message);

    private void createListener() throws IOException, TimeoutException {

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(CommonConfigs.EXCHANGE_NAME, "direct");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, CommonConfigs.EXCHANGE_NAME, topic);
        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            CustomMessage customMessage = gson.fromJson(message, CustomMessage.class);
            handleResponse(customMessage);
        };

        CancelCallback cancelCallback = s -> {

        };
        channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
    }

    public Model getModel() {
        return model;
    }

    public Gson getGson() {
        return gson;
    }
}
