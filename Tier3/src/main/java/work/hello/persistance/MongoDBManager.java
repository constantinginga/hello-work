package work.hello.persistance;

import com.google.gson.Gson;
import com.mongodb.client.*;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import work.hello.model.data.Application;
import work.hello.model.data.JobListing;

import java.util.ArrayList;

public class MongoDBManager implements MongoDB {
    private final String connectionString = "mongodb+srv://hellowork:hellowork123@hellowork.7ufqy.mongodb.net/test";
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> jobCollection;
    private MongoCollection<Document> applicationCollection;
    private JsonWriterSettings settings;
    private Gson gson;

    public MongoDBManager() {

        try {
            MongoClient mongoClient = MongoClients.create(connectionString);
            mongoDatabase = mongoClient.getDatabase("hellowork");
            jobCollection = mongoDatabase.getCollection("Jobs");
            jobCollection.createIndex(Indexes.ascending("JobID"));
            applicationCollection = mongoDatabase.getCollection("Applications");
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

            document.toJson();
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

}
