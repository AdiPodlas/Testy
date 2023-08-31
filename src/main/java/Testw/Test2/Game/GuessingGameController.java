package Testw.Test2.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuessingGameController {
    @Autowired
    private GuessingGame game;

    @Autowired
    private ApplicationContext context;

    @PostMapping("/start")
    public String startGame(@RequestParam(value = "lowerLimit", required = false, defaultValue = "0") int lowerLimit,
                            @RequestParam(value = "upperLimit", required = false, defaultValue = "100") int upperLimit) {
        game.startNewGame(lowerLimit, upperLimit);
        return "Nowa gra rozpoczęta. Odgadnij liczbę z zakresu " + lowerLimit + " - " + upperLimit;
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam("guess") int guess) {
        if (!game.isGameStarted()) {
            return "Gra nie została rozpoczęta. Wywołaj /start, aby zacząć nową grę.";
       }

        String result = game.makeGuess(guess);
        if (result.equals("poprawna")) {
            int attempts = game.getGuessCount();
            game = context.getBean(GuessingGame.class);
            return "Gratulacje! Liczbę " + guess + " udało Ci się odgadnąć po " + attempts + " próbach.";
        } else {
            return "Podana wartość jest " + result + ".";
        }
    }

}