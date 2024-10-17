package day24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day24 {

    public static void main(String[] args) {

        int registers[] = new int[4];

        // File fd = new File("day24/input_test.txt");
        File fd = new File("day24/input.txt");
        Scanner file = null;

        // while(file.hasNextLine()){
        // System.out.println(file.next());
        // }

        long modelNumber = 999999999999L;
        int inpNumber = 0;
        int register = -1;
        String register2 = "";

        while (modelNumber > 0) {
            try {
                file = new Scanner(fd);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            inpNumber = 0;
            while (file.hasNextLine()) {
                String instruction = file.next();
                register = getRegister(file.next().charAt(0));
                // System.out.println(instruction + " " + register);
                System.out.println(inpNumber);
                switch (instruction) {
                    case "inp":
                        registers[register] = Integer.parseInt(Character.toString(Long.toString(modelNumber).charAt(inpNumber)));
                        inpNumber++;
                        break;

                    case "add":
                        register2 = file.next();
                        try {
                            registers[register] = registers[register] + Integer.parseInt(register2);
                        } catch (NumberFormatException e) {
                            registers[register] = registers[register] + registers[getRegister(register2.charAt(0))];
                        }
                        break;

                    case "mul":
                        register2 = file.next();
                        try {
                            registers[register] = registers[register] * Integer.parseInt(register2);
                        } catch (NumberFormatException e) {
                            registers[register] = registers[register] * registers[getRegister(register2.charAt(0))];
                        }
                        break;

                    case "div":
                        register2 = file.next();
                        try {
                            if (Integer.parseInt(register2) == 0)
                                break;
                            registers[register] = registers[register] / Integer.parseInt(register2);
                        } catch (NumberFormatException e) {
                            if (registers[getRegister(register2.charAt(0))] == 0)
                                break;
                            registers[register] = registers[register] / registers[getRegister(register2.charAt(0))];
                        }
                        break;

                    case "eql":
                        register2 = file.next();
                        try {
                            if (registers[register] == Integer.parseInt(register2))
                                registers[register] = 1;
                            else
                                registers[register] = 0;
                        } catch (NumberFormatException e) {
                            if (registers[register] == registers[getRegister(register2.charAt(0))])
                                registers[register] = 1;
                            else
                                registers[register] = 0;
                        }
                        break;

                    case "mod":
                        register2 = file.next();
                        try {
                            if (registers[register] < 0 || Integer.parseInt(register2) <= 0)
                                break;
                            registers[register] = registers[register] % Integer.parseInt(register2);
                        } catch (NumberFormatException e) {
                            if (registers[register] < 0 || registers[getRegister(register2.charAt(0))] <= 0)
                                break;
                            registers[register] = registers[register] % registers[getRegister(register2.charAt(0))];
                        }
                        break;
                }
                // System.out.println(modelNumber);
            }
            if (registers[getRegister('z')] == 0) {
                // System.out.println(modelNumber);
                break;
            }
            modelNumber--;
            while (Long.toString(modelNumber).contains("0"))
            modelNumber--;
        }

        // System.out.println(registers[getRegister('z')]);
    }

    public static int getRegister(char register) {
        switch (register) {
            case 'w':
                return 0;
            case 'x':
                return 1;
            case 'y':
                return 2;
            case 'z':
                return 3;
        }

        return -1;
    }

}
