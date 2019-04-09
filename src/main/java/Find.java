import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Find {


    private static List<String> dLogick(File file, String fileName, boolean recursive, List<String> foundFiles) {
        File[] arrFiles = file.listFiles();
        for (File f : arrFiles) {
            if (f.toString().contains(fileName)) {
                foundFiles.add(f.toString());
            }
            if (f.isDirectory()) {
                if (recursive) dLogick(f, fileName, recursive, foundFiles);
            }
        }
        return foundFiles;
    }

    public static List<String> d(File file, String fileName, boolean recursive) {
        List<String> foundFiles = new ArrayList<>();
        return dLogick(file, fileName, recursive, foundFiles);
    }
}