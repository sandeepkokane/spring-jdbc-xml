package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.ProductDao;
import com.spring.jdbc.model.Product;

public class App {
	public static void main(String[] args) {
		System.out.println("Spring JDBC Project -> CRUD Operations");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ProductDao productDao = context.getBean("productDao", ProductDao.class);

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Spring JDBC Project -> Performing CRUD Operations");
			System.out.println("Select Operation:");
			System.out.println("1. Insert\t2.Update\t3.Delete\t4.View (Single) \t5.View (All)\t6.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("**** INSERT OPERATION ****");
				System.out.println("Enter the Product Name:");
				String name = sc.next();
				System.out.println("Enter the Product Price:");
				int price = sc.nextInt();
				Product product = new Product(name, price);
				String insert = productDao.insert(product);
				System.out.println(insert);
			}
				break;

			case 2: {
				System.out.println("**** UPDATE OPERATION ****");
				System.out.println("Enter the Product Name:");
				String name = sc.next();
				System.out.println("Enter the Product Price:");
				int price = sc.nextInt();
				System.out.println("Enter the Product Id:");
				int id = sc.nextInt();
				String update = productDao.update(new Product(id, name, price));
				System.out.println(update);

			}
				break;

			case 3: {
				System.out.println("**** DELETE OPERATION ****");
				System.out.println("Enter the Product Id:");
				int id = sc.nextInt();
				String delete = productDao.delete(id);
				System.out.println(delete);
			}
				break;

			case 4: {
				System.out.println("**** VIEW OPERATION (SINGLE PRODUCT) ****");
				System.out.println("Enter the Product Id to view:");
				int id = sc.nextInt();
				Product product = productDao.getProduct(id);
				System.out.println(product);
			}
				break;

			case 5: {
				System.out.println("**** VIEW OPERATION (ALL PRODUCTS) ****");
				List<Product> list = productDao.getAllProduct();
				for (Product p : list) {
					System.out.println(p);
				}
			}
				break;

			case 6:
				flag = false;
				System.out.println("Thank You...");
				break;

			default:
				System.out.println("Select amongst given choices only...");
				break;
			}
		}
	}

}
