package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Progression implements Game {

    static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    static final int BORDER_FOR_RANDOM_START = 30;
    static final int BORDER_FOR_RANDOM_STEP = 10;
    static final int VALUES_IN_PROGRESSION = 10;
    static final Supplier<Pair<String, String>> GCD = () -> {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String correctAnswer = "";
        int startValue = random.nextInt(BORDER_FOR_RANDOM_START);
        int randomIndex = random.nextInt(VALUES_IN_PROGRESSION);
        int step = random.nextInt(BORDER_FOR_RANDOM_STEP);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < VALUES_IN_PROGRESSION; i++) {
            int temp = startValue + (i * step);
            if (i == randomIndex) {
                correctAnswer = String.valueOf(temp);
                stringBuilder.append(" .. ");
            } else {
                stringBuilder.append(temp).append(" ");
            }
        }
        System.out.print("Question: " + stringBuilder + "\nYour answer: ");
        String answer = scanner.next();
        return new MutablePair<>(correctAnswer, answer);
    };

    private final Engine engine;

    public Progression(Engine engine) {
        this.engine = engine;
    }

    /**
     * Progression game.
     */
    @Override
    public void play() {
        engine.start(DESCRIPTION, GCD);
    }
}
