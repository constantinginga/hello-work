package work.hello.model;

import com.google.gson.Gson;
import work.hello.data.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.UUID;


public class RabbitMQ implements MessagingHandler {
    private Gson gson;
    private RabbitClient rabbitClient;
    private static MessagingHandler instance;

    private RabbitMQ() {
        gson = new Gson();
        try {
            rabbitClient = new RabbitClient();
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
            response = rabbitClient.sendMessageRPC(message, "getAllJobListings");
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
        rabbitClient.sendMessage(message, "applyForJob");
    }

    @Override
    public void createJobListing(JobListing jobListing) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createJobListing);
        message.setContent(jobListing.toJson());
        rabbitClient.sendMessage(message, "createJobListing");

    }

    @Override
    public User getUser(String email, String password) throws Exception {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.getUser);
        message.setContent(new User(email, password).toJson());
        try {
            String response = rabbitClient.sendMessageRPC(message, MessageType.getUser.toString());
            if (response == null) {

                throw new Exception("User not Found");
            }
            return User.fromJson(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new Exception("User not Found");
        }
    }

    @Override
    public User getUser(String email) throws Exception {
        return getUser(email, "");
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) throws IOException, InterruptedException {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createJobSeeker);
        message.setContent(jobSeeker.toJson());
        return gson.fromJson(rabbitClient.sendMessageRPC(message, "createJobSeeker"), JobSeeker.class);
    }

    @Override
    public Employer createEmployer(Employer employer) throws IOException, InterruptedException {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createEmployer);
        message.setContent(employer.toJson());
        return gson.fromJson(rabbitClient.sendMessageRPC(message, "createEmployer"), Employer.class);
    }

    public static MessagingHandler getInstance() {
        if (instance == null) {
            instance = new RabbitMQ();
        }
        return instance;
    }

}
