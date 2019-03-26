import java.io.*;

public class Find {

    private final String directoryName;
    private final String fileName;

    private String getDirectoryName() { return directoryName; }
    private String getFileName() { return fileName; }

    public Find(String directory, String file) {
        directoryName = directory;
        fileName = file;
    }

    public final String d(String directoryName, String fileName) {
        File file = new File(directoryName);
        File[] arrFiles = file.listFiles();
        boolean hasFile = false;
        for (File f : arrFiles) {
            if (f.toString().contains(fileName)) hasFile = true;
        }
        if (hasFile) return directoryName;
        else return "There is no " + fileName + " in this directory.";
    }
}
