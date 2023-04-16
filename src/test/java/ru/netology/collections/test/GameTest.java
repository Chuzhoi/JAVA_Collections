package ru.netology.collections.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.collections.Game;
import ru.netology.collections.NotRegisteredException;
import ru.netology.collections.Player;

public class GameTest {

    Player player1 = new Player(1, "Саша", 10);
    Player player2 = new Player(2, "Вася", 20);
    Player player3 = new Player(3, "Петя", 20);

    Game game = new Game();


    @Test
    public void testWhenFirstPlayerWinn() {

        game.register(player1);
        game.register(player2);
        int actual = game.round("Вася", "Саша");
        int expected = 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenSecondPlayerWinn() {

        game.register(player1);
        game.register(player3);
        int actual = game.round("Саша", "Петя");
        int expected = 2;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenDraw() {

        game.register(player2);
        game.register(player3);
        int actual = game.round("Вася", "Петя");
        int expected = 0;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testWhenFirstPlayerIsNotRegistered() {

        //game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Вася");
        });

    }

    @Test
    public void testWhenSecondPlayerIsNotRegistered() {

        game.register(player1);
        //game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Вася");
        });

    }

    @Test
    public void testWhenTwoPlayersIsNotRegistered() {

        //game.register(player1);
        //game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Вася");
        });

    }

}
