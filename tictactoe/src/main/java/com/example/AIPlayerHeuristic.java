package com.example;

import static com.example.TicTacToeGrid.EMPTY_CASE;

public class AIPlayerHeuristic extends Player implements AIPlayer {

    public static final int SCORE_FOR_WIN = 100;
    public static final int SCORE_FOR_TWO = 10;
    public static final int SCORE_FOR_ONE = 1;

    private String opponentToken;

    public AIPlayerHeuristic(TicTacToeGrid grid, String playerToken, String opponentToken) {
        super(grid, playerToken);
        this.opponentToken = opponentToken;
    }

    public int[] move() {
        int bestLine = 0;
        int bestCol = 0;
        int bestScore = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.canPlay(i,j)) {
                    int score = scoreFor(i, j, playerToken) + scoreFor(i, j, opponentToken);
                    if (score > bestScore) {
                        bestScore = score;
                        bestLine = i;
                        bestCol = j;
                    }
                }
            }
        }
        return new int[] {bestLine, bestCol};
    }

    public int scoreFor(int line, int column, String token) {
        int score = 0;
        if (canWin(line, column, token)) {
            score += SCORE_FOR_WIN;
        }
        if (canMake2(line, column, token)) {
            score += SCORE_FOR_TWO;
        }
        if (canMake1(line, column)) {
            score += SCORE_FOR_ONE;
        }
        return score;
    }

    private boolean canMake1(int line, int column) {
        return score1InLine(line, column) || score1InColumn(line, column)
                || score1InDiagDown(line, column) || score1InDiagUp(line, column);
    }

    private boolean canMake2(int line, int column, String playerToken) {
        return score2InLine(line, column, playerToken) || score2InColumn(line, column, playerToken)
                || score2InDiagDown(line, column, playerToken) || score2InDiagUp(line, column, playerToken);
    }


    private boolean canWin(int line, int column, String playerToken) {
        return scoreWinLine(line, column, playerToken) || scoreWinColumn(line, column, playerToken)
                || scoreWinDiagDown(line, column, playerToken) || scoreWinDiagUp(line, column, playerToken);
    }

    private boolean score2InColumn(int line, int column, String playerToken) {
        String caseValueInLine0 = grid.getCaseValue(0, column);
        String caseValueInLine1 = grid.getCaseValue(1, column);
        String caseValueInLine2 = grid.getCaseValue(2, column);
        if (line == 0) {
            return (caseValueInLine1.equals(playerToken) && caseValueInLine2.equals(EMPTY_CASE))
                    || (caseValueInLine1.equals(EMPTY_CASE) && caseValueInLine2.equals(playerToken));
        } else if (line == 1) {
            return (caseValueInLine0.equals(playerToken) && caseValueInLine2.equals(EMPTY_CASE))
                    || (caseValueInLine0.equals(EMPTY_CASE) && caseValueInLine2.equals(playerToken));
        } else if (line == 2) {
            return (caseValueInLine0.equals(playerToken) && caseValueInLine1.equals(EMPTY_CASE))
                    || (caseValueInLine0.equals(EMPTY_CASE) && caseValueInLine1.equals(playerToken));
        }
        return false;
    }

    private boolean scoreWinColumn(int line, int column, String playerToken) {
        String caseValueInLine0 = grid.getCaseValue(0, column);
        String caseValueInLine1 = grid.getCaseValue(1, column);
        String caseValueInLine2 = grid.getCaseValue(2, column);
        if (line == 0) {
            return caseValueInLine1.equals(playerToken) && caseValueInLine2.equals(playerToken);
        } else if (line == 1) {
            return caseValueInLine0.equals(playerToken) && caseValueInLine2.equals(playerToken);
        } else if (line == 2) {
            return caseValueInLine0.equals(playerToken) && caseValueInLine1.equals(playerToken);
        }
        return false;
    }

    private boolean score1InColumn(int line, int column) {
        return scoreWinColumn(line, column, EMPTY_CASE);
    }

    private boolean score2InLine(int line, int column, String playerToken) {
        String caseValueInCol0 = grid.getCaseValue(line, 0);
        String caseValueInCol1 = grid.getCaseValue(line, 1);
        String caseValueInCol2 = grid.getCaseValue(line, 2);
        if (column == 0) {
            return (caseValueInCol1.equals(playerToken) && caseValueInCol2.equals(EMPTY_CASE))
                    || (caseValueInCol1.equals(EMPTY_CASE) && caseValueInCol2.equals(playerToken));
        } else if (column == 1) {
            return (caseValueInCol0.equals(playerToken) && caseValueInCol2.equals(EMPTY_CASE))
                    || (caseValueInCol0.equals(EMPTY_CASE) && caseValueInCol2.equals(playerToken));
        } else if (column == 2) {
            return (caseValueInCol0.equals(playerToken) && caseValueInCol1.equals(EMPTY_CASE))
                    || (caseValueInCol0.equals(EMPTY_CASE) && caseValueInCol1.equals(playerToken));
        }
        return false;
    }

    private boolean scoreWinLine(int line, int column, String playerToken) {
        String caseValueInCol0 = grid.getCaseValue(line, 0);
        String caseValueInCol1 = grid.getCaseValue(line, 1);
        String caseValueInCol2 = grid.getCaseValue(line, 2);
        if (column == 0) {
            return caseValueInCol1.equals(playerToken) && caseValueInCol2.equals(playerToken);
        } else if (column == 1) {
            return caseValueInCol0.equals(playerToken) && caseValueInCol2.equals(playerToken);
        } else if (column == 2) {
            return caseValueInCol0.equals(playerToken) && caseValueInCol1.equals(playerToken);
        }
        return false;
    }

    private boolean score1InLine(int line, int column) {
        return scoreWinLine(line, column, EMPTY_CASE);
    }

    private boolean scoreWinDiagDown(int line, int column, String playerToken) {
        String caseValueInDiag0 = grid.getCaseValue(0, 0);
        String caseValueInDiag1 = grid.getCaseValue(1, 1);
        String caseValueInDiag2 = grid.getCaseValue(2, 2);
        if (column == 0 && line == 0) {
            return caseValueInDiag1.equals(playerToken) && caseValueInDiag2.equals(playerToken);
        } else if (column == 1 && line == 1) {
            return caseValueInDiag0.equals(playerToken) && caseValueInDiag2.equals(playerToken);
        } else if (column == 2 && line == 2) {
            return caseValueInDiag0.equals(playerToken) && caseValueInDiag1.equals(playerToken);
        }
        return false;
    }


    private boolean score1InDiagDown(int line, int column) {
        return scoreWinDiagDown(line, column, EMPTY_CASE);
    }


    private boolean score2InDiagDown(int line, int column, String playerToken) {
        String caseValueInDiag0 = grid.getCaseValue(0, 0);
        String caseValueInDiag1 = grid.getCaseValue(1, 1);
        String caseValueInDiag2 = grid.getCaseValue(2, 2);
        if (column == 0 && line == 0) {
            return (caseValueInDiag1.equals(playerToken) && caseValueInDiag2.equals(EMPTY_CASE))
                    || (caseValueInDiag1.equals(EMPTY_CASE) && caseValueInDiag2.equals(playerToken));
        } else if (column == 1 && line == 1) {
            return (caseValueInDiag0.equals(playerToken) && caseValueInDiag2.equals(EMPTY_CASE))
                    || (caseValueInDiag0.equals(EMPTY_CASE) && caseValueInDiag2.equals(playerToken));
        } else if (column == 2 && line == 2) {
            return (caseValueInDiag0.equals(playerToken) && caseValueInDiag1.equals(EMPTY_CASE))
                    || (caseValueInDiag0.equals(EMPTY_CASE) && caseValueInDiag1.equals(playerToken));
        }
        return false;
    }


    private boolean scoreWinDiagUp(int line, int column, String playerToken) {
        String caseValueInDiag0 = grid.getCaseValue(0, 2);
        String caseValueInDiag1 = grid.getCaseValue(1, 1);
        String caseValueInDiag2 = grid.getCaseValue(2, 0);
        if (column == 0 && line == 2) {
            return caseValueInDiag1.equals(playerToken) && caseValueInDiag0.equals(playerToken);
        } else if (column == 1 && line == 1) {
            return caseValueInDiag0.equals(playerToken) && caseValueInDiag2.equals(playerToken);
        } else if (column == 2 && line == 0) {
            return caseValueInDiag2.equals(playerToken) && caseValueInDiag1.equals(playerToken);
        }
        return false;
    }


    private boolean score1InDiagUp(int line, int column) {
        return scoreWinDiagUp(line, column, EMPTY_CASE);
    }

    private boolean score2InDiagUp(int line, int column, String playerToken) {
        String caseValueInDiag0 = grid.getCaseValue(0, 2);
        String caseValueInDiag1 = grid.getCaseValue(1, 1);
        String caseValueInDiag2 = grid.getCaseValue(2, 0);
        if (column == 0 && line == 2) {
            return (caseValueInDiag1.equals(playerToken) && caseValueInDiag0.equals(EMPTY_CASE))
                    || (caseValueInDiag1.equals(EMPTY_CASE) && caseValueInDiag0.equals(playerToken));
        } else if (column == 1 && line == 1) {
            return (caseValueInDiag0.equals(playerToken) && caseValueInDiag2.equals(EMPTY_CASE))
                    || (caseValueInDiag0.equals(EMPTY_CASE) && caseValueInDiag2.equals(playerToken));
        } else if (column == 2 && line == 0) {
            return (caseValueInDiag2.equals(playerToken) && caseValueInDiag1.equals(EMPTY_CASE))
                    || (caseValueInDiag2.equals(EMPTY_CASE) && caseValueInDiag1.equals(playerToken));
        }
        return false;
    }
}
