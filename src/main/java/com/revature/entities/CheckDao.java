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
	public void applyjoint(int userid, int ideposit, int juserid) {
		SecureRandom random = new SecureRandom();
		int num = 10000 + random.nextInt(90000);
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"insert into checks values(?,?,?)");
			PreparedStatement pStatement2 = connection.prepareStatement(
					"insert into checkusers(checkaccount,userid) values(?,?)");
			PreparedStatement pStatement3 = connection.prepareStatement(
					"insert into checkusers(checkaccount,userid) values(?,?)");
			pStatement.setInt(1, num);
			pStatement.setInt(2, ideposit);
			pStatement.setBoolean(3, false);
			pStatement2.setInt(1, num);
			pStatement2.setInt(2, userid);
			pStatement3.setInt(1, num);
			pStatement3.setInt(2, juserid);
			pStatement.executeUpdate();
			pStatement2.executeUpdate();
			pStatement3.executeUpdate();
			System.out.println("Thank you for applying for joint checking account, our agents will approve and give your the account ready.");
		} catch (SQLException e) {
			e.getMessage();
		} finally {
		}
	}
    public List<Check> getAllUnapprove() {
        List<Check> checks = new ArrayList<Check>();
        Check check;
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from checks where approved = false");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int account = resultSet.getInt("id");
            	int balance = resultSet.getInt("balance");
            	boolean approved = resultSet.getBoolean("approved");
                check = new Check(account, balance, approved);
                checks.add(check);
            }
        } catch (SQLException e) {

        }
        return checks;
    }
    
    public List<Check> getAll() {
        List<Check> checks = new ArrayList<Check>();
        Check check;
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from checks  where approved = true");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int account = resultSet.getInt("id");
            	int balance = resultSet.getInt("balance");
            	boolean approved = resultSet.getBoolean("approved");
                check = new Check(account, balance, approved);
                checks.add(check);
            }
        } catch (SQLException e) {

        }
        return checks;
    }
    
    public void approveCheck(int account) {
    	try {
        	PreparedStatement pStatement = connection.prepareStatement("Update checks set approved = true where id = ?");
        	pStatement.setInt(1,account);
        	pStatement.executeUpdate();
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    }
    
    public List<Check> getAccountByUser(int userid) {
        List<Check> checks = new ArrayList<Check>();
        Check check;
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from checks join checkusers on checks.id = checkusers.checkAccount join users on checkusers.userid = users.id where checks.approved = true and users.id = ?");
        	statement.setInt(1, userid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int account = resultSet.getInt("id");
            	int balance = resultSet.getInt("balance");
            	boolean approved = true;
                check = new Check(account, balance, approved);
                checks.add(check);
            }
        } catch (SQLException e) {

        }
        return checks;
    }
    
    public void deposit(int account, int money) {
    	try {
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		String content = "Deposited " + money + " into account: "+ account +" at " + timestamp;
        	PreparedStatement pStatement = connection.prepareStatement("Update checks set balance = balance +? where id = ?");
        	PreparedStatement pStatement2 = connection.prepareStatement("insert into transactions(context,checkid) values (?,?)");
        	pStatement.setInt(1,money);
        	pStatement.setInt(2,account);
        	pStatement2.setString(1,content);
        	pStatement2.setInt(2, account);
        	pStatement.executeUpdate();
        	pStatement2.executeUpdate();
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    	
    }
    
    public void withdraw(int account, int money) {
    	try {
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		String content = "Withdrawn " + money + " into account: "+ account +" at " + timestamp;
        	PreparedStatement pStatement = connection.prepareStatement("Update checks set balance = balance -? where id = ?");
        	PreparedStatement pStatement2 = connection.prepareStatement("insert into transactions(context,checkid) values (?,?)");
        	pStatement.setInt(1,money);
        	pStatement.setInt(2,account);
        	pStatement2.setString(1,content);
        	pStatement2.setInt(2, account);
        	pStatement.executeUpdate();
        	pStatement2.executeUpdate();
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    	
    }
    public void destroy(int account) {
    	try {
        	PreparedStatement pStatement = connection.prepareStatement("Delete From checks where id = ?");
        	pStatement.setInt(1, account);
        	pStatement.executeUpdate();

    	}catch(SQLException e) {
    		e.getMessage();
    	}
    	
    }
    public void transfer(int uaccount, int money, int taccount) {
    	try {
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		String content = "Transferred " + money + " into account: "+ taccount +" at " + timestamp;
    		String content2 = "Received " + money + " from account: "+ uaccount +" at " + timestamp;
        	PreparedStatement pStatement = connection.prepareStatement("Update checks set balance = balance -? where id = ?");
        	pStatement.setInt(1,money);
        	pStatement.setInt(2,uaccount);
        	PreparedStatement pStatement2 = connection.prepareStatement("Update checks set balance = balance +? where id = ?");
        	pStatement2.setInt(1,money);
        	pStatement2.setInt(2,taccount);
        	PreparedStatement pStatement3 = connection.prepareStatement("insert into transactions(context,checkid) values (?,?)");
        	PreparedStatement pStatement4 = connection.prepareStatement("insert into transactions(context,checkid) values (?,?)");
        	pStatement3.setString(1,content);
        	pStatement3.setInt(2, uaccount);
        	pStatement4.setString(1,content2);
        	pStatement4.setInt(2, taccount);
        	pStatement.executeUpdate();
        	pStatement2.executeUpdate();
        	pStatement3.executeUpdate();
        	pStatement4.executeUpdate();
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    	
    }
}
