package KI306.Markovich.Lab2;

import java.io.FileNotFoundException;

/**
 * Драйвер-клас для демонстрації роботи класу WaterBody.
 * @author Markovich
 */
public class WaterBodyDriver {

    public static void main(String[] args) {
        try {
            // 1. Створення об'єкта
            WaterBody lake = new WaterBody("Svitiaz", "Volyn", 5000, 3000, 7.5);

            // 2. Виклик методів
            lake.printInfo();
            
            lake.changeTemperature(20.5);
            lake.isSafeForSwimming(); // Має бути true
            
            lake.polluteWater();
            lake.printInfo();
            
            lake.cleanWater();
            lake.setDepth(6.0); // Рівень води впав
            
            System.out.println(lake.getDimensionsInfo());

            // 3. Завершення роботи
            lake.closeLog();
            System.out.println("Програма завершена. Перевірте файл WaterBodyLog.txt");

        } catch (FileNotFoundException e) {
            System.err.println("Помилка доступу до файлу: " + e.getMessage());
        }
    }
}