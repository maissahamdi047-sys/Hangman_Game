package Hangman;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HangmanController implements Initializable {

    @FXML
    private ImageView hangmanImage;

    @FXML
    private Label wordLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField letterInput;

    @FXML
    private Button submitButton;

    @FXML
    private Button newGameButton;

    @FXML
    private FlowPane lettersPane;

    private HangmanGame game;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] words = {"PROGRAMMATION", "DEVELOPPEMENT", "INTERFACE", "HERITAGE", "POLYMORPHISME",
                "ABSTRACTION", "ENCAPSULATION", "ALGORITHME", "STRUCTURE"};
        game = new HangmanGameImpl(words);

        updateUI();

        submitButton.setOnAction(e -> guessLetter());

        newGameButton.setOnAction(e -> startNewGame());

        letterInput.setOnAction(e -> guessLetter());
    }

    private void guessLetter() {
        String input = letterInput.getText().toUpperCase();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            showAlert("Invalid entry", "Please enter only one letter.");
            letterInput.clear();
            return;
        }

        char letter = input.charAt(0);

        if (game.getGuessedLetters().contains(letter)) {
            showAlert("Letter already tried", "You have already tried this letter.");
            letterInput.clear();
            return;
        }

        boolean correct = game.guessLetter(letter);

        updateUI();

        if (game.isGameOver()) {
            if (game.isGameWon()) {
                messageLabel.setText("Congratulations! You won!");
            } else {
                messageLabel.setText("You lost! The word was:" + game.getCurrentWord());
            }
            submitButton.setDisable(true);
            letterInput.setDisable(true);
        }

        letterInput.clear();
    }

    private void startNewGame() {
        game.startNewGame();
        submitButton.setDisable(false);
        letterInput.setDisable(false);
        messageLabel.setText("");
        updateUI();
    }

    private void updateUI() {
        wordLabel.setText(game.getDisplayWord());

        int errors = game.getIncorrectGuessCount();
        Image image = new Image(getClass().getResourceAsStream("/images/" + (errors + 1) + ".png"));
        hangmanImage.setImage(image);

        lettersPane.getChildren().clear();
        for (Character c : game.getGuessedLetters()) {
            Label letterLabel = new Label(c.toString());
            letterLabel.getStyleClass().add("guessed-letter");
            lettersPane.getChildren().add(letterLabel);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}