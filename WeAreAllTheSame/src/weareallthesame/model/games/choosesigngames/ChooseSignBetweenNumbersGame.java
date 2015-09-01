package weareallthesame.model.games.choosesigngames;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.view.games.choosesigngames.ChooseSignBetweenNumbersViewInterface;

public class ChooseSignBetweenNumbersGame extends AbstractGame implements ChooseSignInterface{

	private static final long serialVersionUID = 3294489516316301348L;

	private ChooseSignBetweenNumbersViewInterface view;
	private Set<Character> signs;
	private int numberOne;
	private int numberTwo;
	private boolean gameOver;
	private char correctSign;
	
	public ChooseSignBetweenNumbersGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new ChooseSignCommandFactory(this));
		if(view instanceof ChooseSignBetweenNumbersViewInterface){
			this.view = (ChooseSignBetweenNumbersViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setNumbers();
		setSigns();
		gameOver = false;
	}
	
	private void setNumbers(){
		Random random = new Random();
		numberOne = random.nextInt(10) + 1;
		int sign = random.nextInt(3);
		if(sign == 0){
			numberTwo = numberOne;
			correctSign = '=';
		}
		else{
			if(numberOne > 5){
				numberTwo = random.nextInt(numberOne - 1) + 1;
				correctSign = '>';
			}
			else{
				numberTwo = random.nextInt(10 - numberOne - 1) + numberOne;
				correctSign = '<';
			}
		}
		view.setNumbers(numberOne, numberTwo);
	}
	
	private void setSigns(){
		signs = new HashSet<Character>();
		signs.add(Character.valueOf('<'));
		signs.add(Character.valueOf('='));
		signs.add(Character.valueOf('>'));
		view.setOfferedSigns(signs);
	}

	@Override
	public String getType() {
		return "ChooseSignBetweenNumbers";
	}

	@Override
	public void chooseSign(Character sign) throws CommandException, GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(!signs.contains(sign)){
			throw new CommandException("Isprateniot znak ne e vo ponudenite");
		}
		if(sign.equals(correctSign)){
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

	public ChooseSignBetweenNumbersViewInterface getView() {
		return view;
	}

}
