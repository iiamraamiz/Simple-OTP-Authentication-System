package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbUtility.DBUtility;

public class LoginDaoImp implements loginDao
{
	String str;
	PreparedStatement stmt;
	Statement stmt1; 
	ResultSet rs;
	int row=0,count=0;
	 
    static Connection con;
    
	@Override
	public boolean signUp(String username, String password ,String phone) 
	{
		    con=DBUtility.getConnection();
	    	str="insert into signup(username,password,phone) values(?,?,?);";
	    	try
	    	{
	    	stmt=con.prepareStatement(str);
	    	stmt.setString(1,username);
	    	stmt.setString(2,password);
	    	stmt.setString(3,phone);
	    	
	    	row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
	    	if(row>0)
	    		return true;
	    	else
	    		return false;
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return false;
	    	 
	 }

	@Override
	public boolean login(String username, String password)
	{
        con=DBUtility.getConnection();
		String uname, upassword;
		
		String query="select * from signup";
		try
		{
			stmt1=con.createStatement();
			rs=stmt1.executeQuery(query);
			while(rs.next())
			{
				uname=rs.getString("username");          // data from database
				upassword=rs.getString("Password");
				
				if(uname.equals(username) && upassword.equals(password))
				{
					count =1;
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


