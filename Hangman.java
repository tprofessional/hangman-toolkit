import java.util.Scanner;
import java.awt.Toolkit;

public class Hangman {
    public static String createBlanks(String word) {
        String blanks = word;
        String sub;
        for (int i = 0; i < word.length() - 1; i++) {
            sub = word.substring(i, i + 1);
            int randInt = (int) (Math.random() * 101 + 0);
            if (randInt < 50) {
                blanks = blanks.replace(sub, "-");
            }
        }
        return blanks;
    }

    public static int countVowel(String word) {
        int vowel = 0;
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o")
                    || letter.equals("u")) {
                vowel++;
            }
        }
        return vowel;
    }

    public static boolean ifFound(String word, String guess) {
        boolean found = false;
        for (int k = 0; k <= word.length() - guess.length(); k++) {
            String portion = word.substring(k, k + guess.length());
            if (guess.equals(portion)) {
                found = true;
            }
        }
        return found;
    }

    public static String reversed(String word) {
        String reversed = "";
        for (int j = 0; j < word.length(); j++) {
            String single = word.substring(j, j + 1);
            reversed = single + reversed;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = "computer";
        boolean found = false;

        System.out.println(createBlanks(word) + "\n");

        System.out.println("Hint: the number of vowels in the word is " + countVowel(word));

        while (!found) {
            System.out.print("Enter a guess: ");
            String guess = sc.nextLine();

            if (ifFound(word, guess)) {
                if (guess.equals(word)) {
                    System.out.println("Congrats! You got the word.");
                    found = true;
                } else {
                    System.out.println("Your guess exists.");
                }
            } else {
                System.out.println("We didn't find the guess.");
                //beep
            }
            System.out.print("\n");
        }

        System.out.println("Reversed word: " + reversed(word));
    }
}