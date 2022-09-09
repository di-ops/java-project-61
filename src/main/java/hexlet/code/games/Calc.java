package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc extends AbstractGame {

    static final int NUMBER_GAMES_FOR_WIN = 3;
    static final int BORDER_FOR_RANDOM_INT = 20;
    static final char[] MATH_SIGNS = {'+', '-', '*'};

    /**
     * Even game.
     */
    @Override
    public void play() {
        greet();
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        while (counter < NUMBER_GAMES_FOR_WIN) {
            int val1 = new Random().nextInt(BORDER_FOR_RANDOM_INT);
            int val2 = new Random().nextInt(BORDER_FOR_RANDOM_INT);
            char mathSign = MATH_SIGNS[new Random().nextInt(MATH_SIGNS.length)];
            int correctAnswer = calculate(val1, val2, mathSign);
            System.out.print("Question: " + val1 + " " + mathSign + " " + val2 + "\nYour answer: ");
            int answer = scanner.nextInt();
            if (answer == correctAnswer) {
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

    private int calculate(int val1, int val2, char operation) {
        return switch (operation) {
            case '+' -> val1 + val2;
            case '-' -> val1 - val2;
            case '*' -> val1 * val2;
            default -> -1;
        };
    }
}
