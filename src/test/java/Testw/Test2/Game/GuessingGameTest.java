package Testw.Test2.Game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)


class GuessingGameTest {
    @Mock
    Logger logger;
@InjectMocks
GuessingGame game;

    @Test
    void isNotStartedByDefult() {

        boolean testing = game.isGameStarted();
        assertFalse(testing);

    }

    @Test
    void isStartedAfterStart(){
        game.startNewGame(0,10);
        boolean testing = game.isGameStarted();
        assertTrue(testing);
        System.out.println("ASDFGHJK");
    }
}