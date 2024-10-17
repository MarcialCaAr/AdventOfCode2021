package day3;

import java.io.File;
import java.util.Scanner;

public class day3 {

    public static void main(String[] args) {
        // List<Integer> unos = new ArrayList<>(12);
        // List<Integer> ceros = new ArrayList<>(12);
        int[] unos = new int[12],ceros = new int[12];
        String gamma_rate = "", epsilon_rate = ""; 


        
        File fd = new File("day3/input.txt");
        Scanner file = null;
        try {
            String line = "";
            file = new Scanner(fd);

            //recorremos el archivo
            while(file.hasNext()){
                line = file.nextLine();
                //comprobamos que bit hay en cada posicion
                for(int i = 0; i<line.length();i++){
                    if(line.charAt(i) == '0'){
                        ceros[i]++;
                    }else{
                        unos[i]++;
                    }
                }
            }

            // comprobamos cual es el bit mayoritario
            for(int i=0;i<unos.length;i++){
                if(unos[i]>ceros[i]){
                    gamma_rate += "1";
                    epsilon_rate += "0";
                } else {
                    gamma_rate += "0";
                    epsilon_rate += "1";
                }
            }

            int sum = Integer.parseInt(epsilon_rate,2) * Integer.parseInt(gamma_rate,2);

            System.out.println(sum);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
