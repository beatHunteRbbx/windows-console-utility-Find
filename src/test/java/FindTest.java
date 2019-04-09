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
        list.clear();
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

    @Test
    public void dTest3() {
        File directory = new File(".");
        String fileName = "file.bat";
        boolean recursive = false;
        ArrayList<String> list = new ArrayList<>();
        list.add(".\\file.bat");
        assertEquals(list, Find.d(directory, fileName, recursive));
    }

    @Test
    public void dTest4() {
        File directory = new File("src\\main");
        String fileName = "file.bat";
        boolean recursive = false;
        ArrayList<String> list = new ArrayList<>();
        assertEquals(list, Find.d(directory, fileName, recursive));
    }
}
