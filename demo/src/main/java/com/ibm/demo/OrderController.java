package com.ibm.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.entity.Order;
import com.ibm.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;						//DI
	@PostMapping("/order")
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry.");
		}
		System.out.println(order);
		return orderService.createOrder(order);
	}
	
	@GetMapping("/order")
	String getOrder() {
		return "Order created";
	}
	
	@PutMapping("/order/{id}")
	String updateOrder(@PathVariable("id")int orderId) {
		System.out.println(orderId);
		return "Order updated";
	}
	
	@DeleteMapping("/order/{id}")
	String deleteOrder(@PathVariable("id")int orderId) {
		System.out.println(orderId);
		return "Order Deleted";
	}

}
