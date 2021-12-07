package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.model.RabbitMQ;
import work.hello.data.JobListing;

import java.util.ArrayList;

@RestController public class JobController
{
  private static final Gson gson = new Gson();

  @GetMapping("/job") public synchronized String getJobListings()
  {
    ArrayList<JobListing> jobListings = RabbitMQ.getInstance().getJobListings();
    return gson.toJson(RabbitMQ.getInstance().getJobListings());
  }

  @PostMapping("/job") public synchronized String postJobListings(
      @RequestBody String json)
  {
    JobListing newJobListing = JobListing.fromJson(json);
    if (newJobListing.validate())
    {
      RabbitMQ.getInstance().createJobListing(newJobListing);
      return newJobListing.toJson();
    }
    else
    {
      return "Validation incorrect";
    }
  }

  @PatchMapping("/job") public synchronized String updateJobListing(@RequestBody String json)
  {
    JobListing updateJobListing = JobListing.fromJson(json);
    if(updateJobListing.validate())
    {
      RabbitMQ.getInstance().updateJobListing(updateJobListing);
      return updateJobListing.toJson();
    }
    else
    {
      return "Validation incorrect";
    }
  }


  @DeleteMapping("/job") public synchronized String deleteJobListing(
      @RequestParam String id)
  {
    if (RabbitMQ.getInstance().deleteJobListing(id))
    {
      return "Deleted";
    }
    return "Not Found";
  }
}
