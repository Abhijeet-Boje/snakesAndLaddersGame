package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;

class NextPositionVisitor {

    static void visit(Player player, int diceNumber) {
        if (!player.isActive()) {
            handleInactivePlayer(player, diceNumber);
        }
        else {
            int newPosition = player.getPosition() + diceNumber;
            int nextPosition = newPosition <= 100 ? newPosition : player.getPosition();
            player.setPosition(nextPosition);
        }
    }

    private static void handleInactivePlayer(Player player, int diceNumber) {
        if (diceNumber == 6) {
            player.setPosition(diceNumber);
        }
    }
}
