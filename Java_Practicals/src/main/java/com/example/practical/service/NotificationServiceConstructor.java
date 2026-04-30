package com.example.practical.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceConstructor {

	private final EmailService emailService;

	public NotificationServiceConstructor(EmailService emailService) {
		this.emailService = emailService;
	}

	public String sendEmail(String msg) {
		return emailService.sendEmail(msg);
	}
}
