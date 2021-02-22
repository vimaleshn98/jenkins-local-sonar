package daoservice;

import entity.Customer;
import exceptions.DaoException.CustomerDaoException;
import exceptions.DaoException.ItemDaoException;
import exceptions.DaoException.PurchasingDaoException;

public interface PurchaseDao {

	Customer getPurchaseDetails() throws ItemDaoException, CustomerDaoException;

	boolean addTOPurchaseInfo(Customer c) throws PurchasingDaoException;

	void getShopingReport() throws ItemDaoException;

}
