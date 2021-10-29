import java.util.List;
import java.util.Scanner;

public class GameLogic {

    //Metode der returnere true hvis man har gættet rigtigt
    private static boolean getGuess(Scanner input, String pickedWord, List<Character> Guess) {
        System.out.println("Please enter a letter");
        String guessedLetter = input.nextLine();
        //Hvis man indtaster mere end 1 bogstav så skal man prøve igen
        while (guessedLetter.length() > 1) {
            System.out.println("Please enter a single letter");
            guessedLetter = input.nextLine();
        }
        Guess.add(guessedLetter.charAt(0));

        return pickedWord.contains(guessedLetter);
    }

    //Metode der printer den hængte mand hvis man gætter forkert.
    private static void printHangedman(int wrongCounter) {
        System.out.println(" ___________.._______\n" +
                "| .__________))______|");
        if (wrongCounter >= 1) {
            System.out.println("| | / /      ||\n" +
                    "| |/ /       ||");
        }
        if (wrongCounter >= 2) {
            System.out.println("| | /        ||.-''.\n" +
                    "| |/         |/  _  \\\n" +
                    "| |          ||  `/,|\n" +
                    "| |          (\\\\`_.'");
        }
        if (wrongCounter >= 3) {
            System.out.println("| |         .-`--'.\n" +
                    "| |        /Y . . Y\\\n" +
                    "| |       // |   | \\\\");
        }
        if (wrongCounter >= 4) {
            System.out.println("| |      //  | . |  \\\\\n" +
                    "| |     ')   |   |   (`");
        }
        if (wrongCounter >= 5) {
            System.out.println("| |          ||'||\n" +
                    "| |          || ||\n" +
                    "| |          || ||");
        }
        if (wrongCounter >= 6) {
            System.out.println("| |          || ||\n" +
                    "| |         / | | \\\n" +
                    "\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|\n" +
                    "|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\n" +
                    "| |        \\ \\        | |\n" +
                    ": :         \\ \\       : :\n" +
                    ". .          `'       . .");
        }
    }

    //Metode der tager vores ord og laver alle bogstaverne om til "-".
    //Og hvis man gætter rigtig erstatter "-" med det gættede bogstav.
    //retunere true hvis man har gættet hele ordet
    private static boolean printWord(String pickedWord, List<Character> Guess) {
        int checkIfCorrect = 0;
        for (int i = 0; i < pickedWord.length(); i++) {
            if (Guess.contains(pickedWord.charAt(i))) {
                System.out.print(pickedWord.charAt(i));
                checkIfCorrect++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (pickedWord.length() == checkIfCorrect);
    }

    //Metoden der kører spillet.
    static void startGame(Scanner input, String pickedWord, List<Character> Guess) {
        int wrongCounter = 0;

        while (true) {

            printHangedman(wrongCounter);

            //Hvis man har gættet forkert 6 gange taber man spillet
            if (wrongCounter >= 6) {
                System.out.println("You lost the game");
                break;
            }

            printWord(pickedWord, Guess);
            if (!getGuess(input, pickedWord, Guess)) {
                wrongCounter++;
            }
            if(printWord(pickedWord, Guess)) {
                System.out.println("Congratulations you win!");
                break;
            }

            System.out.println("Try and guess the word");
            System.out.println("If you dont know the word just press tab");
            String playerGuesses = input.nextLine();
            if(playerGuesses.equals(pickedWord)) {
                System.out.println("Congratulations you win!");
                break;
            } else {
                System.out.println("That was not correct.");
            }
        }
    }
}
