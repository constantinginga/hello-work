package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.hello.model.RabbitMQ;
import work.hello.model.data.Application;
import work.hello.model.data.JobListing;

import java.util.ArrayList;

@RestController
public class JobController {
    private static final Gson gson = new Gson();
    @GetMapping("/job") public synchronized String getJobListings()
    {
        System.out.println("here");
        ArrayList<JobListing> jobListings = RabbitMQ.getInstance().getJobListings();
        return gson.toJson(RabbitMQ.getInstance().getJobListings());
    }
    @PostMapping("/job") public synchronized String postJobListings(@RequestBody String json)
    {
        JobListing newJobListing = JobListing.fromJson(json);
        if (true)
        {
            RabbitMQ.getInstance().createJobListing(newJobListing);
            return newJobListing.toJson();
        }
        else {
         return "Validation incorrect";
        }
    }
}
