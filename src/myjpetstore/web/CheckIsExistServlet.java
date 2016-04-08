package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myjpetstore.domain.Account;
import myjpetstore.service.AccountService;

public class CheckIsExistServlet extends HttpServlet {
	
	private AccountService accountService = new AccountService();
	Account account = null;
	private String username = null;
	private String password = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询数据库若存在将数据写入session中并跳转到"/WEB-INF/jsp/catelog/Main.jsp"
		//若不存在则跳转到error页面并提醒用户注册
		username = request.getParameter("username");
		password = request.getParameter("password");
		account = accountService.getAccount(username, password);
		if(account != null){
			request.getSession().setAttribute("account", account);
			request.getRequestDispatcher("/WEB-INF/jsp/catelog/Main.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp").forward(request, response);
		}
		
	}

}
