package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.exceptions.LadderNotFoundException;
import com.abhi.snakesandladdersgame.exceptions.SnakeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayService implements IPlayService {

    private ISnakeService snakeService;
    private ILadderService ladderService;
    private IDisplayService displayService;

    @Autowired
    public PlayService(ISnakeService snakeService, ILadderService ladderService, IDisplayService displayService) {
        this.snakeService = snakeService;
        this.ladderService = ladderService;
        this.displayService = displayService;
    }

    @Override
    public void play(Player player, int diceNumber) {
        NextPositionVisitor.visit(player, diceNumber);
        int currentPosition = player.getPosition();
        try {
            if(snakeService.hasSnakeAtPosition(currentPosition)) {
                snakeService.eat(player);
                displayService.displaySnakeAte(player, currentPosition);
            }
            if(ladderService.hasLadderAtPosition(currentPosition)) {
                ladderService.climb(player);
                displayService.displayLadderClimbed(player, currentPosition);
            }
            displayService.displayCurrentBoardPosition(player);
        } catch (SnakeNotFoundException | LadderNotFoundException ex) {
            log.error(ex.getMessage()); //continue as it won't affect application rules
        }
    }
}
