package hexlet.code.games;

import java.util.Scanner;

public abstract class AbstractGame {
    private String name;
    public abstract void play();
    public final void askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
