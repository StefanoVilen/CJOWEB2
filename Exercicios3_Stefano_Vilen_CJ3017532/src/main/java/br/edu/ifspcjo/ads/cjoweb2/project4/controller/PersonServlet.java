package br.edu.ifspcjo.ads.cjoweb2.project4.controller;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public	 class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		
		String nome = req.getParameter("nome");

		
		String[] emails = req.getParameterValues("emails");
		String[] cursos = req.getParameterValues("cursos");

		if (emails == null) emails = new String[0];
		if (cursos == null) cursos = new String[0];

		req.setAttribute("nome", nome);
		req.setAttribute("emails", emails);
		req.setAttribute("cursos", cursos);
		req.setAttribute("quantidadeEmails", emails.length);
		req.setAttribute("quantidadeCursos", cursos.length);

		
		System.out.println("Nome: " + nome);
		System.out.println("Emails: " + Arrays.toString(emails));
		System.out.println("Cursos: " + Arrays.toString(cursos));

		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    
	    req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
