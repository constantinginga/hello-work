package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
