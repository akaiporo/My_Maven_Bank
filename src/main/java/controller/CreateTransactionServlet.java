package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AccountManager;
import manager.CreateTransactionManager;
import model.Account;
import model.Category;
import model.TargetTransaction;
import model.TransactionType;

@WebServlet("/newTransaction")
public class CreateTransactionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private CreateTransactionManager createTransactionManager;
	
	@EJB
    private AccountManager accountManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("accounts",createTransactionManager.findAllAccounts());
		req.setAttribute("targets",createTransactionManager.findAllTargets());
		req.setAttribute("categories",createTransactionManager.findAllCategories());
		req.setAttribute("transactionTypes",createTransactionManager.findAllTypes());
		getServletContext().getRequestDispatcher("/createTransaction.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		Account currentAccount=accountManager.findById(1); // remplacer par Integer.valueOf(req.getParameter("account"))
		
		String wording = req.getParameter("wording");
		String description=req.getParameter("description");
		Double transactionValue=-100.15; //a remplacer avec la valeur rentrée
		Category category = createTransactionManager.findCatById(Integer.valueOf(req.getParameter("slct-category")));
		TransactionType transactionType = createTransactionManager.findTypById(Integer.valueOf(req.getParameter("slct-type")));
		TargetTransaction targetTransaction = createTransactionManager.findTarById(Integer.valueOf(req.getParameter("slct-target")));
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date dateOperation = sdf.parse(req.getParameter("date"));
			
			createTransactionManager.saveTransaction(wording, transactionValue, dateOperation, null,
					0, description, transactionType, targetTransaction, category, null,currentAccount);
			System.out.println("success");
		} 
		catch (ParseException e) {			
		}
	}
}
