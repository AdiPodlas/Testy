package Testw.Test2.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class GuessingGame {
    private int secretNumber;
    private int guessCount;

    private boolean gameStarted = false;

    @Autowired
    private Logger logger;

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startNewGame(int lowerLimit, int upperLimit) {
        logger.log("Game is starting ");
        Random random = new Random();
        secretNumber = random.nextInt(upperLimit - lowerLimit);
        guessCount = 0;
        gameStarted = true;
    }

    public String makeGuess(int guess) {
        guessCount++;
        if (guess < secretNumber) {
            return "za mało";
        } else if (guess > secretNumber) {
            return "za dużo";
        } else {
            return "poprawna";
        }
    }

    public int getGuessCount() {
        return guessCount;
    }
}