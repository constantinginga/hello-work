package work.hello.data;

import com.google.gson.Gson;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;

/**
 * The type Job listing.
 */
public class JobListing
{
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
  private String Employer;

  /**
   * Instantiates a new Job listing.
   *
   * @param jobId               the job id
   * @param jobTitle            the job title
   * @param jobType             the job type
   * @param location            the location
   * @param experienceLevel     the experience level
   * @param jobRequirments      the job requirments
   * @param jobPrivilleges      the job privilleges
   * @param phoneNumber         the phone number
   * @param email               the email
   * @param applicationDeadline the application deadline
   * @param employer            the employer
   */
  public JobListing(int jobId, String jobTitle, String jobType, String location,
      float experienceLevel, ArrayList<String> jobRequirments,
      ArrayList<String> jobPrivilleges, String phoneNumber, String email,
      String applicationDeadline, String employer)
  {
    JobId = jobId;
    JobTitle = jobTitle;
    JobType = jobType;
    Location = location;
    ExperienceLevel = experienceLevel;
    JobRequirments = jobRequirments;
    JobPrivilleges = jobPrivilleges;
    PhoneNumber = phoneNumber;
    Email = email;
    ApplicationDeadline = applicationDeadline;
    Employer = employer;
  }

  /**
   * Gets job id.
   *
   * @return the job id
   */
  public int getJobId()
  {
    return JobId;
  }

  /**
   * Sets job id.
   *
   * @param jobId the job id
   */
  public void setJobId(int jobId)
  {
    JobId = jobId;
  }

  public boolean validate()
  {
    return EmailValidator.getInstance().isValid(getEmail()) && getJobId() >= 0 && getJobId() != 0;
  }

  /**
   * To json string.
   *
   * @return the string
   */
  public String toJson()
  {
    return gson.toJson(this);
  }

  /**
   * Gets job type.
   *
   * @return the job type
   */
  public String getJobType()
  {
    return JobType;
  }

  /**
   * Sets job type.
   *
   * @param jobType the job type
   */
  public void setJobType(String jobType)
  {
    JobType = jobType;
  }

  /**
   * Gets location.
   *
   * @return the location
   */
  public String getLocation()
  {
    return Location;
  }

  /**
   * Sets location.
   *
   * @param location the location
   */
  public void setLocation(String location)
  {
    Location = location;
  }

  /**
   * Gets experience level.
   *
   * @return the experience level
   */
  public float getExperienceLevel()
  {
    return ExperienceLevel;
  }

  /**
   * Sets experience level.
   *
   * @param experienceLevel the experience level
   */
  public void setExperienceLevel(float experienceLevel)
  {
    ExperienceLevel = experienceLevel;
  }

  /**
   * Gets job requirments.
   *
   * @return the job requirments
   */
  public ArrayList<String> getJobRequirments()
  {
    return JobRequirments;
  }

  /**
   * Sets job requirments.
   *
   * @param jobRequirments the job requirments
   */
  public void setJobRequirments(ArrayList<String> jobRequirments)
  {
    JobRequirments = jobRequirments;
  }

  /**
   * Gets job privilleges.
   *
   * @return the job privilleges
   */
  public ArrayList<String> getJobPrivilleges()
  {
    return JobPrivilleges;
  }

  /**
   * Sets job privilleges.
   *
   * @param jobPrivilleges the job privilleges
   */
  public void setJobPrivilleges(ArrayList<String> jobPrivilleges)
  {
    JobPrivilleges = jobPrivilleges;
  }

  /**
   * Gets phone number.
   *
   * @return the phone number
   */
  public String getPhoneNumber()
  {
    return PhoneNumber;
  }

  /**
   * Sets phone number.
   *
   * @param phoneNumber the phone number
   */
  public void setPhoneNumber(String phoneNumber)
  {
    PhoneNumber = phoneNumber;
  }

  /**
   * Gets job title.
   *
   * @return the job title
   */
  public String getJobTitle()
  {
    return JobTitle;
  }

  /**
   * Sets job title.
   *
   * @param jobTitle the job title
   */
  public void setJobTitle(String jobTitle)
  {
    JobTitle = jobTitle;
  }

  /**
   * Gets employer.
   *
   * @return the employer
   */
  public String getEmployer()
  {
    return Employer;
  }

  /**
   * Sets employer.
   *
   * @param employer the employer
   */
  public void setEmployer(String employer)
  {
    Employer = employer;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail()
  {
    return Email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email)
  {
    Email = email;
  }

  /**
   * Gets application deadline.
   *
   * @return the application deadline
   */
  public String getApplicationDeadline()
  {
    return ApplicationDeadline;
  }

  /**
   * Sets application deadline.
   *
   * @param applicationDeadline the application deadline
   */
  public void setApplicationDeadline(String applicationDeadline)
  {
    ApplicationDeadline = applicationDeadline;
  }

  public static JobListing fromJson(String json)
  {
    return gson.fromJson(json, JobListing.class);
  }

}
