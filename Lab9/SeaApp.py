# Файл: SeaApp.py
from Sea import Sea

def main():
    """
    Головна функція програми (точка входу).
    """
    # Створення об'єкта класу Sea
    black_sea = Sea("Чорне море", 436400, 18.0)

    # Виведення інформації
    print(black_sea.get_info())

    # Виклик методу базового класу
    black_sea.evaporate()

    # Зміна стану (специфічний метод класу Sea)
    black_sea.set_storm_status(True)

    # Перевірка змін
    print(black_sea.get_info())

    # Створення ще одного об'єкта
    dead_sea = Sea("Мертве море", 605, 342.0, is_stormy=False)
    print("\n" + dead_sea.get_info())

if __name__ == "__main__":
    main()