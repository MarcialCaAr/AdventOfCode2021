package day6;

import java.io.File;
import java.util.Scanner;

public class day6_2 {

    public static final int DAYS = 80;
    public static final int DAYS2 = 256;

    public static void main(String[] args) {

        long[] fish = new long[9];


        File fd = new File("day6/input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        file = new Scanner(file.nextLine().trim().replaceAll(",", "\n"));

        while(file.hasNextInt()){
            fish[file.nextInt()]++;
        }

        long[] aux;
        for(int i = 0; i < DAYS2; i++){
            aux = new long[9];
            for(int j = 0; j < fish.length; j++){
                if(j > 0){
                    aux[j-1] += fish[j];
                } else {
                    aux[6] += fish[j];
                    aux[8] += fish[j];
                }
            }
            fish = aux;
        }

        long sum = 0;
        for(int i = 0; i < fish.length;i++){
            sum += fish[i];
        }
        System.out.println(sum);
    }
    
}
