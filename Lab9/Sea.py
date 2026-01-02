# Файл: Sea.py
from WaterBody import WaterBody

class Sea(WaterBody):
    """
    Клас 'Море', що успадковує клас 'Водойма'.
    """
    def __init__(self, name, area, salinity, is_stormy=False):
        """
        Конструктор похідного класу.
        :param name: Назва (str)
        :param area: Площа (float)
        :param salinity: Солоність у проміле (float)
        :param is_stormy: Чи є зараз шторм (bool)
        """
        # Виклик конструктора батьківського класу
        super().__init__(name, area)
        self.salinity = salinity
        self.is_stormy = is_stormy

    def get_info(self):
        """
        Перевизначений метод (Override).
        Додає інформацію про солоність та стан моря.
        """
        base_info = super().get_info()
        storm_status = "Штормить" if self.is_stormy else "Спокійно"
        return f"Тип: Море | {base_info} | Солоність: {self.salinity}‰ | Шторм: {storm_status}"

    def set_storm_status(self, status):
        """Змінює статус шторму."""
        self.is_stormy = status
        print(f"Стан моря '{self.name}' змінено. Шторм: {self.is_stormy}")