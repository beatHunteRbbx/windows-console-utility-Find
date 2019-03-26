import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collection;


public class Finder {

    public static void main(String[] args) throws IOException {
        /*new Finder().start(args);*/
        String jarPath = Finder.class.getProtectionDomain().getCodeSource().getLocation().getPath();  //возваращет путь испольняемого-jar файла
        System.out.println(jarPath);
        File file = new File("."); //путь к текущему каталогу
        System.out.println(file.toPath());
        /*File file = new File("something.txt");
        file.createNewFile();
        Files.copy(Paths.get("something.txt"), Paths.get("src\\something2.txt"));
        System.out.println(Files.isDirectory(Paths.get("something.txt")));
        System.out.println(Files.isDirectory(Paths.get("src")));*/
    }

    @Option(name = "-d", usage = "Find file in the current directory")
    private String directoryName;

    @Option(name = "-r", usage = "Find file in the current directory and in all subdirectories")
    private boolean recursive;

    @Argument(required = true, usage = "Name of file that needed to find", index = 0)
    private String outputName;

    public void start(String[] args) throws IllegalArgumentException {
        CmdLineParser parse = new CmdLineParser(this);
        try {
            parse.parseArgument(args);
        } catch (CmdLineException exc) {
            System.err.println(exc.getMessage());
            System.err.println("java -jar find.jar -r -d directoryName fileThatNeedToFind");
            parse.printUsage(System.err);
            return;
        }
    }

    private static void d(String directory) {

    }

}
