package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.data.User;

/**
 * The type Login REST controller.
 */
@RestController
public class LoginController {
    private static final Gson gson = new Gson();

    /**
     * Login User.
     *
     * @param email    the email
     * @param password the password
     * @return the response user in json or validation incorrect
     */
    @GetMapping("/user")
    public synchronized String loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = RabbitMQ.getInstance().getUser(email, password);
            return user.toJson();
        } catch (Exception e) {
            return "Validation incorrect";

        }
    }
}
