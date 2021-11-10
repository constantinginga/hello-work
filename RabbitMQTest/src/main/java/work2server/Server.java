package work2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

@SpringBootApplication
public class Server {
    private static Model model;
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
        MessageListner messageListener = new MessageListner();
    }
}