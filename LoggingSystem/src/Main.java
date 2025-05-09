import enums.LogType;

public class Main {
    public static void main(String[] args) {
        System.out.println("Logging System");
        MyLogger logger = new MyLogger();
        logger.log(LogType.Info, "Printing my info log");
        logger.log(LogType.Debug, "Printing my debug log");
        logger.log(LogType.Error, "Printing my error log");
    }
}