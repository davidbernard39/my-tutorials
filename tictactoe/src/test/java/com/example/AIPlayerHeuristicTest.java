package com.example;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class AIPlayerHeuristicTest {

    private TicTacToeGrid ticTacToeGrid;
    private AIPlayerHeuristic player;

    @Before
    public void setUp() throws Exception {
        ticTacToeGrid = new TicTacToeGrid();
        player = new AIPlayerHeuristic(ticTacToeGrid, "X", "O");
    }

    @Test
    public void should_score_0_when_opponent_is_present() {
        ticTacToeGrid.play("O", 1, 0);
        ticTacToeGrid.play("O", 0, 1);
        ticTacToeGrid.play("O", 2, 0);
        ticTacToeGrid.play("O", 2, 2);
        Assertions.assertThat(player.scoreFor(1,1, "X")).isEqualTo(0);
    }

    @Test
    public void should_score_101_when_3_in_a_line_for_computer() {
        ticTacToeGrid.play("X", 1,1);
        ticTacToeGrid.play("X", 1,0);
        Assertions.assertThat(player.scoreFor(1,2, "X")).isEqualTo(101);
    }

    @Test
    public void should_score_11_when_2_in_a_line_for_computer_and_third_is_empty() {
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(1,2, "X")).isEqualTo(11);
        Assertions.assertThat(player.scoreFor(1,0, "X")).isEqualTo(11);
    }

    @Test
    public void should_score_1_when_1_in_a_line_for_computer_and_other_empty() {
        ticTacToeGrid.play("O", 0, 0);
        ticTacToeGrid.play("O", 2, 1);
        ticTacToeGrid.play("O", 2, 2);
        Assertions.assertThat(player.scoreFor(1,0, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(1,1, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(1,2, "X")).isEqualTo(1);
    }

    @Test
    public void should_score_101_when_3_in_a_column_for_computer() {
        ticTacToeGrid.play("X", 0,1);
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,1, "X")).isEqualTo(101);
    }


    @Test
    public void should_score_11_when_2_in_a_column_for_computer_and_third_is_empty() {
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,1, "X")).isEqualTo(11);
        Assertions.assertThat(player.scoreFor(0,1, "X")).isEqualTo(11);
    }

    @Test
    public void should_score_1_when_1_in_a_column_for_computer_and_other_empty() {
        ticTacToeGrid.play("O", 0, 0);
        ticTacToeGrid.play("O", 1, 0);
        ticTacToeGrid.play("O", 2, 0);
        Assertions.assertThat(player.scoreFor(0,1, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(1,1, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(2,1, "X")).isEqualTo(1);
    }

    @Test
    public void should_score_101_when_3_in_a_diag_down_for_computer() {
        ticTacToeGrid.play("X", 0,0);
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,2, "X")).isEqualTo(101);
    }

    @Test
    public void should_score_11_when_2_in_a_diag_down_for_computer_and_third_is_empty() {
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,2, "X")).isEqualTo(11);
        Assertions.assertThat(player.scoreFor(0,0, "X")).isEqualTo(11);
    }


    @Test
    public void should_score_1_when_1_in_a_diag_down_for_computer_and_other_empty() {
        ticTacToeGrid.play("O", 0,1);
        ticTacToeGrid.play("O", 2,0);
        ticTacToeGrid.play("O", 1,2);
        Assertions.assertThat(player.scoreFor(2,2, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(0,0, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(1,1, "X")).isEqualTo(1);
    }

    @Test
    public void should_score_101_when_3_in_a_diag_up_for_computer() {
        ticTacToeGrid.play("X", 0,2);
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,0, "X")).isEqualTo(101);
    }


    @Test
    public void should_score_11_when_2_in_a_diag_up_for_computer_and_third_is_empty() {
        ticTacToeGrid.play("X", 1,1);
        Assertions.assertThat(player.scoreFor(2,0, "X")).isEqualTo(11);
        Assertions.assertThat(player.scoreFor(0,2, "X")).isEqualTo(11);
    }


    @Test
    public void should_score_1_when_1_in_a_diag_up_for_computer_and_other_empty() {
        ticTacToeGrid.play("O", 0,0);
        ticTacToeGrid.play("O", 1,2);
        ticTacToeGrid.play("O", 2,2);
        Assertions.assertThat(player.scoreFor(2,0, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(0,2, "X")).isEqualTo(1);
        Assertions.assertThat(player.scoreFor(1,1, "X")).isEqualTo(1);
    }
}