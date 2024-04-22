package com.tigo.EmShareKernel.log;

import static org.apache.logging.log4j.LogManager.getLogger;

import org.slf4j.LoggerFactory;

public interface IEventLogger {

	void log(String message);

	void logException(String message, Exception e);

	void debug(String message);

	void info(String message);

	void warn(String message);

	void error(String message);

	void logInfo(String uuid, String stepEvent);

}
