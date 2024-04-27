package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private static final Logger logHelper = LogManager.getLogger(LogHelper.class);


    public static void info(String message) {
        logHelper.info(message);
    }

    public static void info(Object object) {
        logHelper.info(object);
    }

    public static void warn(String message) {
        logHelper.warn(message);
    }

    public static void warn(Object object) {
        logHelper.warn(object);
    }


    public static void error(String message) {
        logHelper.error(message);
    }

    public static void error(Object object) {
        logHelper.error(object);
    }


    public static void fatal(String message) {
        logHelper.fatal(message);
    }


    public static void debug(String message) {
        logHelper.debug(message);
    }

    public static void debug(Object object) {
        logHelper.debug(object);
    }

}
