package com.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeGridTest {

    @Test
    public void shouldPrintEmptyGrid() {
        TicTacToeGrid grid = new TicTacToeGrid();
        assertThat(grid.print()).isEqualTo(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldPlayXOnUpperMiddleCase() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("X", 0, 1);
        assertThat(grid.print()).isEqualTo(
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n");
    }

    @Test
    public void shouldWinnerReturnEmptyStringWhenNoPlayerWon() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("X", 1, 0);
        grid.play("O", 1, 1);
        grid.play("X", 1, 2);
        assertThat(grid.winner()).isEqualTo(TicTacToeGrid.EMPTY_CASE);
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInALine() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("X", 1, 0);
        grid.play("X", 1, 1);
        grid.play("X", 1, 2);
        assertThat(grid.winner()).isEqualTo("X");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInARow() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("O", 0, 1);
        grid.play("O", 1, 1);
        grid.play("O", 2, 1);
        assertThat(grid.winner()).isEqualTo("O");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInUpToDownDiag() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("O", 0, 0);
        grid.play("O", 1, 1);
        grid.play("O", 2, 2);
        assertThat(grid.winner()).isEqualTo("O");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInDownToUpDiag() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("O", 0, 2);
        grid.play("O", 1, 1);
        grid.play("O", 2, 0);
        assertThat(grid.winner()).isEqualTo("O");
    }

    @Test
    public void shouldSayThatThereIsAWinner() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("O", 0, 2);
        grid.play("O", 1, 1);
        grid.play("O", 2, 0);
        assertThat(grid.hasWinner()).isTrue();
    }

    @Test
    public void shouldBeEnableToPlayIfNoPlayer() {
        TicTacToeGrid grid = new TicTacToeGrid();
        assertThat(grid.canPlay(0,0)).isTrue();
    }

    @Test
    public void shouldNotBeEnableToPlayIfPlayer() {
        TicTacToeGrid grid = new TicTacToeGrid();
        grid.play("X", 0,0);
        assertThat(grid.canPlay(0,0)).isFalse();
    }
}