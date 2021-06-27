package com.composite.compositems.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.CartServiceProxy;
import com.composite.compositems.clients.CustomerServiceProxy;
import com.composite.compositems.clients.InventoryServiceProxy;
import com.composite.compositems.clients.OrderServiceProxy;
import com.composite.compositems.entity.CustomerCartEntity;
import com.composite.compositems.entity.CustomerOrderEmbeddable;
import com.composite.compositems.entity.CustomerOrderEntity;
import com.composite.compositems.model.cart_ms.Cart;
import com.composite.compositems.model.customer_ms.Customer;
import com.composite.compositems.model.order_ms.Order;
import com.composite.compositems.model.order_ms.OrderLineItem;
import com.composite.compositems.model.order_ms.OrderResponse;
import com.composite.compositems.model.product_inventory_ms.Inventory;
import com.composite.compositems.repos.CustomerCartRepository;
import com.composite.compositems.repos.CustomerOrderRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerOrderRepository customerOrderRepo;

	@Autowired
	private CustomerCartRepository customerCartRepo;

	@Autowired
	private OrderServiceProxy orderServiceProxy;

	@Autowired
	private CustomerServiceProxy customerServiceProxy;

	@Autowired
	private InventoryServiceProxy inventoryServiceProxy;

	@Autowired
	private CartServiceProxy cartServiceProxy;

	/**
	 * Place an order for all the products in the cart for the customerid
	 * 
	 * @param customerId
	 * @return
	 */
	@PostMapping("/customers/{customerId}/cart/placeOrder")
	public ResponseEntity<OrderResponse> placeOrder(@PathVariable("customerId") Long customerId) {
		// Get Customer data using the customerId
		ResponseEntity<Customer> customerResponse = customerServiceProxy.findCustomerById(customerId);
		Customer customer = customerResponse.getBody();
		if (customer != null) {
			// Get the customer cart details ()
			CustomerCartEntity customerCart = customerCartRepo.findByCustomerId(customerId).get(0);

			ResponseEntity<Cart> cartResponse = cartServiceProxy.getCartItems(customerCart.getId().getCartId());
			Cart cart = cartResponse.getBody();

			if (cart.getcartLineItems() != null && cart.getcartLineItems().size() > 0) {
				List<OrderLineItem> orderLineItems = cart.getcartLineItems().stream().map(cartLineItem -> {
					return new OrderLineItem(cartLineItem.getProductId(), cartLineItem.getProductName(),
							cartLineItem.getPrice(), cartLineItem.getQuantity());
				}).collect(Collectors.toList());
				double totalPrice = 0;
				if (orderLineItems != null && orderLineItems.size() > 0) {
					totalPrice = orderLineItems.stream().mapToDouble(ol -> ol.getPrice() * ol.getQuantity()).sum();
				}
				ResponseEntity<Order> orderResponse = orderServiceProxy.saveOrderItem(
						new Order(LocalDate.now(), totalPrice, customer.getShippingAddress(), orderLineItems));
				Order order = orderResponse.getBody();
				customerOrderRepo.save(new CustomerOrderEntity(
						new CustomerOrderEmbeddable(customer.getCustomerId(), order.getOrderId())));
				// Remove the products in the cart
				cartServiceProxy.deleteCartLineItems(cart.getCartId());
				// Reduce the product quantity details in the inventory
				order.getOrderLineItems().forEach(ol -> {
					inventoryServiceProxy
							.reduceInventoryQuantity(new Inventory(ol.getProductId(), (int) ol.getQuantity()));
				});
				return new ResponseEntity<>(new OrderResponse(customerId, Arrays.asList(order)), HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Retrieve the customer orders using the customer id
	 * 
	 * @param customerId
	 * @return
	 */
	@GetMapping("/customers/{customerId}/orders")
	public ResponseEntity<OrderResponse> getOrders(@PathVariable("customerId") Long customerId) {
		ResponseEntity<OrderResponse> response = null;
		List<CustomerOrderEntity> customerOrderList = customerOrderRepo.findByCustomerId(customerId);
		if (customerOrderList != null && customerOrderList.size() > 0) {
			List<Long> orderIdList = customerOrderList.stream().map(customerOrder -> customerOrder.getId().getOrderId())
					.collect(Collectors.toList());
			ResponseEntity<List<Order>> orderListResponse = orderServiceProxy.getOrderItemsList(orderIdList);
			OrderResponse orderResponse = new OrderResponse(customerId, orderListResponse.getBody());

			response = new ResponseEntity<>(orderResponse, orderListResponse.getStatusCode());
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

//Testing Purpose
//	@PostMapping("/customer/{customerId}/order/{orderId}")
//	public CustomerOrderEntity save(@PathVariable("customerId") Long customerId,
//			@PathVariable("orderId") Long orderId) {
//		return customerOrderRepo.save(new CustomerOrderEntity(new CustomerOrderEmbeddable(customerId, orderId)));
//	}
//
//	@GetMapping("/customer/{customerId}/order/{orderId}")
//	public List<CustomerOrderEntity> get(@PathVariable("customerId") Long customerId,
//			@PathVariable("orderId") Long orderId) {
//		return customerOrderRepo.findByCustomerId(customerId);
//	}
}
