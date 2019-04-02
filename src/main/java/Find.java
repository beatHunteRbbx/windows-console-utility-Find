import java.io.*;
import java.util.ArrayList;

public class Find {
    public static final void d(File file, String fileName, boolean recursive) {
        File[] arrFiles = file.listFiles();
        for (File f : arrFiles) {
            if (f.toString().contains(fileName)) {
                System.out.println(f.toString());
            }
            if (f.isDirectory()) if (recursive) d(f, fileName, recursive);
        }
    }

}
