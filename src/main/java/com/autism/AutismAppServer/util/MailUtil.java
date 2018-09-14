package com.autism.AutismAppServer.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	
	@Value("${autism.password}")
	private String password;
	
	@Value("${autism.emailAddress}")
	private String emailAddress;
	
	@Value("${autism.fromName}")
	private String FROM_NAME;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// The port you will connect to on the Amazon SES SMTP endpoint.
	static final int PORT = 465;

	public String sendmail(String emailtext, String toEmail, String emailsubject) {

		String responseMessage = "Success";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		String text = "<div bgcolor='#e8e8e8' style='background:#e8e8e8;margin:0;padding:0;font-family:'Open Sans',Arial,Helvetica,sans-serif;border-bottom:10px solid #0abe51'>"
						+ " <table align='center' border='0' cellpadding='0' cellspacing='0' width='100%' height='100%' style='background-color:#e8e8e8;border-collapse:collapse;margin:0;padding:0'>"
						+ "<tbody><tr><td align='center' valign='top' height='100%' style='padding:10px 10px'><br>"
						+ " <table align='center' bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' width='100%' style='border-collapse:collapse;width:100%;border-radius:8px'>"
						+ "<tbody><tr><td style='padding:30px 40px'>"
						+ " <h2 style='text-align:center;padding:10px 0px 30px 0px;margin:0;color:#000;line-height:36px;font-size:24px;font-weight:400;'>"
						+ "<hr style='height: 20px; background-color:#94BA65'></hr>" + "<img src='https://authenticautismsolutions.com/wp-content/uploads/2016/11/AAS-with-tag-1.png' height='100' width='130'></img>"
						+ "<hr style='height: 10px; background-color: #94BA65'></hr>" + "</h2><div style='display:blcok;'>"
						+ emailtext
						+ "<br></br><br></br><br></br>Thanks and best Regards,"
						+ "<br></br>"
						+ "<br></br><p style='padding:0px 0px 25px;margin:10px 0 0 0;color:#000;line-height:22px;font-size:16px;font-family:'Open Sans',Arial,Helvetica,sans-serif'><a href='https://authenticautismsolutions.com' target='_blank'>www.authenticautismsolutions.com</a></p>"
						+ "Please feel free to contact us at <a href='/#' target='_blank'>www.authenticautismsolutions.com</a> for any questions."
						+ "<br></br><br></br> <h2 style='text-align:center;padding:10px 0px 30px 0px;margin:0;color:#000;line-height:36px;font-size:24px;font-weight:400;'>"
						+ " <a href='/#'>  <img src='https://cdn3.iconfinder.com/data/icons/free-social-icons/67/facebook_circle_color-256.png'  height='40' width='40'></img></a>"
						+ " <a href='/#'><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwf2oRAMLbh9jnOpJCMeuRJZneEs9wfkRce5qaV5l-AuZMHLeELoFDmm0'  height='40' width='40'></img></a>"
						+ "</h2>"
						+ "</div> </td> </tr></tbody> </table> </td></tr></tbody> </table></div>";

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailAddress, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailAddress));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(emailsubject);
			message.setContent(text, "text/html");
			message.setFrom(new InternetAddress(emailAddress, FROM_NAME));

			Transport.send(message);

			System.out.println("Done");
			// logger.log("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		}

		return responseMessage;
	}

}
