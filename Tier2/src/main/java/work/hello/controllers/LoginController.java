package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.model.data.Application;
import work.hello.model.data.User;

@RestController
public class LoginController {
    private static final Gson gson = new Gson();

    @GetMapping("/user")
    public synchronized String applyJobListing(@RequestParam String email, @RequestParam String password) {
        try {
            User user = RabbitMQ.getInstance().getUser(email, password);
            return user.toJson();
        } catch (Exception e) {
            return "Validation incorrect";

        }
    }
}
