package com.main.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.entity.User;
import com.main.util.JConnect;

@WebServlet("/loginController")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User();
		HttpSession session=request.getSession();
		Statement st=JConnect.getStatement();
		
		try {
			ResultSet rs=st.executeQuery("select * from user where email='"+email+"'");
			if(rs.next()){
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getString("dob"));
				user.setGender(rs.getString("gender"));
				
				session.setMaxInactiveInterval(30*60);
				session.setAttribute("id",user.getEmail());
				response.sendRedirect("profile.jsp");
				
			}
			else{
				session.setMaxInactiveInterval(5);
				session.setAttribute("msg","Email doesn't exists create an account");
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	
}
