package com.card;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteCardServlet")
public class deleteCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String cardnumber = request.getParameter("cardnum");
		boolean isTrue;
		
		isTrue = CardDBUtil.deleteCard(cardnumber);
		
		if (isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your Bank Card is canceled.');");
			out.println("location='homepage.html'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your Bank Card is canceled.');");
			out.println("location='deletecard.jsp'");
			out.println("</script>");
		}
	}

}
