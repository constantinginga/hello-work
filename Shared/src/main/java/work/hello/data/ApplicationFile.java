package work.hello.data;

public class ApplicationFile {
    private String FileName;
    private String File;

    public ApplicationFile(String fileName, String file) {
        FileName = fileName;
        File = file;
    }

    public ApplicationFile() {
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
}
