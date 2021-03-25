package com.ibm.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.demo.entity.Order;

@Service
public class OrderService {
	public  String createOrder(Order order) {
		return "Order created";
	}
	
	public List<Order> getOrders() {
		return new ArrayList<Order>();
	}

	public void updateOrder(int orderId) {
		System.out.println("Order updated");
	}

	public void deleteOrder(int orderId) {
		System.out.println("Order deleted");
	}

	public Order getOrder(int orderId) {
		return new Order();
	}
	
	

}
