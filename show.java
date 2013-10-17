package com.jspbook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class show extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		reponse.setContentType("text/html");
		PrintWriter out = reponse.getWriter();
		RandomAccessFile writer =null;
		int i;
		String info;
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Results for the questionare.</h1>");
		out.println("<form method=\"GET\" action=\"http://127.0.0.1:8080/jspbook/delete\">");
		out.println("<table border = \"1\">");
		out.println("<tr>");
		out.println("<th>Name</th><th>Age</th><th>Gender</th><th>Email-address</th>");
		out.println("</tr>");
		try
		{
			writer =  new RandomAccessFile("c://data.dat", "rw");
			info = writer.readLine();
			while(info != null){
				out.println("<tr>");
				out.print("<th>");
				i = 0;
				while(i < info.length()){				
					if(info.charAt(i) == ';'){
						out.println("</th>");
						out.print("<th>");
					} else{
						out.print(info.charAt(i));
					}

					i++;
				}
				out.print("</th>");
				out.println("</tr>");
				info = writer.readLine();
			}

			out.println("</body>");
			out.println("</html>");
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
		out.println("</body>");
		out.println("</html>");
	}
}