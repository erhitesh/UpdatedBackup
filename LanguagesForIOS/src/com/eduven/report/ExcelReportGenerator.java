package com.eduven.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.util.HSSFColor;
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

	public static void generateReport(String destFileName)throws ParserConfigurationException, SAXException, IOException {

		String path = ExcelReportGenerator.class.getClassLoader().getResource("./").getPath();
		
		/* Replace bin to src */
		path = path.replace("bin", "src");
		
		//System.out.println(path);

		/* Create new file for test out */
		File xmlfile = new File(path + "../test-output/testng-results.xml");

		/* Read XML file using SAX parsing */
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder();
		Document doc = builder.parse(xmlfile);
		doc.getDocumentElement().normalize();

		/* Create workbook instance */
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFCellStyle fail = workbook.createCellStyle();
		XSSFCellStyle pass = workbook.createCellStyle();
		XSSFCellStyle skip = workbook.createCellStyle();
		
		/* Set The Sheet Name Header Font */
		XSSFCellStyle header_font = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setUnderline(XSSFFont.U_SINGLE);
		header_font.setFont(font);
		
		/* TestList */
		NodeList test_list = doc.getElementsByTagName("test");
		for (int i = 0; i < test_list.getLength(); i++) {
			int row = 1; //0
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
					
					/* Setting Sheet Row Header Name. */
					XSSFRow row_for_header = sheet.createRow(0);
					XSSFRow rows = sheet.createRow(row++);
					
					/* Set the color value for fail, pass & skip..red, green & black */
					fail.setFillForegroundColor(HSSFColor.RED.index);
					pass.setFillForegroundColor(HSSFColor.GREEN.index);
					skip.setFillForegroundColor(HSSFColor.YELLOW.index);
					
					/* Set style */
					fail.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					pass.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					skip.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

					/* For TestCase Class */
					XSSFCell cellClassName = rows.createCell(0);
					XSSFCell cellClassNameHeader = row_for_header.createCell(0);
					cellClassNameHeader.setCellValue("ClassName-WithPackageName");
					cellClassNameHeader.setCellStyle(header_font);
					cellClassName.setCellValue(class_name); //class_name+"."+test+method_name
					
					/* TestCase Name */
					XSSFCell cellTestName = rows.createCell(1);
					XSSFCell cellTestNameHeader = row_for_header.createCell(1);
					cellTestNameHeader.setCellValue("Test-Name");
					cellTestNameHeader.setCellStyle(header_font);
					cellTestName.setCellValue(test_method_name);
					
					/* start time */
					XSSFCell cellStartedTime = rows.createCell(2);
					XSSFCell cellStartTimeHeader = row_for_header.createCell(2);
					cellStartTimeHeader.setCellValue("Start-Time");
					cellStartTimeHeader.setCellStyle(header_font);
					cellStartedTime.setCellValue(test_method_started_time);

					/* Test status */
					XSSFCell cellStatus = rows.createCell(3);
					XSSFCell cellStatusHeader = row_for_header.createCell(3);
					cellStatusHeader.setCellValue("Test-Status");
					cellStatusHeader.setCellStyle(header_font);
					cellStatus.setCellValue(test_method_status);
					
					if ("fail".equalsIgnoreCase(test_method_status)){
						cellStatus.setCellStyle(fail);
						}
					else if ("pass".equalsIgnoreCase(test_method_status)) {
						cellStatus.setCellStyle(pass);
						}
					else {
						cellStatus.setCellStyle(skip);
						}
					
					/* Test case Finish time */
					XSSFCell cellEndTime = rows.createCell(5);
					XSSFCell cellEndTimeHeader = row_for_header.createCell(5);
					cellEndTimeHeader.setCellValue("End-Time");
					cellEndTimeHeader.setCellStyle(header_font);
					cellEndTime.setCellValue(test_method_end_time);
					
					
					/* Error Description Message */
					XSSFCell cellErrorHeader = row_for_header.createCell(4);
					cellErrorHeader.setCellValue("Error-Name");
					cellErrorHeader.setCellStyle(header_font);
					XSSFCell cellExp;
					String exp_msg;
					
					if ("fail".equalsIgnoreCase(test_method_status)){
						NodeList expList = ((Element) test_method_node).getElementsByTagName("exception");
						Node expNode = expList.item(0);
						exp_msg = ((Element) expNode).getAttribute("class");
						cellExp = rows.createCell(4);
						cellExp.setCellValue(exp_msg);
					}
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
