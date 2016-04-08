package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myjpetstore.domain.Account;

public class SignoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Account account = (Account)request.getSession().getAttribute("account");
		account = null;
		request.getSession().setAttribute("account", account);
		request.getRequestDispatcher("/WEB-INF/jsp/catelog/Main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
