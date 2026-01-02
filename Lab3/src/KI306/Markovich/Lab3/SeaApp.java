package KI306.Markovich.Lab3;

import java.io.FileNotFoundException;

public class SeaApp {
    public static void main(String[] args) throws FileNotFoundException {
        // Створення об'єкта підкласу Sea
        Sea blackSea = new Sea("Чорне море", 1150000, 580000, 1240, 18.0);

        // 1. Виклик методів базового класу
        blackSea.printInfo();
        
        // 2. Виклик абстрактного методу
        blackSea.analyzeEcosystem();

        // 3. Виклик методів інтерфейсу
        System.out.println("Чи можна пливти? " + blackSea.isNavigationAllowed());
        
        blackSea.declareStormWarning();
        System.out.println("Чи можна пливти зараз? " + blackSea.isNavigationAllowed());
        
        blackSea.calmDown();
        
        // Завершення
        blackSea.closeLog();
        System.out.println("Робота завершена. Перевірте файл SeaLog.txt");
    }
}