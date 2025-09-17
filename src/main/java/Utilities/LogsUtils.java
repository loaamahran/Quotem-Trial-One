package Utilities;


import org.apache.logging.log4j.LogManager;

public class LogsUtils {
public static String LOGS_PATH="Test-output/Logs/";
public void trace(String message){
    LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).trace(message);
}
public void debug(String message){
LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).debug(message); }
public void warn(String message){
   LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).warn(message);

    }
    public void error(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).error(message);

    }
    public void fatal(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).fatal(message);

    }
    public static void info(String message){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).info(message);

    }
}

