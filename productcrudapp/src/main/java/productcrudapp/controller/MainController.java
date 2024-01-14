package productcrudapp.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productdao;
	@RequestMapping("/")
	public String home() {
		
		
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
		
		this.productdao.createProduct(product);
		RedirectView redirectview=new RedirectView() ;
		redirectview.setUrl(request.getContextPath()+"/");
		return redirectview		;
	}
}
