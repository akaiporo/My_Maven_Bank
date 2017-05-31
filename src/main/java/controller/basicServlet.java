package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;


@WebServlet("/index.html")
public class basicServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="MyBankPersistence")
	private EntityManager em;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String login = "gdelacroix";
		Query q =  em.createQuery("SELECT pt.login FROM Owner pt WHERE pt.login = :login", String.class);
		q.setParameter("login",login);
		String name = q.getSingleResult().toString();
		resp.getWriter().write("Servlet is Ok with you "+name);
	}
	
}
