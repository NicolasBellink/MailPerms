package com.mail.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.demo.model.User;
import com.mail.demo.service.MailService;

@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private User user;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("send-mail")
	public String send() {


		user.setFirstName("Nicolas");
		user.setLastName("Bellini");
		user.setEmailAddress("cbalderrama@tecnosoftware.com"); //Receiver's email address


		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {


		user.setFirstName("Nicolas");
		user.setLastName("Bellini");
		user.setEmailAddress("cvalderrama@tecnosoftware.com"); //Receiver's email address


		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Mail sent.";
	}
}
