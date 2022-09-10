package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Even implements Game {

    static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int BORDER_FOR_RANDOM_INT = 100;
    static final Supplier<Pair<String, String>> EVEN = () -> {
        Scanner scanner = new Scanner(System.in);
        int randomInt = new Random().nextInt(BORDER_FOR_RANDOM_INT);
        String correctAnswer = (randomInt % 2 == 0) ? "yes" : "no";
        System.out.print("Question: " + randomInt + "\nYour answer: ");
        String answer = scanner.next();
        return new MutablePair<>(correctAnswer, answer);
    };

    private final Engine engine;

    public Even(Engine engine) {
        this.engine = engine;
    }

    /**
     * Even game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, EVEN);
    }
}
