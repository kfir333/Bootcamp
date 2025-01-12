package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestYourself {

	public static final int TOTAL_SCORE_TO_BE_A_ANGEL = 5;
	static String[] questionNum = { "First", "Second", "Third", "Fourth" };

	class Question {
		public String question;
		public Answer[] answers = new Answer[4];

		public Question(String question, Answer[] answers) {
			super();
			this.question = question;
			this.answers = answers;
		}
	}

	class Answer {
		public String answer;
		public int score;

		public Answer(String answer, int score) {
			this.answer = answer;
			this.score = score;
		}
	}

	public static Answer[] mixAnswerAlgo(Answer[] answer) {
		Random rgen = new Random(); // Random number generator

		for (int i = 0; i < answer.length; i++) {
			int randomPosition = rgen.nextInt(answer.length);
			Answer temp = answer[i];
			answer[i] = answer[randomPosition];
			answer[randomPosition] = temp;
		}

		return answer;
	}

	public static void main(String arg[]) {
		TestYourself testYourself = new TestYourself();
		List<Question> questions = new ArrayList<Question>();
		Answer[] tempAnswer = new Answer[4];
		String tempQuestion;
		int userScore = 0;

		tempQuestion = "How many white gowns do you hava in your closet?";
		tempAnswer[0] = testYourself.new Answer("What is a gown?", 0);
		tempAnswer[1] = testYourself.new Answer("Only one for Purim", 1);
		tempAnswer[2] = testYourself.new Answer("I have only white gowns in my closet", 2);
		tempAnswer[3] = testYourself.new Answer("What is a closet", 3);

		questions.add(testYourself.new Question(tempQuestion, mixAnswerAlgo(tempAnswer.clone())));

		tempQuestion = "Where are you born?";
		tempAnswer[0] = testYourself.new Answer("TLV", 0);
		tempAnswer[1] = testYourself.new Answer("In my mother house", 1);
		tempAnswer[2] = testYourself.new Answer("Milke Way", 2);
		tempAnswer[3] = testYourself.new Answer("I was always there", 3);

		questions.add(testYourself.new Question(tempQuestion, mixAnswerAlgo(tempAnswer.clone())));

		tempQuestion = "How's your parents?";
		tempAnswer[0] = testYourself.new Answer("Dan and Dana", 0);
		tempAnswer[1] = testYourself.new Answer("Bibi and Sara", 1);
		tempAnswer[2] = testYourself.new Answer("Mary, mother of Jesus!", 2);
		tempAnswer[3] = testYourself.new Answer("I hava no parents", 3);

		questions.add(testYourself.new Question(tempQuestion, mixAnswerAlgo(tempAnswer.clone())));

		tempQuestion = "Where are you now?";
		tempAnswer[0] = testYourself.new Answer("Canada", 0);
		tempAnswer[1] = testYourself.new Answer("Pizza Hat", 1);
		tempAnswer[2] = testYourself.new Answer("BBB", 2);
		tempAnswer[3] = testYourself.new Answer("Everyware", 3);

		questions.add(testYourself.new Question(tempQuestion, mixAnswerAlgo(tempAnswer.clone())));

		System.out.println("******************************************************************\n"
				+ "*       Hello Welcome to the 'Are you an angel?' quiz\n"
				+ "******************************************************************");

		Scanner reader = new Scanner(System.in);
		int userAnswer;

		for (Question q : questions) {

			System.out.println(questionNum[questions.indexOf(q)] + " Question\n" + "--------------------------\n"
					+ q.question + "\n");

			for (int i = 0; i < q.answers.length; i++) {
				System.out.println(i + ". " + q.answers[i].answer);
			}

			System.out.println("--------------------------\n" + "Please choose an answer:");

			userAnswer = reader.nextInt();
			
			while (true) {
				if (userAnswer >= q.answers.length || userAnswer < 0) {
					System.out.println("Answer number:" + userAnswer + " does not exist! Please try again...\n"
							+ "Please choose an answer:");
					userAnswer = reader.nextInt();
				}else {
					break;
				}
			}

			userScore += q.answers[userAnswer].score;

		}
		reader.close();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Quiz Result ~~~~~~~~~~~~~~~~~~~~~~\n");
		if (userScore >= TOTAL_SCORE_TO_BE_A_ANGEL) {
			System.out.println("OMG! You are an real angel!! your score is " + userScore + "\n");
		} else {
			System.out.println("A halo does not suit you.\n" + "And I guess you should try to help pepole more.\n"
					+ "Please refer to the 'Are you the devil?' Quiz instead...\n" + "Bye bye\n");
		}

	}
}
