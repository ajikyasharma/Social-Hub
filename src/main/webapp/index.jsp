<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#error_email{
 color:red;
}

</style>
<script>

var count=0;
function checkemail(email)
{
	if(email.indexOf("@")==-1 || email.indexOf(".")==-1)
	{
		count= count+1;
		document.getElementById("error_email").innerHTML="Invalid email";
	}
	else
		document.getElementById("error_email").innerHTML="";
		
}

function checkall()
{
  var email= document.getElementById("email").value;
  count=0;
  checkemail(email);
  
  if(count==0)
	  return true;
  else
	  return false;
}

</script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
//Cookie cookies[]= request.getCookies();
//if(cookies != null && cookies.length !=0){
//	for(Cookie c:cookies){
//		if(c.getName().equals("myfb_email"))
//		{
//			session.setAttribute("email", c.getValue());
//			response.sendRedirect("Welcome");
//		}
//	}
//}


%>


<div class="jumbotron text-center" style="background-color: #1C529C; color: white;height: 300px">
  <h1>FriendsBook</h1>
</div>

<div class="container" style="text-align: left;">
  <div class="row">
    <div class="col-sm-6">
     <h3>For SignUp</h3>
<form action="signUp" onsubmit="return checkall()">
	<input type="text" name="email" onblur="checkemail(this.value)" id="email" placeholder="Enter your email here" class="form-control" style="width: 300px"><br>
	<div id="error_email"></div>
	<input type="password" name="password" placeholder="Enter your password here" class="form-control" style="width: 300px"><br>
	<input type="text" name="name" placeholder="Enter your name here" class="form-control" style="width: 300px"><br>
	<input type="submit" value="SignUp">
	
</form>
    </div>
    <div class="col-sm-6" style="text-align: left;">
     <h3>For login</h3>
<form action="login">
	<input type="text" name="email" placeholder="Enter your email here" class="form-control" style="width: 300px"><br>
	<input type="password" name="password" placeholder="Enter your password here" class="form-control" style="width: 300px"><br>

	<input type="submit" value="login">
	
	<%
if(request.getParameter("error")!=null)
{
%>	
<br>
<%=request.getParameter("error") %>	
<%

}
%>
</form>
    </div>
  </div>
</div>
</body>
</html>