package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.LadderNotFoundException;

public interface ILadderService {

    boolean hasLadderAtPosition(int position);

    void climb(Player player) throws LadderNotFoundException;
}
