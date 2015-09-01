package weareallthesame.model.exceptions;

public class WrongAnswerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7714947218551919921L;

	public WrongAnswerException() {
		// TODO Auto-generated constructor stub
	}

	public WrongAnswerException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public WrongAnswerException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public WrongAnswerException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
