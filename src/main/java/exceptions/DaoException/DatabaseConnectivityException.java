package exceptions.DaoException;


public class DatabaseConnectivityException extends CustomerDaoException  {

	public DatabaseConnectivityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectivityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectivityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectivityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DatabaseConnectivityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
