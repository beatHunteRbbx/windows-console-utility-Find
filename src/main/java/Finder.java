import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;


public class Finder {

    public static void main(String[] args) {
        new Finder().start(args);
    }

    @Option(name = "-d", usage = "Find file in the current directory")
    private File directory = new File(".");

    @Option(name = "-r", usage = "Find file in the current directory and in all subdirectories")
    private boolean recursive;

    @Argument(required = true, usage = "Name of file that needed to find", index = 0)
    private String fileName;

    private void start(String[] args) throws IllegalArgumentException {
        CmdLineParser parse = new CmdLineParser(this);
        try {
            parse.parseArgument(args);
        } catch (CmdLineException exc) {
            System.err.println(exc.getMessage());
            System.err.println("java -jar find.jar -r -d directory fileThatNeedToFind");
            parse.printUsage(System.err);
        }
        if (directory.isDirectory()) {
            for (String path : Find.d(directory, fileName, recursive)) System.out.println(path);
        }
    }
}
