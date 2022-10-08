package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService implements IDisplayService {

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayGameStart(List<Player> players) {
        System.out.println("###### Game started #######");
        System.out.println();
        for (Player player: players) {
            System.out.println("Player name: " + player.getName());
        }
    }

    @Override
    public void displayWinner(Player player) {
        System.out.println("Yay!!" + player.getName() + " you won!!");
    }

    @Override
    public void displayLadderClimbed(Player player, int oldPosition) {
        System.out.println("Awesome!! " + player.getName() + " you climbed from " + oldPosition + " to " + player.getPosition());
    }

    @Override
    public void displaySnakeAte(Player player, int oldPosition) {
        System.out.println("Ohhh! " + player.getName() + " snake ate you and you fall from " + oldPosition + " to " + player.getPosition());

    }

    @Override
    public void displayCurrentBoardPosition(Player player) {
        System.out.println(player.getName() + " your new position is: " + player.getPosition());
        displayLineBreak();
    }

    private void displayLineBreak() {
        System.out.println("=====================================================================");
    }
}
