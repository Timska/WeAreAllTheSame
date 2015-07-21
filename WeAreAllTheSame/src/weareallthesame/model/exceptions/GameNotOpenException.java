package weareallthesame.model.exceptions;

public class GameNotOpenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7824914954843755518L;

	public GameNotOpenException() {
		// TODO Auto-generated constructor stub
	}

	public GameNotOpenException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public GameNotOpenException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public GameNotOpenException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
