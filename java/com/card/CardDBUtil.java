package com.card;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CardDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
//	public static boolean validate(String username, String password) {
//		
//		try {
//			con = DBConnect.getConnection();
//			stmt = con.createStatement();
//			String sql = "select * from log where user='"+username+"' and pass='"+password+"'";
//			rs = stmt.executeQuery(sql);
//			
//			if (rs.next()) {
//				isSuccess = true;
//			} else {
//				isSuccess = false;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return isSuccess;
//	}
//	
//	public static List<user> getuser(String User) {
//		
//		ArrayList<user> u = new ArrayList<>();
//		
//		try {
//			
//			con = DBConnect.getConnection();
//			stmt = con.createStatement();
//			String sql1 = "select * from log where user='"+User+"'";
//			rs = stmt.executeQuery(sql1);
//						
//			while (rs.next()) {
//				String user = rs.getString(1);
//				int pass = rs.getInt(2);
//				String name = rs.getString(3);
//				
//				user c = new user(user,pass,name);
//				u.add(c);
//			}
//			
//		} catch (Exception e) {
//			
//		}
//		
//		return u;	
//	}
	
	public static boolean validatecard(String AccNum, String PIN) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from bank_card where accnumber='"+AccNum+"' and pin='"+PIN+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	public static List<Card> getcard(String Num) {
		ArrayList<Card> u = new ArrayList<>();
				
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql2 = "select * from bank_card where holdername='"+Num+"'";
			rs = stmt.executeQuery(sql2);
			
			while (rs.next()) {
				String cardnumber = rs.getString(1);
				String accnumber = rs.getString(2);
				String name = rs.getString(3);
				int pin = rs.getInt(4);
				String expiredate = rs.getString(5);
				
				
				Card c = new Card(cardnumber,accnumber,name,pin,expiredate);
				u.add(c);
			}
			
		} catch (Exception e) {
			
		}
		
		return u;	
	}
	
	public static boolean cardidchk(String Num) {
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql2 = "select cardnumber from bank_card where cardnumber='"+Num+"'";
			rs = stmt.executeQuery(sql2);
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}	
			
		} catch (Exception e) {
			
		
		}
		
		return isSuccess;
	}
	
	public static List<account> getaccount(String Num) {
		
		ArrayList<account> ac = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql2 = "select * from accounts where username='"+Num+"'";
			rs = stmt.executeQuery(sql2);
			
			while (rs.next()) {
				String accountnum = rs.getString(1);
				String name = rs.getString(2);
				String balance = rs.getString(3);				
				
				account a = new account(accountnum,name,balance);
				ac.add(a);
			}
			
		} catch (Exception e) {
			
		}
		
		return ac;	
	}
	
	public static boolean insertcard(String cardnumber, String accnumber, String name, String pin, String expiredate) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into bank_card values ('"+cardnumber+"','"+accnumber+"','"+name+"','"+pin+"','"+expiredate+"')";
    		int rs = stmt.executeUpdate(sql);
    		   
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
	
	public static boolean updatecard(String cardnumber, String accnumber, String pin, String expiredate) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update bank_card set cardnumber='"+cardnumber+"',pin='"+pin+"',expiredate='"+expiredate+"'"
    				+ "where accnumber='"+accnumber+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
	
	public static boolean deleteCard(String cardnumber) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from bank_card where cardnumber='"+cardnumber+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
}
