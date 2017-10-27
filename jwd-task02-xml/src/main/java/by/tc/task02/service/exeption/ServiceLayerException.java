package by.tc.task02.service.exeption;

public class ServiceLayerException extends Exception {
	public ServiceLayerException() {
		super();
	}

	public ServiceLayerException(String message) {
		super(message);
	}

	public ServiceLayerException(String message, Throwable cause) {
		super(message,cause);
	}

	public ServiceLayerException(Throwable cause) {
		super(cause);
	}
}
