package com.jspbook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileWriter;

public class Que extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		reponse.setContentType("text/html");
		String Age = request.getParameter("Age");
		String Name = request.getParameter("Name");
		String Emailaddr = request.getParameter("Emailaddr");
		String Gender = request.getParameter("Gender");
		PrintWriter out = reponse.getWriter();
		//FileWriter writer = new FileWriter("data/quesdata.dat", true);
		out.println("<html>");
		out.println("<title>Thanks!</title>");
		out.println("Questionare filled success. <a href=\"/jspbook/data/quesdata.dat\"> ");
	}
}