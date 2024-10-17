package day8;

import java.io.File;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class day8 {
    public static void main(String[] args) {

        // List<Integer> data = new ArrayList<>();

        // File fd = new File("day8/input_test.txt");
        File fd = new File("day8/input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        String aux = "";
        int count = 0;
        while(file.hasNext()){
            // crosses all the inputs
            for(int i = 0; i < 10; i++){
                file.next();
            }
            file.next();

            // checks the outputs and count the correct ones
            for(int i = 0; i < 4; i++){
                aux = file.next();
                if(aux.length() == 2 || aux.length() == 3 || aux.length() == 4 || aux.length() == 7){
                    count++;
                }
            }
        }

        System.out.println(count);
    }   
}
