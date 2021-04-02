package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][i] == 1 && (checkRow(board, i) || checkColumn(board, i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRow(int[][] board, int row) {
        boolean result = true;

        for (int i = 0; i < board.length; i++) {
            if(board[i][row] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkColumn(int[][] board, int column) {
        boolean result = true;

        for (int i = 0; i < board[column].length; i++) {
            if(board[column][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
