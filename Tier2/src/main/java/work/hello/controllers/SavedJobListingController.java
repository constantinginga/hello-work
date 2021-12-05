package work.hello.controllers;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import work.hello.data.SavedJobListing;
import work.hello.model.RabbitMQ;

/**
 * The type Saved job listing controller.
 */
@RestController
public class SavedJobListingController {
    private static final Gson gson = new Gson();

    /**
     * Gets saved job listings.
     *
     * @return the saved job listings
     */
    @GetMapping("/saved")
    public synchronized String getSavedJobListings() {
        return gson.toJson(RabbitMQ.getInstance().getSavedJobListings());
    }

    /**
     * Create saved job listing string.
     *
     * @param json the json of saved job listing
     * @return the response
     */
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

    /**
     * Delete saved job listing string.
     *
     * @param id the id of saved job listing
     * @return the response
     */
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
