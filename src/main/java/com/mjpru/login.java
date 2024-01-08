package com.mjpru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.User;
import com.mjpru.data.DBHandler;


@WebServlet("/login")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter out= response.getWriter();
	      String email= request.getParameter("email");
	      String password= request.getParameter("password");
	      DBHandler db= new DBHandler();
	      User user= db.getUser(email);
	      if(user == null)
	    	   response.sendRedirect("index.jsp?error=invalid email");
	      else {
	    	  if(password.equals(user.getPassword()))
	    	  {
	        	  HttpSession session= request.getSession();
	        	  session.setAttribute("email",email);
	        	  Cookie cookie= new Cookie("myfb_email", email);
	        	  cookie.setMaxAge(3600*24);
	        	  response.addCookie(cookie);
	        	  response.sendRedirect("Welcome");
	    	  }
	    	  else {
	    		  response.sendRedirect("error.jsp?error = invalid password");
	    	  }
	      }
	    	  
	      
	      
	     
	      
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
