package service.impl;

import daoservice.ItemDaoInterface;
import daoservice.PurchaseDao;
import daoservice.impl.Itemdao;
import daoservice.impl.PurchaseInfoDao;
import entity.Customer;
import exceptions.CustomerException;
import exceptions.DaoException.CustomerDaoException;
import exceptions.DaoException.ItemDaoException;
import exceptions.DaoException.PurchasingDaoException;
import exceptions.serviceexception.PurchasingServiceException;
import exceptions.serviceexception.ServiceItemException;
import service.PurchaseInfoService;

public class PurchaseInfo implements PurchaseInfoService {

	@Override
	public Customer getPurchaseDetails() throws CustomerException, ServiceItemException {
		// TODO Auto-generated method stub
		PurchaseDao interface1 = new PurchaseInfoDao();

		try {
			return interface1.getPurchaseDetails();
		} catch (ItemDaoException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			throw new ServiceItemException("Item not found");
		} catch (CustomerDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomerException("customer not found");
		}

	}

	@Override
	public boolean addTOPurchaseInfo(Customer c) throws PurchasingServiceException {
		// TODO Auto-generated method stub
		PurchaseDao interface1 = new PurchaseInfoDao();
		try {
			return interface1.addTOPurchaseInfo(c);
		} catch (PurchasingDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PurchasingServiceException("item info not inserted");
		}
	}

	@Override
	public void getShopingReport() throws PurchasingServiceException {
		// TODO Auto-generated method stub
		PurchaseDao interface1 = new PurchaseInfoDao();
		try {
			interface1.getShopingReport();
		} catch (ItemDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PurchasingServiceException("item info not inserted");
		}
	}

}
