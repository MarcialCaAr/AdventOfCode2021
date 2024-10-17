package day6;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class day6 {

    public static final int DAYS = 80;
    public static final int DAYS2 = 256;

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();


        File fd = new File("day6/input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        file = new Scanner(file.nextLine().trim().replaceAll(",", "\n"));

        while(file.hasNextInt()){
            list.add(file.nextInt());
        }

        for(int i = 0; i < DAYS2; i++){
            for(int j = list.size()-1; j >= 0 ; j--){
                if(list.get(j) > 0){
                    list.set(j, list.get(j)-1);
                } else {
                    list.set(j, 6);
                    list.add(8);
                }
            }
        }

        System.out.println(list.size());
    }
    
}
