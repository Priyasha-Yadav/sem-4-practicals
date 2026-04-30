package com.example.practical.controller;

import com.example.practical.service.BankTransactionService;
import com.example.practical.service.NotificationServiceConstructor;
import com.example.practical.service.NotificationServiceField;
import com.example.practical.service.NotificationServiceSetter;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private final NotificationServiceField notificationServiceField;
	private final NotificationServiceConstructor notificationServiceConstructor;
	private final NotificationServiceSetter notificationServiceSetter;
	private final BankTransactionService bankTransactionService;

	public TestController(
		NotificationServiceField notificationServiceField,
		NotificationServiceConstructor notificationServiceConstructor,
		NotificationServiceSetter notificationServiceSetter,
		BankTransactionService bankTransactionService) {
		this.notificationServiceField = notificationServiceField;
		this.notificationServiceConstructor = notificationServiceConstructor;
		this.notificationServiceSetter = notificationServiceSetter;
		this.bankTransactionService = bankTransactionService;
	}

	@GetMapping("/di/field")
	public String fieldInjectionDemo() {
		return notificationServiceField.sendEmail("Test");
	}

	@GetMapping("/di/constructor")
	public String constructorInjectionDemo() {
		return notificationServiceConstructor.sendEmail("Test");
	}

	@GetMapping("/di/setter")
	public String setterInjectionDemo() {
		return notificationServiceSetter.sendEmail("Test");
	}

	@GetMapping("/bank/transfer")
	public String transfer(
		@RequestParam int accountNumber,
		@RequestParam BigDecimal amount) {
		return bankTransactionService.transfer(accountNumber, amount);
	}
}
