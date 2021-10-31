package work.hello;


import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
public class ApplicationsController {
    private static final Gson gson = new Gson();

    @Autowired
    private RabbitTemplate template;

    private TreeMap<Integer, JobListing> joblisting = new TreeMap<Integer, JobListing>();

    @GetMapping("/joblistings/getJobListings")
    public synchronized String getJobListings()
    {
        RabbitMQ rabbitMQ = new RabbitMQ(template);
        return gson.toJson(rabbitMQ.getJobListings());
    }
    @PutMapping("/applications/{application}")
    public synchronized void applyJobListing(@RequestBody String json, @PathVariable String application) throws Exception {
        Application newApplication = Application.fromJson(json);
        if(newApplication.validate())
        {

        }
        else {
            throw new Exception("Validation failed");
        }
    }

}
