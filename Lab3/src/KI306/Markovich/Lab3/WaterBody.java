package KI306.Markovich.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Абстрактний клас, що реалізує базову водойму.
 * @author Markovich
 * @version 1.0
 */
public abstract class WaterBody {
    
    protected String name;
    protected Dimensions dimensions; // protected, щоб бачили нащадки
    protected PrintWriter logger;

    /**
     * Конструктор базового класу.
     * @param name Назва
     * @param len Довжина
     * @param wid Ширина
     * @param depth Глибина
     * @throws FileNotFoundException
     */
    public WaterBody(String name, double len, double wid, double depth) throws FileNotFoundException {
        this.name = name;
        this.dimensions = new Dimensions(len, wid, depth);
        logger = new PrintWriter(new File("SeaLog.txt")); // Записуємо в файл
        log("Створено абстрактну водойму: " + name);
    }

    /**
     * Абстрактний метод: кожна конкретна водойма має свою екосистему.
     */
    public abstract void analyzeEcosystem();

    public double calculateVolume() {
        return dimensions.length * dimensions.width * dimensions.avgDepth;
    }

    public void printInfo() {
        System.out.println("Водойма: " + name);
        System.out.println("Об'єм: " + calculateVolume());
        log("Запитано інформацію.");
    }

    public void closeLog() {
        if (logger != null) {
            logger.println("Завершення роботи.");
            logger.close();
        }
    }
    
    protected void log(String msg) {
        if (logger != null) {
            logger.println(msg);
            logger.flush();
        }
    }
}

// Допоміжний клас
class Dimensions {
    double length, width, avgDepth;
    public Dimensions(double l, double w, double d) {
        length = l; width = w; avgDepth = d;
    }
}