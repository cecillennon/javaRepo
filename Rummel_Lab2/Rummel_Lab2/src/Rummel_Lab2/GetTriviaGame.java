package Rummel_Lab2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetTriviaGame 
{
	public static TriviaGame useTextFile(String textfile) throws IOException
	//precondition: text file is properly formatted and exists
	{
		TriviaGame game;
		
		String quizName;
		int numQuestions, numChances;
		
		//for specific trivia question
		TriviaQuestion tq;
		String category, question, answer;
		int numAnswers;
		
		FileReader fin = new FileReader(textfile);
		Scanner triviaIn = new Scanner(fin);
		String skip;   //skip end of line after reading integer
		
		//Scans in trivia quiz info and sets variable
		quizName = triviaIn.nextLine();
		numQuestions = triviaIn.nextInt();
		numChances = triviaIn.nextInt();
		skip = triviaIn.nextLine();
		
		//Instantiate the triviagame
		game = new TriviaGame(quizName, numQuestions, numChances);
		
		//scan in and set up questions/answers
		for(int i = 1; i <= numQuestions; i++)
		{
			category = triviaIn.nextLine();
			question = triviaIn.nextLine();
			numAnswers = triviaIn.nextInt();
			skip = triviaIn.nextLine();
			tq = new TriviaQuestion(category, question, numAnswers);
			for(int j = 1; j <= numAnswers; j++)
			{
				answer = triviaIn.nextLine();
				tq.storeAnswer(answer);
			}
			game.insertQuestion(tq);
		}
		return game;
	  }
		
}
