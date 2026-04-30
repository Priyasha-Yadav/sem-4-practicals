package com.example.practical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceField {

	@Autowired
	private EmailService emailService;

	public String sendEmail(String msg) {
		return emailService.sendEmail(msg);
	}
}
