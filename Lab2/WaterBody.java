package KI306.Markovich.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Клас, що реалізує предметну область "Водойма".
 * @author Markovich
 * @version 1.0
 */
public class WaterBody {
    
    // Поля класу (композиція - об'єкти інших класів)
    private String name;
    private Location location;
    private Dimensions dimensions;
    private WaterQuality quality;
    private PrintWriter logger;

    /**
     * Конструктор без параметрів.
     * Створює водойму за замовчуванням.
     * @throws FileNotFoundException якщо не вдалося створити файл логу
     */
    public WaterBody() throws FileNotFoundException {
        this.name = "Unknown Lake";
        this.location = new Location("Unknown", 0.0, 0.0);
        this.dimensions = new Dimensions(100, 50, 5);
        this.quality = new WaterQuality(15.0, "Clean");
        
        logger = new PrintWriter(new File("WaterBodyLog.txt"));
        logger.println("Створено нову водойму (default): " + name);
        logger.flush();
    }

    /**
     * Конструктор з параметрами.
     * @param name Назва водойми
     * @param region Регіон розташування
     * @param length Довжина (м)
     * @param width Ширина (м)
     * @param depth Глибина (м)
     * @throws FileNotFoundException помилка створення логу
     */
    public WaterBody(String name, String region, double length, double width, double depth) throws FileNotFoundException {
        this.name = name;
        this.location = new Location(region, 0, 0);
        this.dimensions = new Dimensions(length, width, depth);
        this.quality = new WaterQuality(12.0, "Normal");
        
        logger = new PrintWriter(new File("WaterBodyLog.txt"));
        logger.println("Створено нову водойму: " + name + " у регіоні " + region);
        logger.flush();
    }

    // --- Методи дії (Business Logic) ---

    /**
     * Обчислює об'єм водойми.
     * @return об'єм у кубічних метрах
     */
    public double calculateVolume() {
        double vol = dimensions.length * dimensions.width * dimensions.avgDepth;
        log("Обчислено об'єм: " + vol + " м3");
        return vol;
    }

    /**
     * Змінює температуру води.
     * @param newTemp нова температура
     */
    public void changeTemperature(double newTemp) {
        double oldTemp = quality.temperature;
        quality.temperature = newTemp;
        log("Температуру змінено з " + oldTemp + " на " + newTemp);
    }

    /**
     * Проводить очищення водойми, покращуючи стан.
     */
    public void cleanWater() {
        quality.status = "Very Clean";
        log("Водойму очищено. Поточний стан: " + quality.status);
    }

    /**
     * Забруднює водойму (наприклад, через викиди).
     */
    public void polluteWater() {
        quality.status = "Polluted";
        log("УВАГА! Водойму забруднено. Стан: " + quality.status);
    }

    /**
     * Змінює назву водойми.
     * @param newName нова назва
     */
    public void rename(String newName) {
        String oldName = this.name;
        this.name = newName;
        log("Водойму перейменовано з " + oldName + " на " + newName);
    }
    
    /**
     * Встановлює нову глибину (наприклад, після посухи).
     * @param newDepth нова глибина
     */
    public void setDepth(double newDepth) {
        dimensions.avgDepth = newDepth;
        log("Змінено середню глибину на: " + newDepth + " м");
    }

    /**
     * Повертає інформацію про розміри.
     * @return рядок з розмірами
     */
    public String getDimensionsInfo() {
        log("Запитано інформацію про розміри.");
        return "L: " + dimensions.length + ", W: " + dimensions.width + ", D: " + dimensions.avgDepth;
    }
    
    /**
     * Перевіряє, чи придатна вода для купання.
     * @return true, якщо вода чиста і тепла
     */
    public boolean isSafeForSwimming() {
        boolean safe = quality.status.contains("Clean") && quality.temperature > 18.0;
        log("Перевірка на безпеку купання: " + (safe ? "Безпечно" : "Небезпечно"));
        return safe;
    }

    /**
     * Виводить повну інформацію про об'єкт.
     */
    public void printInfo() {
        System.out.println("====== INFO ======");
        System.out.println("Водойма: " + name);
        System.out.println("Розташування: " + location.region);
        System.out.println("Стан води: " + quality.status + ", Температура: " + quality.temperature);
        System.out.println("Об'єм: " + calculateVolume());
        log("Виведено інформацію в консоль.");
    }

    /**
     * Закриває файл логу.
     * Необхідно викликати перед завершенням роботи.
     */
    public void closeLog() {
        if (logger != null) {
            logger.println("Роботу завершено. Файл закрито.");
            logger.close();
        }
    }
    
    /**
     * Приватний метод для запису в лог.
     */
    private void log(String message) {
        if (logger != null) {
            logger.println(message);
            logger.flush();
        }
    }
}

// --- Внутрішні класи-компоненти (для структури) ---

/**
 * Клас для опису розташування.
 */
class Location {
    String region;
    double lat;
    double lon;

    public Location(String region, double lat, double lon) {
        this.region = region;
        this.lat = lat;
        this.lon = lon;
    }
}

/**
 * Клас для опису фізичних розмірів.
 */
class Dimensions {
    double length;
    double width;
    double avgDepth;

    public Dimensions(double length, double width, double avgDepth) {
        this.length = length;
        this.width = width;
        this.avgDepth = avgDepth;
    }
}

/**
 * Клас для опису якості води.
 */
class WaterQuality {
    double temperature;
    String status;

    public WaterQuality(double temperature, String status) {
        this.temperature = temperature;
        this.status = status;
    }
}