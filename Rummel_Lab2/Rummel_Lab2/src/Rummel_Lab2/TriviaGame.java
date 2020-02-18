package Rummel_Lab2;

public class TriviaGame 
{
	private String quizName;
	private int maxNumQuestions;
	private int numChances;
	private int remainingChances;
	private int numCorrect = 0;
	private int numIncorrect = 0;
	private TriviaQuestion[] questions;  //set of questions
	private boolean[] correct;   //true if corresponding question answered corectly
	private int currNumQuestions = 0;
	
	public TriviaGame(String quizName, int maxNumQuestions, int numChances)
	//precondition: maxNumQuestions > 0 and numChances > 0
	{
		this.quizName = quizName;
		this.maxNumQuestions = maxNumQuestions;
		this.numChances = numChances;
		remainingChances = numChances;
		questions = new TriviaQuestion[maxNumQuestions];
		correct = new boolean[maxNumQuestions];
	}
	
	public String getQuizName()
	{
		return quizName;
	}
	
	public int getNumChances()
	{
		return numChances;
	}
	
	public int getRemainingChances()
	{
		return remainingChances;
	}
	
	public int getNumCorrect()
	{
		return numCorrect;
	}
	
	public int getCurrNumQuestions()
	{
		return currNumQuestions;
	}
	
	public TriviaQuestion getTriviaQuestion(int questionNumber)
	//precondition:  0 < questionNumber <= currNumQuestions
	{
		return questions[questionNumber - 1];
	}
	
	public boolean isAnswered(int questionNumber)
	//precondition:  0 < questionNumber <= currNumQuestions
	{
		return correct[questionNumber - 1];
	}
	
	public boolean isOver()
	//return true if this game is over, false otherwise
	{
		return(numCorrect == currNumQuestions || remainingChances <= 0);
	}
	
	public void insertQuestion(TriviaQuestion question)
	//precondition: currNumQuestions < maxNumQuestions
	//adds question to this triviagame
	{
		questions[currNumQuestions] = question;
		correct[currNumQuestions] = false;
		currNumQuestions = currNumQuestions + 1;
	}
	
	public void correctAnswer(int questionNumber)
	//precondition: 0 < questionNumber < maxNumQuestions
	//updates game status for question number, questionNumber was answered correctly
	{
		correct[questionNumber - 1] = true;
		numCorrect = numCorrect + 1;
		remainingChances = remainingChances + 1;
	}
	
	public void incorrectAnswer()
	//update game status for question that was answered incorrectly
	{
		numIncorrect = numIncorrect + 1;
		remainingChances = remainingChances - 1;
	}
}
