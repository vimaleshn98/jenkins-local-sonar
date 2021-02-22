package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Customer;
import entity.Item;
import exceptions.serviceexception.ServiceDataNotFoundException;
import service.GetDetailInterface;
import service.ItemServiceInterface;

public class GetDetails implements GetDetailInterface{
	Scanner scanner = new Scanner(System.in);
	public Customer addCustomerInfo() {
		System.out.println("Enter the id of Customer");
		int id =  scanner.nextInt();
		System.out.println("Enter the name of customer");
		String name =scanner.next();
		System.out.println("Enter the Mobile number of Customer");
		String mobileno =scanner.next();
		Customer c = new Customer(id,name,mobileno);
		return c;
	}
	@Override
	public Customer getId() throws ServiceDataNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("enter the id of customer");
		int id =scanner.nextInt();
		ItemServiceInterface itemServiceInterface  = new ItemService();
		try {
			Customer c = itemServiceInterface.getId(id);
			return c;
		} catch (ServiceDataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceDataNotFoundException("id not found");
		}
		
	}
	@Override
	public Item getItemDetails() {
		// TODO Auto-generated method stub
//		List<Item> ls = new ArrayList<Item>();
			System.out.println("Enter the Item id ");
			int id = scanner.nextInt();
			System.out.println("Enter the item name");
			String name = scanner.next();
			System.out.println("Enter the   Price/item ");
			float price = scanner.nextFloat();
			System.out.println("Enter the total quantity of item");
			int quantity = scanner.nextInt();
			Item item = new Item(id,name,price,quantity);
			return item;
	}
	

}
