package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

import static hexlet.code.Cli.askName;

public class App {

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    """
                            Please enter the game number and press Enter.
                            1 - Greet
                            2 - Even
                            0 - Exit""");
            int input = scanner.nextInt();
            switch (input) {
                case 0 -> System.exit(0);
                case 1 -> askName();
                case 2 -> new Even().play();
                default -> System.out.println("Select correct item");
            }
        }
    }
}
