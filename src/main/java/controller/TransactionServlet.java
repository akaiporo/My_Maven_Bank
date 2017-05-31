package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.CreateTransactionManager;
import model.Account;
import model.Category;
import model.TargetTransaction;
import model.TransactionType;

@WebServlet("/newTransaction")
public class TransactionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private CreateTransactionManager createTransactionManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List <Category> categories=createTransactionManager.findAllCategories();
		List <TransactionType> transactionTypes=createTransactionManager.findAllTypes();
		List <TargetTransaction> targets=createTransactionManager.findAllTargets();
		List <Account> accounts=createTransactionManager.findAllAccounts();
		req.setAttribute("accounts",accounts);
		req.setAttribute("targets",targets);
		req.setAttribute("categories", categories);
		req.setAttribute("transactionTypes", transactionTypes);
		getServletContext().getRequestDispatcher("/createTransaction.jsp").forward(req, resp);
	}
}
