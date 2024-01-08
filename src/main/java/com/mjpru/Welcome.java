package com.mjpru;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.Friend;
import com.mjpru.beans.Wpost;
import com.mjpru.data.DBHandler;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		DBHandler db= new DBHandler();
		HttpSession session= request.getSession();
		String email= session.getAttribute("email").toString();
//		ArrayList<Friend> pfriends= db.getPendingRequests(email);
//        System.out.println("test 0.2");  
		
		ArrayList<Wpost> wposts= db.getPosts(email);
//
//		
		RequestDispatcher rd= request.getRequestDispatcher("welcome.jsp");
//		request.setAttribute("pfriends", pfriends);
		request.setAttribute("wposts", wposts)
		
		;
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
