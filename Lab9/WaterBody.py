# Файл: WaterBody.py

class WaterBody:
    """
    Базовий клас, що описує водойму.
    """
    def __init__(self, name, area):
        """
        Конструктор базового класу.
        :param name: Назва водойми (str)
        :param area: Площа поверхні у кв. км (float)
        """
        self.name = name
        self.area = area

    def get_info(self):
        """Повертає рядок з інформацією про водойму."""
        return f"Водойма: {self.name}, Площа: {self.area} кв.км"

    def evaporate(self):
        """Імітація випаровування води."""
        print(f"Вода випаровується з поверхні {self.name}...")