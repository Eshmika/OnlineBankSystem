package com.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CardInsertServlet")
public class CardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDate currentDate = LocalDate.now();
		LocalDate expireDate = currentDate.plusMonths(6);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String cardnumber = request.getParameter("cardnum");
		String accnumber = request.getParameter("accnum");
		String name = request.getParameter("holdername");
		String pin = request.getParameter("pin");
		String expiredate = expireDate.format(format);
		
		boolean isTrue;
		
		isTrue = CardDBUtil.insertcard(cardnumber,accnumber,name,pin,expiredate);
		
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Bank Card is created.');");
			out.println("location='homepage.html'");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Card isnot created or your account has a card!!!!');");
			out.println("location='cardinsert.jsp'");
			out.println("</script>");
		}
	}

}
