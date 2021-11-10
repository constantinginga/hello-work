package work.hello.persistance;

import com.google.gson.Gson;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import work.hello.model.data.*;

import java.util.ArrayList;

public class MongoDBManager implements MongoDB {
    private final String connectionString = "mongodb+srv://hellowork:hellowork123@hellowork.7ufqy.mongodb.net/test";
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> jobCollection;
    private MongoCollection<Document> applicationCollection;
    private MongoCollection<Document> jobSeekerCollection;
    private MongoCollection<Document> employerCollection;
    private JsonWriterSettings settings;
    private Gson gson;

    public MongoDBManager() {

        try {
            MongoClient mongoClient = MongoClients.create(connectionString);
            mongoDatabase = mongoClient.getDatabase("hellowork");
            jobCollection = mongoDatabase.getCollection("Jobs");
            jobCollection.createIndex(Indexes.ascending("JobID"));
            applicationCollection = mongoDatabase.getCollection("Applications");
            jobSeekerCollection = mongoDatabase.getCollection("JobSeekers");
            employerCollection = mongoDatabase.getCollection("Employers");
            settings = JsonWriterSettings.builder()
                    .int64Converter((value, writer) -> writer.writeNumber(value.toString()))
                    .build();
            gson = new Gson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getJobListings();
    }

    public String getConnectionString() {
        return connectionString;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public MongoCollection<Document> getJobCollection() {
        return jobCollection;
    }

    public MongoCollection<Document> getApplicationCollection() {
        return applicationCollection;
    }

    @Override
    public ArrayList<JobListing> getJobListings() {
        ArrayList<JobListing> jobListings = new ArrayList<>();
        FindIterable<Document> iterDoc = jobCollection.find();
        for (Document document : iterDoc) {
            String json = document.toJson(settings);
            jobListings.add(gson.fromJson(json, JobListing.class));
        }
        return jobListings;
    }

    @Override
    public void applyJobListing(Application application) {
        Document document = Document.parse(application.toJson());
        applicationCollection.insertOne(document);
    }

    @Override
    public void createJobListing(JobListing jobListing) {
        Document document = Document.parse(jobListing.toJson());
        jobCollection.insertOne(document);
    }


    @Override
    public User getUser(String email, String password) {
        Document doc = jobSeekerCollection.find(Filters.eq("email", email)).first();
        User user;
        if (doc != null) {
            String json = doc.toJson(settings);
            user = (User) gson.fromJson(json, JobSeeker.class);

        } else {
            doc = employerCollection.find(Filters.eq("email", email)).first();
            if (doc != null) {
                String json = doc.toJson(settings);
                user = (User) gson.fromJson(json, Employer.class);
            } else {
                return null;
            }
        }
        if (password.equals("")) {
            return user;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker seeker) {
        Document document = Document.parse(seeker.toJson());
        jobSeekerCollection.insertOne(document);
        return seeker;
    }

    @Override
    public Employer createEmployer(Employer employer) {
        Document document = Document.parse(employer.toJson());
        employerCollection.insertOne(document);
        return employer;
    }

}
