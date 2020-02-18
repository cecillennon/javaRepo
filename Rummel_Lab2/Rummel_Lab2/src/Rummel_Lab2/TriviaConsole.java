package Rummel_Lab2;

import java.io.*;
import java.util.Scanner;

public class TriviaConsole 
{
	public static void main(String[] args) throws IOException
	{
		
		Scanner conIn = new Scanner(System.in);
		
		TriviaGame game;  //the trivia game
		
		int questNum;  //current question number
		TriviaQuestion tq;  //current quesiton
		String answer;  //answer provided by user
		
		//initialize the game
		game = GetTriviaGame.useTextFile("C:\\Users\\Rosemary\\Documents\\Rummel_Lab2.txt");
		
		//greet user
		System.out.println("Hello, and welcome to the " + game.getQuizName() + " trivia quiz!!");
		System.out.println("Beware though, for you will only have " + game.getNumChances() + " chances to get them right!");
		System.out.println("There are " + game.getCurrNumQuestions() + " questions!\n");
		
		questNum = 0;
		while(!game.isOver())
		{
			//get number of next unanswered question
			do
				if(questNum == game.getCurrNumQuestions())
					questNum = 1;
				else
					questNum = questNum + 1;
			while(game.isAnswered(questNum));
			
			//ask question and handle user's response
			tq = game.getTriviaQuestion(questNum);
			System.out.println(tq.getCategory() + ": " + tq.getQuestion());
			answer = conIn.nextLine();
			if(tq.tryAnswer(answer))
			{
				System.out.println("Lucky guess...I mean...Correct!!!\n");
				game.correctAnswer(questNum);
			}
			else
			{
				System.out.println("WRONG!!!\n");
				game.incorrectAnswer();
			}
		}
		
		System.out.println("\nGame Over");
		System.out.println("\nResults");
		System.out.println("Chances used: " + (game.getNumChances() - game.getRemainingChances()));
		System.out.println("Number corect: " + game.getNumCorrect());
		System.out.println("\nThanks for playing!\n");
	}

}
