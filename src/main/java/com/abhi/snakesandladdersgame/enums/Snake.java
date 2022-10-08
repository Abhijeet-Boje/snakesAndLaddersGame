package com.abhi.snakesandladdersgame.enums;

import java.util.Arrays;
import java.util.Optional;

import lombok.Getter;

@Getter
public enum Snake {
    S1(36, 19),
    S2(65, 35),
    S3(87, 32),
    S4(97, 21);

    private int head;
    private int tail;

    Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public static Optional<Snake> getByHeadPosition(int position) {
        return Arrays.stream(Snake.values()).filter(snake -> snake.getHead() == position).findFirst();
    }
}
