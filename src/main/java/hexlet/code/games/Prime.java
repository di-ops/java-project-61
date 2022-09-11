package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Prime implements Game {

    static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int BORDER_FOR_RANDOM_INT = 100;
    static final Supplier<Pair<String, String>> PRIME = () -> {
        Scanner scanner = new Scanner(System.in);
        int randomInt = new Random().nextInt(BORDER_FOR_RANDOM_INT);
        String correctAnswer = isPrime(randomInt) ? "yes" : "no";
        System.out.print("Question: " + randomInt + "\nYour answer: ");
        String answer = scanner.next();
        return new MutablePair<>(correctAnswer, answer);
    };

    private final Engine engine;

    public Prime(Engine e) {
        this.engine = e;
    }

    private static boolean isPrime(int randomInt) {
        for (int i = randomInt - 1; i > 1; i--) {
            if (randomInt % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prime game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, PRIME);
    }
}
