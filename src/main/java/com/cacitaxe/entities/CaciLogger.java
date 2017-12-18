package com.cacitaxe.entities;

import org.apache.log4j.Logger;


public abstract class CaciLogger {
	public static Logger logger = Logger.getLogger(CaciLogger.class);
	
	/**
	 * 
	 * @param msg
	 * Log à titre informatif
	 */
	 public static void logInfo(String message){
		 logger.info(message);
	 }
	 
	 /**
	  * 
	  * @param msg
	  * Log d'erreures et exceptions
	  */
	 public static void logError(String message){
		 logger.error(message);
	 }
	 
	 public static void logError(String message,Throwable t){
		 logger.error(message,t);
	 }
	
}
