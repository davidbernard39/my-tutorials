package com.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TicTacToeGridTest {

    @Test
    public void shouldPrintEmptyGrid() {
        TicTacToeGrid grid = new TicTacToeGrid();
        Assertions.assertThat(grid.print()).isEqualTo(
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
        Assertions.assertThat(grid.print()).isEqualTo(
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n");
    }
}