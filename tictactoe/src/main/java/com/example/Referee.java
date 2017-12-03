package com.example;

import static com.example.TicTacToeGrid.*;

public class Referee {

    private TicTacToeGrid ticTacToeGrid;

    public Referee(TicTacToeGrid ticTacToeGrid) {
        this.ticTacToeGrid = ticTacToeGrid;
    }

    public String winner() {
        String winner = getWinningLine();
        if (EMPTY_CASE.equals(winner)) {
            winner = getWinningRow();
        }
        if (EMPTY_CASE.equals(winner)) {
            winner = getWinningDiagUpDown();
        }
        if (EMPTY_CASE.equals(winner)) {
            winner = getWinningDiagDownUp();
        }
        return winner;
    }

    public boolean hasWinner() {
        return !EMPTY_CASE.equals(winner());
    }

    private String getWinningDiagUpDown() {
        if (ticTacToeGrid.isPlayedCase(FIRST_LINE_IDX, FIRST_ROW_IDX)
                && ticTacToeGrid.areCasesEqual(FIRST_LINE_IDX,FIRST_ROW_IDX,1,1)
                && ticTacToeGrid.areCasesEqual(FIRST_LINE_IDX,FIRST_ROW_IDX,2, 2)) {
            return ticTacToeGrid.getCaseValue(FIRST_LINE_IDX,FIRST_ROW_IDX);

        }
        return EMPTY_CASE;
    }

    private String getWinningDiagDownUp() {
        if (ticTacToeGrid.isPlayedCase(2, FIRST_ROW_IDX)
                && ticTacToeGrid.areCasesEqual(2,FIRST_ROW_IDX,1,1)
                && ticTacToeGrid.areCasesEqual(2,FIRST_ROW_IDX,0, 2)) {
            return ticTacToeGrid.getCaseValue(2,FIRST_ROW_IDX);

        }
        return EMPTY_CASE;
    }

    private String getWinningLine() {
        String winner = EMPTY_CASE;
        for (int lineIdx = FIRST_LINE_IDX; lineIdx < LINES_COUNT; lineIdx++) {
            if (isWinningLine(lineIdx)) {
                winner = ticTacToeGrid.getCaseValue(lineIdx, FIRST_ROW_IDX);
                break;
            }
        }
        return winner;
    }

    private String getWinningRow() {
        String winner = EMPTY_CASE;
        for (int rowIdx = FIRST_ROW_IDX; rowIdx < ROWS_COUNT; rowIdx++) {
            if (isWinningRow(rowIdx)) {
                winner = ticTacToeGrid.getCaseValue(FIRST_LINE_IDX, rowIdx);
                break;
            }
        }
        return winner;
    }

    private boolean isWinningLine(int lineIdx) {
        return ticTacToeGrid.isPlayedCase(lineIdx, FIRST_ROW_IDX)
                && ticTacToeGrid.areCasesEqual(lineIdx,FIRST_ROW_IDX,lineIdx,1)
                && ticTacToeGrid.areCasesEqual(lineIdx,FIRST_ROW_IDX,lineIdx, 2);
    }


    private boolean isWinningRow(int rowIdx) {
        return ticTacToeGrid.isPlayedCase(FIRST_LINE_IDX, rowIdx)
                && ticTacToeGrid.areCasesEqual(FIRST_LINE_IDX,rowIdx,1,rowIdx)
                && ticTacToeGrid.areCasesEqual(FIRST_LINE_IDX,rowIdx,2, rowIdx);
    }
}
