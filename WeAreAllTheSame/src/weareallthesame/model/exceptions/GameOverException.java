package weareallthesame.model.exceptions;

public class GameOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8331163944618911739L;

	public GameOverException() {
		// TODO Auto-generated constructor stub
	}

	public GameOverException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public GameOverException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

	public GameOverException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

}
