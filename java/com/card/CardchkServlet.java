package com.card;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CardchkServlet")
public class CardchkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession(); // session 
		String username = (String) session.getAttribute("userName"); // pass the session id with user 
		
//		String accnum = request.getParameter("accnumber");
		
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();	
		List<account> accDetails = CardDBUtil.getaccount(username);
		request.setAttribute("accDetails", accDetails);
		
		while(true) {
			Random cardnum = new Random();
			Integer cardNum = cardnum.nextInt(999999999);
			String concardNum = Integer. toString(cardNum);
			
			boolean isTrue;
			isTrue = CardDBUtil.cardidchk(concardNum);
			
			if (isTrue == true) {			
				continue;
			} else {			
				request.setAttribute("cardNum", cardNum);
				RequestDispatcher dis = request.getRequestDispatcher("cardinsert.jsp");
				dis.forward(request, response);
				break;
			}
		}
	}

}
