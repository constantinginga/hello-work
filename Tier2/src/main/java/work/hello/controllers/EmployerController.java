package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.data.Employer;
import work.hello.data.User;

@RestController

public class EmployerController {
    private static final Gson gson = new Gson();

    @PostMapping("/employer")
    public synchronized String postJobSeeker(@RequestBody String json) throws Exception {
        Employer newEmployer = gson.fromJson(json, Employer.class);
        if (newEmployer.validate()) {
            User user = RabbitMQ.getInstance().getUser(newEmployer.getEmail());
            if (user == null) {
                return RabbitMQ.getInstance().createEmployer(newEmployer).toJson();
            }
            return "Email already in use";
        }
        return "Not Valid Email";


    }

    @GetMapping("/employer")
    public synchronized String getEmployer(@RequestParam String email) {
        try {
            return RabbitMQ.getInstance().getEmployer(email).toJson();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}


