package weareallthesame.model.games.questiongame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import weareallthesame.factories.QuestionFactory;
import weareallthesame.model.Question;
import weareallthesame.model.exceptions.CommandException;
import weareallthesame.model.exceptions.GameOverException;
import weareallthesame.model.exceptions.InvalidViewTypeException;
import weareallthesame.model.games.AbstractGame;
import weareallthesame.model.interfaces.ChooseStringInterface;
import weareallthesame.view.games.questiongame.QuestionViewInterface;

public class QuestionGame extends AbstractGame implements ChooseStringInterface {

	private QuestionViewInterface view;
	private Question correct;
	private Set<String> offeredAnswers;
	private boolean gameOver;
	
	public QuestionGame(Iterator<String> tags, Object view, String question) throws InvalidViewTypeException {
		super(tags, question);
		this.setCommandFactory(new QuestionCommandFactory(this));
		if(view instanceof QuestionViewInterface){
			this.view = (QuestionViewInterface) view;
		}
		else{
			throw new InvalidViewTypeException("Se koristi gresno activity za ovaa igra");
		}
		setQuestion();
		setOfferedAnswrers();
		gameOver = false;
	}
	
	private void setQuestion(){
		correct = QuestionFactory.getQuestion(this.getTags(), 1).next();
		//view.setQuestion(correct.getQuestion());
	}
	
	private void setOfferedAnswrers(){
		offeredAnswers = new HashSet<String>();
		//offeredAnswers.add(correct.getAnswer());
		Random random = new Random();
		int numOfferedAnswers = 0;
		while(numOfferedAnswers < 5){
			numOfferedAnswers = random.nextInt(10);
		}
		Iterator<Question> offeredQuestions = QuestionFactory.getQuestion(this.getTags(), numOfferedAnswers - 1);
		while(offeredQuestions.hasNext()){
			//offeredAnswers.add(offeredQustions.next().getAnswer());
		}
		view.setOfferedAnswers(offeredAnswers);
	}

	@Override
	public String getType() {
		return "Question";
	}

	@Override
	public void chooseAnswer(String str) throws CommandException,
			GameOverException {
		if(gameOver){
			throw new GameOverException("Igrata e zavrsena");
		}
		else if(!offeredAnswers.contains(str)){
			throw new CommandException("Vasiot odgovor ne e vo ponudenite");
		}
		/*if(correct.getAnswer().equals(str)){
			gameOver = true;
			view.gameOver();
		}*/
		else{
			view.wrongAnswer();
		}
	}

}
