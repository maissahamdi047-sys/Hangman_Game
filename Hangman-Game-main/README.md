# Hangman Game

A JavaFX Hangman game built with Maven.

## Project Overview

This project is a simple Hangman game using JavaFX for the user interface.
The game loads words, draws the hangman image based on wrong guesses, and
tracks letters guessed by the player.

## Requirements

- Java JDK 17 or newer installed
- Maven or the included Maven wrapper (`mvnw.cmd` / `mvnw`)
- Internet access to download Maven dependencies the first time

## Project Structure

- `pom.xml` - Maven project configuration
- `src/main/java/Hangman` - Java source code
- `src/main/resources/Hangman` - FXML layout and CSS styling
- `src/main/resources/images` - hangman images used by the game

## How to Run

### From a terminal

Open a terminal in the project folder and run:

```powershell
.\mvnw.cmd clean javafx:run
```

If you have Maven installed globally, you can also use:

```powershell
mvn clean javafx:run
```

### In VS Code

1. Open the project folder in VS Code.
2. Install Java extensions if needed.
3. Open `src/main/java/Hangman/Main.java`.
4. Use the built-in Run button or run the command above in the integrated terminal.

## Notes

- The main application class is `Hangman.Main`.
- The main UI layout is defined in `src/main/resources/Hangman/hangman-view.fxml`.
- The CSS file is `src/main/resources/Hangman/Style.css`.
- Make sure `JAVA_HOME` is set to a valid JDK root folder (not the `bin` folder).

## Common Commands

```powershell
# Clean and run the game
.\mvnw.cmd clean javafx:run

# Build the project only
.\mvnw.cmd clean package
```

## Gameplay

- Enter a single letter in the input field.
- Click `New Try` to submit your guess.
- Click `New Game` to restart the game.
- The game displays used letters and updates the hangman image for wrong guesses.

## License

Propriétaire - Tous droits réservés
