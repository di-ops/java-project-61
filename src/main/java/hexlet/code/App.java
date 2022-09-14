package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

import static hexlet.code.Cli.askName;

public class App {

    static final Engine ENGINE = new Engine();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(
                    """
                            Please enter the game number and press Enter.
                            1 - Greet
                            2 - Even
                            3 - Calc
                            4 - GCD
                            5 - Progression
                            6 - Prime
                            0 - Exit
                            Your choice:\040""");
            String input = scanner.next();
            switch (input) {
                case "0" -> System.exit(0);
                case "1" -> askName();
                case "2" -> new Even(ENGINE).play();
                case "3" -> new Calc(ENGINE).play();
                case "4" -> new GCD(ENGINE).play();
                case "5" -> new Progression(ENGINE).play();
                case "6" -> new Prime(ENGINE).play();
                default -> System.out.println("Select correct item");
            }
        }
    }
}
