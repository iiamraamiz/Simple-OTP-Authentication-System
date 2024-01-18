package otp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbUtility.DBUtility;

public class DeleteOTP 
{
    public static boolean deleteOTP(String phone)
    {
    	PreparedStatement stmt;
    	int row=0;
    	Connection con=DBUtility.getConnection();
    	String sql="delete from phoneverify where phone=?";
	    try
    	{
    	stmt=con.prepareStatement(sql);
    	stmt.setString(1,phone);
    	row=stmt.executeUpdate();
    	}
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
		
	    if(row>0)
	    	return true;
	    else
	    	return false;
    }
}
