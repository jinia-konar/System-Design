package loggers.impl;

import enums.LogType;
import loggers.LogProcessor;

public class ErrorLogger extends LogProcessor {

    public ErrorLogger(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogType type, String message) {
        if (LogType.Error.equals(type)) {
            System.out.println(LogType.Error + ": " + message);
            return;
        }
        super.log(type, message);
    }
}
