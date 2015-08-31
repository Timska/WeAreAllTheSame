package weareallthesame.model.games.additionandsubtractiongames;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.exceptions.MissingTagException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.interfaces.ChooseNumberInterface;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubtractionNumbersViewInterface;

public class AdditionAndSubtractionNumbersGame extends AbstractGame implements ChooseNumberInterface{

	private static final long serialVersionUID = -571230758625520275L;

	private AdditionAndSubtractionNumbersViewInterface view;
	private int numberOne;
	private int numberTwo;
	private boolean addition;
	private boolean gameOver;
	private Set<Integer> offeredAnswers;
	private int result;
	
	public AdditionAndSubtractionNumbersGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException, MissingTagException {
		super(tags, question);
		this.setCommandFactory(new AdditionAndSubtractionCommandFactory(this));
		if(view instanceof AdditionAndSubtractionNumbersViewInterface){
			this.view = (AdditionAndSubtractionNumbersViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setSubgame();
		setNumbers();
		setOfferedAnswers();
		gameOver = false;
	}
	
	private void setOfferedAnswers(){
		offeredAnswers = new HashSet<Integer>();
		offeredAnswers.add(result);
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		while(offeredAnswers.size() < numOfferedAnswers){
			offeredAnswers.add(random.nextInt(20));
		}
		view.setOfferedAnswers(offeredAnswers);
	}
	
	private void setNumbers(){
		Random random = new Random();
		numberOne = random.nextInt(10) + 1;
		if(addition){
			numberTwo = random.nextInt(11 - numberOne) + 1;
			result = numberOne + numberTwo;
		}
		else{
			numberTwo = random.nextInt(numberOne) + 1;
			result = numberOne - numberTwo;
		}
		System.out.println("numOne: " + numberOne + ", numTwo: " + numberTwo);
		view.setNumbers(numberOne, numberTwo);
	}
	
	private void setSubgame() throws MissingTagException{
		Iterator<String> tags = this.getTags();
		boolean flag = false;
		while(tags.hasNext()){
			String tag = tags.next();
			if(tag.equals("addition")){
				addition = true;
				flag = true;
			}
			else if(tag.equals("subtraction")){
				addition = false;
				flag = true;
			}
		}
		view.setAdditionOperator(addition);
		if(!flag){
			throw new MissingTagException("Nedostiga tag za definiranje na igrata");
		}
	}

	@Override
	public String getType() {
		return "AdditionAndSubtractionNumbers";
	}

	@Override
	public void chooseNumber(int number) throws GameOverException, CommandException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		if(!offeredAnswers.contains(number)){
			throw new CommandException("Isprateniot broj ne e vo ponudenite");
		}
		if(number == result){
			gameOver = true;
			view.gameOver();
		}
		else{
			view.wrongAnswer();
		}
	}

	public AdditionAndSubtractionNumbersViewInterface getView() {
		return view;
	}

	
}
