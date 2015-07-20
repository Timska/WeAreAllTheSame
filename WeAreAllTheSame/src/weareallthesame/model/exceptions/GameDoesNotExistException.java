package weareallthesame.model.exceptions;

public class GameDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3155917645378316350L;

	public GameDoesNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public GameDoesNotExistException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public GameDoesNotExistException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public GameDoesNotExistException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
