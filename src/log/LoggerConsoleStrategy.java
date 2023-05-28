package log;

public class LoggerConsoleStrategy implements LoggerStrategyInterface {
    @Override
    public void log(String log) {
        System.out.println(log);
    }
}
