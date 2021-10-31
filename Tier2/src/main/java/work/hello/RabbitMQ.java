package work.hello;

import com.google.gson.Gson;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

@Component
public class RabbitMQ implements MessagingHandler {
    private RabbitTemplate template;
    private final HashMap<String, CustomMessage> response;
    private Gson gson;
    private final Object instance;


    public RabbitMQ(RabbitTemplate rabbitTemplate) {
        instance = ResponsesSinglton.getMonitor();
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
        while (!ResponsesSinglton.getInstance().getResponse().containsKey(message.getMessageId())) {
            try {
                synchronized (instance) {
                    instance.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CustomMessage responseMessage = ResponsesSinglton.getInstance().getResponse().get(message.getMessageId());
        ArrayList<JobListing> jobListings = new ArrayList<>();
        Collections.addAll(jobListings, gson.fromJson(responseMessage.getContent(), JobListing[].class));
        ResponsesSinglton.getInstance().getResponse().remove(responseMessage.getMessageId());
        return jobListings;

    }

    @RabbitListener(queues = MQConfig.CALLBACK_QUEUE)
    public void listener(CustomMessage message) {
        ResponsesSinglton.getInstance().getResponse().put(message.getMessageId(), message);
        synchronized (instance) {
            instance.notifyAll();
        }

    }
}
