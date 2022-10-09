package com.abhi.snakesandladdersgame.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private String name;
    @Setter
    private int position;

    public Player(String name) {
        this.name = name;
        position = 0;
    }

    public boolean isActive() {
        return position != 0;
    }

    public boolean isWonTheGame() {
        return position == 100;
    }
}
