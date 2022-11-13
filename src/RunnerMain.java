import java.util.*;

//This class is the interface for the trivia game, where all the questions are presented to the user.
public class RunnerMain {

    //main runner method
    public static void main (String[] args) throws Exception {

        //These lines of code prep for the trivia game, before the user starts.
        int mode = 1;
        TriviaReader test = new TriviaReader(mode);
        ArrayList<Integer> triviaLeft = new ArrayList<>();
        for (int i = 0; i < test.getSize(); i++) {
            triviaLeft.add(i);
        }
        System.out.println("Welcome to Halloween Trivia! For this trivia, type the correct answer below each question given." +
                "\n" + "The trivia continues until you get an answer wrong, or you complete all the questions. If an answer requires" +
                "\n" + "a number, don't answer in word form except when writing numbers a million or above (ex. \"10 million pumpkins\")." +
                "\n" + "Good Luck, here is your first question ::" + "\n");
        Scanner keyboard = new Scanner(System.in);
        boolean allCorrect = true;

        //These lines code are a loop that runs until the user gets a question wrong, or finishes all the questions.
        while (allCorrect == true) {
            int random = triviaLeft.get((int)(Math.random()*triviaLeft.size()));
            System.out.println(test.getQuestion(random));
            String answer = keyboard.nextLine();
            if (test.isAnswerCorrect(random, answer)) {
                System.out.println("Correct!");
                triviaLeft.remove(triviaLeft.indexOf(random));
            } else {
                System.out.println("Sorry, that's incorrect! The correct answer is: " + test.getAnswer(random));
                allCorrect = false;
            }
            if (triviaLeft.size() == 0) {
                mode++;
                if (mode > 3) {
                    System.out.println("\n" + "Congratulations, you got all the questions right!" + "\n");
                    break;
                } else {
                    test = new TriviaReader(mode);
                    for (int i = 0; i < test.getSize(); i++) {
                        triviaLeft.add(i);
                    }
                    System.out.println("\n" + "Nice work, here are some harder questions ::" + "\n");
                }
            }
        }
    }
}
