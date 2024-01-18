package otp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbUtility.DBUtility;

public class OTPVerify
{
       public static boolean otpVerify(String phone,String otp)
       {
    	   int count=0;
    	   Connection con=DBUtility.getConnection();
    	   Statement stmt;
   		ResultSet rs;
    	
    	String sql="select * from phoneverify where phone="+phone;
   		try
   		{
   		stmt= con.createStatement();
   		rs=stmt.executeQuery(sql);
   		while(rs.next())
   		{		
   			
   			if(otp.equals(rs.getString("password"))&& phone.equals(rs.getString("phone")))
   			{
   				count=1;
   			}
   			
   		}
   		}
   		catch(Exception e)
        {
   			e.printStackTrace();
   		}
   		
   		if(count==1)
   		{
   			count=0;
   			return true;
   		}
   		else
   		{
   			return false;
   		}
}
}
