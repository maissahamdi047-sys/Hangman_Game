package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class AbstractHangmanGame implements HangmanGame {

    protected static final int MAX_INCORRECT_GUESSES = 6;

    protected String currentWord;
    protected Set<Character> guessedLetters;
    protected int incorrectGuesses;
    protected String[] wordList;
    protected Random random;

    public AbstractHangmanGame(String[] wordList) {
        this.wordList = wordList;
        this.random = new Random();
        this.guessedLetters = new HashSet<>();
        startNewGame();
    }

    @Override
    public void startNewGame() {
        currentWord = selectRandomWord();
        guessedLetters.clear();
        incorrectGuesses = 0;
    }

    @Override
    public String getDisplayWord() {
        StringBuilder display = new StringBuilder();

        for (char c : currentWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c);
            } else {
                display.append("_");
            }
            display.append(" ");
        }

        return display.toString();
    }

    @Override
    public String getCurrentWord() {
        return currentWord;
    }

    @Override
    public Set<Character> getGuessedLetters() {
        return new HashSet<>(guessedLetters);
    }

    @Override
    public int getIncorrectGuessCount() {
        return incorrectGuesses;
    }

    @Override
    public boolean isGameOver() {
        return isGameWon() || incorrectGuesses >= MAX_INCORRECT_GUESSES;
    }

    @Override
    public boolean isGameWon() {
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    protected abstract String selectRandomWord();
}