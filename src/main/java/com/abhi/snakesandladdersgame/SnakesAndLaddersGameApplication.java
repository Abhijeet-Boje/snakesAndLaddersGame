package com.abhi.snakesandladdersgame;

import com.abhi.snakesandladdersgame.service.UserInteractionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SnakesAndLaddersGameApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SnakesAndLaddersGameApplication.class, args);
        UserInteractionService userInteractionService = applicationContext.getBean(UserInteractionService.class);
        userInteractionService.startGame();
    }

}
