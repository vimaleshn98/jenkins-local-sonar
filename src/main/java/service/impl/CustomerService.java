package service.impl;
import daoservice.CustomerDaoInterface;
import daoservice.impl.CustomerDao;
import entity.Customer;
import exceptions.DaoException.DatabaseConnectivityException;
import exceptions.serviceexception.ServiceConnectityExeception;
import service.CustomerInterface;
public class CustomerService implements CustomerInterface {

	public boolean addToCustomerDatabase(Customer customer) throws ServiceConnectityExeception {
		CustomerDaoInterface customerDBInDao = new CustomerDao();
		boolean flag =false;
		try {
			flag=customerDBInDao.addToCustomerDatabase(customer);
		} catch (DatabaseConnectivityException e) {
			e.printStackTrace();
			throw new ServiceConnectityExeception("Something went worng in dB");
		}
		return flag;
	}

}
