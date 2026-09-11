package Hangman;

public class HangmanGameImpl extends AbstractHangmanGame {

    public HangmanGameImpl(String[] wordList) {
        super(wordList);
    }

    @Override
    public boolean guessLetter(char letter) {
        letter = Character.toUpperCase(letter);

        guessedLetters.add(letter);

        boolean letterFound = currentWord.indexOf(letter) >= 0;

        if (!letterFound) {
            incorrectGuesses++;
        }

        return letterFound;
    }

    @Override
    protected String selectRandomWord() {
        int index = random.nextInt(wordList.length);
        return wordList[index].toUpperCase();
    }
}