package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;

import java.util.List;

/**
 * Idea behind adding different methods is to let display service handle how these messages it want to show
 * with different styling and better user experience.
 * Generic method displayMessage is for displaying with standard styling.
 */
public interface IDisplayService {

    void displayMessage(String message);

    void displayGameStart(List<Player> players);

    void displayWinner(Player player);

    void displayLadderClimbed(Player player, int oldPosition);

    void displaySnakeAte(Player player, int oldPosition);

    void displayCurrentBoardPosition(Player player);

    void displayPlayerNotActive(Player player);
}
