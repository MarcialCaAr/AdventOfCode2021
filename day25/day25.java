package day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day25 {

    public static void main(String[] args) {

        char[][] board;
        boolean[][] canMove;

        // File fd = new File("day25/input_test.txt");
        File fd = new File("day25/input.txt");
        Scanner file = null;

        try {
            file = new Scanner(fd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int x = file.nextLine().length();
        int y = 1;
        while (file.hasNextLine()) {
            file.nextLine();
            y++;
        }
        board = new char[x][y];
        canMove = new boolean[x][y];

        try {
            file = new Scanner(fd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        for (y = 0; file.hasNextLine(); y++) {
            line = file.nextLine();
            for (x = 0; x < line.length(); x++) {
                board[x][y] = line.charAt(x);
            }
        }

        for (x = 0; x < board.length; x++) {
            for (y = 0; y < board[x].length; y++) {
                canMove[x][y] = true;
            }
        }

        boolean move = true;
        int countMoves = 0;
        while (move) {
            move = false;
            // printBoard(board);
            // System.out.println("\n\n");
            for (x = 0; x < board.length; x++) {
                for (y = 0; y < board[x].length; y++) {
                    if (canMove[x][y] && canMove[(x + 1) % (board.length)][y])
                        if (board[x][y] == '>' && board[((x + 1) % (board.length))][y] == '.') {
                            board[((x + 1) % (board.length))][y] = '>';
                            board[x][y] = '.';
                            canMove[(x + 1) % (board.length)][y] = false;
                            canMove[x][y] = false;
                            move = true;
                        }
                }
            }

            for (x = 0; x < board.length; x++) {
                for (y = 0; y < board[x].length; y++) {
                    canMove[x][y] = true;
                }
            }

            for (x = 0; x < board.length; x++) {
                for (y = 0; y < board[x].length; y++) {
                    if (canMove[x][y] && canMove[x][((y + 1) % (board[x].length))])
                        if (board[x][y] == 'v' && board[x][((y + 1) % (board[x].length))] == '.') {
                            board[x][((y + 1) % (board[x].length))] = 'v';
                            board[x][y] = '.';
                            canMove[x][((y + 1) % (board[x].length))] = false;
                            canMove[x][y] = false;
                            move = true;
                        }
                }
            }

            for (x = 0; x < board.length; x++) {
                for (y = 0; y < board[x].length; y++) {
                    canMove[x][y] = true;
                }
            }

            countMoves++;
        }

        // printBoard(board);
        System.out.println(countMoves);

    }

    @SuppressWarnings("unused")
    private static void printBoard(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[i][j]);
            }
            System.out.println("\n");
        }
    }

}
