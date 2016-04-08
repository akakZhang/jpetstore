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
import myjpetstore.domain.Product;
import myjpetstore.service.CatagoryService;

@SuppressWarnings("serial")
public class CatagoryViewServlet extends HttpServlet {
	
	private String catagoryId;
	private CatagoryService catagoryService;
	private List<Category> catagoryList;
	private Category catagory;
	private List<Product> productList;
	private Product product;
	private static final String VIEW_CATAGORY = "/WEB-INF/jsp/catelog/Category.jsp";
	
	public CatagoryViewServlet() {
		super();
		this.catagoryService = new CatagoryService();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�ͻ���catagoryId
		catagoryId = request.getParameter("catagoryId");
		//����ҵ���߼����ѯ���ݿⲢ�洢
		catagory = catagoryService.getCategory(catagoryId);
		productList = catagoryService.getProductListByCategory(catagoryId);
		//Ϊ��һ��ҳ���ʹ�ô���session
		HttpSession session = request.getSession();
		session.setAttribute("catagory", catagory);
		session.setAttribute("productList", productList);
		//����ת��
		request.getRequestDispatcher(VIEW_CATAGORY).forward(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
