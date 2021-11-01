package work.hello.model;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import work.hello.CommonConfigs;
import work.hello.model.data.CustomMessage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class RPCClient implements AutoCloseable {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";
    private Gson gson;

    public RPCClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        connection = factory.newConnection(CommonConfigs.AMQP_URL);
        channel = connection.createChannel();
        gson = new Gson();
    }

    public String sendMessageRPC(CustomMessage customMessage) throws IOException, InterruptedException {
        String message = gson.toJson(customMessage);
        final String corrId = UUID.randomUUID().toString();

        String replyQueueName = channel.queueDeclare().getQueue();
        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes(StandardCharsets.UTF_8));

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

    public void sendMessage(CustomMessage customMessage) {
        try {
            String message = gson.toJson(customMessage);
            channel.queueDeclare(CommonConfigs.DEFAULT_QUEUE, true, false, false, null);
            //publish - (exchange, routingKey, properties, message)
            channel.basicPublish("", CommonConfigs.DEFAULT_QUEUE, null, message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() throws IOException {
        connection.close();
    }
}