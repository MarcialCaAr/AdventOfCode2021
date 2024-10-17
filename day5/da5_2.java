package day5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import librerias.Tuple;

public class da5_2 {

    public static void main(String[] args) {

        List<Tuple<Integer, Integer>> list1 = new ArrayList<>();
        List<Tuple<Integer, Integer>> list2 = new ArrayList<>();

        int[][] board = new int[1000][1000];

        File fd = new File("day5/input.txt");
        Scanner file = null;
        Scanner line = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        while (file.hasNextLine()) {
            line = new Scanner(file.nextLine().trim().replaceAll(",", "\n").replaceAll("->", "\n"));
            list1.add(new Tuple<Integer, Integer>(line.nextInt(), line.nextInt()));
            list2.add(new Tuple<Integer, Integer>(line.nextInt(), line.nextInt()));
        }

        for (int i = 0; i < list1.size(); i++) {
            int valx1 = list1.get(i).getFirst();
            int valy1 = list1.get(i).getSecond();
            int valx2 = list2.get(i).getFirst();
            int valy2 = list2.get(i).getSecond();

            if (valx1 == valx2) {
                for (int j = Math.min(valy1, valy2); j <= Math.max(valy1, valy2); j++) {
                    board[valx1][j]++;
                }
            }
            if (valy1 == valy2) {
                for (int j = Math.min(valx1, valx2); j <= Math.max(valx1, valx2); j++) {
                    board[j][valy1]++;
                }
            }
            // cutrada, analizar todos los casos de la parte 2
            if(valx1 > valx2 && valy1 > valy2){
                for(int j = valx2; j <= valx1; j++){
                    board[j][valy2]++;
                    valy2++;
                }
                continue;
            }
            if(valx1 < valx2 && valy1 < valy2){
                for(int j = valx2; j >= valx1; j--){
                    board[j][valy2]++;
                    valy2--;
                }
                continue;
            }

            if(valx1 > valx2 && valy1 < valy2){
                for(int j = valx1; j >= valx2; j--){
                    board[j][valy1]++;
                    valy1++;
                }
                continue;
            }
            if(valx1 < valx2 && valy1 > valy2){
                for(int j = valx1; j <= valx2; j++){
                    board[j][valy1]++;
                    valy1--;
                }
                continue;
            }
        }

        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
