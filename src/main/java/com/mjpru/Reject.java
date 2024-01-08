package com.mjpru;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjpru.data.DBHandler;


@WebServlet("/Reject")
public class Reject extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int fid= Integer.parseInt(request.getParameter("fid"));
	      DBHandler db= new DBHandler();
	      db.acceptRequest(fid);
	      response.sendRedirect("Welcome");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
