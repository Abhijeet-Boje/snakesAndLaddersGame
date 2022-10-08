package com.abhi.snakesandladdersgame.enums;

import java.util.Arrays;
import java.util.Optional;

import lombok.Getter;

@Getter
public enum Ladder {
    L1(7, 33),
    L2(37, 85),
    L3(51, 72),
    L4(65, 99);

    private int foot;
    private int top;

    Ladder(int foot, int top) {
        this.foot = foot;
        this.top = top;
    }

    public static Optional<Ladder> getByFootPosition(int position) {
        return Arrays.stream(Ladder.values()).filter(ladder -> ladder.getFoot() == position).findFirst();
    }
}
