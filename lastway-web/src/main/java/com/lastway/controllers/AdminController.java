package com.lastway.controllers;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AdminController implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private static final Order[] orderList = new Order[] {

			new Order("A0001", "Intel CPU",
					new BigDecimal("700.00"), 1),
			new Order("A0002", "Harddisk 10TB",
					new BigDecimal("500.00"), 2),
			new Order("A0003", "Dell Laptop",
					new BigDecimal("11600.00"), 8),
			new Order("A0004", "Samsung LCD",
					new BigDecimal("5200.00"), 3),
			new Order("A0005", "A4Tech Mouse",
					new BigDecimal("100.00"), 10)
		};

		public Order[] getOrderList() {
			System.out.println("=== getOrderList ===");
			return orderList;

		}

		public static class Order{

			String orderNo;
			String productName;
			BigDecimal price;
			int qty;

			public Order(String orderNo, String productName,
	                                BigDecimal price, int qty) {

				this.orderNo = orderNo;
				this.productName = productName;
				this.price = price;
				this.qty = qty;
			}

			public String getOrderNo() {
				return orderNo;
			}
			
			public void setOrderNo(String orderNo) {
				this.orderNo = orderNo;
			}
			
			public BigDecimal getPrice() {
				return price;
			}
			
			public void setPrice(BigDecimal price) {
				this.price = price;
			}
			
			public String getProductName() {
				return productName;
			}
			
			public void setProductName(String productName) {
				this.productName = productName;
			}
			
			public int getQty() {
				return qty;
			}
			
			public void setQty(int qty) {
				this.qty = qty;
			}
		}
}
