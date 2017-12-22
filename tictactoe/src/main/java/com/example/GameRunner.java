package com.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        TicTacToeGrid ticTacToeGrid = new TicTacToeGrid();
        Referee referee = new Referee(ticTacToeGrid);

        System.out.println("Welcome to TicTacToe");
        System.out.println("Do you want to start (y/n)");
        Scanner scanner = new Scanner(System.in);
        String keyboardEntry = scanner.next();

        System.out.println(ticTacToeGrid.print());

        boolean userPlaysFirst = "y".equalsIgnoreCase(keyboardEntry);

        //Player player1 = userPlaysFirst ? new Player(ticTacToeGrid, "X") : new AIPlayerTableLookup(ticTacToeGrid, "X");
        //Player player2 = userPlaysFirst ? new AIPlayerTableLookup(ticTacToeGrid, "O") : new Player(ticTacToeGrid, "O");

        Player player1 = userPlaysFirst ? new Player(ticTacToeGrid, "X") : new AIPlayerHeuristic(ticTacToeGrid, "X", "O");
        Player player2 = userPlaysFirst ? new AIPlayerHeuristic(ticTacToeGrid, "O", "X") : new Player(ticTacToeGrid, "O");


        int turn = 0;
        while (!referee.hasWinner()) {
            Player whoPlay = (turn % 2 == 0) ? player1 : player2;
            System.out.println("Player " + whoPlay.token() + " : ");

            if (whoPlay instanceof AIPlayer) {
                AIPlayer ai = (AIPlayer) whoPlay;
                int[] move = ai.move();
                ai.play(move[0], move[1]);
            } else {
                keyboardEntry = scanner.next();
                String[] move = keyboardEntry.split(",");
                if (ticTacToeGrid.canPlay(Integer.valueOf(move[0]), Integer.valueOf(move[1]))) {
                    whoPlay.play(Integer.valueOf(move[0]), Integer.valueOf(move[1]));
                } else {
                    continue;
                }
            }

            System.out.println(ticTacToeGrid.print());
            turn += 1;
        }
        System.out.println("Game over");
        System.out.println("Player " + referee.winner() + " won !");
    }
}
