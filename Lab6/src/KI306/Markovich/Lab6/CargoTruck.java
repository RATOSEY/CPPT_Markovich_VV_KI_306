package KI306.Markovich.Lab6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Параметризований клас "Грузова машина".
 * @param <T> Тип вантажу, який має реалізовувати інтерфейс Comparable (для порівняння)
 */
public class CargoTruck<T extends Comparable<T>> {
    
    // Сховище для вантажу (список)
    private ArrayList<T> cargoHold;
    
    /**
     * Конструктор
     */
    public CargoTruck() {
        cargoHold = new ArrayList<>();
    }

    /**
     * Метод 1: Додавання вантажу (Place element)
     * @param item Елемент вантажу
     */
    public void loadCargo(T item) {
        cargoHold.add(item);
        System.out.println("Завантажено: " + item);
    }

    /**
     * Метод 2: Виймання вантажу за індексом (Remove element)
     * @param index Індекс елементу
     */
    public void unloadCargo(int index) {
        if (index >= 0 && index < cargoHold.size()) {
            T removed = cargoHold.remove(index);
            System.out.println("Вивантажено: " + removed);
        } else {
            System.out.println("Помилка: Невірний індекс вантажу.");
        }
    }

    /**
     * Метод 3: Пошук мінімального елементу (Варіант парний - Min)
     * @return Найменший елемент (наприклад, найлегший)
     */
    public T findMinCargo() {
        if (cargoHold.isEmpty()) {
            return null;
        }
        T min = cargoHold.get(0);
        for (T item : cargoHold) {
            // compareTo повертає < 0, якщо item менше min
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Метод 4: Виведення вмісту кузова
     */
    public void printTruckContents() {
        System.out.println("=== Вміст грузової машини ===");
        for (int i = 0; i < cargoHold.size(); i++) {
            System.out.println(i + ": " + cargoHold.get(i));
        }
        System.out.println("=============================");
    }
}