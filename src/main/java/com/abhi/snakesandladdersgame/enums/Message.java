package com.abhi.snakesandladdersgame.enums;

import org.apache.commons.lang3.StringUtils;

public enum Message {
    LETS_START_THE_GAME("Let's start the game!!"),
    GAME_STARTED("###### Game started #######"),
    PLAYER_NAME_INPUT("Player name: "),
    SHOW_PLAYER_NAME("Player name: {0}"),
    DICE_NUMBER_INPUT("Enter new dice number: "),
    REQUEST_USER_FOR_CORRECT_DICE_INPUT("Please enter number b/w  1 to 6."),
    PLAYER_NOT_ACTIVATED_MESSAGE("{0} you are not active yet! You need dice number 6 to get Started!!"),
    PLAYER_WON_MESSAGE("Yay!! {0} you won!!"),
    LADDER_CLIMBED_MESSAGE("Awesome!! {0} you climbed from {1} to {2}!!"),
    SNAKE_ATE_MESSAGE("Ohhh! {0} snake ate you and you fall from {1} to {2}!"),
    PLAYER_NEW_POSITION("{0} your new position is: {1}!"),
    LINE_BREAK("=====================================================================");



    private String massage;

    Message(String massage) {
        this.massage = massage;
    }

    public String getMassage(String ...args) {
        if(args.length == 0) {
            return this.massage;
        }
        String[] searchList = new String[args.length];
        for (int i=0; i<args.length; i++) {
            searchList[i] = "{" + i + "}";
        }
        return StringUtils.replaceEachRepeatedly(this.massage, searchList, args);
    }
}
