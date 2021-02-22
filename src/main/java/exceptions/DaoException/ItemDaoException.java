package exceptions.DaoException;

import daoservice.impl.Itemdao;
import exceptions.ItemException;

public class ItemDaoException  extends ItemException{

	public ItemDaoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ItemDaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ItemDaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ItemDaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
