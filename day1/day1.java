package day1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {

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

            for (int i = 1; i < lista.size(); i++) {
                if (lista.get(i).compareTo(lista.get(i - 1)) > 0) {
                    counter++;
                }
            }
            System.out.println(counter);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}