package day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2_2 {

    
    public static void main(String[] args) {
        List<String> direction = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();

        int x = 0, y=0, aim = 0;

        File fd = new File("day2/input.txt");
        Scanner file = null;
        try {
            file = new Scanner(fd);

            while (file.hasNext()) {
                direction.add(file.next());
                distance.add(file.nextInt());
            }

            for(int i = 0; i < direction.size(); i++) {
                switch(direction.get(i)){
                    case "forward": 
                        x += distance.get(i); 
                        y += aim * distance.get(i);
                        break;
                    case "down": aim += distance.get(i); break;
                    case "up": aim -= distance.get(i); break;
                }
            }

            System.out.println(x*y);


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
