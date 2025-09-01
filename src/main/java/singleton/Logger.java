package singleton;

import java.io.*;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    private Logger() {
        this.fileName = "default.log";
        openFile();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void openFile() {
        try {
            if (writer != null) {
                writer.close();
            }
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void setFileName(String fileName) {
        this.fileName = fileName;
        openFile();
    }

    public synchronized void log(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
