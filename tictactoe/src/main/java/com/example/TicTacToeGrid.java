package com.example;

public class TicTacToeGrid {

    public static final int FIRST_LINE_IDX = 0;
    public static final int FIRST_ROW_IDX = 0;
    public static final int LINES_COUNT = 3;
    public static final int ROWS_COUNT = 3;

    public static final String EMPTY_CASE = " ";
    public static final String ROW_SEPARATOR = "-----------\n";
    public static final String LINE_SEPARATOR = " \n";
    public static final String CASE_SEPARATOR = " |";

    private String[][] grid = new String[3][3];

    public TicTacToeGrid() {
        clear();
    }

    public String print() {
        String result = "";
        for (int lineIdx = FIRST_LINE_IDX ; lineIdx < LINES_COUNT ; lineIdx++) {
            for (int rowIdx = FIRST_ROW_IDX ; rowIdx < ROWS_COUNT ; rowIdx++) {
                result += EMPTY_CASE + getCaseValue(lineIdx,rowIdx) + getSeparator(rowIdx);
            }
            if (lineIdx < LINES_COUNT - 1) {
                result += ROW_SEPARATOR;
            }
        }
        return result;
    }

    public void play(String playerToken, int lineIdx, int rowIdx) {
        setCaseValue(lineIdx, rowIdx, playerToken);
    }

    private String getSeparator(int rowIdx) {
        return rowIdx == ROWS_COUNT - 1 ? LINE_SEPARATOR : CASE_SEPARATOR;
    }

    private void clear() {
        for (int lineIdx = FIRST_LINE_IDX; lineIdx < LINES_COUNT; lineIdx++) {
            for (int rowIdx = FIRST_ROW_IDX; rowIdx < ROWS_COUNT; rowIdx++) {
                setCaseValue(lineIdx, rowIdx, EMPTY_CASE);
            }
        }
    }

    private void setCaseValue(int lineIdx, int rowIdx, String caseValue) {
        grid[lineIdx][rowIdx] = caseValue;
    }

    private String getCaseValue(int lineIdx, int rowIdx) {
        return grid[lineIdx][rowIdx];
    }
}
