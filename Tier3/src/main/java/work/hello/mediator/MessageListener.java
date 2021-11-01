package work.hello.mediator;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import work.hello.CommonConfigs;
import work.hello.model.data.Application;
import work.hello.model.data.CustomMessage;
import work.hello.model.Model;
import work.hello.Tier3Application;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class MessageListener {
    private Model model;
    private Gson gson;
    Connection connection;
    ConnectionFactory factory;

    public MessageListener() {
        this.model = Tier3Application.getModel();
        gson = new Gson();
        factory = new ConnectionFactory();
        try {
            connection = factory.newConnection(CommonConfigs.AMQP_URL);
            createRPCListener();
            createListener();
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
                        response = gson.toJson(model.getJobListings());
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

    public void createListener() throws IOException, TimeoutException {

        Channel channel = connection.createChannel();
        channel.queueDeclare(CommonConfigs.DEFAULT_QUEUE, true, false, false, null);

        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            CustomMessage customMessage = gson.fromJson(message, CustomMessage.class);
            switch (customMessage.getType()) {
                case applyForJob:
                    model.applyJobListing(gson.fromJson(customMessage.getContent(), Application.class));
            }
        };

        CancelCallback cancelCallback = s -> {

        };
        channel.basicConsume(CommonConfigs.DEFAULT_QUEUE, true, deliverCallback, cancelCallback);
    }

}