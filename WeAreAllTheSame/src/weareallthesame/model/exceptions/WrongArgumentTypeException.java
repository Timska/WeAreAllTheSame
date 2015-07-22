package weareallthesame.model.exceptions;

public class WrongArgumentTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6097021096702934399L;

	public WrongArgumentTypeException() {
		// TODO Auto-generated constructor stub
	}

	public WrongArgumentTypeException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public WrongArgumentTypeException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public WrongArgumentTypeException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
