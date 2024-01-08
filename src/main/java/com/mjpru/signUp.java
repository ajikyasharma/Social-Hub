package com.mjpru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.User;
import com.mjpru.data.DBHandler;


@WebServlet("/signUp")
public class signUp extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out= response.getWriter();
      String email= request.getParameter("email");
      String password= request.getParameter("password");
      String name= request.getParameter("name");
      User user= new  User(email, password, name);
      DBHandler db= new DBHandler();
      db.save(user);
      if(db.getMessage().length()==0) {	  
    	  HttpSession session= request.getSession();
    	  session.setAttribute("email",email);
    	  response.sendRedirect("Welcome");
    	  
      }
    		  
      

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
