package KI306.Markovich.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Програма-драйвер для тестування методів читання/запису.
 * @author Markovich
 */
public class FioApp {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);

        System.out.print("Введіть x: ");
        int x = s.nextInt();

        try {
            // 1. Обчислюємо
            obj.calculate(x);
            System.out.println("Результат обчислення: " + obj.getResult());

            // 2. Робота з ТЕКСТОВИМ файлом
            obj.writeResTxt("textRes.txt");
            obj.readResTxt("textRes.txt");
            System.out.println("Зчитано з textRes.txt: " + obj.getResult());

            // 3. Робота з БІНАРНИМ файлом
            obj.writeResBin("BinRes.bin");
            obj.readResBin("BinRes.bin");
            System.out.println("Зчитано з BinRes.bin: " + obj.getResult());

        } catch (CalcException e) {
            System.out.println("Помилка обчислень: " + e.getMessage());
        }
        
        s.close();
    }
}