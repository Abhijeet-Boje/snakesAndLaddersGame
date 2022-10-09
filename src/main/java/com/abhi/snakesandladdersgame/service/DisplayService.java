package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.enums.Message;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService implements IDisplayService {

    @Override
    public void displayMessage(String message) {
        display(message);
    }

    @Override
    public void displayGameStart(List<Player> players) {
        display(Message.GAME_STARTED.getMassage());
        for (Player player: players) {
            display(Message.SHOW_PLAYER_NAME.getMassage(player.getName()));
        }
    }

    @Override
    public void displayWinner(Player player) {
        display(Message.PLAYER_WON_MESSAGE.getMassage(player.getName()));
    }

    @Override
    public void displayLadderClimbed(Player player, int oldPosition) {
        display(Message.LADDER_CLIMBED_MESSAGE.getMassage(player.getName(), String.valueOf(oldPosition), String.valueOf(player.getPosition())));
    }

    @Override
    public void displaySnakeAte(Player player, int oldPosition) {
        display(Message.SNAKE_ATE_MESSAGE.getMassage(player.getName(), String.valueOf(oldPosition), String.valueOf(player.getPosition())));

    }

    @Override
    public void displayCurrentBoardPosition(Player player) {
        display(Message.PLAYER_NEW_POSITION.getMassage(player.getName(), String.valueOf(player.getPosition())));
        display(Message.LINE_BREAK.getMassage());
    }

    @Override
    public void displayPlayerNotActive(Player player) {
        display(Message.PLAYER_NOT_ACTIVATED_MESSAGE.getMassage(player.getName()));
    }

    private void display(String message) {
        System.out.println(message);
    }
}
