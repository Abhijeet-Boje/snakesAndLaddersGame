package com.abhi.snakesandladdersgame.exceptions;

public class SnakeNotFoundException extends Exception {

    public SnakeNotFoundException(int position) {
        super("Snake not found at position: " + position);
    }
}
