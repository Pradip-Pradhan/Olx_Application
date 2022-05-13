package com.zensar.spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		String enteredValue = null;

		ProductService service = context.getBean("service", ProductService.class);

		do {
			System.out.println("Enter your choose");
			System.out.println("1. Insert");
			System.out.println("2. show all product");
			System.out.println("3. Update");
			System.out.println("4. delete single record");
			System.out.println("5. drop table");
			Scanner scanner = new Scanner(System.in);
			int chooise1 = scanner.nextInt();
			switch (chooise1) {

			case 1:
				System.out.println("enter productId");
				int id = scanner.nextInt();
				System.out.println("enter productName");
				String name = scanner.next();
				System.out.println("enter productCost");
				int cost = scanner.nextInt();
				Product product = new Product(id,name,cost);
				service.insertProduct(product);
				System.out.println("Product inserted successfullyyyyy !!!");
				break;
				
				
				
			case 2:
				List<Product> list=service.getAllProductsRowMapper();
				for(Product p:list) {
					System.out.println(p);
				}
				break;

				
				
			case 3:
				System.out.println("enter whose id you want to update");
				int oldId = scanner.nextInt();
				System.out.println("with respect to what you want to update");
				System.out.println("1. productId");
				System.out.println("2. productName");
				System.out.println("3. productCost");
				int chooise2 = scanner.nextInt();
				switch (chooise2) {
				case 1:
					System.out.println("enter updated Id you want to enter");
					int newId = scanner.nextInt();
					service.updateIdWithRespectToId(newId, oldId);
					System.out.println("update successfullyyyyy");
					break;
				case 2:
					System.out.println("enter updated name you want to enter");
					String newName = scanner.next();
					service.updateNameWithRespectToId(newName, oldId);
					break;
				case 3:
					System.out.println("enter updated price you want to enter");
					int newCost = scanner.nextInt();
					service.updatePriceWithRespectToId(newCost, oldId);
					break;
				default:
					System.out.println("entered wrong choose");
				}
				break;

			case 4:
				System.out.println("enter the Id you want to delete");
				int deleteId = scanner.nextInt();
				service.deleteInfo(deleteId);
				System.out.println("deleted successfullyyyyy");
				break;

			case 5:
				service.dropTable();
				System.out.println("table droped successfullyyyyy !!!");
				break;

			default:
				System.out.println("entered wrong choose");
			}
			System.out.println("Do you want to continue (y/n)");
			enteredValue = scanner.next();
		} while (enteredValue.equalsIgnoreCase("y"));

	}
}
