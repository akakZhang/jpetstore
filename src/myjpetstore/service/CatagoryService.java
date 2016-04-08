package myjpetstore.service;

import java.util.List;

import myjpetstore.domain.Category;
import myjpetstore.domain.Item;
import myjpetstore.domain.Product;
import myjpetstore.persistence.CategoryDAO;
import myjpetstore.persistence.ItemDAO;
import myjpetstore.persistence.ProductsDAO;

public class CatagoryService {
	
	private CategoryDAO catagoryDAO;
	private ProductsDAO productsDAO;
	private ItemDAO itemDAO;
	
	public CatagoryService(){
		this.catagoryDAO = new CategoryDAO();
		this.productsDAO = new ProductsDAO();
		this.itemDAO = new ItemDAO();
	}
	
	public List<Category> getCategoryList() {
	    return catagoryDAO.getCategoryList();
	  }

	  public Category getCategory(String categoryId) {
	    return catagoryDAO.getCategory(categoryId);
	  }

	  public Product getProduct(String productId) {
	    return productsDAO.getProduct(productId);
	  } 

	  public List<Product> getProductListByCategory(String categoryId) {
	    return productsDAO.getProductListByCategory(categoryId);
	  }

	  // TODO enable using more than one keyword
	  public List<Product> searchProductList(String keyword) {
	    return productsDAO.searchProductList("%" + keyword.toLowerCase() + "%");
	  }
	  
	  public List<Item> getItemListByProduct(String productId) {
			return itemDAO.getItemListByProduct(productId);
		}

		public Item getItem(String itemId) {
			return itemDAO.getItem(itemId);
		}

		public boolean isItemInStock(String itemId) {
			return itemDAO.getInventoryQuantity(itemId) > 0;
		}
}
