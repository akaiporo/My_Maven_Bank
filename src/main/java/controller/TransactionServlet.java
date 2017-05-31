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
import model.Category;

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
		List <String> categories=createTransactionManager.findAll();
		req.setAttribute("categories", categories);
		getServletContext().getRequestDispatcher("/createTransaction.jsp").forward(req, resp);
	}
}
