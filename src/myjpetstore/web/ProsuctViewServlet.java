package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjpetstore.domain.Category;
import myjpetstore.domain.Item;
import myjpetstore.domain.Product;
import myjpetstore.service.CatagoryService;

public class ProsuctViewServlet extends HttpServlet {

	private String productId = null;
	private CatagoryService cataservice = new CatagoryService(); 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		productId = request.getParameter("productId");
		List<Item> itemList = cataservice.getItemListByProduct(productId);
		Product product = cataservice.getProduct(productId);
		HttpSession session = request.getSession();
		session.setAttribute("itemList", itemList);
		session.setAttribute("product", product);
		Category catagory = (Category)session.getAttribute("catagory");
		session.setAttribute("catagory", catagory);
		request.getRequestDispatcher("/WEB-INF/jsp/catelog/Product.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
