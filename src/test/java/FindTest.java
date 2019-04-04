import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class FindTest {

    @Test
    public void dTest1() {
        File directory = new File("src");
        String fileName = "file.bat";
        boolean recursive = true;
        List<String> list = new ArrayList<>();
        list.add("src\\main\\file12\\file.bat");
        assertEquals(list, Find.d(directory, fileName, recursive));
    }

    @Test
    public void dTest2() {
        File directory = new File("src");
        String fileName = "file.bat";
        boolean recursive = true;
        ArrayList<String> list = new ArrayList<>();
        list.add("src\\main\\file11\\file111\\file.bat");
        list.add("src\\main\\file12\\file.bat");
        assertEquals(list, Find.d(directory, fileName, recursive));
    }
}
