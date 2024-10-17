package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day12 {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        int counter = 0;

        File fd = new File("input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

            while (file.hasNext()) {
                lista.add(file.nextInt());
            }

            for (int i = 0; i < lista.size()-3; i++) {
                int val1 = lista.get(i);
                int val2 = lista.get(i+1);
                int val3 = lista.get(i+2);
                int val4 = lista.get(i+3);

                int valA = val1 + val2 + val3;
                int valB = val2 + val3 + val4;

                if (valA < valB) {
                    counter++;
                }
            }
            System.out.println(counter);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}