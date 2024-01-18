package servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbUtility.DBUtility;
import login.LoginDaoImp;
import otp.AddOTP;
import otp.DeleteOTP;
import otp.OTP;
import otp.OTPVerify;
import otp.SendOTP;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		String action=request.getParameter("action");
		Connection con=DBUtility.getConnection();
		if(action.equals("signUp"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String mobile=request.getParameter("phone");
			
			OTP otp=new OTP();
		    String otpp= otp.generateOTP(5);
		    String apiKey="Nh3n1kAuCflBaFtgpZDw8I2HzQ5Pb6YGjiRqLr4UOExTSsXovJwgSpT8M6rLkoZy5nlOvzNK0RCejAWt";
			SendOTP sotp=new SendOTP();
			String message="OTP PROJECT mobile verification, Your OTP : "+otpp;
			sotp.sendOTP(message, mobile, apiKey);
		  
		    boolean flag= AddOTP.addOTP(mobile, otpp);
		    if(flag==true)
		    {
		    	
		    	session.setAttribute("username", username);
			    session.setAttribute("password", password);
			    session.setAttribute("mobile",mobile);
		    	rd=request.getRequestDispatcher("phoneverify.jsp");
			    rd.forward(request, response);
		    }
		    
		    else
		    {
		    	request.setAttribute("status","Failed to register, Please try again..");
		    	rd=request.getRequestDispatcher("signup.jsp");
			    rd.forward(request, response);
		    }  
		    
		}
		
		else if(action.equals("phone"))
		{
			String otp=request.getParameter("otp");
			System.out.println("otp:"+otp);
			String phone=(String) session.getAttribute("mobile");
			String user=(String) session.getAttribute("username");
			String pass=(String)session.getAttribute("password");
			
			
			boolean flag=OTPVerify.otpVerify(phone, otp);
			System.out.println("flag:"+flag);
			if(flag==true)
			{
				boolean flag2=DeleteOTP.deleteOTP(phone);
				
				if(flag2==true)
				{
					LoginDaoImp ld=new LoginDaoImp();
					boolean flag3=ld.signUp(user, pass, phone);
					
					if(flag3==true)
					{
						request.setAttribute("status","Successfuly registered....");
				    	rd=request.getRequestDispatcher("login.jsp");
					    rd.forward(request, response);
					}
					
					else
					{
						request.setAttribute("status","Failed to register, Please try again..");
				    	rd=request.getRequestDispatcher("signup.jsp");
					    rd.forward(request, response);
					}
					
				}
				
				else
				{
					request.setAttribute("status","Failed to register, Please try again..");
			    	rd=request.getRequestDispatcher("signup.jsp");
				    rd.forward(request, response);
				}
				
			}
			
			else
			{
				request.setAttribute("status","Failed to register, Please try again..");
		    	rd=request.getRequestDispatcher("signup.jsp");
			    rd.forward(request, response);
			}
		}
		
		else if(action.equals("login"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			LoginDaoImp ld=new LoginDaoImp();
			boolean flag=ld.login(username, password);
			
			if(flag==true)
		    {
				request.setAttribute("user", username);
		    	rd=request.getRequestDispatcher("home.jsp");
			    rd.forward(request, response);
		    }
		    
		    else
		    {
		    	request.setAttribute("status","Failed to login, Please try again..");
		    	rd=request.getRequestDispatcher("login.jsp");
			    rd.forward(request, response);
		    }  
			
		}
	}

}
