package Hangman;

import java.util.Set;

public interface HangmanGame {


    void startNewGame();


    boolean guessLetter(char letter);


    String getDisplayWord();


    String getCurrentWord();


    Set<Character> getGuessedLetters();


    int getIncorrectGuessCount();


    boolean isGameOver();


    boolean isGameWon();
}
