import java.io.*;
import java.util.ArrayList;

public class Find {

    private static ArrayList<String> foundFiles = new ArrayList<>();

    public static ArrayList<String> d(File file, String fileName, boolean recursive) {
        File[] arrFiles = file.listFiles();
        for (File f : arrFiles) {
            if (f.toString().contains(fileName)) {
                foundFiles.add(f.toString());
            }
            if (f.isDirectory()) {
                if (recursive) d(f, fileName, recursive);
            }
        }
        return foundFiles;
    }
}