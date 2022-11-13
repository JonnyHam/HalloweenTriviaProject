import java.util.*;

//This class is the interface for the trivia game, where all the questions are presented to the user.
public class RunnerMain {

    //main runner method
    public static void main (String[] args) throws Exception {

        //These lines of code prep for the variables needed for the trivia game, and ask whether the user wants to do a test run or not.
        int level;
        String mode;
        TriviaReader test;
        ArrayList<Integer> triviaLeft;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Do you want to do a test round (less questions per level) (type t), or the real thing (type r)?");

        String testOrReal;
        testOrReal = keyboard.nextLine();
        if (testOrReal.equals("r")) {
            mode = "HalloweenTrivia";
        } else {
            mode = "TestQuestions";
        }

        //These lines of code prep for the trivia game, before the user starts.
        level = 1;
        test = new TriviaReader(level, mode);
        triviaLeft = new ArrayList<>();
        for (int i = 0; i < test.getSize(); i++) {
            triviaLeft.add(i);
        }

        System.out.println("""
                Welcome to Halloween Trivia! For this trivia, type the correct answer below each question given.
                The trivia continues until you get an answer wrong, or you complete all the questions (of each level).
                If an answer requires a number, don't answer in word form except when writing numbers a million or above (ex. "10 million pumpkins").
                Good Luck, here is your first question ::
                """);

        boolean allCorrect = true;

        //These lines code are a loop that runs until the user gets a question wrong, or finishes all the questions.
        while (allCorrect) {
            int random = triviaLeft.get((int) (Math.random() * triviaLeft.size()));
            System.out.println(test.getQuestion(random));
            String answer = keyboard.nextLine();

            if (test.isAnswerCorrect(random, answer)) {
                System.out.println("Correct!");
                triviaLeft.remove((Integer) random);
            } else {
                System.out.println("Sorry, that's incorrect! The correct answer is: " + test.getAnswer(random));
                allCorrect = false;
            }

            if (triviaLeft.size() == 0) {
                level++;
                if (level > 3) {
                    System.out.println("""

                            Congratulations, you got all the questions right!
                            """);
                    break;
                } else {
                    test = new TriviaReader(level, mode);
                    for (int i = 0; i < test.getSize(); i++) {
                        triviaLeft.add(i);
                    }
                    System.out.println("""

                            Nice work, here are some harder questions ::
                            """);
                }
            }
        }
    }
}
