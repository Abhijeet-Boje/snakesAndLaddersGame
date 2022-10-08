package com.abhi.snakesandladdersgame.exceptions;

public class LadderNotFoundException extends Exception {

    public LadderNotFoundException(int position) {
        super("Ladder not found at position: " + position);
    }
}
