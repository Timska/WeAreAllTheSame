package weareallthesame.exceptions;

public class CategoryDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2775267332897832836L;

	public CategoryDoesNotExistException() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDoesNotExistException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public CategoryDoesNotExistException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public CategoryDoesNotExistException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
