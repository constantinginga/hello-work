package work.hello.model;

import com.google.gson.Gson;
import work.hello.model.data.JobListing;
import work.hello.model.data.Application;
import work.hello.model.data.CustomMessage;
import work.hello.model.data.MessageType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.UUID;



public class RabbitMQ implements MessagingHandler {
    private Gson gson;
    private RPCClient rpcClient;
    private static MessagingHandler instance;

    private RabbitMQ() {
        gson = new Gson();
        try {
            rpcClient = new RPCClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<JobListing> getJobListings() {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType(MessageType.getAllJobListings);
        String response = "";
        try {
            response = rpcClient.sendMessageRPC(message);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<JobListing> jobListings = new ArrayList<>();
        Collections.addAll(jobListings,
                gson.fromJson(response, JobListing[].class));
        return jobListings;

    }

    @Override
    public void applyForJob(Application application) {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType(MessageType.applyForJob);
        message.setContent(application.toJson());
        rpcClient.sendMessage(message);
    }

    public static  MessagingHandler getInstance() {
        if (instance == null) {
            instance = new RabbitMQ();
        }
        return instance;
    }
}
