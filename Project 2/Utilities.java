/**Utilities class is used to write messages to console and log file
 * @author Amruta Khot, Leena Singhal and Manali Bhalgat
 * @version 1.0.0
 */
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Timestamp;

public class Utilities {
    /**
     * Classify log as Error or Information
     */
    enum LogType {
        Error,
        Information
    }

    PrintWriter pw;

    Utilities(String logPath) {
        try {
            Files.deleteIfExists(FileSystems.getDefault().getPath(logPath));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(logPath, true)));
            } 
	catch (IOException e) 
	    {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    /**
     * This method reads messages from console
     */
    static String readFromConsole() throws IOException {
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    /**
     * This method prints messages to console
     */
    static void writeToConsole(String str) {
    	String message = "Information" + ": " + new Timestamp(new java.util.Date().getTime()) + ": " + str;
        System.out.println(message);
    }

    /**
     * This method writes log in the log file
     */
    void log(LogType type, String str) {
        String message = type.toString() + ": " + new Timestamp(new java.util.Date().getTime()) + ": " + str;
        pw.println(message);
        System.out.println(message);
        pw.flush();
    }

    /**
     * This method terminates the server when ctrl-c is pressed
     */
    public static void addShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.print("Shutting down ctrl-c pressed");
            }
        });
    }
}
