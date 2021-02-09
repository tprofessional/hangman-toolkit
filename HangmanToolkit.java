//Authors: Julia Zhao, Trisha Moorkoth
//Version: 2.0

//to get user input
import java.util.Scanner;
//for toolkit classes and methods
import java.awt.*;
//for event handlers
import java.awt.event.*;

public class HangmanToolkit{
    /*
    * static String method createBlanks
    * parameter: String word
    * randomly generates blanks ("_") throughout word
    * returns String blanks
    */  
    public static String createBlanks(String word) {
        String blanks = word;
        String sub;
        for (int i = 0; i < word.length() - 1; i++) {
            sub = word.substring(i, i + 1);
            //random integer in range 0-100 is generated
            int randInt = (int) (Math.random() * 101 + 0);
            //50% chance each index will be replaced with a blank
            if (randInt < 50) {
                blanks = blanks.replace(sub, "-");
            }
        }
        return blanks;
    }

    /*
    * static int method countVowel
    * parameter: String word
    * counts the number of vowels in word
    * returns int vowel
    */
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

    /*
    * static boolean method ifFound
    * parameters: String word, String guess
    * evaluates user's guess and determines whether it is correct
    * returns boolean found
    */
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

    /*
    * static String method reversed 
    * parameter: String word
    * reverses the word
    * returns String reversed
    */
    public static String reversed(String word) {
        String reversed = "";
        for (int j = 0; j < word.length(); j++) {
            String single = word.substring(j, j + 1);
            reversed = single + reversed;
        }
        return reversed;
    }

    /*
    * static void method frame
    * parameters: Frame f, Color c, String w
    * sets up the frame and the button
    */
    public static void frame(Frame f, Color c, String w) {
        //create a Button object
        Button b = new Button("Reverse the word!");
        //set the size of the button object
        b.setBounds(50, 100, 150, 30);
        //add the button to the frame object
        f.add(b);
        //set the frame size to 600 x 600 px
        f.setSize(600, 600);
        //no layout (test whether we need this)
        f.setLayout(null);
        //set background to color c
        f.setBackground(c);
        //show the frame
        f.setVisible(true);
        //when the button is clicked, beep and print the reversed word
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Reversed word: " + reversed(w));
            }
        });
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = "computer";
        boolean found = false;
        //create color objects for each frame background
        Color red = new Color(255, 0, 0);
        Color yellow = new Color(255, 255, 0);
        Color green = new Color(0, 255, 0);
        //create frame object
        Frame f = new Frame("");

        System.out.println(createBlanks(word) + "\n");

        System.out.println("Hint: the number of vowels in the word is " + countVowel(word));

        while (!found) {
            System.out.print("Enter a guess: ");
            String guess = sc.nextLine();

            if (ifFound(word, guess)) {
                if (guess.equals(word)) {
                    //green frame for correct word guess (entirely correct)
                    System.out.println("Congrats! You got the word.");
                    found = true;
                    frame(f, green, word);
                } else {
                    //yellow frame for correct substring guess (partially correct)
                    System.out.println("Your guess exists.");
                    frame(f, yellow, word);
                }
            } else {
                //red frame for incorrect guess
                System.out.println("We didn't find the guess.");
                frame(f, red, word);
            }
            System.out.print("\n");
        }
    }
}