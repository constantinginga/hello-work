package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.hello.model.data.JobListing;
import work.hello.model.RabbitMQ;

import java.util.TreeMap;

@RestController public class ApplicationsController
{
  private static final Gson gson = new Gson();


  @GetMapping("/joblistings/getJobListings") public synchronized String getJobListings()
  {
    System.out.println("Recieved");
    return gson.toJson(RabbitMQ.getInstance().getJobListings());
  }

  @PutMapping("/applications/{application}") public synchronized void applyJobListing(
      @RequestBody String json, @PathVariable String application) {

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


}
