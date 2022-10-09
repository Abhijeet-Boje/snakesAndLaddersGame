package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.enums.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Scanner;

/**
 * This User interaction service is just temporary mechanism to interact with user.
 * Eventually this application is going to be used as web application and interaction will happen through UI.
 */
@Service
public class UserInteractionService {

    private IDisplayService displayService;
    private IPlayService playService;

    @Autowired
    public UserInteractionService(IDisplayService displayService, IPlayService playService) {
        this.displayService = displayService;
        this.playService = playService;
    }

    public void startGame() {
        displayService.displayMessage(Message.LETS_START_THE_GAME.getMassage());
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(getPlayerName(scanner));
        displayService.displayGameStart(Collections.singletonList(player));

        while (!player.isWonTheGame()) {
            int diceNum = getDiceNumber(scanner);
            playService.play(player, diceNum);
        }
        displayService.displayWinner(player);
    }


    private int getDiceNumber(Scanner scanner) {
        displayService.displayMessage(Message.DICE_NUMBER_INPUT.getMassage());
        String diceNumber = scanner.nextLine();
        try {
            int dNumber = Integer.valueOf(diceNumber);
            if (dNumber < 1 || dNumber > 6) {
                displayService.displayMessage(Message.REQUEST_USER_FOR_CORRECT_DICE_INPUT.getMassage());
                return getDiceNumber(scanner);
            } else {
                return dNumber;
            }
        }
        catch (NumberFormatException ex) {
            displayService.displayMessage(Message.REQUEST_USER_FOR_CORRECT_DICE_INPUT.getMassage());
            return getDiceNumber(scanner);
        }
    }


    private String getPlayerName(Scanner scanner) {
        displayService.displayMessage(Message.PLAYER_NAME_INPUT.getMassage());
        return scanner.nextLine();
    }
}
