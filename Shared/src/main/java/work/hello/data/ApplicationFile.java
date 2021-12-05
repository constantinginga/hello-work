package work.hello.data;

import com.google.gson.Gson;

import java.util.concurrent.RecursiveTask;

/**
 * The type Application file.
 */
public class ApplicationFile {
    private String FileName;
    private String ApplicationId;
    private String File;
    private static Gson gson = new Gson();

    /**
     * Instantiates a new Application file.
     *
     * @param fileName      the file name
     * @param applicationId the application id
     * @param file          the file
     */
    public ApplicationFile(String fileName, String applicationId, String file) {
        FileName = fileName;
        ApplicationId = applicationId;
        File = file;
    }

    /**
     * Instantiates a new Application file.
     */
    public ApplicationFile() {
    }

    /**
     * From json application file.
     *
     * @param content the content
     * @return the application file
     */
    public static ApplicationFile fromJson(String content) {
        return gson.fromJson(content, ApplicationFile.class);
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
        return gson.toJson(this);
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return FileName;
    }

    /**
     * Sets file name.
     *
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        FileName = fileName;
    }

    /**
     * Gets file.
     *
     * @return the file
     */
    public String getFile() {
        return File;
    }

    /**
     * Sets file.
     *
     * @param file the file
     */
    public void setFile(String file) {

        File = file;
    }

    /**
     * Gets application id.
     *
     * @return the application id
     */
    public String getApplicationId() {
        return ApplicationId;
    }

    /**
     * Sets application id.
     *
     * @param applicationId the application id
     */
    public void setApplicationId(String applicationId) {
        ApplicationId = applicationId;
    }
}
