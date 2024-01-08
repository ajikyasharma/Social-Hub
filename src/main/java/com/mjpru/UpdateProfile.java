package com.mjpru;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.User;
import com.mjpru.data.DBHandler;


@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email= request.getParameter("email");
	      String password= request.getParameter("password");
	      String name= request.getParameter("name");
	      System.out.println("Hello"+ password);
	      User user= new  User(email, password, name);
	      DBHandler db= new DBHandler();
	      db.update(user);
	      System.out.println("Bye");
	      if(db.getMessage().length()==0) {	  

	    	  response.sendRedirect("Welcome");
	    	  
	      }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
