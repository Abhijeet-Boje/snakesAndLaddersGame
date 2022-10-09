package com.abhi.snakesandladdersgame.service;

import static org.junit.jupiter.api.Assertions.*;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.LadderNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.SneakyThrows;

@SpringBootTest
class LadderServiceTest {

    @Autowired
    private ILadderService ladderService;

    @Test
    public void testClimbLadderFromStart() {
        Player player = new Player("Abhijeet");

        assertThrows(LadderNotFoundException.class, () -> ladderService.climb(player));
        //check no change in position
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testClimbLadderAfterWin() {
        Player player = new Player("Abhijeet");
        player.setPosition(100);

        assertThrows(LadderNotFoundException.class, () -> ladderService.climb(player));
        //check no change in position
        assertEquals(100, player.getPosition());
    }


    @Test
    @SneakyThrows
    public void testClimbLadder_L2() {
        Player player = new Player("Abhijeet");
        player.setPosition(37);

        ladderService.climb(player);
        //verify player new position
        assertEquals(85, player.getPosition());
    }

    @Test
    @SneakyThrows
    public void testClimbLadder_L4() {
        Player player = new Player("Abhijeet");
        player.setPosition(65);

        ladderService.climb(player);
        //verify player new position
        assertEquals(99, player.getPosition());
    }

    @Test
    public void testClimbLadder_PlayerNotAtLadderPosition() {
        Player player = new Player("Abhijeet");
        player.setPosition(50);
        assertThrows(LadderNotFoundException.class, () -> ladderService.climb(player)) ;
    }

}