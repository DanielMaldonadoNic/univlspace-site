package com.misitio.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService {

	private static final String SERVLET = "http://localhost:8080/Consultor-Plataformas-Digitales01/ActivarCuentaServlet";
	
	public void sendEmail(String nombreEmail,String email) {
		String from = "danielmaldonadonic@gmail.com";
		final String username = "danielmaldonadonic@gmail.com";
		final String password = "nvwjzeumzwlrieie";
		
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		//Login a nuestra cuenta
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		
		Message message = new MimeMessage(session);	
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Activacion de tu cuenta");
			message.setContent("Bienvenido "+nombreEmail+" a tu plataforma digital para activar tu cuenta da click en el siguiente enlace <a href=\""+ SERVLET+ "?email="+email+"\">Activar aqui</>","text/html");
			Transport.send(message);
			System.out.println("Envio de email correctamente");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
