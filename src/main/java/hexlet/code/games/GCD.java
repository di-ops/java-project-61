package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.function.Supplier;

public class GCD implements Game {

    static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    static final int BORDER_FOR_RANDOM_INT_1 = 100;
    static final int BORDER_FOR_RANDOM_INT_2 = 20;
    static final Supplier<Pair<String, String>> GENERATED_GAME_DATA = () -> {
        Random random = new Random();
        int val1 = random.nextInt(BORDER_FOR_RANDOM_INT_1);
        int val2 = random.nextInt(BORDER_FOR_RANDOM_INT_2);
        String correctAnswer = String.valueOf(calculateGCD(val1, val2));
        String question =  val1 + " " + val2;
        return new MutablePair<>(correctAnswer, question);
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
        engine.start(DESCRIPTION, GENERATED_GAME_DATA);
    }
}
