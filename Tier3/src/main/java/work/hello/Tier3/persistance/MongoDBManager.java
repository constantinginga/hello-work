package work.hello.Tier3.persistance;

import com.mongodb.client.*;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import work.hello.Tier3.Model.Application;
import work.hello.Tier3.Model.JobListing;

import java.util.ArrayList;
import java.util.Iterator;

public class MongoDBManager implements MongoDB
{
  private final String connectionString = "mongodb+srv://hellowork:hellowork123@hellowork.7ufqy.mongodb.net/test";
  private MongoClient mongoClient;
  private MongoDatabase mongoDatabase;
  private MongoCollection<Document> jobCollection;
  private MongoCollection<Document> applicationCollection;

  public MongoDBManager()
  {

    try
    {
      MongoClient mongoClient = MongoClients.create(connectionString);
      mongoDatabase = mongoClient.getDatabase("hellowork");
      jobCollection = mongoDatabase.getCollection("JobID");
      jobCollection.createIndex(Indexes.ascending("world"));
      applicationCollection = mongoDatabase.getCollection("application");

    }
    catch (Exception e)
    {
      e.printStackTrace();
    } getJobListings();
  }

  public String getConnectionString()
  {
    return connectionString;
  }

  public MongoClient getMongoClient()
  {
    return mongoClient;
  }

  public MongoDatabase getMongoDatabase()
  {
    return mongoDatabase;
  }

  public MongoCollection<Document> getJobCollection()
  {
    return jobCollection;
  }

  public MongoCollection<Document> getApplicationCollection()
  {
    return applicationCollection;
  }

  @Override public ArrayList<JobListing> getJobListings()
  {
    jobCollection
        .insertOne(new Document("JobID", 1).append("Details", "Software"));
    ArrayList<JobListing> jobListings = new ArrayList<>();
    FindIterable<Document> iterDoc = jobCollection.find();
    for (Document document : iterDoc)
    {
      jobListings.add(new JobListing(document.getInteger("JobID"),
          document.getString("Details")));
    }
    for (JobListing jobListing : jobListings)
    {
      System.out.println(jobListing.getJobID());
    }
    return jobListings;
  }

  @Override public void applyJobListing(Application application)
  {

  }
}
