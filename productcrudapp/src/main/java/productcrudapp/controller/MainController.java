package productcrudapp.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;
import java.util.*;
@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Product> products=productDao.getProducts()
;		model.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("title","ADD PRODUCT");
		return "add_product_form";
	}  
	
	@RequestMapping(value ="handle-product",method = RequestMethod.POST)
	
	public RedirectView handlleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		
		this.productDao.createProduct(product);
		RedirectView redirectview=new RedirectView() ;
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview	;
	}
	
	@RequestMapping("/delete/{productId}")
	//delete handler
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectview=new RedirectView() ;
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview	;
	}
	
	@RequestMapping("/update/{productId}")
	//update  
	
	
	
	public String updateForm( @PathVariable("productId") int pid ,Model model  ) {
		
		 Product product=this.productDao.getProduct(pid); 
			 model.addAttribute("product", product); 
		 
		
		return "update_form";
	}
	
}
