import java.io.*;
import java.util.*;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {

        //Vi henter vores fil med alle de ord som kan blive valgt
        Scanner sc = new Scanner(new File("src\\WordsForHangman.txt"));

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        List<String> HangmanWords = new ArrayList<>();
        List<Character> Guess = new ArrayList<>();

        String pickedWord = getHangmanWord(sc, random, HangmanWords);

        //Vi kører startgame metoden fra GameLogic klassen som starter spillet
        GameLogic.startGame(input, pickedWord, Guess);
    }

    //Metode til at få det ord vi skal gætte
    private static String getHangmanWord(Scanner sc, Random random, List<String> HangmanWords) {
        while (sc.hasNext()) {
            HangmanWords.add(sc.nextLine());
        }
        return HangmanWords.get(random.nextInt(HangmanWords.size()));
    }
}
