package day4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day4 {

    static record Board(int[][] board, boolean[][] marked) {

        // private void printBoard() {
        //     for (int i = 0; i < board.length; i++) {
        //         for (int j = 0; j < board[i].length; j++) {
        //             System.out.print(marked[i][j] + " ");
        //         }
        //         // System.out.println("\n");
        //     }
        // }

        private void checkNum(int num) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == num) {
                        marked[i][j] = true;
                        return;
                    }
                }
            }
        }

        private int isWinner() {
            for (int i = 0; i < board.length; i++) {
                if (marked[i][0] == true && marked[i][1] == true && marked[i][2] == true && marked[i][3] == true
                        && marked[i][4] == true) {
                    int sum = 0;
                    for (int j = 0; j < marked.length; j++) {
                        for (int k = 0; k < marked.length; k++) {
                            if (marked[j][k] == false)
                                sum += board[j][k];
                        }
                    }
                    return sum;
                }
                if (marked[0][i] == true && marked[1][i] == true && marked[2][i] == true && marked[3][i] == true
                        && marked[4][i] == true) {
                    int sum = 0;
                    for (int j = 0; j < marked.length; j++) {
                        for (int k = 0; k < marked.length; k++) {
                            if (marked[j][k] == false)
                                sum += board[j][k];
                        }
                    }
                    return sum;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        List<Board> boards = new ArrayList<>();

        File fd = new File("day4/input.txt");
        Scanner file = null;
        Scanner numsS = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        numsS = new Scanner(file.nextLine().replaceAll(",", "\n"));

        while (numsS.hasNextInt()) {
            nums.add(numsS.nextInt());
        }

        int[][] aux;
        while (file.hasNext()) {
            aux = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    aux[i][j] = file.nextInt();
                }
            }
            boards.add(new Board(aux, new boolean[5][5]));
        }

        metodo(nums, boards);

        // System.out.println(boards.get(1).printBoard());
        // boards.get(0).checkNum(2);
        // boards.get(0).printBoard();

    }

    private static void metodo(List<Integer> nums, List<Board> boards) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = boards.size()-1; j>= 0; j--) {
                boards.get(j).checkNum(nums.get(i));
                sum = boards.get(j).isWinner();
                if (sum != -1) {
                    System.out.println((sum) * nums.get(i));
                    System.out.println("board: " + j + " num: " + i);
                    boards.remove(j);
                    return; // descomentar para optener la solucion de la parte 1
                }
            }
        }
    }

}
