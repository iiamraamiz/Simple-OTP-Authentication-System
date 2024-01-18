<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<script type="text/javascript" >
function loginValidate()
{
	
	var username=document.getElementById("username").value; 
	var pass=document.getElementById("password").value;
	

		if(username=="")
		{
		 document.getElementById("nameError").innerHTML ="Enter Name.";
		 return false;
		}
	    else
		{
		 document.getElementById("nameError").innerHTML ="";
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
	
	return true;
	
	
	
}
</script>
</head>
<body>

      <div align="center">
      <h1>LOGIN FORM</h1>
       <form  onsubmit="return loginValidate()" action="SignUpServlet" method="post">
        <input type="hidden" name="action" value="login" >
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
                          <td ><b>Password :</b></td>
                          <td><input type="password" id="password" name="password" size="40" ></td>
                          <td><span style="color:red" id="passwordError">*</span></td>
                     </tr>
                    
                     
                     <tr>
                         <td><input type="submit" value="Login"></td>
                     </tr>
              </table>
       </form>
         </div>


      
</body>
</html>