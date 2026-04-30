package com.example.practical.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class BankTransactionService {

	private static final int BANK_ACCOUNT_NUMBER = 102;

	private final DataSource dataSource;

	public BankTransactionService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String transfer(int accountNumber, BigDecimal amount) {
		try (Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);

			BigDecimal sourceBalance = getBalance(connection, accountNumber);
			BigDecimal bankBalance = getBalance(connection, BANK_ACCOUNT_NUMBER);

			if (sourceBalance == null || bankBalance == null || sourceBalance.compareTo(amount) < 0) {
				connection.rollback();
				return "Transaction Failed";
			}

			updateBalance(connection, accountNumber, sourceBalance.subtract(amount));
			updateBalance(connection, BANK_ACCOUNT_NUMBER, bankBalance.add(amount));

			connection.commit();
			return "Transaction Successful";
		} catch (SQLException ex) {
			return "Transaction Failed";
		}
	}

	private BigDecimal getBalance(Connection connection, int accountNumber) throws SQLException {
		String sql = "SELECT balance FROM accounts WHERE account_number = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, accountNumber);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getBigDecimal("balance");
				}
				return null;
			}
		}
	}

	private void updateBalance(Connection connection, int accountNumber, BigDecimal balance)
		throws SQLException {
		String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setBigDecimal(1, balance);
			statement.setInt(2, accountNumber);
			statement.executeUpdate();
		}
	}
}