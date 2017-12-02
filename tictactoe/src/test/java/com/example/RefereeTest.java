package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    TicTacToeGrid grid;
    Referee referee;

    @Before
    public void setUp() throws Exception {
        grid = new TicTacToeGrid();
        referee = new Referee(grid);
    }

    @Test
    public void shouldWinnerReturnEmptyStringWhenNoPlayerWon() {
        grid.play("X", 1, 0);
        grid.play("O", 1, 1);
        grid.play("X", 1, 2);
        assertThat(referee.winner()).isEqualTo(TicTacToeGrid.EMPTY_CASE);
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInALine() {
        grid.play("X", 1, 0);
        grid.play("X", 1, 1);
        grid.play("X", 1, 2);
        assertThat(referee.winner()).isEqualTo("X");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInARow() {
        grid.play("O", 0, 1);
        grid.play("O", 1, 1);
        grid.play("O", 2, 1);
        assertThat(referee.winner()).isEqualTo("O");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInUpToDownDiag() {
        grid.play("O", 0, 0);
        grid.play("O", 1, 1);
        grid.play("O", 2, 2);
        assertThat(referee.winner()).isEqualTo("O");
    }

    @Test
    public void shouldWinnerReturnPlayerWhoWonInDownToUpDiag() {
        grid.play("O", 0, 2);
        grid.play("O", 1, 1);
        grid.play("O", 2, 0);
        assertThat(referee.winner()).isEqualTo("O");
    }

    @Test
    public void shouldSayThatThereIsAWinner() {
        grid.play("O", 0, 2);
        grid.play("O", 1, 1);
        grid.play("O", 2, 0);
        assertThat(referee.hasWinner()).isTrue();
    }
}