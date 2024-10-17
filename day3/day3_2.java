package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3_2 {

    public static void main(String[] args) {
        List<Integer> unos = new ArrayList<>();
        List<Integer> ceros = new ArrayList<>();
        List<String> data = new ArrayList<>();
        // int[] unos = new int[12],ceros = new int[12];
        String oxygen = "", co2 = "";

        File fd = new File("day3/input.txt");
        Scanner file = null;
        try {
            String line = "";
            file = new Scanner(fd);

            for (int i = 0; i < file.nextLine().trim().length(); i++) {
                unos.add(0);
                ceros.add(0);
            }

            file = new Scanner(fd);

            // recorremos el archivo
            while (file.hasNext()) {
                line = file.nextLine().trim();
                data.add(line);
                // comprobamos que bit hay en cada posicion
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '0') {
                        ceros.set(i, ceros.get(i) + 1);
                    } else {
                        unos.set(i, unos.get(i) + 1);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        oxygen = oxygenGenerator(data, ceros, unos);
        co2 = co2Generator(data, ceros, unos);


        // System.out.println(oxygen + " " + co2);
        int sum = Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2);

        System.out.println(sum);
    }

    public static String oxygenGenerator(List<String> data, List<Integer> ceros, List<Integer> unos) {
        int count = 0;
        for (int i = 0; i < unos.size(); i++) {
            if (unos.get(i) >= ceros.get(i)) {
                for (int j = data.size() - 1; j >= 0; j--) {
                    count++;
                    if (data.get(j).charAt(i) == '0'){
                        System.out.println(data.get(j));
                        data.remove(j);}
                    if (data.size() == 1)
                        return data.get(0);
                }
            }
        }
        System.out.println("entra: " + count);
        System.out.println("oxygen length = " + data.size());
        System.out.println(data.get(0) + "\n" + data.get(1));
        return data.get(0);
    }

    public static String co2Generator(List<String> data, List<Integer> ceros, List<Integer> unos) {
        int count = 0;
        for (int i = 0; i < unos.size(); i++) {
            if (unos.get(i) < ceros.get(i)) {
                for (int j = data.size() - 1; j >= 0; j--) {
                    count++;
                    if (data.get(j).charAt(i) == '1')
                        data.remove(j);
                    if (data.size() == 1){
                        System.out.println("entra: " + count);
                        return data.get(0);}
                        
                }
            }
        }
        System.out.println("co2 length = " + data.size());
        return data.get(0);
    }

}
