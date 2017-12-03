package com.example;

public class Player {
    protected TicTacToeGrid grid;
    private String playerToken;

    public Player(TicTacToeGrid grid, String playerToken) {
        this.grid = grid;
        this.playerToken = playerToken;
    }

    public void play(int lineIdx, int rowIdx) {
        grid.play(playerToken, lineIdx, rowIdx);
    }

    public String token() {
        return playerToken;
    }
}
