package service;

import java.util.List;

import entity.Customer;
import entity.Item;
import exceptions.serviceexception.ServiceDataNotFoundException;

public interface GetDetailInterface {

	Customer addCustomerInfo();

	Customer getId() throws ServiceDataNotFoundException;

	Item getItemDetails();

}
