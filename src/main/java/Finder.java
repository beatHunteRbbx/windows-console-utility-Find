import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.nio.file.*;
import java.util.Collection;


public class Finder {

    public static void main(String[] args) {
        /*new Finder().start(args);*/
        String jarPath = Finder.class.getProtectionDomain().getCodeSource().getLocation().getPath();  //возваращет путь испольняемого-jar файла
        System.out.println(jarPath);
    }

    @Option(name = "-d", usage = "Find file in the current directory")
    private String directoryName;

    @Option(name = "-r", usage = "Find file in the current directory and in all subdirectories")

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
