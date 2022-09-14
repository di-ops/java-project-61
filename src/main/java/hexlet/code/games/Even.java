package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.function.Supplier;

public class Even implements Game {

    static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int BORDER_FOR_RANDOM_INT = 100;

    static final Supplier<Pair<String, String>> GENERATED_GAME_DATA = () -> {
        Random random = new Random();
        int randomInt = random.nextInt(BORDER_FOR_RANDOM_INT);
        String correctAnswer = isEven(randomInt) ? "yes" : "no";
        String question = String.valueOf(randomInt);
        return new MutablePair<>(correctAnswer, question);
    };

    private final Engine engine;

    public Even(Engine e) {
        this.engine = e;
    }

    /**
     * Even game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, GENERATED_GAME_DATA);
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
