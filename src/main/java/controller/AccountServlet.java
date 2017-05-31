package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AccountManager;
import manager.AgencyManager;
import model.Account;
import model.Address;
import model.Agency;
import model.Bank;
import model.CountryCode;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/Account.jsp")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AccountManager accountManager;
	@EJB
	private AgencyManager agencyManager;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Agency> agencies = new ArrayList<Agency>();
		agencies.add(new Agency("agence 1", "125", new Address(), new Bank()));
		request.setAttribute("agencies", agencies);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Agency> agencies = agencyManager.findAll();
		request.setAttribute("agencies", agencies);
		String accountnumber = request.getParameter("accountnumber");
		Date creationdate = new Date(request.getParameter("creationdate"));
		double balance = Double.valueOf(request.getParameter("balance"));
		double interestrate = Double.valueOf(request.getParameter("interestrate"));
		int overdraft = Integer.valueOf(request.getParameter("overdraft"));
		//Agency agency = request.getParameter("agency");
		//AccountType accounttype = request.getParameter("accounttype");
		int alert = Integer.valueOf(request.getParameter("alert"));
		//Account accountToSave = new Account(accountnumber, creationdate, balance, overdraft, interestrate, agency, new CountryCode("fr"),accounttype, alert);
	}

}
