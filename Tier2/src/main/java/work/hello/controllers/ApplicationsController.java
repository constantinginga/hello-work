package work.hello.controllers;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;
import work.hello.data.Application;
import work.hello.model.RabbitMQ;


@RestController
public class ApplicationsController {
    private static final Gson gson = new Gson();

    @GetMapping("/application")
    public synchronized String getJobListings()
    {
        return gson.toJson(RabbitMQ.getInstance().getApplications());
    }
    @PostMapping("/application")
    public synchronized String applyJobListing(@RequestBody String json) {
        System.out.println(json);
        Application newApplication = Application.fromJson(json);
        if (true) {
            System.out.println(newApplication.getFiles().size());
            RabbitMQ.getInstance().applyForJob(newApplication);
            return newApplication.toJson();
        } else {
            return "Validation incorrect";
        }
    }
}
