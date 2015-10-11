import java.net.URLConnection;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailNotifier implements Observer {

	//URLConnection connect;
	//WebPageWatcher webPageWatcher;
	private Date modifiedDate;
	private String webPageUrl;
	private boolean sentMail = false;

	public boolean isSentMail() {
		return sentMail;
	}

	@Override
	public void update(Observable webPageWatcher, Object connect) {
		//this.webPageWatcher = (WebPageWatcher) webPageWatcher;
		long time = ((URLConnection)connect).getLastModified();
		modifiedDate = new Date(time);
		webPageUrl = ((WebPageWatcher)webPageWatcher).getWebPageUrl();
		sentMail = sendMail();
	}

	private boolean sendMail() {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chinnupadman@gmail.com","avni@2015");
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("chinnupadman@gmail.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("chinnupadman@gmail.com"));
			message.setSubject("Web Page is Updated");
			message.setText("Web page " + webPageUrl + " is modified at " + modifiedDate.toString());
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

}
