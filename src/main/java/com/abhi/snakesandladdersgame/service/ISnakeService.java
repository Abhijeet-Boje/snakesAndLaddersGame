package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.SnakeNotFoundException;

public interface ISnakeService {

    boolean hasSnakeAtPosition(int position);

    void eat(Player player) throws SnakeNotFoundException;
}
