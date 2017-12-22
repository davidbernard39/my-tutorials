package com.example;

public class AIPlayerTableLookup extends Player implements AIPlayer {

    // Moves {row, col} in order of preferences. {0, 0} at top-left corner
    private int[][] preferredMoves = {
            {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
            {0, 1}, {1, 0}, {1, 2}, {2, 1}};

    public AIPlayerTableLookup(TicTacToeGrid grid, String playerToken) {
        super(grid, playerToken);
    }

    public int[] move() {
        for (int movePosition = 0 ; movePosition < preferredMoves.length; movePosition++) {
            if (grid.canPlay(preferredMoves[movePosition][0],preferredMoves[movePosition][0])) {
                return preferredMoves[movePosition];
            }
        }
        return null;
    }
}
