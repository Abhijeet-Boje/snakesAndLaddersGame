package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.LadderNotFoundException;
import com.abhi.snakesandladdersgame.exceptions.SnakeNotFoundException;

public interface IPlayService {

    void play(Player player, int diceNumber);
}
