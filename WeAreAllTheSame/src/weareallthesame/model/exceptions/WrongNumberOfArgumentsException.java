package weareallthesame.model.exceptions;

public class WrongNumberOfArgumentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -518713466339483697L;

	public WrongNumberOfArgumentsException() {
		// TODO Auto-generated constructor stub
	}

	public WrongNumberOfArgumentsException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public WrongNumberOfArgumentsException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public WrongNumberOfArgumentsException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
