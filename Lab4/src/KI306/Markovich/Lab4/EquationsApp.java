package KI306.Markovich.Lab4;

import java.util.Scanner;
import java.io.*;

/**
 * Головний клас-драйвер для демонстрації роботи програми.
 * @author Markovich
 */
public class EquationsApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter fout = null;
        
        try {
            // Підготовка файлу для запису результатів
            fout = new PrintWriter(new File("MyResult.txt"));
            
            System.out.print("Введіть значення x (у градусах): ");
            int x = in.nextInt();

            // Створення об'єкта класу обчислень
            Equations eq = new Equations();
            
            try {
                // Спроба обчислити вираз
                double result = eq.calculate(x);
                
                // Вивід результату
                System.out.println("Результат: y = " + result);
                fout.println("Результат обчислення при x = " + x + " градусів: y = " + result);
                
            } catch (CalcException ex) {
                // Обробка нашої власної помилки (ділення на нуль)
                System.out.print("Арифметична помилка: " + ex.getMessage());
                fout.print("Арифметична помилка: " + ex.getMessage());
            }

        } catch (FileNotFoundException ex) {
            // Помилка створення файлу
            System.out.println("Помилка роботи з файлом: " + ex.getMessage());
        } catch (Exception ex) {
            // Інші помилки (наприклад, ввели букви замість цифр)
            System.out.println("Невідома помилка: " + ex.getMessage());
        } finally {
            // Цей блок виконується завжди. Закриваємо ресурси.
            if (fout != null) {
                fout.flush();
                fout.close();
            }
            in.close();
        }
    }
}