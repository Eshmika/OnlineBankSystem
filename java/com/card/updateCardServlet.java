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


@WebServlet("/updateCardServlet")
public class updateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		LocalDate currentDate = LocalDate.now();
		LocalDate expireDate = currentDate.plusMonths(6);
		LocalDate expiredDate = currentDate.minusMonths(6);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String accnumber = request.getParameter("accnum");
		String cardnumber = request.getParameter("newcardnum");
		String pin = request.getParameter("newpin");
		String carddate = request.getParameter("expiredate");
		
		LocalDate date = LocalDate.parse(carddate, format);
		
		if (date.isAfter(expiredDate)) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your Bank Card is not expired.');");
			out.println("location='updatecard.jsp'");
			out.println("</script>");
			
		}
		else {
			String expiredate = expireDate.format(format);
			boolean isTrue;
			isTrue = CardDBUtil.updatecard(cardnumber,accnumber,pin,expiredate);
			
			if(isTrue == true) {
				out.println("<script type='text/javascript'>");
				out.println("alert('New Bank Card is updated.');");
				out.println("location='homepage.html'");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('New Bank Card is not updated.');");
				out.println("location='updatecard.jsp'");
				out.println("</script>");
			}
		}
		
		
	
	}
}

