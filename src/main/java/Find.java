import java.io.*;
import java.util.ArrayList;

public class Find {

    private final String directoryName;
    private final String fileName;
    private boolean haveFile;

    private String getDirectoryName() { return directoryName; }
    private String getFileName() { return fileName; }

    public Find(String directory, String file) {
        directoryName = directory;
        fileName = file;
    }

    public final void d(String directoryName, String fileName, boolean recursive) {
        File file = new File(directoryName);
        File[] arrFiles = file.listFiles();
        ArrayList<File> arrDirectories = new ArrayList<>();
        haveFile = false;
        for (File f : arrFiles) {
            if (f.toString().contains(fileName)) {
                haveFile = true;
            }
            if (f.isDirectory()) arrDirectories.add(f);
        }
        if (haveFile) {
            if (directoryName.equals(".")) System.out.println(fileName + " is in current directory.");
            else System.out.println(fileName + " is in " + directoryName);
        }
        if (recursive) {
            arrDirectories.forEach(f -> d(f.toString(), fileName, recursive));
            arrDirectories.remove(directoryName);
        }
    }

    public final void hasFile() {
        if (!haveFile) {
            if (directoryName.equals(".")) System.out.println("There is no " + fileName + " is in the current directory.");
            else System.out.println("There is no " + fileName + " in " + directoryName);
        }
    }
}
