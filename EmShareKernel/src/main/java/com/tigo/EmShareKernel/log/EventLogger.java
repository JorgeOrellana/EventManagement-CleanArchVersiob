package com.tigo.EmShareKernel.log;

import static org.apache.logging.log4j.LogManager.getLogger;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventLogger implements IEventLogger{

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void logException(String message, Exception e) {
		// TODO Auto-generated method stub
		System.out.println(message);
		System.out.println(e.toString());
		e.printStackTrace();
	}
	
	private Logger logger;
	private Class myClass;

	  public EventLogger(Class<?> clazz) {
	    this.logger = LoggerFactory.getLogger(clazz);
	    this.myClass = clazz;
	  }

	  @Override
	  public void debug(String message) {
	    logger.debug("[Custom Debug] " + message);
	  }

	  @Override
	  public void info(String message) {
	    logger.info("[Custom Info] " + message);
	  }

	  @Override
	  public void warn(String message) {
	    logger.warn("[Custom Warning] " + message);
	  }

	  @Override
	  public void error(String message) {
	    logger.error("[Custom Error] " + message);
	  }

	  @Override
	  public void logInfo(String uuid, String stepEvent) {
	    String setMessage = String.format("[Custom Info] %s %s %s %s", LocalDateTime.now().toString(), this.myClass, uuid,
	        stepEvent);
	    getLogger().info(setMessage);
	  }

}
