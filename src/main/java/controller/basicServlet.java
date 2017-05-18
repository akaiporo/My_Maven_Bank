package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;


@WebServlet("/index.html")
public class basicServlet extends HttpServlet{

	@PersistenceUnit(unitName="My_Bank_Web")
	 private EntityManagerFactory emf;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		EntityManager em = emf.createEntityManager();
		String login = "gdelacroix";
		Query q =  em.createQuery("SELECT pt.login FROM Owner pt WHERE pt.login = :login");
		q.setParameter("login",login);
		String name = q.getSingleResult().toString();
		resp.getWriter().write("Servlet is Ok with you"+name);
		
		
	}
	
}
