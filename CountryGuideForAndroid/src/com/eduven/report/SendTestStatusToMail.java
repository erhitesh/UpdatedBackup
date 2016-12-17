package com.eduven.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import com.eduven.modules.HomePage;

public class SendTestStatusToMail {
	
	//
	static String time_pattern = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	static String path="./test-output/emailable-report.html";
	
	public static boolean sendMail(String userName,
			String passWord,
			String host,
			String port,
			String starttls,
			String auth,
			boolean debug,
			String socketFactoryClass,
			String fallback,
			String to,
			String cc,
			String bcc
			/*String[] to,
			String[] cc,
			String[] bcc*/,
			String subject,
			String text,
			String attachmentPath,
			String attachmentName){
		
		//Object Instantiation of a properties file.
		Properties props = new Properties();

		props.put("mail.smtp.user", userName);

		props.put("mail.smtp.host", host);
		
		if(!"".equals(port)){
			props.put("mail.smtp.port", port);
		}

		if(!"".equals(starttls)){
			props.put("mail.smtp.starttls.enable",starttls);
			props.put("mail.smtp.auth", auth);
		}

		if(debug){

			props.put("mail.smtp.debug", "true");

		}else{

			props.put("mail.smtp.debug", "false");

		}

		if(!"".equals(port)){
			props.put("mail.smtp.socketFactory.port", port);
		}
		if(!"".equals(socketFactoryClass)){
			props.put("mail.smtp.socketFactory.class",socketFactoryClass);
		}
		if(!"".equals(fallback)){
			props.put("mail.smtp.socketFactory.fallback", fallback);
		}

		try{

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));
			
			//*******************
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));

			/*for(int i=0;i<to.length;i++){
				msg.addRecipient(Message.RecipientType.TO, new
						InternetAddress(to[i]));
			}

			for(int i=0;i<cc.length;i++){
				msg.addRecipient(Message.RecipientType.CC, new
						InternetAddress(cc[i]));
			}

			for(int i=0;i<bcc.length;i++){
				msg.addRecipient(Message.RecipientType.BCC, new
						InternetAddress(bcc[i]));
			}*/

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void sendReportToMail(){
		sendMail("hitesh.bhardwaj@mediaagility.in", "bhardwajhitesh2", "smtp.gmail.com", "465", "true", "true", true, "javax.net.ssl.SSLSocketFactory", "false", "hitesh.bhardwaj@mediaagility.in", "hitesh.bhardwaj@mediaagility.in", "rahul.sharma@mediaagility.in", "Android Automation Report of "+HomePage.appName()+" "+time_pattern+"", "Android App for Travel SMART Africa Automation Report", path, "Test_Execution_Report.html");
	}
	
	public static void main(String args[]){
		sendReportToMail();
	}
}