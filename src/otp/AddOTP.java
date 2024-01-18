package otp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbUtility.DBUtility;

public class AddOTP 
{
    public static boolean addOTP(String phone,String password)
    {
    	PreparedStatement stmt;
    	int row=0;
    	Connection con=DBUtility.getConnection();
    	String sql="insert into phoneverify values(?,?)";
	    try
    	{
    	stmt=con.prepareStatement(sql);
    	stmt.setString(1,phone);
    	stmt.setString(2,password);
    	
    	
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
