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
@WebServlet("/newAccount")
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
		List<Agency> agencies = agencyManager.findAll();
		request.setAttribute("agencies", agencies);
		getServletContext().getRequestDispatcher("/account-creation.jsp").forward(request, response);
	}


}
