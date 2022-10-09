package com.abhi.snakesandladdersgame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.abhi.snakesandladdersgame.entity.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PlayServiceTest {

    public static final String P1 = "P1";
    private IPlayService playService;
    @Autowired
    private ISnakeService snakeService;
    @Autowired
    private ILadderService ladderService;
    @Autowired
    private IDisplayService displayService;

    @BeforeEach
    public void setUp() {
        playService = new PlayService(snakeService, ladderService, displayService);
    }

    @Test
    public void testPlayerGotLadderAndClimbed() {
        //34 + 3 -> 37 -> 85
        Player player = new Player(P1);
        int existingPosition = 34;
        player.setPosition(existingPosition);

        playService.play(player, 3);

        //verify player got ladder
        assertTrue(player.getPosition() - existingPosition > 3);

        //verify new position
        assertEquals(85, player.getPosition());
    }

    @Test
    public void testPlayerMovedAheadWithoutLadder() {
        //43 + 5 => 48
        Player player = new Player(P1);
        int existingPosition = 43;
        player.setPosition(43);

        playService.play(player, 5);

        //verify player didn't get ladder or snake
        assertEquals(5, player.getPosition() - existingPosition);

        //verify new position
        assertEquals(48, player.getPosition());
    }

    @Test
    public void testPlayerMovedAheadButAteBySnake() {
        //93 + 4 -> 97 => 21
        Player player = new Player(P1);
        int existingPosition = 93;
        player.setPosition(existingPosition);

        playService.play(player, 4);

        //verify player got snake
        assertTrue(player.getPosition() < (existingPosition + 4));

        //verify player new position
        assertEquals(21, player.getPosition());
    }

    @Test
    public void testPlayerWonTheGame() {
        //96 + 4 => 100

        Player player = new Player(P1);
        int existingPosition = 96;
        player.setPosition(existingPosition);

        playService.play(player, 4);

        //verify player won
        assertTrue(player.isWonTheGame());
        assertEquals(100, player.getPosition());
    }

    @Test
    public void testActivePlayerDidNotMove() {
        //98 + 4 -> (101 > 100) => 98
        Player player = new Player(P1);
        int existingPosition = 98;
        player.setPosition(existingPosition);

        playService.play(player, 4);

        //verify player didn't move
        assertEquals(98, player.getPosition());
    }
}