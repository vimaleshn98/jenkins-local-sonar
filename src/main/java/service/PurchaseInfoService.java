package service;

import entity.Customer;
import exceptions.CustomerException;
import exceptions.serviceexception.PurchasingServiceException;
import exceptions.serviceexception.ServiceItemException;

public interface PurchaseInfoService {

	Customer getPurchaseDetails() throws CustomerException, ServiceItemException;

	boolean addTOPurchaseInfo(Customer c) throws PurchasingServiceException;

	void getShopingReport() throws PurchasingServiceException;

}
