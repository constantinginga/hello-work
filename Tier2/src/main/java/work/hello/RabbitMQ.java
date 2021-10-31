package work.hello;

import com.google.gson.Gson;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

@Component
public class RabbitMQ implements MessagingHandler {
    private RabbitTemplate template;

    private final static String QUEUE_NAME = "Message_Queue";
    private Connection connection;
    private String requestQueueName = "rpc_queue";
    private final HashMap<String, CustomMessage> response;
    private Gson gson;
    final static Object monitor = new Object();


    public RabbitMQ(RabbitTemplate rabbitTemplate) {
        this.template = rabbitTemplate;
        response = new HashMap<>();
        gson = new Gson();
    }

    @Override
    public ArrayList<JobListing> getJobListings() {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType("getAllJobListings");
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);
        while (!response.containsKey(message.getMessageId())) {
            try {
                System.out.println("here");
                synchronized (monitor) {
                    monitor.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CustomMessage responseMessage = response.get(message.getMessageId());
        ArrayList<JobListing> jobListings = new ArrayList<>();
        Collections.addAll(jobListings, gson.fromJson(responseMessage.getContent(), JobListing[].class));
        response.remove(responseMessage.getMessageId());
        System.out.println("here2");
        return jobListings;


    }

    @RabbitListener(queues = MQConfig.CALLBACK_QUEUE)
    public void listener(CustomMessage message) {
        System.out.println("Received");
        System.out.println(message);
        response.put(message.getMessageId(), message);
        synchronized (monitor) {
            monitor.notifyAll();
        }

    }
}
