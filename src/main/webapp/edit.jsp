<%@page import="com.mjpru.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%
User user= (User)request.getAttribute("user");

%>

   <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><%=user.getName() %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
  </div>
</nav>


<div class="container">
  <div class="row">
    <div class="col-sm-12">
    <br>
      <h4>Update Your Profile</h4>
      <br>
      <form action="UpdateProfile">
      <b>Email-id</b>
	<input class="form-control" type="text" name="email" value="<%= user.getEmail() %>" readonly="readonly"><br>
	<b>Password</b>
	<input class="form-control" type="password" name="password" value="<%= user.getPassword()%>"><br>
	<b>Name</b>
	<input class="form-control" type="text" name="name" value="<%= user.getName() %>"><br>
	<input class="btn btn-outline-primary" type="submit" value="Update">
	
</form>
       
    
    
  </div>
  </div>










<!-- 
<h3>For SignUp</h3>
<form action="UpdateProfile">
	<input type="text" name="email" value="<%= user.getEmail() %>" readonly="readonly"><br>
	<input type="password" name="password" value="<%= user.getPassword()%>"><br>
	<input type="text" name="name" value="<%= user.getName() %>"><br>
	<input type="submit" value="Update">
	
</form>
 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>