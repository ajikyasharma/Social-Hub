package com.mjpru;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mjpru.beans.Friend;
import com.mjpru.data.DBHandler;

@WebServlet("/SaveRequest")
public class SaveRequest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rec= request.getParameter("rec");
        int status=0;
        String dor= new Date().toString();
        HttpSession session= request.getSession();
        String sender= session.getAttribute("email").toString();
        Friend friend= new Friend(0,status, sender, rec, dor);
        DBHandler db= new DBHandler();
        db.save(friend);
        response.sendRedirect("Welcome");
        
        
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
