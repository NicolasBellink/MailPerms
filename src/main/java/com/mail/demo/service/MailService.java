package com.mail.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.demo.model.User;


@SuppressWarnings("unused")
@Service
public class MailService {

	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * 
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(User user) throws MailException {


		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Testing Mail API");
		mail.setText("test");

		javaMailSender.send(mail);
	}

	/**
	 * This function is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(user.getEmailAddress());
		helper.setSubject("Test permutaciones");
		helper.setText("test");
		
		/*ClassPathResource classPathResource = new ClassPathResource("c:/keys/fichero.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);
		*/
		
		FileSystemResource file = new FileSystemResource("C:\\keys/fichero.pdf");
		helper.addAttachment(file.getFilename(), file);
		
		javaMailSender.send(message);
	}

}
