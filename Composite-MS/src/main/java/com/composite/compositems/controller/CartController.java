package com.composite.compositems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.CartServiceProxy;
import com.composite.compositems.clients.CustomerServiceProxy;
import com.composite.compositems.clients.ProductServiceProxy;
import com.composite.compositems.entity.CustomerCartEntity;
import com.composite.compositems.exception.RecordNotFoundException;
import com.composite.compositems.model.customer_ms.Customer;
import com.composite.compositems.model.product_inventory_ms.Product;
import com.composite.compositems.model.cart_ms.Cart;
import com.composite.compositems.model.cart_ms.CartLineItem;
import com.composite.compositems.model.cart_ms.CartList;
import com.composite.compositems.repos.CustomerCartRepository;

@RestController
public class CartController {
	@Autowired
	private CartServiceProxy cartProxy;

	@Autowired
	private ProductServiceProxy productProxy;

	@Autowired
	private CustomerCartRepository custCartRepository;
	@Autowired
	private CustomerServiceProxy customerProxy;

	@PostMapping("customers/{id}/cart/products")
	public ResponseEntity<Cart> createCart(@RequestBody List<CartList> cartRequest,
			@PathVariable("id") Long customerId) {

		Cart cart = new Cart();
		CartLineItem lineitem = null;
		List<CartLineItem> cartLineItemList = new ArrayList<CartLineItem>();
		for (CartList request : cartRequest) {
			Product product = productProxy.findProductById(request.getProductId());
			lineitem = new CartLineItem();
			lineitem.setProductId(product.getProduct_id());
			lineitem.setProductName(product.getProduct_name());
			lineitem.setQuantity(request.getQuantity());
			lineitem.setPrice(product.getPrice());
			cartLineItemList.add(lineitem);
		}
		CustomerCartEntity entity = custCartRepository.findByCustomerId(customerId).get(0);
		cart.setCartId(entity.getId().getCartId());
		cart.setcartLineItems(cartLineItemList);
		return cartProxy.updateCartItem(cart, cart.getCartId());
	}

	@GetMapping("customers/{cusId}/cart/")
	public ResponseEntity<Cart> findCartById(@PathVariable("cusId") Long customerId) {
		ResponseEntity<Customer> customerResponse = customerProxy.findCustomerById(customerId);
		Customer customer = customerResponse.getBody();
		if (customer.getCustomerName().equals(null) || customer.getCustomerName().equals("null")) {
			throw new RecordNotFoundException("customer details not found with this id :     " + customerId);
		}
		List<CustomerCartEntity> list = custCartRepository.findByCustomerId(customerId);
		if (list != null && list.size() > 0) {
			CustomerCartEntity entity = list.get(0);
			return cartProxy.getCartItems(entity.getId().getCartId());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
