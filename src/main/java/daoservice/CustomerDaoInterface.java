package daoservice;

import entity.Customer;
import exceptions.DaoException.DataNotFoundException;
import exceptions.DaoException.DatabaseConnectivityException;

public interface CustomerDaoInterface {
	boolean addToCustomerDatabase(Customer customer) throws DatabaseConnectivityException ;

	Customer getCustomerByID(int id) throws DataNotFoundException;
}
