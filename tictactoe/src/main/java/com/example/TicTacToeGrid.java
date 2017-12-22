package com.example;

public class TicTacToeGrid {

    public static final int FIRST_LINE_IDX = 0;
    public static final int FIRST_COL_IDX = 0;
    public static final int LINES_COUNT = 3;
    public static final int COLS_COUNT = 3;

    public static final String EMPTY_CASE = " ";
    public static final String ROW_SEPARATOR = "-----------\n";
    public static final String LINE_SEPARATOR = " \n";
    public static final String CASE_SEPARATOR = " |";

    private String[][] grid = new String[3][3];

    public TicTacToeGrid() {
        clear();
    }

    public boolean canPlay(int lineIdx, int columnIdx) {
        return EMPTY_CASE.equals(getCaseValue(lineIdx,columnIdx));
    }

    public String print() {
        String result = "";
        for (int lineIdx = FIRST_LINE_IDX ; lineIdx < LINES_COUNT ; lineIdx++) {
            for (int columnIdx = FIRST_COL_IDX; columnIdx < COLS_COUNT; columnIdx++) {
                result += EMPTY_CASE + getCaseValue(lineIdx,columnIdx) + getSeparator(columnIdx);
            }
            if (lineIdx < LINES_COUNT - 1) {
                result += ROW_SEPARATOR;
            }
        }
        return result;
    }

    public void play(String playerToken, int lineIdx, int columnIdx) {
        setCaseValue(lineIdx, columnIdx, playerToken);
    }

    boolean isPlayedCase(int lineIdx, int columnIdx) {
        return !EMPTY_CASE.equals(getCaseValue(lineIdx, columnIdx));
    }

    boolean areCasesEqual(int firstCaseLineIdx, int firstCaseColumnIdx, int secondCaseLineIdx, int secondCaseColumnIdx) {
        return getCaseValue(firstCaseLineIdx, firstCaseColumnIdx).equals(getCaseValue(secondCaseLineIdx,secondCaseColumnIdx));
    }

    private String getSeparator(int rowIdx) {
        return rowIdx == COLS_COUNT - 1 ? LINE_SEPARATOR : CASE_SEPARATOR;
    }

    private void clear() {
        for (int lineIdx = FIRST_LINE_IDX; lineIdx < LINES_COUNT; lineIdx++) {
            for (int columnIdx = FIRST_COL_IDX; columnIdx < COLS_COUNT; columnIdx++) {
                setCaseValue(lineIdx, columnIdx, EMPTY_CASE);
            }
        }
    }

    private void setCaseValue(int lineIdx, int columnIdx, String caseValue) {
        grid[lineIdx][columnIdx] = caseValue;
    }

    String getCaseValue(int lineIdx, int columnIdx) {
        return grid[lineIdx][columnIdx];
    }

}
