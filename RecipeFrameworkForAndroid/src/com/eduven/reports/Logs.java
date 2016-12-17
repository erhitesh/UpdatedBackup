package com.eduven.reports;

import org.apache.log4j.Logger;

public class Logs {
	
	private static Logger Log = Logger.getLogger(Logs.class);
	
	/**
	 * This message is used to giving information about TestCase Execution start.
	 * @param sTestCaseName, TestCase Name.
	 */
	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");
		Log.info(">>>>>>>>>>>>>>>  " + sTestCaseName+"  >>>>>>>>>>>>>>>");
		Log.info("****************************************************************************************");

	}

	/**
	 * This message is used to giving information about TestCase Execution end.
	 * @param sTestCaseName, TestCase name
	 */
	public static void endTestCase(String sTestCaseName) {

		Log.info(">>>>>>>>>>>>>>>" + " -E---N---D- "+"  >>>>>>>>>>>>>>>");
		Log.info("X");
		Log.info("X");
	}
	
	/**
	 * This method is used to print info message
	 * @param message, message you want at execution time for giving some infromation.
	 */
	public static void info(String message) {

		Log.info(message);

	}
	
	/**
	 * This method is used to print warn message.
	 * @param message, message you want at execution time for giving some warning.
	 */
	public static void warn(String message) {
		Log.warn(message);
	}

	/**
	 * This method is used to print error message.
	 * @param message, message you want at execution time for giving some error.
	 */
	public static void error(String message) {
		Log.error(message);
	}

	/**
	 * This method is used to print fatal message.
	 * @param message, message you want at execution time for giving some fatal error.
	 */
	public static void fatal(String message) {
		Log.fatal(message);
	}

	/**
	 * This method is used to print debug message.
	 * @param message, message you want at execution time for giving some debugging related.
	 */
	public static void debug(String message) {
		Log.debug(message);
	}
}
