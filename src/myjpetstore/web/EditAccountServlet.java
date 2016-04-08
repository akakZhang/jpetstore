package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myjpetstore.domain.Account;
import myjpetstore.service.AccountService;

/**
 * 
 * @author Administrator
 *
 */
public class EditAccountServlet extends HttpServlet {

	private AccountService accountService;
	
	public EditAccountServlet(){
		super();
		this.accountService = new AccountService();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Account account = new Account();
		String password = request.getParameter("newPassword");
		String repassword = request.getParameter("repeatedPassword");
		
		if("".equals(request.getParameter("username"))){
			request.getRequestDispatcher("WEB-INF/jsp/Error.jsp").forward(request, response);
		}
		
		if(!password.equals(repassword)){
			request.getRequestDispatcher("WEB-INF/jsp/Error.jsp").forward(request, response);
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
			//更新数据库
			accountService.updateAccount(account);
			//写入session中更新session
			request.getSession().setAttribute("account", account);
			//转到main页面
			request.getRequestDispatcher("/WEB-INF/jsp/catelog/Main.jsp").forward(request, response);
		}
	}
}
