package com.wipro.productms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.productms.dao.ProductDAO;
import com.wipro.productms.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<Product>();
		dao.findAll().forEach(product1->products.add(product1));
		return products;
	}
	
	public Product addProduct(Product product)
	{
		return dao.save(product);
	}
	public Product getProductById(Long product_id)
	{
		return dao.findById(product_id).get();
	}
	
	public Product updateProduct(Product product)
	{
		return dao.save(product);
	}
	
	public void deleteProduct(Long product_id)
	{
		dao.deleteById(product_id);
	}
}
