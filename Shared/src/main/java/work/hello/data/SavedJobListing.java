package work.hello.data;
import com.google.gson.Gson;
import org.apache.commons.validator.routines.EmailValidator;

public class SavedJobListing {
    public String Email;
    public int JobId;
    public int Id;
    private static final Gson gson = new Gson();


    public SavedJobListing(String email, int JobId,int Id)
    {
        this.Email = email;
        this.JobId = JobId;
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public boolean validate()
    {
        return EmailValidator.getInstance().isValid(Email) && JobId != 0 && Id != 0;
    }

    public static SavedJobListing fromJson(String json) {
        SavedJobListing savedJobListing = gson.fromJson(json, SavedJobListing.class);
        return savedJobListing;
    }
}
