package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.enums.Ladder;
import com.abhi.snakesandladdersgame.exceptions.LadderNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LadderService implements ILadderService {

    @Override
    public boolean hasLadderAtPosition(int position) {
        return Ladder.getByFootPosition(position).isPresent();
    }

    @Override
    public void climb(Player player) throws LadderNotFoundException {
        Optional<Ladder> ladder = Ladder.getByFootPosition(player.getPosition());
        if(!ladder.isPresent()) {
            throw new LadderNotFoundException(player.getPosition());
        }
        player.setPosition(ladder.get().getTop());
    }
}
