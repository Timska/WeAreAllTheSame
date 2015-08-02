package weareallthesame.model;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = -9157488480650805668L;

	private String question;
	private String answer;

	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

}
