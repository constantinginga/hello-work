package work.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.hello.mediator.listeners.*;
import work.hello.persistance.MongoDB;
import work.hello.persistance.MongoDBManager;

@SpringBootApplication
public class Tier3Application {
    private static MongoDB data;

    public static void main(String[] args) {
        SpringApplication.run(Tier3Application.class, args);
        data = new MongoDBManager();
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
        new RemoveJobListingListener();
        new GetJobListingListener();
        new GetAllApplicationsListner();
        new UpdateApplicationListener();
        new UploadApplicationFileListener();
        new GetApplicationFileController();
        new UpdateJobSeekerListener();
        new GetJobSeekerListener();
        new GetEmployerListener();
        new CreateSavedJobListingListener();
        new DeleteSavedJobListingListener();
        new GetAllSavedJobListingListener();
        new UpdateJobListingListener();
    }


    public static MongoDB getData() {
        return data;
    }
}
