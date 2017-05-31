package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.PeriodicTransactionManager;
import model.PeriodicTransaction;

@WebServlet("/transactionList")

public class PeriodicTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
     @EJB
     private PeriodicTransactionManager periodicTransactionManager;
    

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		List <PeriodicTransaction> periodicTransaction = this.periodicTransactionManager.findAll();
		req.setAttribute("periodicTransaction", periodicTransaction);
		req.getRequestDispatcher("/PeriodicTransaction.jsp").forward(req, resp);
		
		
		
	}
}
