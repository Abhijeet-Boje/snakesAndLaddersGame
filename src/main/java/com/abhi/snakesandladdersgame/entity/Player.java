package com.abhi.snakesandladdersgame.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private String name;
    @Setter
    private int position;
    private boolean isActive;
    private boolean wonTheGame;

    public Player(String name) {
        this.name = name;
        position = 0;
        isActive = false;
        wonTheGame = false;
    }

    public void markActive() {
        this.isActive = true;
    }

    public void markWon() {
        this.position = 100;
        this.wonTheGame = true;
    }
}
