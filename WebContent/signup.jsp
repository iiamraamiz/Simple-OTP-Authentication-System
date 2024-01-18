<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<script type="text/javascript">
function signUpValidate()
{

	var username=document.getElementById("username").value; 
	var phone=document.getElementById("phone").value; 
	var pass=document.getElementById("password").value;   // String
	var cpass=document.getElementById("cpassword").value;
	var passLength=pass.length;
	
	
	
		if(username=="")
			{
			 document.getElementById("nameError").innerHTML ="Enter Name.";
			 return false;
			}
		else
			{
			 document.getElementById("nameError").innerHTML ="";
			}
		
		
		
		if(phone=="")
		{
		 document.getElementById("phoneError").innerHTML ="Enter Contact No..";
		 return false;
		}
	    else
		{
		 document.getElementById("phoneError").innerHTML ="";
		}
		
		if(isNaN(phone))
	    {
		   document.getElementById("phoneError").innerHTML=("Please enter numeric value");
	       return false; 
	    }
		 else
			{
			  document.getElementById("phoneError").innerHTML=("");
			}
		
		if(phone.length !=10)
		{
			   document.getElementById("phoneError").innerHTML=("Please enter valid contact No.");
		       return false; 
		    }
			 else
				{
				  document.getElementById("phoneError").innerHTML=("");
				}
		
		if(pass=="")
		{
		 document.getElementById("passwordError").innerHTML ="Enter Password..";
		 return false;
		}
	    else
		{
		 document.getElementById("passwordError").innerHTML ="";
		}
		
		if(passLength<5 || passLength>8)
		{
			document.getElementById("passwordError").innerHTML ="Password Length should be between 5-8";
			return false;
		}
		
		else
		{
			document.getElementById("passwordError").innerHTML ="";
		}
		
		if(cpass != pass)
	    {
			document.getElementById("confirmPasswordError").innerHTML ="It should be same as password field,";
			return false;
		}
		
		else
		{
			document.getElementById("confirmPasswordError").innerHTML ="";
		}
		
		return true;

}
</script>
</head>
<body>
      <div align="center">
        <h1>REGISTRATION FORM</h1>
       <form onsubmit="return signUpValidate()" action="SignUpServlet" method="post">
              <input type="hidden" name="action" value="signUp" >
              <table>
                     <%
                         String status=(String)request.getAttribute("status");
                         if(status!=null)
                         {
                        	 out.println(status);
                         }
                     %>
                    
                     
                     <tr>
                          <td ><b>Name :</b></td>
                          <td ><input type="text" id="username" name="username" size="40" ></td>
                          <td><span style="color:red" id="nameError">*</span></td>
                     </tr>
                     

                     
                     <tr>
                          <td ><b>Contact No. :</b></td>
                          <td><input type="text" id="phone" name="phone"  size="40" ></td>
                          <td><span style="color:red" id="phoneError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td ><b>Password :</b></td>
                          <td><input type="password" id="password" name="password" size="40" ></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                     
                     <tr>
                          <td ><b>Confirm Password :</b></td>
                          <td><input type="password" id="cpassword" name="cpassword" size="40" ></td>
                          <td><span style="color:red" id="confirmPasswordError">*</span></td>
                     </tr>
                     
                     <tr>
                         <td><input type="submit" value="Register"></td>
                     </tr>
              </table>
       </form>
         </div>
       
</body>
</html>