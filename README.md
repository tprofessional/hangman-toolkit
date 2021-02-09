# hangman-toolkit
Contributors: Julia Zhao, Karen Zhao, Trisha Moorkoth

AP CSA Unit 2 Project - Research Topics in CS

We researched and used java.awt.Toolkit, incorporating it into a game involving AP Classroom Topic 4 lessons on developing algorithms using strings. Our project was based around a basic hangman game program, which we later developed mainly by using a new method, frame(f, c, w) from the toolkit. Some methods we used from the toolkit package were beep(), setBounds(), and setLayout(). We also used classes from the awt library such as Frame, Color, and Button.

Our program begins by providing a given word that has a few random letters replaced with blanks, and a hint that tells the user how many vowels are supposed to be in the given word. The user input initializes the frame, which then prompts the user to enter a guess for the word. There are three different outcomes depending on the user’s guess. If the guess is wrong, the program will return a message, “We didn’t find the guess” and the frame will turn red. If the user guesses a correct substring, the program will return the message, “Your guess exists”, and the frame will turn yellow, signifying the user’s guess is somewhat correct. If the user guesses the entire word correctly, the program will return the message, “Congrats! You got the word”, and the frame will turn green.

An additional feature is the button located in the middle of the frame, labelled “Reverse the word!”. The user can press this button to get the program to return the original given word with the letters in reversed order. At the same time, a beep sound will be played due to the calling of the beep() method from the toolkit package.

Here is a link to the Java toolkit we used: https://docs.oracle.com/javase/7/docs/api/java/awt/Toolkit.html
