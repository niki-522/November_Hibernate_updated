package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility {
	public static Product prepareProductData(Scanner scanner) {
		System.out.println("Enter productID");
		long ProductId = scanner.nextLong();
		
		System.out.println("Enter Product Name");
		String productName = scanner.next();
		
		System.out.println("Enter category Id");
		long categoryId = scanner.nextLong();
		
		System.out.println("Enter supplier Id");
		long supplierId = scanner.nextLong();
		
		System.out.println("Enter Product Quantity");
		int productQTY=scanner.nextInt();
		
		System.out.println("Enter Product price");
		int productPrice=scanner.nextInt();
		
		Product product = new Product(ProductId, productName, supplierId, categoryId, productQTY, productPrice);
		
		return product;
	}
	

}
