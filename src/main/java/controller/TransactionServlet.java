package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.CreateTransactionManager;
import model.Account;
import model.Category;
import model.PeriodicTransaction;
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
		req.setAttribute("accounts",createTransactionManager.findAllAccounts());
		req.setAttribute("targets",createTransactionManager.findAllTargets());
		req.setAttribute("categories",createTransactionManager.findAllCategories());
		req.setAttribute("transactionTypes",createTransactionManager.findAllTypes());
		getServletContext().getRequestDispatcher("/createTransaction.jsp").forward(req, resp);
	}
	
	/**
	 * SES LAAAAAAAAA
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		String wording = req.getParameter("wording");
		String description=req.getParameter("description");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dateOperation = sdf.parse(req.getParameter("date"));
			System.out.println("success");
			
		} catch (ParseException e) {
			System.out.println("no success");
			e.printStackTrace();
		}
	
			/*Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH,1);
			return cal.getTime();
			return new GregorianCalendar(2030,4,10).getTime();*/
			
		/*Double transactionValue=-100.15; //a remplacer avec la valeur rentrée
		System.out.println(req.getParameter("slct-category"));
		Category category = createTransactionManager.findCatById(Integer.valueOf(req.getParameter("slct-category")));
		TransactionType transactionType = createTransactionManager.findTypById(Integer.valueOf(req.getParameter("slct-type")));
		TargetTransaction targetTransaction = createTransactionManager.findTarById(Integer.valueOf(req.getParameter("slct-target")));
		Account account=createTransactionManager.findAccById(1); //a remplacer avec le compte actuel
			
		createTransactionManager.saveTransaction(wording, transactionValue, dateOperation, null,
					0, description, transactionType, targetTransaction, category, null,account);
		System.out.println("success");*/
		
		
	}
}
