import enums.LogType;
import loggers.LogProcessor;
import loggers.impl.DebugLogger;
import loggers.impl.ErrorLogger;
import loggers.impl.InfoLogger;

public class MyLogger {
    private final LogProcessor logProcessor;

    public MyLogger() {
        logProcessor =  new ErrorLogger(new DebugLogger(new InfoLogger(null)));
    }

    public void log(LogType logType, String message) {
        logProcessor.log(logType, message);
    }
}
