package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day9 {
    public static void main(String[] args) {

        int line = 0, column = 0;
        int[][] board;

        // File fd = new File("day9/input_test.txt");
        File fd = new File("day9/input.txt");
        Scanner file = null;

        try {
            file = new Scanner(fd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // set the array length
        while (file.hasNext()) {
            column = file.nextLine().length();
            line++;
        }
        board = new int[line][column];


        try {
            file = new Scanner(fd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // introduce numbers in array
        String aux = "";
        int i = 0;
        while (file.hasNext()) {
            aux = file.nextLine();
            for (int j = 0; j < aux.length(); j++) {
                board[i][j] = Character.getNumericValue(aux.charAt(j));
            }
            i++;
        }

        // iterate the map searching lows
        int risk = 0;
        for (i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isLow(board, i, j)) {
                    risk += 1 + board[i][j];
                }
            }
        }


        System.out.println("riesgo " + risk);
    }

    /* returns true if a point in a map is a low
     * A point is a low if all sorunding points are a higher altitude
     */
    public static boolean isLow(int[][] board, int posI, int posJ) {
        // top left corner
        if (posI == 0 && posJ == 0)
            if (board[0][0] < board[1][0] && board[0][0] < board[0][1])
                return true;
            else
                return false;
        // top right corner
        if (posI == 0 && posJ == board[0].length - 1)
            if (board[0][posJ] < board[1][posJ] && board[0][posJ] < board[0][posJ - 1])
                return true;
            else
                return false;
        // bottom right corner
        if (posI == board.length - 1 && posJ == board[0].length - 1)
            if (board[posI][posJ] < board[posI - 1][posJ] && board[posI][posJ] < board[posI][posJ - 1])
                return true;
            else
                return false;
        // bottom left corner
        if (posI == board.length - 1 && posJ == 0)
            if (board[posI][posJ] < board[posI - 1][posJ] && board[posI][posJ] < board[posI][posJ + 1])
                return true;
            else
                return false;

        // first line
        if (posI == 0)
            if (board[posI][posJ] < board[posI][posJ - 1] && board[posI][posJ] < board[posI][posJ + 1]
                    && board[posI][posJ] < board[posI + 1][posJ])
                return true;
            else
                return false;
        // last line
        if (posI == board.length - 1)
            if (board[posI][posJ] < board[posI][posJ - 1] && board[posI][posJ] < board[posI][posJ + 1]
                    && board[posI][posJ] < board[posI - 1][posJ])
                return true;
            else
                return false;
        // first column
        if (posJ == 0)
            if (board[posI][posJ] < board[posI - 1][posJ] && board[posI][posJ] < board[posI + 1][posJ]
                    && board[posI][posJ] < board[posI][posJ + 1])
                return true;
            else
                return false;
        // last column
        if (posJ == board[0].length - 1)
            if (board[posI][posJ] < board[posI - 1][posJ] && board[posI][posJ] < board[posI + 1][posJ]
                    && board[posI][posJ] < board[posI][posJ - 1])
                return true;
            else
                return false;

        // normal case
        if (board[posI][posJ] < board[posI - 1][posJ] && board[posI][posJ] < board[posI + 1][posJ]
                && board[posI][posJ] < board[posI][posJ - 1] && board[posI][posJ] < board[posI][posJ + 1])
            return true;

        return false;
    }
}
