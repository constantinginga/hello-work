package work.hello.controllers;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;
import work.hello.data.Application;
import work.hello.data.ApplicationFile;
import work.hello.model.RabbitMQ;

import java.io.IOException;


/**
 * The type Applications REST controller.
 */
@RestController
public class ApplicationsController {
    private static final Gson gson = new Gson();

    /**
     * Gets job listings.
     *
     * @return the job listings
     */
    @GetMapping("/application")
    public synchronized String getJobListings() {
        return gson.toJson(RabbitMQ.getInstance().getApplications());
    }

    /**
     * Apply job listing string.
     *
     * @param json the json
     * @return the response
     */
    @PostMapping("/application")
    public synchronized String applyJobListing(@RequestBody String json) {
        Application newApplication = Application.fromJson(json);
        if (true) {
            RabbitMQ.getInstance().applyForJob(newApplication);
            return newApplication.toJson();
        } else {
            return "Validation incorrect";
        }
    }

    /**
     * Upload file for application.
     *
     * @param json the file
     * @param id   the id of application
     * @param name the name of file
     */
    @PostMapping("/file")
    public synchronized void uploadFile(@RequestBody String json, @RequestParam String id, @RequestParam String name) {
        ApplicationFile applicationFile = new ApplicationFile(name, id, json);
        RabbitMQ.getInstance().uploadFile(applicationFile);
    }

    /**
     * Gets file for application.
     *
     * @param id   the id of application
     * @param name the name of file
     * @return the file
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @GetMapping("/file")
    public synchronized String getFile(@RequestParam String id, @RequestParam String name) throws IOException, InterruptedException {
        return RabbitMQ.getInstance().getApplicationFile(id, name);
    }

    /**
     * Patch application string.
     *
     * @param json the application
     * @return the response
     */
    @PatchMapping("/application")
    public synchronized String patchApplication(@RequestBody String json) {
        Application updatedApplication = Application.fromJson(json);
        if (true) {
            RabbitMQ.getInstance().updateApplication(updatedApplication);
            return updatedApplication.toJson();
        } else {
            return "Validation incorrect";
        }
    }
}
