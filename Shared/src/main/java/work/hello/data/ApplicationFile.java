package work.hello.data;

import com.google.gson.Gson;

import java.util.concurrent.RecursiveTask;

public class ApplicationFile {
    private String FileName;
    private String ApplicationId;
    private String File;
    private static Gson gson = new Gson();

    public ApplicationFile(String fileName, String applicationId, String file) {
        FileName = fileName;
        ApplicationId = applicationId;
        File = file;
    }

    public ApplicationFile() {
    }

    public static ApplicationFile fromJson(String content) {
        return gson.fromJson(content, ApplicationFile.class);
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {

        File = file;
    }

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String applicationId) {
        ApplicationId = applicationId;
    }
}
