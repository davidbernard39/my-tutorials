package com.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        TicTacToeGrid ticTacToeGrid = new TicTacToeGrid();
        Referee referee = new Referee(ticTacToeGrid);
        Player player1 = new Player(ticTacToeGrid, "X");
        Player player2 = new Player(ticTacToeGrid, "O");

        System.out.println("Welcome to TicTacToe");
        System.out.println(ticTacToeGrid.print());

        int turn = 0;
        Scanner scanner = new Scanner(System.in);
        while (!referee.hasWinner()) {
            Player whoPlay = (turn % 2 == 0) ? player1 : player2;
            System.out.println("Player " + whoPlay.token() + " : ");

            String keyboardEntry = scanner.next();
            String[] move = keyboardEntry.split(",");
            if (ticTacToeGrid.canPlay(Integer.valueOf(move[0]), Integer.valueOf(move[1]))) {
                ticTacToeGrid.play(whoPlay.token(), Integer.valueOf(move[0]), Integer.valueOf(move[1]));
            } else {
                continue;
            }
            System.out.println(ticTacToeGrid.print());
            turn += 1;
        }
        System.out.println("Game over");
        System.out.println("Player " + referee.winner() + " won !");
    }
}
