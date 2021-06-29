package com.codingdojo.numbergame.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Integer num = (Integer) session.getAttribute("num");
		Integer guess = Integer.parseInt(request.getParameter("guess"));
		Random rand = new Random();
		
		if(session.getAttribute("num") == null) {
			session.setAttribute("num", rand.nextInt(100));
		}
		if(num == guess) {
			session.setAttribute("num", rand.nextInt(100));
			session.setAttribute("response", "correct");
		}
		else if(guess > num) {
			session.setAttribute("response", "high");	
		}
		else {
			session.setAttribute("response", "low");		
		}
		response.sendRedirect("Index");
	}

}
