package work.hello.model.data;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class JobListing {
    private int JobId;
    private static final Gson gson = new Gson();
    private String JobTitle;
    private String JobType;
    private String Location;
    private float ExperienceLevel;
    private ArrayList<String> JobRequirments;
    private ArrayList<String> JobPrivilleges;
    private String PhoneNumber;
    private String Email;
    private String ApplicationDeadline;

    public JobListing(int jobID, String jobTitle, String jobType, String location, int experienceLevel, ArrayList<String> jobRequirments,
        ArrayList<String> jobPrivilleges, String phoneNumber, String email, String applicationDeadline)
        throws ParseException
    {
        JobId = jobID;
        JobTitle = jobTitle;
        JobType = jobType;
        Location = location;
        ExperienceLevel = experienceLevel;
        JobRequirments = jobRequirments;
        JobPrivilleges = jobPrivilleges;
        PhoneNumber = phoneNumber;
        Email = email;
        System.out.println(applicationDeadline);
        ApplicationDeadline = applicationDeadline;
    }

    public String getJobType()
    {
        return JobType;
    }

    public void setJobType(String jobType)
    {
        JobType = jobType;
    }

    public String getLocation()
    {
        return Location;
    }

    public void setLocation(String location)
    {
        Location = location;
    }

    public float getExperienceLevel()
    {
        return ExperienceLevel;
    }

    public void setExperienceLevel(float experienceLevel)
    {
        ExperienceLevel = experienceLevel;
    }

    public ArrayList<String> getJobRequirments()
    {
        return JobRequirments;
    }

    public void setJobRequirments(ArrayList<String> jobRequirments)
    {
        JobRequirments = jobRequirments;
    }

    public ArrayList<String> getJobPrivilleges()
    {
        return JobPrivilleges;
    }

    public void setJobPrivilleges(ArrayList<String> jobPrivilleges)
    {
        JobPrivilleges = jobPrivilleges;
    }

    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        PhoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public String getApplicationDeadline()
    {
        return ApplicationDeadline;
    }

    public void setApplicationDeadline(String applicationDeadline)
    {
        ApplicationDeadline = applicationDeadline;
    }


    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public boolean validate(JobListing jobListing)
    {
       return false;
    }

    public String toJson()
    {
        return gson.toJson( this );
    }


    public static JobListing fromJson( String json )
    {
        return gson.fromJson( json, JobListing.class );
    }
}
