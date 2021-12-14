package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.data.Employer;
import work.hello.data.User;

/**
 * The type Employer REST controller.
 */
@RestController

public class EmployerController {
    private static final Gson gson = new Gson();

    /**
     * Post job seeker .
     *
     * @param json the job seeker as json
     * @return response
     * @throws Exception the exception
     */
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

    /**
     * Gets employer.
     *
     * @param email the email of employer
     * @return the employer
     */
    @GetMapping("/employer")
    public synchronized String getEmployer(@RequestParam String email) {
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


