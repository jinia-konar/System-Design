package loggers;

import enums.LogType;

public abstract class LogProcessor {
    private final LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(LogType type, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(type, message);
        }
    }
}
