package work.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.hello.mediator.listeners.*;
import work.hello.model.Model;
import work.hello.model.ModelManager;

@SpringBootApplication
public class Tier3Application {
    private static Model model;

    public static void main(String[] args) {
        SpringApplication.run(Tier3Application.class, args);
        model = new ModelManager();
        registerListeners();
    }

    private static void registerListeners() {
        new ApplyForJobListener();
        new CreateJobListingListener();
        new GetAllJobListingsListener();
        new GetUserListener();
        new CreateJobListingListener();
        new CreateEmployerListener();
        new CreateJobSeekerListener();
    }


    public static Model getModel() {
        return model;
    }
}
