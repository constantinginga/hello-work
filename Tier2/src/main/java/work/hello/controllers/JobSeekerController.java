package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.data.JobSeeker;
import work.hello.data.User;

@RestController
public class JobSeekerController {
    private static final Gson gson = new Gson();

    @PostMapping("/jobSeeker")
    public synchronized String postJobSeeker(@RequestBody String json) throws Exception {
        JobSeeker newJobSeeker = gson.fromJson(json, JobSeeker.class);
        if (newJobSeeker.validate()) {
            User user = RabbitMQ.getInstance().getUser(newJobSeeker.getEmail());
            if (user == null) {
                return RabbitMQ.getInstance().createJobSeeker(newJobSeeker).toJson();
            }
            return "Email already in use";
        }
        return "Not Valid Email";
    }

    @PatchMapping("/jobSeeker")
    public synchronized String patchJobSeeker(@RequestBody String json){
        try {
            JobSeeker newJobSeeker = JobSeeker.fromJson(json);
            User user = RabbitMQ.getInstance().getUser(newJobSeeker.getEmail());
            if (user != null) {
                RabbitMQ.getInstance().updateJobSeeker(newJobSeeker);
                return "Ok";
            }
            else {
                return "User not found";
            }
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @GetMapping("/jobSeeker")
    public synchronized String getJobSeeker(@RequestParam String email) {
        try {
            User user = RabbitMQ.getInstance().getUser(email);
                if (user != null) {
                    return RabbitMQ.getInstance().getJobSeeker(email).toJson();
                }
                else {
                    return "User not found";
                }
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
