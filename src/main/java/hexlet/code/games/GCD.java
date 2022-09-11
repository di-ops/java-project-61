package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class GCD implements Game {

    static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    static final int BORDER_FOR_RANDOM_INT_1 = 100;
    static final int BORDER_FOR_RANDOM_INT_2 = 20;
    static final Supplier<Pair<String, String>> GCD = () -> {
        Scanner scanner = new Scanner(System.in);
        int val1 = new Random().nextInt(BORDER_FOR_RANDOM_INT_1);
        int val2 = new Random().nextInt(BORDER_FOR_RANDOM_INT_2);
        int correctAnswer = calculateGCD(val1, val2);
        System.out.print("Question: " + val1 + " " + val2 + "\nYour answer: ");
        String answer = scanner.next();
        return new MutablePair<>(String.valueOf(correctAnswer), answer);
    };

    private static int calculateGCD(int val1, int val2) {
        while (val2 != 0) {
            int tmp = val1 % val2;
            val1 = val2;
            val2 = tmp;
        }
        return val1;
    }

    private final Engine engine;

    public GCD(Engine e) {
        this.engine = e;
    }

    /**
     * GCD game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, GCD);
    }
}
