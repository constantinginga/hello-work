package work.hello.model.data;

import com.google.gson.Gson;

public class Application {
    private int JobId;
    private String Details;
    private static final Gson gson = new Gson();

    public Application(int jobId, String details) {
        JobId = jobId;
        Details = details;
    }

    public int getJobID() {
        return JobId;
    }

    public void setJobID(int jobID) {
        JobId = jobID;
    }

    public String getApplication() {
        return Details;
    }

    public void setApplication(String details) {
        Details = details;
    }

    public String toJson()
    {
        return gson.toJson( this );
    }


    public static Application fromJson( String json )
    {
        return gson.fromJson( json, Application.class );
    }

    public boolean validate()
    {
        return getJobID() >= 0 && getJobID() != 0 && getApplication() != null && getApplication().length() > 1;
    }

}
