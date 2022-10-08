package com.abhi.snakesandladdersgame.service;

import com.abhi.snakesandladdersgame.entity.Player;
import com.abhi.snakesandladdersgame.enums.Snake;
import com.abhi.snakesandladdersgame.exceptions.SnakeNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SnakeService implements ISnakeService {

    @Override
    public boolean hasSnakeAtPosition(int position) {
        return Snake.getByHeadPosition(position).isPresent();
    }

    @Override
    public void eat(Player player) throws SnakeNotFoundException {
        Optional<Snake> snake = Snake.getByHeadPosition(player.getPosition());
        if(!snake.isPresent()) {
           throw new SnakeNotFoundException(player.getPosition());
        }
        player.setPosition(snake.get().getTail());
    }
}
