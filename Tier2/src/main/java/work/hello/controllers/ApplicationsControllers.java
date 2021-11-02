package work.hello.controllers;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;
import work.hello.model.data.Application;
import work.hello.model.RabbitMQ;


@RestController public class ApplicationsControllers
{
  private static final Gson gson = new Gson();

  @GetMapping("/joblistings/getJobListings") public synchronized String getJobListings()
  {
    return gson.toJson(RabbitMQ.getInstance().getJobListings());
  }

  @PostMapping("/applications") public synchronized void applyJobListing(@RequestBody String json) {
      Application newApplication = Application.fromJson(json);
      if (true)
      {
        RabbitMQ.getInstance().applyForJob(newApplication);
      }
      else {
        System.out.println("Validation incorrect");
      }
    }
}
