package java8.ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DelayLogger {
	private final Logger logger;

	public DelayLogger(Logger logger, Level level) {
		this.logger = logger;
		setLogLevel(level);
	}

	public void setLogLevel(Level level) {
		logger.setLevel(level);
	}

	public void logIf(Level level, BooleanSupplier condition, Supplier<String> message) {
		if (logger.isLoggable(level)) {
			if (condition.getAsBoolean()) {
				logger.log(level, message.get());
			}
		}
	}
	
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("sampleLogger");
		DelayLogger delayLogger = new DelayLogger(logger, Level.SEVERE);
		delayLogger.logIf(Level.INFO, () -> true, () -> "info log");
		delayLogger.logIf(Level.WARNING, () -> true, () -> "warning log");
		delayLogger.logIf(Level.SEVERE, () -> true, () -> "severe log");
		
	}

}
