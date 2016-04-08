package myjpetstore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjpetstore.domain.Product;
import myjpetstore.service.CatagoryService;

public class SearchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keywords = request.getParameter("keyword");
		CatagoryService catagoryService = new CatagoryService();
		List<Product> productList = catagoryService.searchProductList(keywords);
		HttpSession session = request.getSession();
		session.setAttribute("productList", productList);
		request.getRequestDispatcher("/WEB-INF/jsp/catelog/SearchProduct.jsp").forward(request, response);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
