package work2server;


import com.google.gson.Gson;
import com.rabbitmq.client.*;
import model.data.Application;
import model.data.CommonConfigs;
import model.data.CustomMessage;
import org.springframework.ui.Model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.concurrent.TimeoutException;

public class MessageListner {
    private Model model;
    private Gson gson;
    Connection connection;
    private Channel channel;
    ConnectionFactory factory;

    public MessageListner() {
        gson = new Gson();
        factory = new ConnectionFactory();
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();
            createRPCListener();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void createRPCListener() throws IOException, TimeoutException {
        Channel channel = connection.createChannel();
        channel.queueDeclare(CommonConfigs.RPC_QUEUE_NAME, false, false, false, null);
        channel.queuePurge(CommonConfigs.RPC_QUEUE_NAME);

        channel.basicQos(1);

        System.out.println(" [x] Awaiting RPC requests");

        Object monitor = new Object();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                    .Builder()
                    .correlationId(delivery.getProperties().getCorrelationId())
                    .build();

            String response = "";

            try {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                CustomMessage customMessage = gson.fromJson(message, CustomMessage.class);
                switch (customMessage.getType()) {
                    case getAllJobListings:
                        response = gson.toJson("lol");
                }
            } catch (RuntimeException e) {
                System.out.println(" [.] " + e);
            } finally {
                channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes(StandardCharsets.UTF_8));
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                // RabbitMq consumer worker thread notifies the RPC server owner thread
            }
        };

        channel.basicConsume(CommonConfigs.RPC_QUEUE_NAME, false, deliverCallback, (consumerTag -> {
        }));
    }

}