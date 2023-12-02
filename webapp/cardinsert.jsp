<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request a new bank card</title>
<link rel="stylesheet" type="text/css" href="cardCSS.css">
<style>


th, td {
	padding-left: 30px;
}

input[type="text"], input[type="password"] {
	border: none;
	outline: none;
}

.tabhei {
	height: 40px;
}
</style>
</head>
<body>
	<!-- Header -->
	<table class="topnav" style="width: 100%; border: 1px solid;">
		<tr>
			<td><img src="Images/logo.jpg" alt="LOGO" width="210px"
				height="50px"></td>
		</tr>
	</table>

	<div class="navbar">
		<a href="homepage.html">Home</a>
		<form action="customerview" method="post">
			<div class="dropdown">
				<button class="dropbtn">User Information</button>
			</div>
		</form>
		<div class="dropdown">
			<button class="dropbtn">
				Transactions <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<form action="selects" method="post">

					<button type="submit" class="transfbtn">View Transfer</button>
				</form>
				<a href="FundTransfer.jsp">Fund Transfer</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Bank Card <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<form action="CardCheck" method="post">

					<button type="submit" class="transfbtn">Request a Bank
						card</button>
				</form>
				<form action="updateCardCheck" method="post">

					<button type="submit" class="transfbtn">Update the expire
						card</button>
				</form>
				<form action="deleteCardCheck" method="post">

					<button type="submit" class="transfbtn">Cancel the card</button>
				</form>
			</div>
		</div>
		<a href=" ">Bank Accounts</a>
		<form action="logout" method="post">
			<div class="dropdown">
				<button class="dropbtn">Log out</button>
			</div>
		</form>
	</div>
	<!-- Content -->
	<br>
	<br>
	<table style="width: 100%">
		<tr>
			<td style="width: 50%">
				<!-- 				<form action="CardCheck" method="post"> --> <!-- 					<table style="width: 100%"> -->
				<!-- 						<tr> --> <!-- 							<td>Account number</td> --> <!-- 							<td style="border: 1px solid black"><input type="text" -->
				<!-- 								name="accnumber" placeholder="Enter the Account number"><br> -->
				<!-- 							</td> --> <!-- 						</tr> --> <!-- 						<tr> --> <!-- 							<td colspan="2" align="center"><input type="submit" -->
				<!-- 								name="submit" class="cardsubmitbtn" --> <!-- 								value="Check the Account number"></td> -->
				<!-- 						<tr> --> <!-- 					</table> --> <!-- 				</form> <br> 		border="1px" -->
				<form action="CardInsert" method="post">
					<table style="width: 100%">
						<tr style="width: 100%" class="tabhei">
							<td style="background-color: rgb(123, 204, 255)">Account
								Holder name</td>
							<td style="border: 1px solid black"><c:forEach var="acc"
									items="${accDetails}">
									<input type="text" name="holdername" value="${acc.name}"
										readonly>
								</c:forEach></td>
						</tr>
						<tr class="tabhei">
							<td style="background-color: rgb(123, 204, 255)">Account
								number</td>
							<td style="border: 1px solid black"><c:forEach var="acc"
									items="${accDetails}">
									<input type="text" name="accnum" value="${acc.accountnum}"
										readonly>
								</c:forEach></td>
						</tr>
						<tr class="tabhei">
							<td style="background-color: rgb(123, 204, 255)">Card number</td>
							<td style="border: 1px solid black"><input type="text"
								name="cardnum" value="${cardNum}" readonly></td>
						</tr>
						<tr class="tabhei">
							<td style="background-color: rgb(123, 204, 255)">PIN</td>
							<td style="border: 1px solid black"><input type="password"
								name="pin" placeholder="Enter the 4 digit PIN number" required></td>
						</tr>
						<tr class="tabhei">
							<td colspan="2" align="center"><input type="submit"
								name="submit" class="cardsubmitbtn" value="Request a new card">
							</td>
						</tr>
					</table>
				</form>
			</td>
			<td align="center"><img src="Images/bankcard.png" alt="bankcard"
				width="300px"></td>
		</tr>
	</table>
	<br>
	<!-- Footer -->

	<table class="footernav" style="width: 100%;">
		<tr>
			<td style="width: 15%;">
				<p
					style="font-size: 18px; font-family: Arial; font-weight: bold; color: #6699ff;">ABC
					Bank</p>
				<p style="font-size: 12px; font-family: Arial; color: white;">Online
					banking offers customers the freedom to access their accounts and
					perform various financial activities anytime, anywhere if they have
					an internet connection. This accessibility has eliminated the
					constraints of physical branch visits and banking hours, making it
					possible for individuals to check balances, transfer funds, pay
					bills, and even apply for loans from the comfort of their homes or
					while on the go.</p>
			</td>
			<td style="width: 12%;">
				<ul class="footerul">
					<li class="footerli"><a href="">User Information</a></li>
					<li class="footerli"><a href="">View Transaction</a></li>
					<li class="footerli"><a href="">Fund Transfer</a></li>
				</ul>
			</td>
			<td style="width: 12%;">
				<ul class="footerul">
					<li class="footerli"><a href="">Request a Bank Card</a></li>
					<li class="footerli"><a href="">Update the expire card</a></li>
					<li class="footerli"><a href="">Cancel the bank card</a></li>
				</ul>
			</td>
			<td style="width: 12%;">
				<ul class="footerul">
					<li class="footerli"><a href="">Customer Support</a></li>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>