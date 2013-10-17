package com.jspbook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Que extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		reponse.setContentType("text/html");
		String Age = request.getParameter("age");
		String Name = request.getParameter("name");
		String Emailaddr = request.getParameter("emailaddr");
		String Gender = request.getParameter("gender");
		PrintWriter out = reponse.getWriter();
		//FileWriter writer = new FileWriter("/data/quesdata.dat", true);
		String info = Name + ";" + Age + ";" + Gender + ";" + Emailaddr + "\n";
		RandomAccessFile writer =null;
		try{
			writer =  new RandomAccessFile("data.dat", "rw");
			writer.seek(writer.length());
			writer.write(info.getBytes());
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				if(writer != null){
					writer.close();
				}
			}

			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		out.println("<html>");
		out.println("<title>Thanks!</title>");
		out.println(Age + " " + Name + " " + Gender + " " + Emailaddr);
		out.println("<br>");
		out.println("<a href=\"/jspbook/show\">To view colleted data so far, click here.</a>");
	}
}