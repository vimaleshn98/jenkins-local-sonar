package daoservice;

import entity.Item;
import exceptions.DaoException.ItemDaoAlreadyExistsException;
import exceptions.DaoException.ItemDaoException;

public interface ItemDaoInterface {

boolean addToItemDaoToDatabase(Item it) throws ItemDaoAlreadyExistsException;

Item getItemDatabase() throws ItemDaoException;

boolean UpadateItemDatabase(Item itemup) throws ItemDaoException;

boolean deletedItemDatabase(Item itemup)throws ItemDaoException;

boolean updateQuantity(int i, int itemId) throws ItemDaoException;

void display() throws ItemDaoException;

}
