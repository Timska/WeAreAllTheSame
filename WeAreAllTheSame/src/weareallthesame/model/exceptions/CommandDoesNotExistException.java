package weareallthesame.model.exceptions;

public class CommandDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6826919636932207277L;

	public CommandDoesNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public CommandDoesNotExistException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public CommandDoesNotExistException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public CommandDoesNotExistException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
