package com.abhi.snakesandladdersgame.service;

import static org.junit.jupiter.api.Assertions.*;

import com.abhi.snakesandladdersgame.entity.Player;

import org.junit.jupiter.api.Test;

class NextPositionVisitorTest {

    @Test
    public void testPositionWithInactivePlayerAndDiceNumber_5() {
        Player player = new Player("Abhijeet");
        NextPositionVisitor.visit(player, 5);
        //verify player not activated
        assertFalse(player.isActive());
        //verify player position at start
        assertEquals(0, player.getPosition());
    }

    @Test
    public void testPositionWithInactivePlayerAndDiceNumber_6() {
        Player player = new Player("Abhijeet");
        NextPositionVisitor.visit(player, 6);
        //verify player activated
        assertTrue(player.isActive());
        //verify player position moved
        assertEquals(6, player.getPosition());
    }

    @Test
    public void testPositionWithNewDiceNumberMovingAheadOf_100() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(97);
        NextPositionVisitor.visit(player, 5);
        //verify player not won
        assertFalse(player.isWonTheGame());
        //verify player position not changed
        assertEquals(97, player.getPosition());
    }

    @Test
    public void testNewPositionWithExistingAt_50_AndDiceNumber_3() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(50);
        NextPositionVisitor.visit(player, 3);
        //verify player not won
        assertFalse(player.isWonTheGame());
        //verify player position changed
        assertEquals(53, player.getPosition());
    }

    @Test
    public void testPositionWithNewDiceNumberMovingAt_100() {
        Player player = new Player("Abhijeet");
        player.markActive();
        player.setPosition(97);
        NextPositionVisitor.visit(player, 3);
        //verify player won
        assertTrue(player.isWonTheGame());
        //verify player position not changed
        assertEquals(100, player.getPosition());
    }

}