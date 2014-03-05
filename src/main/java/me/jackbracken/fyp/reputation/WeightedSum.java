package main.java.me.jackbracken.fyp.reputation;

import java.util.HashMap;
import java.util.LinkedList;

import main.java.me.jackbracken.fyp.models.Answer;
import main.java.me.jackbracken.fyp.models.Question;
import main.java.me.jackbracken.fyp.models.User;

public class WeightedSum {
	
	
	public WeightedSum(HashMap<Integer, Question> questions, HashMap<Integer, Answer> answers, HashMap<Integer, User> users) {
		assignAnswersToQuestions(questions, answers);
		computeWeightedSum(questions, answers, users);
	}
	
	private void assignAnswersToQuestions(HashMap<Integer, Question> questions, HashMap<Integer, Answer> answers) {
		for(Answer a: answers.values()) {
			int parentID = a.getParentID();
			questions.get(parentID).addAnswer(a.getID());
		}
	}
	
	private void computeWeightedSum(HashMap<Integer, Question> questions, HashMap<Integer, Answer> answers, HashMap<Integer, User> users) {
		for(Question q: questions.values()) {
			
			int[] answerArray = q.getAnswers();
			int size = answerArray.length;
			int totalRep = 0;
			int goodAnswers = 0;
			double r = 0.0;
			
			for(int i = 0; i < size; i++) {
				if(answers.get(answerArray[i]).getScore() > 0) {
					goodAnswers++;
					totalRep += answers.get(answerArray[i]).getScore();
				}
			}
			
			for(int i = 0; i < size; i++) {
				if(answers.get(answerArray[i]).getScore() > 0) {
					r = totalRep / answers.get(answerArray[i]).getScore();
					users.get(answers.get(answerArray[i]).getOwnerID()).increaseWS(r);;
				}
			}
			
		}
	}
}
