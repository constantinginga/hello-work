package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.data.SavedJobListing;
import work.hello.model.RabbitMQ;

@RestController
public class SavedJobListingController {
    private static final Gson gson = new Gson();

    @GetMapping("/saved")
    public synchronized String getSavedJobListings() {
        return gson.toJson(RabbitMQ.getInstance().getSavedJobListings());
    }

    @PostMapping("/saved")
    public synchronized String createSavedJobListing(@RequestBody String json) {
        SavedJobListing savedJobListing = SavedJobListing.fromJson(json);
        if (true) {
            RabbitMQ.getInstance().createSavedJobListing(savedJobListing);
            return savedJobListing.toJson();
        } else {
            return "Validation incorrect";
        }
    }
    @DeleteMapping("/saved") public synchronized String deleteSavedJobListing(
            @RequestParam String id) {
        if (true) {
            RabbitMQ.getInstance().deleteSavedJobListing(id);
            return "Deleted";
        } else {
            return "Validation incorrect";
        }
    }
}
