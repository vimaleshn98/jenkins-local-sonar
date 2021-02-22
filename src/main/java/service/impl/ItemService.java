package service.impl;

import daoservice.CustomerDaoInterface;
import daoservice.ItemDaoInterface;
import daoservice.impl.CustomerDao;
import daoservice.impl.Itemdao;
import entity.Customer;
import entity.Item;
import exceptions.DaoException.DataNotFoundException;
import exceptions.DaoException.ItemDaoAlreadyExistsException;
import exceptions.DaoException.ItemDaoException;
import exceptions.serviceexception.ServiceDataNotFoundException;
import exceptions.serviceexception.ServiceItemAlreadyExistsException;
import exceptions.serviceexception.ServiceItemException;
import service.ItemServiceInterface;

public class ItemService implements ItemServiceInterface {

	@Override
	public Customer getId(int id) throws ServiceDataNotFoundException {
		// TODO Auto-generated method stub
		CustomerDaoInterface interface1 = new CustomerDao();
		try {
			return interface1.getCustomerByID(id);
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceDataNotFoundException("ID not Found");
			
		}
		
	}

//	@Override
//	public boolean addToItemDatabase(Item it) throws ServiceItemAlreadyExistsException  {
//		// TODO Auto-generated method stub
//		ItemDaoInterface daoInterface = new Itemdao();
//		boolean b;
//		try {
//			b = daoInterface.addToItemDaoToDatabase(it);
//		} catch (ItemDaoAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new ServiceItemAlreadyExistsException("ID not Found");
//		}
//		return b;
//	}

	@Override
	public boolean addToItemDatabase(Item item) throws ServiceItemAlreadyExistsException, ServiceDataNotFoundException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		try {
			return interface1.addToItemDaoToDatabase(item);
		} catch (ItemDaoAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceItemAlreadyExistsException("ID Alreay Found");
			
		}
	}

	@Override
	public Item getItemDatabase() throws ServiceItemException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		try {
			return interface1.getItemDatabase();
		} catch (ItemDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceItemException("Item Not Found");
		}
	}

	@Override
	public boolean UpadateItemDatabase(Item itemup) throws ServiceItemException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		try {
			return interface1.UpadateItemDatabase(itemup);
		} catch (ItemDaoException e) {
			e.printStackTrace();
			throw new ServiceItemException("Item Not Found");
		}
	}

	@Override
	public boolean deletedItemDatabase(Item itemup) throws ServiceItemException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		try {
			return interface1.deletedItemDatabase(itemup);
		} catch (ItemDaoException e) {
			e.printStackTrace();
			throw new ServiceItemException("Item Not Found");
		}
	}

	@Override
	public void display() throws ServiceItemException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		try {
			 interface1.display();
		} catch (ItemDaoException e) {
			e.printStackTrace();
			throw new ServiceItemException("Item Not Found");
		}
	}

}
