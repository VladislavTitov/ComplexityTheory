import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyLogger {

    public static final String pathToLogFile = System.getProperty("user.dir") + "/src/main/resources/log/log.txt";

    public static PrintWriter writer;

    static  {
        try {
            writer = new PrintWriter(pathToLogFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void log(String text){
        writer.print(text);
        writer.flush();
    }

    public static void logTime(long time){
        writer.print(time);
        writer.flush();
    }

    public static void append(String text){
        writer.append(text);
        writer.flush();
    }

    public static void newLine(){
        writer.println();
    }
}
