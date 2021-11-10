package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.hello.model.RabbitMQ;
import work.hello.model.data.Employer;
import work.hello.model.data.JobSeeker;
import work.hello.model.data.User;

@RestController

public class EmployerController {
    private static final Gson gson = new Gson();

    @PostMapping("/employer")
    public synchronized String postJobSeeker(@RequestBody String json) throws Exception {
        Employer newEmployer = gson.fromJson(json, Employer.class);
        System.out.println(newEmployer.getEmail());
        if (newEmployer.validate()) {
            User user = RabbitMQ.getInstance().getUser(newEmployer.getEmail());
            if (user == null) {
                return RabbitMQ.getInstance().createEmployer(newEmployer).toJson();
            }
            return "Email already in use";
        }
        return "Not Valid Email";


    }
}

