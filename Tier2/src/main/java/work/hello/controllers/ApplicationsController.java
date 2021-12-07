package work.hello.controllers;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;
import work.hello.data.Application;
import work.hello.data.ApplicationFile;
import work.hello.model.RabbitMQ;

import java.io.IOException;


@RestController
public class ApplicationsController {
    private static final Gson gson = new Gson();

    @GetMapping("/application")
    public synchronized String getJobListings() {
        return gson.toJson(RabbitMQ.getInstance().getApplications());
    }

    @PostMapping("/application")
    public synchronized String applyJobListing(@RequestBody String json) {
        Application newApplication = Application.fromJson(json);
        if (newApplication.validate()) {
            RabbitMQ.getInstance().applyForJob(newApplication);
            return newApplication.toJson();
        } else {
            return "Validation incorrect";
        }
    }

    @PostMapping("/file")
    public synchronized void uploadFile(@RequestBody String json, @RequestParam String id, @RequestParam String name) {
        ApplicationFile applicationFile = new ApplicationFile(name, id, json);
        try {
            if(name != null && id != null && json != null)
            {
                RabbitMQ.getInstance().uploadFile(applicationFile);
            }
            else {
                throw new Exception("Uploading was not successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/file")
    public synchronized String getFile(@RequestParam String id, @RequestParam String name) throws IOException, InterruptedException {
        return RabbitMQ.getInstance().getApplicationFile(id, name);
    }

    @PatchMapping("/application")
    public synchronized String patchApplication(@RequestBody String json) {
        Application updatedApplication = Application.fromJson(json);
        if (updatedApplication.validate()) {
            RabbitMQ.getInstance().updateApplication(updatedApplication);
            return updatedApplication.toJson();
        } else {
            return "Validation incorrect";
        }
    }
}
