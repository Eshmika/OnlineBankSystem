package com.card;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/updateCardcheckServlet")
public class updateCardcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
		
		HttpSession session = (HttpSession) request.getSession(); // session 
		String username = (String) session.getAttribute("userName"); // pass the session id with user 						
				
			List<Card> cardDetails = CardDBUtil.getcard(username);
			request.setAttribute("cardDetails", cardDetails);
			
			while(true) {
				Random cardnum = new Random();
				Integer cardNum = cardnum.nextInt(999999999);
				String concardNum = Integer. toString(cardNum);
				
				boolean isTrue1;
				isTrue1 = CardDBUtil.cardidchk(concardNum);
				
				if (isTrue1 == true) {			
					continue;
				} else {			
					request.setAttribute("cardNum", cardNum);
					RequestDispatcher dis = request.getRequestDispatcher("updatecard.jsp");
					dis.forward(request, response);
					break;
				}
			}
		
		
	}

}
