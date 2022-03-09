package com.cybage.pms;

import java.util.List;
import java.util.Scanner;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

public class TestProduct {
	
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int choice=0;
			ProductService pservice=new ProductServiceImpl();
			do {
				System.out.println("1.Add Product\n 2.Display all Product \n 3.Delete Product\n 4.Display by id\n 5.Exit\\n");
				System.out.println("choice");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					int n=pservice.addProduct();
					if(n>0) {
						System.out.println("Insertion done");
					}
					else {
						System.out.println("Not found");
					}
					break;
				case 2:
					List<Product> plist=pservice.displayAll();
					if(plist!=null)
						plist.forEach(System.out::println);
					else
						System.out.println("Not Found");
					break;
				case 3:
					System.out.println("Enter id:");
					int id=sc.nextInt();
					boolean status=pservice.deleteById(id);
					if(status) {
						System.out.println("deletion done!");
					}
					else {
						System.out.println("Not found");
					}
					break;
				case 4:
					System.out.println("Enter Id:");
					id=sc.nextInt();
					Product p=pservice.getById(id);
					if(p!=null) {
						System.out.println(p);
					}
					else {
						System.out.println("Not found");
					}
					break;
				case 5:
					pservice.closeConnection();
					System.out.println("Thank you for visiting");
					break;
				}
			}while(choice!=5);	
	}

}
