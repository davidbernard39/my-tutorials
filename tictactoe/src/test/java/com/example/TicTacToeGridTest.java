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

}