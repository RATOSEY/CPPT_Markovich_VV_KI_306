package KI306.Markovich.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас "Море", що розширює Водойму та реалізує інтерфейс судноплавства.
 * @author Markovich
 */
public class Sea extends WaterBody implements Navigable {
    
    private double salinity; // Солоність у проміле
    private boolean hasStorm;

    /**
     * Конструктор.
     * @param name Назва моря
     * @param len Довжина
     * @param wid Ширина
     * @param depth Глибина
     * @param salinity Солоність
     * @throws FileNotFoundException
     */
    public Sea(String name, double len, double wid, double depth, double salinity) throws FileNotFoundException {
        super(name, len, wid, depth); // Виклик конструктора батька
        this.salinity = salinity;
        this.hasStorm = false;
        log("Створено море. Солоність: " + salinity + " проміле.");
    }

    // Реалізація абстрактного методу
    @Override
    public void analyzeEcosystem() {
        String ecoType = (salinity > 35) ? "Солона (океанічна)" : "Слабосолона";
        System.out.println("Екосистема моря: " + ecoType);
        log("Проведено аналіз екосистеми: " + ecoType);
    }

    // Реалізація методу інтерфейсу
    @Override
    public boolean isNavigationAllowed() {
        boolean allowed = !hasStorm;
        log("Перевірка навігації. Дозволено: " + allowed);
        return allowed;
    }

    // Реалізація методу інтерфейсу
    @Override
    public void declareStormWarning() {
        this.hasStorm = true;
        System.out.println("УВАГА! Штормове попередження на морі " + name);
        log("Оголошено шторм!");
    }
    
    // Власний метод моря
    public void calmDown() {
        this.hasStorm = false;
        System.out.println("Море заспокоїлось.");
        log("Шторм закінчився.");
    }
    
    // Перевизначення методу toString() (або printInfo)
    @Override
    public void printInfo() {
        super.printInfo(); // Виклик методу батька
        System.out.println("Тип: Море | Солоність: " + salinity + "‰ | Шторм: " + hasStorm);
    }
}