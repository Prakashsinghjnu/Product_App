package productcrudapp.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.util.*;
/*		project ka object ye khud se create kr paye 
 * LIFE ISKI SPRING MANNAGE KRE TO HM annotation USE KRENGE @COMPONENT
 * */
/*we use @component to give permission to spring to create object by it its own and after that we can 
able to use that object*/

import productcrudapp.model.Product;

@Component
public class ProductDao {
	/*
	 * use to inject objects of hibernate template automatic so for this we
	 * use @autowired 
	 */
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	
	//create
	@Transactional
	public void createProduct(Product product) {
		
		this.hibernatetemplate.saveOrUpdate(product);
	}
	 
	//getallproduct
	
	public List<Product> getProducts(){
		List<Product> products=this.hibernatetemplate.loadAll(Product.class);
		
		return products;
	}
	
	//deletethe single product
	@Transactional
	public void deleteProduct(int pid) {
		
		
	Product p=	this.hibernatetemplate.load(Product.class, pid);
	this.hibernatetemplate.delete(p);
	}
	
	//get the single product
	
	public Product getProduct(int pid) {
		Product p= this.hibernatetemplate.get(Product.class, pid);
		return p;
	}
	
}
