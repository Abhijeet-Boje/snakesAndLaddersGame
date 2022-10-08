package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;

import java.util.List;

public interface IDisplayService {

    void displayMessage(String message);

    void displayGameStart(List<Player> players);

    void displayWinner(Player player);

    void displayLadderClimbed(Player player, int oldPosition);

    void displaySnakeAte(Player player, int oldPosition);

    void displayCurrentBoardPosition(Player player);
}
