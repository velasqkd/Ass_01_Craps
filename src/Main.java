import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out. You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("The point is " + point + ". Try to make the point again!");

                boolean pointMade = false;
                while (!pointMade) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + sum);

                    if (sum == point) {
                        System.out.println("You made the point! You win.");
                        pointMade = true;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        pointMade = true;
                    } else {
                        System.out.println("Trying for the point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = in.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}
