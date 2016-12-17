package test.log;

import org.apache.log4j.Logger;

public class LoggerTest {
	
	private static Logger logger = Logger.getLogger(LoggerTest.class.getName());
	
	public static void startTestCase(String sTestCaseName) {

		logger.info("****************************************************************************************");
		logger.info(">>>>>>>>>>>>>>>  " + sTestCaseName+"  >>>>>>>>>>>>>>>");
		logger.info("****************************************************************************************");

	}

	/**
	 * This message is used to giving information about TestCase Execution end.
	 * @param sTestCaseName, TestCase name
	 */
	public static void endTestCase(String sTestCaseName) {

		logger.info(">>>>>>>>>>>>>>>" + " -E---N---D- "+"  >>>>>>>>>>>>>>>");
		logger.info("X");
		logger.info("X");
	}
	
	/**
	 * This method is used to print info message
	 * @param message, message you want at execution time for giving some infromation.
	 */
	public static void info(String message) {

		logger.info(message);

	}
	
	/**
	 * This method is used to print warn message.
	 * @param message, message you want at execution time for giving some warning.
	 */
	public static void warn(String message) {
		logger.warn(message);
	}

	/**
	 * This method is used to print error message.
	 * @param message, message you want at execution time for giving some error.
	 */
	public static void error(String message) {
		logger.error(message);
	}

	/**
	 * This method is used to print fatal message.
	 * @param message, message you want at execution time for giving some fatal error.
	 */
	public static void fatal(String message) {
		logger.fatal(message);
	}

	/**
	 * This method is used to print debug message.
	 * @param message, message you want at execution time for giving some debugging related.
	 */
	public static void debug(String message) {
		logger.debug(message);
	}
	
	

}
