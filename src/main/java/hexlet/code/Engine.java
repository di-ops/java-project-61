package hexlet.code;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Scanner;
import java.util.function.Supplier;

public class Engine {

    static final int ROUNDS = 3;
    private String name;

    /**
     *
     * @param description describe rules of game
     * @param gameData contains correct answer and question
     */
    public void start(String description, Supplier<Pair<String, String>> gameData) {
        greet();
        int counter = 0;
        System.out.println(description);
        while (counter < ROUNDS) {
            Pair<String, String> logic = gameData.get();
            String correctAnswer = logic.getLeft();
            String question = logic.getRight();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Question: " + question + "\nYour answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                counter++;
                System.out.println("Correct!");
                if (counter == ROUNDS) {
                    System.out.println("Congratulations, " + name + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.\nLet's try again, " + name + "!");
                break;
            }
        }
        System.exit(0);
    }

    private void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}
