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
	public Product getProductById(long product_id)
	{
		return dao.findById(product_id).orElse(null);
	}
	
	public void updateProduct(Product product)
	{
		dao.save(product);
	}
	
	public void deleteProduct(long product_id)
	{
		dao.deleteById(product_id);
	}
}
