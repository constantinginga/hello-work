package work.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.hello.model.Model;
import work.hello.model.ModelManager;
import work.hello.mediator.MessageListener;

@SpringBootApplication
public class Tier3Application {
    private static Model model;
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) {
        SpringApplication.run(Tier3Application.class, args);
        model = new ModelManager();
        MessageListener messageListener = new MessageListener();
    }



    public static Model getModel() {
        return model;
    }
}
