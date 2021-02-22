package service;

import entity.Customer;
import exceptions.serviceexception.ServiceConnectityExeception;

public interface CustomerInterface {

	boolean addToCustomerDatabase(Customer customer) throws ServiceConnectityExeception;

}
