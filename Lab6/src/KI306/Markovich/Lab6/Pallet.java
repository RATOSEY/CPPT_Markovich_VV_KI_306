package KI306.Markovich.Lab6;

/**
 * Клас "Палета" для тестування.
 * Реалізує порівняння за кількістю ящиків на ній.
 */
public class Pallet implements Comparable<Pallet> {
    private int itemsCount;
    private String type;

    public Pallet(String type, int itemsCount) {
        this.type = type;
        this.itemsCount = itemsCount;
    }

    @Override
    public int compareTo(Pallet other) {
        // Порівнюємо палети за кількістю речей
        return this.itemsCount - other.itemsCount;
    }

    @Override
    public String toString() {
        return "Pallet [" + type + ", речей: " + itemsCount + " шт]";
    }
}