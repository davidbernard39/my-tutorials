package com.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        TicTacToeGrid ticTacToeGrid = new TicTacToeGrid();

        System.out.println("Welcome to TicTacToe");
        System.out.println(ticTacToeGrid.print());

        System.out.println("Play : ");
        Scanner scanner = new Scanner(System.in);
        String keyboardEntry = scanner.next();
        String[] move = keyboardEntry.split(",");
        ticTacToeGrid.play(move[0], Integer.valueOf(move[1]), Integer.valueOf(move[2]));
        System.out.println(ticTacToeGrid.print());
        System.out.println("Game over");
    }
}
