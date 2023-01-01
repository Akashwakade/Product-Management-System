package domain;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.ProductDAO;
import dto.Product;

public class ProductMainApp {
	static Scanner sc1=new Scanner(System.in);
	public static void main(String[] args) {
		boolean exit=true;
		while(exit) {
		System.out.println("Select Mode of Operations");
		System.out.println("\n1:add product");
		System.out.println("\n2:delete Product");
		System.out.println("\n3:Display Product");
		System.out.println("\n4.Exit");
		int choice=sc1.nextInt();
		switch(choice) {
		case 1:
		{
			insertProduct();
		}
		break;
		case 2:
		{
			deleteProduct();
		}
		break;
		case 3:
		{
			displayProduct();
		}
		break;
		case 4:{
			exit=false;
		}
		break;
		}
		}
	}
	static void insertProduct() {
		System.out.println("Enter product Name");
		String name=sc1.next();
		System.out.println("Enter Product Price");
		double price=sc1.nextDouble();
		
		//add data to DTO object
		Product p1=new Product();
		p1.setProductName(name);
		p1.setProductPrice(price);
		//pass Dto object as agrument to addProduct() method
		ProductDAO d1= new ProductDAO();
		int count =d1.addProduct(p1);
		System.out.println(count+"Insert Product Sucessfully");
		
		
	}
	static void deleteProduct() {
		System.out.println("Enter Id ");
		int id=sc1.nextInt();
		Product p1=new Product();
		p1.setProductId(id);
		ProductDAO d1= new ProductDAO();
		int count =d1.deleteProduct(p1);
		if(count!=0) {
			System.out.println(count+"Product Deleted Sucessfully");
		}else {
			System.out.println("Product not Deleted");
		}
		
	}
	static void displayProduct() {
		ProductDAO d1=new ProductDAO();
		ArrayList<Product> data=d1.displayProduct();
		for(Product p:data) {
			System.out.println(p);
		}
		
	}
		
	
	

}

