package com.eduven.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.xml.sax.SAXException;

import com.eduven.report.ExcelReportGenerator;
import com.eduven.report.SendTestStatusToMail;


public class RunTestng {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		/* Create XmlSuite Instance */
		XmlSuite suite = new XmlSuite();
		
	    /* Set XmlSuite name, verbose and order */
		suite.setName("Suite For Android Testing");
		suite.setVerbose(2);
		//suite.setPreserveOrder("true");
		
		/* Create instance of XmlTest */
		XmlTest test = new XmlTest(suite);
		test.setName("Regressing Testing");
		
		/* Add class to the XmlClass */
		List<XmlClass> classes = new ArrayList<XmlClass>();
		for ( int i = 0; i < ExcelOperation.getSheetDataValues().size(); i++){
			List<String> sheet_rows_value = (List<String>) ExcelOperation.getSheetDataValues().get(i);
			if(sheet_rows_value.get(1).equalsIgnoreCase("y")){
				classes.add(new XmlClass(sheet_rows_value.get(2)));
			}	
		}
		
		/* Add classes to the XmlTest */
		test.setXmlClasses(classes);
		
		/* Create a list of XmlTests and add the XmlTest above created. */
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(test);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		
		/* Create instance of TestNG */
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		
		/* Run TestNG */
		testng.run();
		
		try {
			ExcelReportGenerator.generateReport("excelreports.xlsx");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Sending report to mail */
		SendTestStatusToMail.sendReportToMail();
	}
}
