package day7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day7 {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        // File fd = new File("day7/input_test.txt");
        File fd = new File("day7/input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        file = new Scanner(file.nextLine().trim().replaceAll(",", "\n"));
        while (file.hasNextLine()) {
            data.add(file.nextInt());
        }
        data.sort(null);

        // calcula la mediaana
        int mediana;
        int mitad = data.size() / 2;
        // Si la longitud es par, se deben promediar los del centro
        if (data.size() % 2 == 0) {
            mediana = (data.get(mitad-1) + data.get(mitad)) / 2;
        } else {
            mediana = data.get(mitad);
        }

        System.out.println(mediana);


        // calcula el gasto de combustible de cada elemento hasta la mediana
        int fuel = 0;
        for(int i = 0; i < data.size(); i++){
            fuel += Math.abs(data.get(i)-mediana);
        }

        System.out.println(fuel);

    }
}
