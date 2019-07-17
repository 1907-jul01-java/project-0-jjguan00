package com.revature.entities;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 import com.revature.model.Transaction;

public class TransactionDao {
	Connection connection;
	
	public TransactionDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public List<Transaction> getTransactionByAccount(int account) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction transaction;
		try {
			PreparedStatement pStatement = connection.prepareStatement("Select * from transactions join checks on transactions.checkid = checks.id where transactions.checkid=?");
			pStatement.setInt(1, account);
			ResultSet resultSet = pStatement.executeQuery();
	        while (resultSet.next()) {
        	String content = resultSet.getString("context");
            transaction = new Transaction(content);
            transactions.add(transaction);
        }
    } catch (SQLException e) {

    }
    return transactions;
			
	}
}