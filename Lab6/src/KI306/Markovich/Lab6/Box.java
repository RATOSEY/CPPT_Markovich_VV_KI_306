package KI306.Markovich.Lab6;

/**
 * Клас "Коробка" для тестування.
 * Реалізує порівняння за вагою.
 */
public class Box implements Comparable<Box> {
    private int weight;
    private String label;

    public Box(String label, int weight) {
        this.label = label;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Box other) {
        // Порівнюємо коробки за вагою
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "Box [" + label + ", вага: " + weight + "кг]";
    }
}