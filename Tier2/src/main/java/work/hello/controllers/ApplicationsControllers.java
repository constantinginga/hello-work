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

  @PutMapping("/applications/{application}") public synchronized void applyJobListing(@RequestBody String json, @PathVariable String application) {
      Application newApplication = Application.fromJson(json);
      if (newApplication.validate())
      {
        RabbitMQ.getInstance().applyForJob(Application.fromJson(application));
      }
      else {
        System.out.println("Validation incorrect");
      }
    }
}
