package loggers.impl;

import enums.LogType;
import loggers.LogProcessor;

public class DebugLogger extends LogProcessor {

    public DebugLogger(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogType type, String message) {
        if (LogType.Debug.equals(type)) {
            System.out.println(LogType.Debug + ": " + message);
            return;
        }
        super.log(type, message);
    }
}
