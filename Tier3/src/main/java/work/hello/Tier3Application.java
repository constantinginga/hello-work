package work.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.hello.mediator.listeners.ApplyForJobListener;
import work.hello.mediator.listeners.CreateJobListingListener;
import work.hello.mediator.listeners.GetAllJobListingsListener;
import work.hello.model.Model;
import work.hello.model.ModelManager;

@SpringBootApplication
public class Tier3Application {
    private static Model model;
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) {
        SpringApplication.run(Tier3Application.class, args);
        model = new ModelManager();
        registerListeners();
    }

    private static void registerListeners() {
        new ApplyForJobListener();
        new CreateJobListingListener();
        new GetAllJobListingsListener();
    }


    public static Model getModel() {
        return model;
    }
}
