package com.mjpru;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.Wpost;
import com.mjpru.data.DBHandler;


@WebServlet("/SavePost")
public class SavePost extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String message= request.getParameter("message");
	     HttpSession session= request.getSession();
	     String sender= session.getAttribute("email").toString();
	     String dop= new Date().toString();
	     DBHandler db= new DBHandler();
	     Wpost wpost= new Wpost(0, message, sender, dop);
	     db.save(wpost);
	     response.sendRedirect("Welcome");
	     
	     
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
