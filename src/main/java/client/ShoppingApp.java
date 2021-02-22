package client;

import java.util.Scanner;

import entity.Customer;
import entity.Item;
import exceptions.CustomerException;
import exceptions.DaoException.CustomerDaoException;
import exceptions.DaoException.ItemDaoException;
import exceptions.serviceexception.PurchasingServiceException;
import exceptions.serviceexception.ServiceConnectityExeception;
import exceptions.serviceexception.ServiceDataNotFoundException;
import exceptions.serviceexception.ServiceItemAlreadyExistsException;
import exceptions.serviceexception.ServiceItemException;
import service.GetDetailInterface;
import service.CustomerInterface;
import service.impl.CustomerService;
import service.impl.GetDetails;
import service.impl.ItemService;
import service.impl.PurchaseInfo;
import service.ItemServiceInterface;
import service.PurchaseInfoService;

public class ShoppingApp {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean flag = false;
		GetDetailInterface detailInterface = new GetDetails();
		ItemServiceInterface it =new ItemService();
		PurchaseInfoService ip =new PurchaseInfo();
		int choice;
		do {
			System.out.println("1 --> Sign up(Customer Info)\n 2 --> Shoping Details\n 3--> Generate Shopping Report\n 4--> Add item\n 5-->Update items Quantity\n 6-->Delete item by id\n 7-->Get All item (sorted based on price and quantity)\n 8--> Exit\n Enter your choice");
			choice = scanner.nextInt();
			boolean flag3;
			switch (choice) {
			case 1:
				System.out.println("--------------- Sign up(Customer Info)-----------");
				Customer customer=detailInterface.addCustomerInfo();
				CustomerInterface ci = new CustomerService();
				try {
					flag=ci.addToCustomerDatabase(customer);
					if(flag)
						System.out.println("Inserted customer data successfully!!");
					else
						System.out.println("Data not inserted!!");
				} catch (ServiceConnectityExeception e) {
					e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}
				break;
			case 2:
				System.out.println("----------- Shoping Details -----------------");
				Customer c;
				try {
					c = ip.getPurchaseDetails();
					flag = ip.addTOPurchaseInfo(c);
				} catch (CustomerException | ServiceItemException | PurchasingServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				System.out.println("-----------Generate Shopping Report-----------------");
				try {
					ip.getShopingReport();
				} catch (PurchasingServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				System.out.println("-----------Add item-----------------");
				Item item=detailInterface.getItemDetails();
				boolean flag2;
				try {
					flag2 = it.addToItemDatabase(item);
					if(flag2)
						System.out.println("Inserted Item data successfully!!");
					else
						System.out.println("Data not inserted!!");
				} catch (ServiceItemAlreadyExistsException | ServiceDataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("-----------Update items Quantity-----------------");
				try {
					Item itemup =it.getItemDatabase();
					flag3 = it.UpadateItemDatabase(itemup);
					if(flag3)
						System.out.println("Updated Item data successfully!!");
					else
						System.out.println("Data not Updated!!");
				} catch (ServiceItemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 6:
				System.out.println("-----------Delete items-----------------");
				try {
					Item itemup =it.getItemDatabase();
					flag3 = it.deletedItemDatabase(itemup);
					if(flag3)
						System.out.println("Deleted Item data successfully!!");
					else
						System.out.println("Data not Updated!!");
				} catch (ServiceItemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				System.out.println("-----------Get All items -----------------");
				try {
					it.display();
				} catch (ServiceItemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				
				System.out.println("-------------Logout-------------");
				
			}
		} while (choice <= 7 && choice >= 1);
	}

}
