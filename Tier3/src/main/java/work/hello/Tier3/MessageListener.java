package work.hello.Tier3;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MessageListener {
    @Autowired
    private RabbitTemplate template;
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        if (message.getType().equals("getAllJobListings")){
            System.out.println("Received");
            ArrayList<JobListing> jobListings = new ArrayList<>();
            Gson gson = new Gson();
            jobListings.add(new JobListing(1,"test"));
            jobListings.add(new JobListing(2,"test1"));
            jobListings.add(new JobListing(3,"test3"));
            message.setContent(gson.toJson(jobListings));
            System.out.println("Sent");
            template.convertAndSend(MQConfig.EXCHANGE,
                    MQConfig.ROUTING_KEY, message);

        }
    }

}