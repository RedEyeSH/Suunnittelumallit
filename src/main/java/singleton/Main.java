package singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_log.txt");
        logger.log("Starting simulation...");
        logger.log("Processing data...");
        logger.log("Simulation finished");

        logger.close();
    }
}
