<%@page import="com.mjpru.beans.User"%>
<%@page import="com.mjpru.data.DBHandler"%>
<%@page import="com.mjpru.beans.Chat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<style >



.left{
text-align: left;
}

.right{
text-align:right;

}
select{
width:100%;
font-size: 24px;
padding-left: 50px;
padding-right: 50px;

}

</style>
</head>
<body>
<%

String reciver= (String)request.getAttribute("reciver");
ArrayList<Chat> chats= (ArrayList<Chat>)request.getAttribute("chats");
DBHandler db= new DBHandler();
User user= db.getUser(reciver);


%>


   <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><%=user.getName() %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
  </div>
</nav>

<br>

<div class="container">
  <div class="row">
    <div class="col-sm-12">
    <br>
    <select size="22">
<%
if(chats != null)
{
	for(Chat chat : chats)
	{
		String msg= chat.getMessage();
		String sender=chat.getSender();
		if(sender.equals(reciver)){
%>
   <option  class="left"><%=msg %></option> 
   <hr> 
<%
}
else{   
%>
  <option  class="right"><%=msg %></option> 
<% 
}
	}
}
%>
</select>
   <br>
   <br>
<form method="get" action="SaveChat" class="d-flex" style="width:100%">
<input type="hidden" name="reciver" value="<%=reciver%>">
<input type="text" class="form-control" name= "message" style="width:80%;">
<input type="submit"  class="btn btn-primary" value="send">
</form>    
    
    
  </div>
  </div>
  
  


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>