package hibernate;

import java.util.Scanner;

public class UserInteraction {

    private Scanner scanner = new Scanner(System.in);

    public String stringChoice(){
        return scanner.nextLine();
    }

    public int intChoice(){
        String choice = scanner.nextLine();
        int intChoice = 1000;
        try {
            intChoice = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return intChoice;
    }
}
