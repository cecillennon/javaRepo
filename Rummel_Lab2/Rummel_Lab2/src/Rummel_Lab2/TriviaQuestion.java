package Rummel_Lab2;


public class TriviaQuestion 
{
	private String category;   //question category
	private String question;   //the question
	private StringLogInterface answers;  //acceptable answers
	
	public TriviaQuestion(String category, String question, int maxNumAnswers)
	//Precondition: maxNumAnswers > 0
	{
		this.category = category;
		this.question = question;
		answers = new ArrayStringLog("trivia", maxNumAnswers);
	}
	
	public TriviaQuestion(String testName) {
		// TODO Auto-generated constructor stub
	}

	public String getCategory()
	//gets category
	{
		return category;
	}
	
	public String getQuestion()
	//gets question
	{
		return question;
	}
	
	public boolean tryAnswer(String answer)
	//if answer is correct returns true, otherwise false
	{
		return answers.contains(answer);
	}
	
	public void storeAnswer(String answer)
	//Precondition: answers is not full
	{
		answers.insert(answer);
	}
	

}
