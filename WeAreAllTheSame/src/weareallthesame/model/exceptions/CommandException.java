package weareallthesame.model.exceptions;

public class CommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3225380763498786778L;

	public CommandException() {
		// TODO Auto-generated constructor stub
	}

	public CommandException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public CommandException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public CommandException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
