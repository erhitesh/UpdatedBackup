package com.eduven.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExcelReportGenerator {

	public static void generateReport(String destFileName)
			throws ParserConfigurationException, SAXException, IOException {

		String path = ExcelReportGenerator.class.getClassLoader()
				.getResource("./").getPath();
		

		/* Replace bin to src */
		path = path.replace("bin", "src");
		
		System.out.println(path);

		/* Create new file for test out */
		File xmlfile = new File(path + "../test-output/testng-results.xml");

		/* Read XML file using SAX parsing */
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder();
		Document doc = builder.parse(xmlfile);
		doc.getDocumentElement().normalize();

		/* Create workbook instance*/
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFCellStyle fail = workbook.createCellStyle();
		XSSFCellStyle pass = workbook.createCellStyle();
		XSSFCellStyle skip = workbook.createCellStyle();
		
		// Set The Sheet Name Header Font
		XSSFCellStyle header_font = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		/* Under line */
		//font.setUnderline(Font.U_SINGLE); // Underline
		header_font.setFont(font);
		
		/* TestList */
		NodeList test_list = doc.getElementsByTagName("test");

		for (int i = 0; i < test_list.getLength(); i++) {
			int row = 1; /* because 0th index is header name.*/
			Node test_node = test_list.item(i);
			String test_name = ((Element) test_node).getAttribute("name");
			XSSFSheet sheet = workbook.createSheet(test_name);
			NodeList class_list = ((Element) test_node).getElementsByTagName("class");

			for (int j = 0; j < class_list.getLength(); j++) {
				Node class_node = class_list.item(j);
				String class_name = ((Element) class_node).getAttribute("name");
				NodeList test_method_list = ((Element) class_node).getElementsByTagName("test-method");
				for (int k = 0; k < test_method_list.getLength(); k++) {
					Node test_method_node = test_method_list.item(k);

					String test_method_name = ((Element) test_method_node).getAttribute("name");
					String test_method_started_time = ((Element) test_method_node).getAttribute("started-at");
					String test_method_status = ((Element) test_method_node).getAttribute("status");
					String test_method_end_time = ((Element) test_method_node).getAttribute("finished-at");
					String test_error_description_message = ((Element) test_method_node).getAttribute("message");
					
					/* Setting Sheet Row Header Name. */
					XSSFRow row_for_header = sheet.createRow(0);
		
					XSSFRow rows = sheet.createRow(row++);
					
					/* Set the color value for fail, pass & skip..red, green & black */
					fail.setFillForegroundColor(HSSFColor.RED.index);
					pass.setFillForegroundColor(HSSFColor.GREEN.index);
					skip.setFillForegroundColor(HSSFColor.YELLOW.index);
					
					/* Set style */
					fail.setFillPattern(CellStyle.SOLID_FOREGROUND);
					pass.setFillPattern(CellStyle.SOLID_FOREGROUND);
					skip.setFillPattern(CellStyle.SOLID_FOREGROUND);

					/* For Testcase Class */
					XSSFCell cell_class_name = rows.createCell(0);
					XSSFCell cell_class_name_header = row_for_header.createCell(0);
					cell_class_name_header.setCellValue("ClassName-WithPackageName");
					cell_class_name_header.setCellStyle(header_font);
					cell_class_name.setCellValue(class_name); //class_name+"."+test+method_name
					
					/* TestCase Name */
					XSSFCell cell_test_name = rows.createCell(1);
					XSSFCell cell_test_name_header = row_for_header.createCell(1);
					cell_test_name_header.setCellValue("Test-Name");
					cell_test_name_header.setCellStyle(header_font);
					cell_test_name.setCellValue(test_method_name);
					
					/*  Start time */
					XSSFCell cell_started_time = rows.createCell(2);
					XSSFCell cell_startTime_header = row_for_header.createCell(2);
					cell_startTime_header.setCellValue("Start-Time");
					cell_startTime_header.setCellStyle(header_font);
					cell_started_time.setCellValue(test_method_started_time);

					/* Test status */
					XSSFCell cell_status = rows.createCell(3);
					XSSFCell cell_status_header = row_for_header.createCell(3);
					cell_status_header.setCellValue("Test-Status");
					cell_status_header.setCellStyle(header_font);
					cell_status.setCellValue(test_method_status);
					
					
					if ("fail".equalsIgnoreCase(test_method_status)){
						cell_status.setCellStyle(fail);
					}
					
					else if ("pass".equalsIgnoreCase(test_method_status)) {
						cell_status.setCellStyle(pass);
					}
					
					else {
						cell_status.setCellStyle(skip);
					}
					
					
					/* Test case Finish time */
					XSSFCell cell_end_time = rows.createCell(6);
					XSSFCell cell_end_time_header = row_for_header.createCell(6);
					cell_end_time_header.setCellValue("End-Time");
					cell_end_time_header.setCellStyle(header_font);
					cell_end_time.setCellValue(test_method_end_time);
				
					/* Error Type */
					XSSFCell cell_error_header = row_for_header.createCell(4);
					cell_error_header.setCellValue("Error-Name");
					cell_error_header.setCellStyle(header_font);
					XSSFCell cell_exp;
					String exp_msg;
					
					if ("fail".equalsIgnoreCase(test_method_status)){
						NodeList exp_list = ((Element) test_method_node).getElementsByTagName("exception");
						Node exp_node = exp_list.item(0);
						exp_msg = ((Element) exp_node).getAttribute("class");
						
						cell_exp = rows.createCell(4);
						cell_exp.setCellValue(exp_msg);
					}
					
					/* Error Description */
					XSSFCell cell_error_message = rows.createCell(5);
					XSSFCell cell_error_message_header = row_for_header.createCell(5);
					cell_error_message_header.setCellValue("Error-Message-Description");
					cell_error_message_header.setCellStyle(header_font);
					cell_error_message.setCellValue(test_error_description_message);
				}
			}
		}

		FileOutputStream fout = new FileOutputStream(path +"com/eduven/report/"+ destFileName);
		workbook.write(fout);
		fout.close();
		System.out.println("Report Generated..");

	}

	public static void main(String args[]) {
		try {
			generateReport("excelreports.xlsx");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
