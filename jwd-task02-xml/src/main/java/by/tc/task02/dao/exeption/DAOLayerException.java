package by.tc.task02.dao.exeption;

public class DAOLayerException extends Exception{
	public DAOLayerException() {
		super();
	}

	public DAOLayerException(String message) {
		super(message);
	}

	public DAOLayerException(String message, Throwable cause) {
		super(message,cause);
	}

	public DAOLayerException(Throwable cause) {
		super(cause);
	}
}
