package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day10 {
    public static void main(String[] args) {
        File fd = new File("day10/input_test.txt");
        // File fd = new File("day10/input.txt");
        Scanner file = null;

        try {
            file = new Scanner(fd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        char opener;
        int sum = 0;
        while (file.hasNextLine()) {
            line = file.nextLine();
            for(int i = 0; i < line.length(); i++){
                opener = line.charAt(i);
                if(!hasCloser(line,i+1,getCloser(opener))){
                    sum += valueCloser(opener);
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static int valueCloser(char opener){
        switch(opener){
            case '(':
                return 3;
            case '[':
                return 57;
            case '<':
                return 25137;
            case '{':
                return 1197;
        }

        return 0;
    }

    public static boolean hasCloser(String line,int i, char closer){
        for(int j = i; j < line.length(); j++){
            if(closer == line.charAt(j)){
                return true;
            }
        }
        return false;
    }

    public static char getCloser(char opener){
        switch(opener){
            case '(':
                return ')';
            case '[':
                return ']';
            case '<':
                return '>';
            case '{':
                return '}';
        }

        return '.';
    }

}
