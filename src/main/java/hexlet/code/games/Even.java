package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even extends AbstractGame {

    static final int NUMBER_GAMES_FOR_WIN = 3;
    static final int BORDER_FOR_RANDOM_INT = 100;

    /**
     * Even game.
     */
    @Override
    public void play() {
        askName();
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (counter < NUMBER_GAMES_FOR_WIN) {
            int randomInt = new Random().nextInt(BORDER_FOR_RANDOM_INT);
            String correctAnswer = (randomInt % 2 == 0) ? "yes" : "no";
            System.out.print("Question: " + randomInt + "\nYour answer: ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase(correctAnswer)) {
                counter++;
                System.out.println("Correct!");
                if (counter == NUMBER_GAMES_FOR_WIN) {
                    System.out.println("Congratulations, " + getName() + "!");
                }
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.\nLet's try again, " + getName() + "!");
                break;
            }
        }
    }
}
