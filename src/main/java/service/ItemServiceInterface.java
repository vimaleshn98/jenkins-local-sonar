package service;

import entity.Customer;
import entity.Item;
import exceptions.DaoException.ItemDaoAlreadyExistsException;
import exceptions.serviceexception.ServiceDataNotFoundException;
import exceptions.serviceexception.ServiceItemAlreadyExistsException;
import exceptions.serviceexception.ServiceItemException;

public interface ItemServiceInterface {

	Customer getId(int id) throws ServiceDataNotFoundException;

	boolean addToItemDatabase(Item item) throws ServiceItemAlreadyExistsException, ServiceDataNotFoundException;

	Item getItemDatabase() throws ServiceItemException;

	boolean UpadateItemDatabase(Item itemup) throws ServiceItemException;

	boolean deletedItemDatabase(Item itemup)throws ServiceItemException;

	void display() throws ServiceItemException;

}
