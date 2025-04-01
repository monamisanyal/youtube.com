package youtube.com.utility;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log {

	public static Logger logger = LogManager.getLogger(Logger.class.getName());
	   // Method to log the start of a test case
    public static void startTestCase(String testCaseName) {
        logger.info("****************************************");
        logger.info("Starting Test Case: " + testCaseName);
        logger.info("****************************************");
    }

    // Method to log the end of a test case
    public static void endTestCase(String testCaseName) {
        logger.info("****************************************");
        logger.info("Ending Test Case: " + testCaseName);
        logger.info("****************************************");
    }
    // Static method to log DEBUG level messages
    public static void logDebug(String message) {
        logger.debug(message);
    }

 // Static method to log INFO level messages
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Static method to log WARN level messages
    public static void logWarn(String message) {
        logger.warn(message);
    }

    // Static method to log ERROR level messages
    public static void logError(String message) {
        logger.error(message);
    }

    // Static method to log FATAL level messages
    public static void logFatal(String message) {
        logger.fatal(message);
    }

    // Static method to log ERROR messages with exceptions
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
	
}
