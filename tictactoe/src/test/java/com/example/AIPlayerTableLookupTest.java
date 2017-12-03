package com.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AIPlayerTableLookupTest {
    @Test
    public void whenPlayingFirstShouldPlayInTheMiddle() {
        TicTacToeGrid grid = new TicTacToeGrid();
        AIPlayerTableLookup player = new AIPlayerTableLookup(grid,"X");
        assertThat(player.move()).containsExactly(1,1);
    }

    @Test
    public void whenMiddleAlreadyPlayedShouldPlayAtTopLeftCorner() {
        TicTacToeGrid grid = new TicTacToeGrid();
        AIPlayerTableLookup player = new AIPlayerTableLookup(grid,"X");
        grid.play("O", 1,1);
        assertThat(player.move()).containsExactly(0,0);
    }
}