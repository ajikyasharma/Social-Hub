package com.mjpru;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.Chat;
import com.mjpru.data.DBHandler;


@WebServlet("/Message")
public class Message extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session= request.getSession();
           
           String sender= session.getAttribute("email").toString();
           String reciver= request.getParameter("reciver");
           

           
           DBHandler db= new DBHandler();
           ArrayList<Chat> chats= db.getMessages(sender, reciver);
           
           RequestDispatcher rd= request.getRequestDispatcher("message.jsp");
           request.setAttribute("chats", chats);
           request.setAttribute("reciver", reciver);
           rd.forward(request, response);
           
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
