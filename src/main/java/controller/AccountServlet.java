package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AccountManager;
import manager.AccountTypeManager;
import manager.AgencyManager;
import model.AccountType;
import model.Agency;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/newAccount")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private AgencyManager agencyManager;
	@EJB
	private AccountTypeManager accountTypeManager;
	@EJB
	private AccountManager accountManager;;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Agency> agencies = agencyManager.findAll();
		List<AccountType> accounttype = accountTypeManager.findAll(); 
		if(request.getParameter("accountId")!= null){
			request.setAttribute("currentAccount", accountManager.findById(Integer.valueOf(request.getParameter("accountId"))));
		}
		request.setAttribute("agencies", agencies);
		request.setAttribute("accounttype", accounttype);
		request.setAttribute("contextPath", getServletContext().getContextPath());
		getServletContext().getRequestDispatcher("/createAccount.jsp").forward(request, response);
	}
}
