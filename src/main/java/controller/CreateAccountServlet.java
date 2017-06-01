package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AgencyManager;
import manager.AccountTypeManager;
import model.Account;
import model.AccountType;
import model.Agency;
import model.CountryCode;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/account-creation.jsp")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AgencyManager agencyManager;
	@EJB
	private AccountTypeManager accountTypeManager;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Agency agency = agencyManager.findById(Integer.valueOf(request.getParameter("agency")));
		AccountType accounttype = accountTypeManager.findById(Integer.valueOf(request.getParameter("accounttype")));
		CountryCode cc = new CountryCode("FR");
		String accountNumber = request.getParameter("accountnumber");
		Date creationDate = new Date(request.getParameter("creationdate"));
		double solde = Double.valueOf(request.getParameter("balance"));
		double interest = Double.valueOf(request.getParameter("interestrate"));
		int alert = Integer.valueOf(request.getParameter("alert"));
		int overdraft = Integer.valueOf(request.getParameter("overdraft"));
		
		Account newAccount = new Account(accountNumber, creationDate, solde, overdraft, interest, agency, cc, accounttype, alert);
		
		request.setAttribute("account", newAccount);
		getServletContext().getRequestDispatcher("/account.jsp").forward(request, response);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
	}

}
