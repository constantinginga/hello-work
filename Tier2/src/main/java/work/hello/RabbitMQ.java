package work.hello;

import com.google.gson.Gson;




import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class RabbitMQ implements MessagingHandler {
    private RabbitTemplate template;

    private final static String QUEUE_NAME = "Message_Queue";
    private Connection connection;
    private String requestQueueName = "rpc_queue";
    private HashMap<String, CustomMessage> response;
    private Gson gson;


    public RabbitMQ(RabbitTemplate rabbitTemplate) {
        this.template = rabbitTemplate;
        response = new HashMap<>();
        gson = new Gson();
    }

    @Override
    public synchronized ArrayList<JobListing> getJobListings() {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType("getAllJobListings");
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);
        while (!response.containsKey(message.getMessageId())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CustomMessage responseMessage = response.get(message.getMessageId());
        ArrayList<JobListing> jobListings = new ArrayList<>();
        Collections.addAll(jobListings, gson.fromJson(responseMessage.getContent(), JobListing[].class));
        response.remove(responseMessage.getMessageId());
        return jobListings;
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public synchronized void listener(CustomMessage message) {
        System.out.println("Received");
        System.out.println(message);
        response.put(message.getMessageId(), message);
        notifyAll();
    }
}
