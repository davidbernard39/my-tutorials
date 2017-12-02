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
        if (isPlayedCase(FIRST_LINE_IDX, FIRST_ROW_IDX)
                && areCasesEqual(FIRST_LINE_IDX,FIRST_ROW_IDX,1,1)
                && areCasesEqual(FIRST_LINE_IDX,FIRST_ROW_IDX,2, 2)) {
            return getCaseValue(FIRST_LINE_IDX,FIRST_ROW_IDX);

        }
        return EMPTY_CASE;
    }

    private String getWinningDiagDownUp() {
        if (isPlayedCase(2, FIRST_ROW_IDX)
                && areCasesEqual(2,FIRST_ROW_IDX,1,1)
                && areCasesEqual(2,FIRST_ROW_IDX,0, 2)) {
            return getCaseValue(2,FIRST_ROW_IDX);

        }
        return EMPTY_CASE;
    }

    private String getWinningLine() {
        String winner = EMPTY_CASE;
        for (int lineIdx = FIRST_LINE_IDX; lineIdx < LINES_COUNT; lineIdx++) {
            if (isWinningLine(lineIdx)) {
                winner = getCaseValue(lineIdx, FIRST_ROW_IDX);
                break;
            }
        }
        return winner;
    }

    private String getWinningRow() {
        String winner = EMPTY_CASE;
        for (int rowIdx = FIRST_ROW_IDX; rowIdx < ROWS_COUNT; rowIdx++) {
            if (isWinningRow(rowIdx)) {
                winner = getCaseValue(FIRST_LINE_IDX, rowIdx);
                break;
            }
        }
        return winner;
    }

    private boolean isWinningLine(int lineIdx) {
        return isPlayedCase(lineIdx, FIRST_ROW_IDX)
                && areCasesEqual(lineIdx,FIRST_ROW_IDX,lineIdx,1)
                && areCasesEqual(lineIdx,FIRST_ROW_IDX,lineIdx, 2);
    }


    private boolean isWinningRow(int rowIdx) {
        return isPlayedCase(FIRST_LINE_IDX, rowIdx)
                && areCasesEqual(FIRST_LINE_IDX,rowIdx,1,rowIdx)
                && areCasesEqual(FIRST_LINE_IDX,rowIdx,2, rowIdx);
    }

    private boolean isPlayedCase(int lineIdx, int rowIdx) {
        return !EMPTY_CASE.equals(getCaseValue(lineIdx, rowIdx));
    }

    private boolean areCasesEqual(int firstCaseLineIdx, int firstCaseRowIdx, int secondCaseLineIdx, int secondCaseRowIdx) {
        return getCaseValue(firstCaseLineIdx, firstCaseRowIdx).equals(getCaseValue(secondCaseLineIdx,secondCaseRowIdx));
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

    public boolean canPlay(int lineIdx, int rowIdx) {
        return EMPTY_CASE.equals(getCaseValue(lineIdx,rowIdx));
    }
}
