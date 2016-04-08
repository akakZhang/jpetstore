package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myjpetstore.domain.Account;
import myjpetstore.service.AccountService;

public class RegisterServlet extends HttpServlet {

	private AccountService accountService = new AccountService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Account account = new Account();
		String username = request.getParameter("username");
		String password = request.getParameter("newPassword");
		String repassword = request.getParameter("repeatedPassword");
		
		if(!password.equals(repassword)){
			request.getRequestDispatcher("").forward(request, response);
		}
		else{
		
			account.setUsername(request.getParameter("username"));
			account.setPassword(request.getParameter("newPassword"));
			account.setFirstName(request.getParameter("firstname"));
			account.setLastName(request.getParameter("lastname"));
			account.setEmail(request.getParameter("email"));
			account.setPhone(request.getParameter("phone"));
			account.setAddress1(request.getParameter("address1"));
			account.setAddress2(request.getParameter("address2"));
			account.setCity(request.getParameter("city"));
			account.setState(request.getParameter("state"));
			account.setZip(request.getParameter("zip"));
			account.setCountry(request.getParameter("country"));
			account.setLanguagePreference(request.getParameter("languagePreference"));
			account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
			account.setBannerOption(request.getParameter("bannerOption").equals("true") ? true : false);
			account.setListOption(request.getParameter("listOption").equals("true") ? true : false);
			//写入数据库
			accountService.insertAccount(account);
			//跳转到登陆界面
			request.getRequestDispatcher("/WEB-INF/jsp/account/SignonForm.jsp").forward(request, response);
			
		}
		
	}

}
