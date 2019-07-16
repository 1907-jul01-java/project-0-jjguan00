package com.revature.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.security.SecureRandom;
import java.sql.*;
import com.revature.model.Check;
public class CheckDao {
	Connection connection;

	public CheckDao(Connection connection) {
		this.connection = connection;
	}
	
	public void apply() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please make your initial deposit");
		int initialDeposit = sc.nextInt();
		SecureRandom random = new SecureRandom();
		int num = 10000 + random.nextInt(90000);
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"insert into checks values(?,?,?)");
			PreparedStatement pStatement2 = connection.prepareStatement(
					"insert into checkusers(checkaccount,userid) values(?,?)");
			pStatement.setInt(1, num);
			pStatement.setInt(2, initialDeposit);
			pStatement.setBoolean(3, false);
			pStatement2.setInt(1, num);
			pStatement2.setInt(2, 1);
			pStatement.executeUpdate();
			pStatement2.executeUpdate();
			System.out.println("Thank you for applying for checking account, our agents will approve and give your the account ready.");
		} catch (SQLException e) {
			e.getMessage();
		} finally {
		}
	}
	
    public List<Check> getAllUnapprove() {
        Check check;
        List<Check> checks = new ArrayList<>();
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from checks");
            ResultSet resultSet = statement.executeQuery();
            int size = resultSet.getRow();
            System.out.print(size);
            while (resultSet.next()) {
                check = new Check();
                check.setAccount(resultSet.getInt("account"));
                check.setBalance(resultSet.getInt("balance"));
                check.setApprove(resultSet.getBoolean("approved"));
                checks.add(check);
            }
        } catch (SQLException e) {

        }
        return checks;
    } 
}
