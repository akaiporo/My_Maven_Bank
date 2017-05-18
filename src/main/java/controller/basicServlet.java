package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@WebServlet("/index.html")
public class basicServlet extends HttpServlet{

	@PersistenceUnit(unitName="My_Bank_Web")
	 private EntityManagerFactory emf;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		EntityManager em = emf.createEntityManager();
		resp.getWriter().write("Servlet is Ok");
		
	}
	
}
