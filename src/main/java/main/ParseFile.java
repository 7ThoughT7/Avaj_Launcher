package main;

import model.Simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ParseFile {

    String HELICOPTER = "Helicopter";
    String JETPLANE = "JetPlane";
    String BALOON = "Baloon";
    int B = 1;
    int H = 1;
    int J = 1;

    public boolean isEmptyFile(String fileName) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            if (bufferedReader.readLine() == null) {
                System.err.println("Error: file is empty");
                return false;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error: invalid argument", e);
        }
        return true;
    }

    public boolean wrongNumberAndTypeParameters(String newString) {
        String[] arrayParameters = newString.split(" ");
        if (arrayParameters.length > 1) {
            System.err.println("Error: wrong number of parameters");
            return false;
        }
        return true;
    }

    public int amountLinesToFile(String newString) {
        int amount = 0;
        try (Reader reader = new FileReader(newString);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String lineFile = bufferedReader.readLine();

            while (lineFile != null) {
                lineFile = bufferedReader.readLine();
                amount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    public String[] readFile(String newString) {
        String[] result = new String[amountLinesToFile(newString)];
        int i = 0;

        try (Reader reader = new FileReader(newString);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
            String lineFile = bufferedReader.readLine();

            while (lineFile != null) {
                result[i] = lineFile;
                lineFile = bufferedReader.readLine();
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void checkFirstLineToFile(String first) {
        String[] mas = first.split(" ");
        int iterationCount;
        if (mas.length > 1) {
            System.out.println("Неверный первый параметр файла");
            return;
        }
        try {
            iterationCount = Integer.parseInt(mas[0]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат первого параметра файла");
            return;
        }
        if (iterationCount <= 0) {
            System.out.println("Первый параметр файла не может быть отрицательным числом");
            return;
        }
        if (iterationCount > 1000) {
            System.out.println("IDEA сломается с таким количеством итераций:) Введи первый параметр из диапазона [1;50]");
        }
    }

    public int checkOtherLineToFile(String[] mas) {
        if (mas.length != 5) {
            System.out.println("Неверное количество параметров в строке");
            return 0;
        }

        if (!mas[0].equals(HELICOPTER) && !mas[0].equals(JETPLANE) && !mas[0].equals(BALOON)) {
            System.out.println("Неверный тип летательного аппарата");
            return 0;
        }

        if (mas[0].charAt(0) != mas[1].charAt(0)) {
            System.out.println("Неверное имя летательного аппарата");
            return 0;
        } else {
            int s = Integer.parseInt(mas[1].substring(1));
            String a = mas[1].substring(0, 1);
            if (a.contains("H")) {
                if (H == s) {
                    H++;
                } else {
                    System.out.println("Неверное имя летательного аппарата (второй параметр)");
                    return 0;
                }
            } else if (a.contains("B")) {
                if (B == s) {
                    B++;
                } else {
                    System.out.println("Неверное имя летательного аппарата (второй параметр)");
                    return 0;
                }
            } else if (a.contains("J")) {
                if (J == s) {
                    J++;
                } else {
                    System.out.println("Неверное имя летательного аппарата (второй параметр)");
                    return 0;
                }
            }
        }
        for (int i = 2; i < mas.length; i++) {
            checkFirstLineToFile(mas[i]);
        }
        return 1;
    }

    public List<Simulation> splitFileToMass(String[] second) {
        List<Simulation> simulationList = new ArrayList<>();
        int j;
        for (int i = 1; i < second.length; i++) {
            String[] mas = second[i].split(" ");
            if (checkOtherLineToFile(mas) == 1) {
                String type = mas[0];
                String name = mas[1];
                int longitude = Integer.parseInt(mas[2]);
                int latitude = Integer.parseInt(mas[3]);
                int height = Math.min(Integer.parseInt(mas[4]), 100);
                Simulation simulation = new Simulation(type, name, longitude, latitude, height);
                simulationList.add(simulation);
            } else {
                break;
            }
        }
        return simulationList;
    }
}
