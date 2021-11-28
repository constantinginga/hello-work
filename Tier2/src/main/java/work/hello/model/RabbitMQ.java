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
        Collections
                .addAll(jobListings, gson.fromJson(response, JobListing[].class));
        return jobListings;

    }

    @Override
    public void createSavedJobListing(SavedJobListing savedJobListing) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createSavedJobListing);
        message.setContent(savedJobListing.toJson());
        rabbitClient.sendMessage(message, "createSavedJobListing");
    }

    @Override
    public ArrayList<SavedJobListing> getSavedJobListings() {

        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType(MessageType.getSavedJobListings);
        String response = "";
        try {
            response = rabbitClient.sendMessageRPC(message, "getSavedJobListings");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<SavedJobListing> savedJobListings = new ArrayList<>();
        Collections
                .addAll(savedJobListings, gson.fromJson(response, SavedJobListing[].class));
        return savedJobListings;
    }



    @Override
    public JobListing getJobListing(String id) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.getJobListing);
        String response = "";
        try {
            response = rabbitClient
                    .sendMessageRPC(message, MessageType.getJobListing.toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        JobListing jobListing = gson.fromJson(response, JobListing.class);
        return jobListing;

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
    public void updateApplication(Application application) {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType(MessageType.updateApplication);
        message.setContent(application.toJson());
        rabbitClient.sendMessage(message, "updateApplication");
    }

    @Override
    public ArrayList<Application> getApplications() {
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setType(MessageType.getAllApplications);
        String response = "";
        try {
            response = rabbitClient.sendMessageRPC(message, "getAllApplications");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Application> applications = new ArrayList<>();
        Collections
                .addAll(applications, gson.fromJson(response, Application[].class));
        return applications;

    }

    @Override
    public void createJobListing(JobListing jobListing) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createJobListing);
        message.setContent(jobListing.toJson());
        rabbitClient.sendMessage(message, "createJobListing");

    }

    @Override
    public boolean deleteJobListing(String id) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.removeJobListing);
        message.setContent(id);
        if (getJobListing(id) != null) {
            rabbitClient.sendMessage(message, MessageType.removeJobListing.name());
            return true;
        }
        return false;
    }
    @Override
    public void deleteSavedJobListing(String id) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.deletingSavedJobListing);
        message.setContent(id);
        rabbitClient.sendMessage(message, MessageType.deletingSavedJobListing.name());
    }

    @Override
    public User getUser(String email, String password) throws Exception {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.getUser);
        message.setContent(new User(email, password).toJson());
        try {
            String response = rabbitClient
                    .sendMessageRPC(message, MessageType.getUser.toString());
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
    public JobSeeker createJobSeeker(JobSeeker jobSeeker)
            throws IOException, InterruptedException {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createJobSeeker);
        message.setContent(jobSeeker.toJson());
        return gson
                .fromJson(rabbitClient.sendMessageRPC(message, "createJobSeeker"),
                        JobSeeker.class);
    }

    @Override
    public Employer createEmployer(Employer employer)
            throws IOException, InterruptedException {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.createEmployer);
        message.setContent(employer.toJson());
        return gson.fromJson(rabbitClient.sendMessageRPC(message, "createEmployer"),
                Employer.class);
    }

    @Override
    public void uploadFile(ApplicationFile applicationFile) {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.uploadApplicationFile);
        message.setContent(applicationFile.toJson());
        rabbitClient.sendMessage(message, message.getType().name());

    }

    @Override
    public String getApplicationFile(String id, String name) throws IOException, InterruptedException {
        CustomMessage message = new CustomMessage();
        message.setType(MessageType.getApplicationFile);
        message.setMessageId(id);
        message.setContent(name);
        return rabbitClient.sendMessageRPC(message, message.getType().name());
    }

    public static MessagingHandler getInstance() {
        if (instance == null) {
            instance = new RabbitMQ();
        }
        return instance;
    }

}
