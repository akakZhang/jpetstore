package myjpetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myjpetstore.domain.Item;
import myjpetstore.service.CatagoryService;

public class ItemViewServlet extends HttpServlet {

	private String itemId = null;

	CatagoryService catagoryService = new CatagoryService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		itemId = request.getParameter("itemId");
		
		Item item = catagoryService.getItem(itemId);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("item", item);
		session.setAttribute("itemid", itemId);
		
		request.getRequestDispatcher("/WEB-INF/jsp/catelog/Item.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request,response);
	}

}
