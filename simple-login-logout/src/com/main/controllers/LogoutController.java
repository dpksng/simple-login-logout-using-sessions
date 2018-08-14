package com.main.controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
			if(request.getSession().getAttribute("id")!=null){
				request.getSession().invalidate();
				response.sendRedirect("profile.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request,response);
	}
	
}
