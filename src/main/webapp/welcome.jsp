<!DOCTYPE html>
<%@page import="com.mjpru.beans.Wpost"%>
<%@page import="com.mjpru.data.DBHandler"%>
<%@page import="com.mjpru.beans.User"%>
<%@page import="com.mjpru.beans.Friend"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%
//ArrayList <Friend> pfriends= (ArrayList <Friend>)request.getAttribute("pfriens");
User user= null;
DBHandler db= new DBHandler();
HttpSession session1 = request.getSession();
String email=session1.getAttribute("email").toString();

User user1= db.getUser(email);

System.out.println(email);

ArrayList <Friend> pfriends= db.getPendingRequests(email);
ArrayList<Wpost> wposts= (ArrayList<Wpost>)request.getAttribute("wposts");
%>
   <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><%=user1.getName() %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          
        </li>  
      </ul>

      <form class="d-flex" action="SaveRequest" >
        <input class="form-control me-2" type="text" name="rec" placeholder="Search new friends here">
        <input  class="btn btn-outline-primary" type="submit" value= "send">

</form>  
    &nbsp;&nbsp;&nbsp;
    <a  class="btn btn-outline-primary  d-flex" href="EditProfile">Edit Profile</a>
   
    </div>
  </div>
</nav>





<div class="container">
  <div class="row">
    <div class="col-md-3">
    <br>
      <h4>Pending Requests</h4>
      <br>
       <%
       if(pfriends != null)
       {

       for(Friend friend:pfriends)
       {
	   user= db.getUser(friend.getSender());
       %>
 
       <b><%= user.getName() %></b> 
      <a  class="btn btn-outline-primary btn-sm" href="Accept?fid=<%=friend.getFid()%>">Accept</a>
      &nbsp;&nbsp;&nbsp;
      <a  class="btn btn-outline-primary btn-sm" href="Reject?fid=<%=friend.getFid()%>">Reject</a> 
      <br>
      <br>
      <% 
      }
      }
      %>
    </div>
    <div class="col-md-6">
    <br>
     <form action="SavePost">
     <textarea class="form-control" name ="message" rows="6" cols="50"></textarea>
     <br>
     <input class="btn btn-outline-primary" type="submit" value= "Save Post">
     </form>
     
     <%
     for(Wpost wpost:wposts){
	
	User wu= db.getUser(wpost.getSender());
     %>
    <br>
    <b><%= wu.getName() %></b><br>
    <%= wpost.getDop() %>
    <br>
    <%= wpost.getMessage() %>
    <br>
    <% 	
    }

    %>



    </div>
    <div class="col-md-3 text-end " >
    <br>
      <h4>Friends</h4>
      <br>
      <%
      ArrayList <String> friends= db.getFriends(email);
      if(friends != null)
       {
       for(String f:friends)
       {
	   user= db.getUser(f);
       %>

      <b><%= user.getName() %> </b> 
      &nbsp;&nbsp;&nbsp;
       <a class="btn btn-outline-primary btn-sm" href="Message?reciver=<%=user.getEmail() %>">Message</a>
       <br>
       <br>
 
       <% 
       }
       }
       %>
    </div>
  </div>
  </div>

<%
  if(session.getAttribute("email")==null){
	  response.sendRedirect("index.jsp");
  }
%>















<!--  <a href="EditProfile">Edit Profile</a>
<table width="100%" border="1">
<tr>
<td width="20%">
<%
if(pfriends != null)
{

for(Friend friend:pfriends)
{
	user= db.getUser(friend.getSender());
%>
 
<%= user.getName() %> 
 <a href="Accept?fid=<%=friend.getFid()%>">Accept</a>
 &nbsp;&nbsp;&nbsp;
 <a href="Reject?fid=<%=friend.getFid()%>">Reject</a> 
 <% 
}
}
%>

</td>
<td width="60%">
<form action="SaveRequest">
<input type="text" name="rec" placeholder="Enter email id of reciver">
<input type="submit" value= "send">

</form>
<hr>
<form action="SavePost">
<textarea name ="message" rows="6" cols="50"></textarea>
<input type="submit" value= "Save Post">
</form>
</td>
<td width="20%">
<%
ArrayList <String> friends1= db.getFriends(email);
if(friends1 != null)
{
for(String f:friends1)
{
	user= db.getUser(f);
 %>

 <b><%= user.getName() %> </b> 
 &nbsp;&nbsp;&nbsp;
 <a href="Message?reciver=<%=user.getEmail() %>">Message</a>
 <br>
 
 <% 
}
}
%>
</td>
</tr>
<tr>
<td></td>
<td>
<%
for(Wpost wpost:wposts){
	
	User wu= db.getUser(wpost.getSender());
%>
<hr>
<%= wu.getName() %><br>
<%= wpost.getDop() %>
<hr>
<%= wpost.getMessage() %>

<% 	
}

%>


</td>
<td></td>
</tr>

</table>
<%
  if(session.getAttribute("email")==null){
	  response.sendRedirect("index.jsp");
  }
  else
  {

%>
Welcome <%=session.getAttribute("email").toString() %>
<%
  }
%>
<br>
<%

%>
-->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>