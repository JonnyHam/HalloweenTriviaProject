import java.util.*;
import java.io.*;

//This class processes all the trivia question data from the text files into a usable form for the trivia question game interface.
public class TriviaReader {
    private ArrayList<String> trivia;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    //This constructor reads all the necessary trivia questions for the level (number) asked when initialized (from the text documents).
    public TriviaReader(int level, String mode) throws Exception{
        trivia = new ArrayList<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();

        File file = new File("C:\\Users\\Jonathan Kim\\Documents\\HalloweenTriviaProject\\src\\" + mode + level + ".txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        while ((st = br.readLine()) != null) {
            trivia.add(st);
        }

        for(int i = 0; i < trivia.size(); i++) {
            if (i % 2 == 0) {
                questions.add(trivia.get(i));
            } else {
                answers.add(trivia.get(i));
            }
        }
    }

    //This method gets the number of questions for the specific trivia question level being used.
    public int getSize () {
        return questions.size();
    }

    //This method gets the question based off of the specific number it is in the trivia question level (from the question ArrayList)
    public String getQuestion (int num) {
        return questions.get(num);
    }

    //This method gets the answer based off of the specific number it is in the trivia question level (from the question ArrayList)
    public String getAnswer (int num) {
        return answers.get(num);
    }

    //This method declares whether an answer is correct or not, through a true or false statement.
    public boolean isAnswerCorrect (int num, String answer) {
        return (answer).equalsIgnoreCase(answers.get(num));
    }
}
