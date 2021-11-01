package work.hello;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController public class ApplicationsController
{
  private static final Gson gson = new Gson();

  @Autowired private RabbitTemplate template;

  private TreeMap<Integer, JobListing> joblisting = new TreeMap<Integer, JobListing>();
  private RabbitMQ rabbitMQ;

  @GetMapping("/joblistings/getJobListings") public synchronized String getJobListings()
  {
    return gson.toJson(getRabbitMQ().getJobListings());
  }

  @PutMapping("/applications/{application}") public synchronized void applyJobListing(
      @RequestBody String json, @PathVariable String application)
      throws Exception
  {
    Application application1 = new Application(++Tier2Application.deleteLater, "VERY GOOD APPLICATION");
    getRabbitMQ().applyForJob(application1);

//    Application newApplication = Application.fromJson(json);
//    if (newApplication.validate())
//    {
//      //getRabbitMQ().applyForJob(Application.fromJson(application));
//
//    }
//    else
//    {
//      throw new Exception("Validation failed");
//    }
  }

  public RabbitMQ getRabbitMQ()
  {
    if (rabbitMQ == null)
    {
      rabbitMQ = new RabbitMQ(template);
    }
    return rabbitMQ;
  }
}
