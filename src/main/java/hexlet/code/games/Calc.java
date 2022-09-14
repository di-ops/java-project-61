package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.function.Supplier;

public class Calc implements Game {

    static final String DESCRIPTION = "What is the result of the expression?";
    static final int BORDER_FOR_RANDOM_INT = 20;
    static final char[] MATH_SIGNS = {'+', '-', '*'};

    static final Supplier<Pair<String, String>> GENERATED_GAME_DATA = () -> {
        Random random = new Random();
        int val1 = random.nextInt(BORDER_FOR_RANDOM_INT);
        int val2 = random.nextInt(BORDER_FOR_RANDOM_INT);
        char mathSign = MATH_SIGNS[random.nextInt(MATH_SIGNS.length)];
        int correctAnswer = calculate(val1, val2, mathSign);
        String question = val1 + " " + mathSign + " " + val2;
        return new MutablePair<>(String.valueOf(correctAnswer), question);
    };

    private final Engine engine;

    public Calc(Engine e) {
        this.engine = e;
    }

    /**
     * Calc game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, GENERATED_GAME_DATA);
    }

    private static int calculate(int val1, int val2, char operation) {
        return switch (operation) {
            case '+' -> val1 + val2;
            case '-' -> val1 - val2;
            case '*' -> val1 * val2;
            default -> -1; // Строчка для компилятора. Невозможный сценарий, см. строку 20
        };
    }
}
