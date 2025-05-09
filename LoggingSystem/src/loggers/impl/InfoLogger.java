package loggers.impl;

import enums.LogType;
import loggers.LogProcessor;

public class InfoLogger extends LogProcessor {

    public InfoLogger(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(LogType type, String message) {
        if (LogType.Info.equals(type)) {
            System.out.println(LogType.Info + ": " + message);
            return;
        }
        super.log(type, message);
    }
}
