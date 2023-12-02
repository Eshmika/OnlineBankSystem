package com.card;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteCardcheckServlet")
public class deleteCardcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = (HttpSession) request.getSession(); // session 
		String username = (String) session.getAttribute("userName"); // pass the session id with user 						
				
							
		List<Card> cardDetails = CardDBUtil.getcard(username);
		request.setAttribute("cardDetails", cardDetails);	
			
		RequestDispatcher dis = request.getRequestDispatcher("deletecard.jsp");
		dis.forward(request, response);
			
	} 
	

}
