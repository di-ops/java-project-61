package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Calc implements Game {

    static final String DESCRIPTION = "What is the result of the expression?";
    static final int BORDER_FOR_RANDOM_INT = 20;
    static final char[] MATH_SIGNS = {'+', '-', '*'};

    static final Supplier<Pair<String, String>> CALC = () -> {
        Scanner scanner = new Scanner(System.in);
        int val1 = new Random().nextInt(BORDER_FOR_RANDOM_INT);
        int val2 = new Random().nextInt(BORDER_FOR_RANDOM_INT);
        char mathSign = MATH_SIGNS[new Random().nextInt(MATH_SIGNS.length)];
        int correctAnswer = calculate(val1, val2, mathSign);
        System.out.print("Question: " + val1 + " " + mathSign + " " + val2 + "\nYour answer: ");
        String answer = scanner.next();
        return new MutablePair<>(String.valueOf(correctAnswer), answer);
    };

    private final Engine engine;

    public Calc(Engine engine) {
        this.engine = engine;
    }

    /**
     * Calc game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, CALC);
    }

    private static int calculate(int val1, int val2, char operation) {
        return switch (operation) {
            case '+' -> val1 + val2;
            case '-' -> val1 - val2;
            case '*' -> val1 * val2;
            default -> -1;
        };
    }
}
