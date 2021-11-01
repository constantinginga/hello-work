package work.hello.model.data;

import com.google.gson.Gson;

public class Application {
    private int JobID;
    private String Application;
    private static final Gson gson = new Gson();

    public Application(int jobID, String application) {
        JobID = jobID;
        Application = application;
    }

    public int getJobID() {
        return JobID;
    }

    public void setJobID(int jobID) {
        JobID = jobID;
    }

    public String getApplication() {
        return Application;
    }

    public void setApplication(String application) {
        Application = application;
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
        return false;
    }

}
