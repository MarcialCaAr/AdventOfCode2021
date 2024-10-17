package day7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day7_2 {
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

        double sum = 0;
        int aux;
        file = new Scanner(file.nextLine().trim().replaceAll(",", "\n"));
        while (file.hasNextLine()) {
            aux = file.nextInt();
            data.add(aux);
            sum += aux;
        }

        // calcula la media
        double media = sum / data.size();
        media = Math.round(media);


        // calcula el gasto de combustible de cada elemento hasta la media
        int fuel = 0;
        int dist = 0;
        for(int i = 0; i < data.size(); i++){
            dist = Math.abs(data.get(i)-(int)media);
            fuel += dist*(dist+1) / 2;
        }

        System.out.println(fuel);

    }
}
