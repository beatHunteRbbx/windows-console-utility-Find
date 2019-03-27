import java.io.*;
import java.util.ArrayList;

public class Find {

    private final String directoryName;
    private final String fileName;

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
        boolean hasFile = false;
        for (File f : arrFiles) {
            if (f.toString().contains(fileName))
                hasFile = true;
            if (f.isDirectory()) arrDirectories.add(f);
        }
        if (hasFile) System.out.println(fileName + " is in " + directoryName);
        else if (!hasFile && recursive)
            arrDirectories.forEach(f -> d(f.toString(),fileName, recursive));
            arrDirectories.remove(directoryName);
        if (!hasFile && arrDirectories.isEmpty())
            System.out.println("There is no " + fileName + " in " + directoryName + " and in all subdirectories");
    }
}
