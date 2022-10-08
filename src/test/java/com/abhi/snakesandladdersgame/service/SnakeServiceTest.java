package com.abhi.snakesandladdersgame.service;

import static org.junit.jupiter.api.Assertions.*;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.SnakeNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.SneakyThrows;

@SpringBootTest
class SnakeServiceTest {

    @Autowired
    private ISnakeService snakeService;

    @Test
    public void testEatActionAtStart() {
        Player player = new Player("Abhijeet");

        //verify no snake at start
        assertThrows(SnakeNotFoundException.class, ()-> snakeService.eat(player));
        //verify position not changed
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testEatActionAfterWinning() {
        Player player = new Player("Abhijeet");
        player.markWon();
        //verify no snake at start
        assertThrows(SnakeNotFoundException.class, ()-> snakeService.eat(player));
        //verify position not changed
        assertEquals(100, player.getPosition());
    }

    @Test
    @SneakyThrows
    public void testEatActionBySnakeS2() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(65);

        snakeService.eat(player);

        //verify new position
        assertEquals(35, player.getPosition());
    }

    @Test
    @SneakyThrows
    public void testEatActionBySnakeS4() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(97);

        snakeService.eat(player);

        //verify new position
        assertEquals(21, player.getPosition());
    }

    @Test
    public void testEatActionFromPositionWithoutSnake() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(50);
        //verify no snake at start
        assertThrows(SnakeNotFoundException.class, ()-> snakeService.eat(player));
        //verify position not changed
        assertEquals(50, player.getPosition());
    }

}