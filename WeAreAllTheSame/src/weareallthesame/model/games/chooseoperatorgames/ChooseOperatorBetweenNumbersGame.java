package weareallthesame.model.games.chooseoperatorgames;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.view.games.chooseoperatorgames.ChooseOperatorBetweenNumbersViewInterface;

public class ChooseOperatorBetweenNumbersGame extends AbstractGame implements ChooseOperatorInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2019277825228322070L;

	private ChooseOperatorBetweenNumbersViewInterface view;
	private Set<Character> operators;
	private Character correctOperator;
	private int numberOne;
	private int numberTwo;
	private int result;
	private boolean gameOver;
	
	public ChooseOperatorBetweenNumbersGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChooseOperatorCommandFactory(this));
		if(view instanceof ChooseOperatorBetweenNumbersViewInterface){
			this.view = (ChooseOperatorBetweenNumbersViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		init();
	}
	
	private void init(){
		operators = new HashSet<Character>();
		operators.add(Character.valueOf('+'));
		operators.add(Character.valueOf('-'));
		view.setOfferedOperators(operators);
		
		Random random = new Random();
		int correct = random.nextInt(2);
		if(correct == 0){
			correctOperator = '+';
			numberOne = random.nextInt(10) + 1;
			numberTwo = random.nextInt(15 - numberOne + 1);
		}
		else{
			correctOperator = '-';
			numberOne = random.nextInt(15) + 1;
			numberTwo = random.nextInt(16);
		}
		result = numberOne + numberTwo;
		
		view.setNumbers(numberOne, numberTwo, result);
	}
	
	@Override
	public String getType() {
		return "ChooseOperatorBetweenNumbers";
	}

	@Override
	public void chooseOperator(Character operator) throws GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(operator.equals(correctOperator)){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

	public ChooseOperatorBetweenNumbersViewInterface getView() {
		return view;
	}
}
