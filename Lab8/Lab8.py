import math
import pickle
import sys

# Лабораторна робота №8
# Виконав: Студент групи KI-306 Маркович
# Варіант: 12

class CalcException(Exception):
    """Клас для власних помилок обчислення."""
    pass

def calculate_expression(x_deg):
    """
    Обчислює вираз y = sin(x) / tg(4x).
    
    :param x_deg: Значення x у градусах.
    :return: Результат обчислення (float).
    :raises CalcException: Якщо знаменник дорівнює нулю.
    """
    # Переведення градусів у радіани
    x_rad = math.radians(x_deg)
    
    # Обчислення знаменника: tg(4x)
    denominator = math.tan(4 * x_rad)
    
    # Перевірка на ділення на нуль (або дуже мале число)
    if abs(denominator) < 1e-9:
        raise CalcException("Помилка: знаменник tg(4x) занадто близький до нуля.")
        
    y = math.sin(x_rad) / denominator
    return y

def write_txt(filename, data):
    """Записує результат у текстовий файл."""
    with open(filename, 'w') as f:
        f.write(str(data))
    print(f"Дані записано у текстовий файл {filename}")

def read_txt(filename):
    """Зчитує результат з текстового файлу."""
    try:
        with open(filename, 'r') as f:
            data = float(f.read())
            print(f"Зчитано з текстового файлу: {data}")
            return data
    except FileNotFoundError:
        print(f"Файл {filename} не знайдено.")
    except ValueError:
        print("Помилка формату даних у файлі.")

def write_bin(filename, data):
    """Записує результат у двійковий файл (використовуючи pickle)."""
    with open(filename, 'wb') as f:
        pickle.dump(data, f)
    print(f"Дані записано у двійковий файл {filename}")

def read_bin(filename):
    """Зчитує результат з двійкового файлу."""
    try:
        with open(filename, 'rb') as f:
            data = pickle.load(f)
            print(f"Зчитано з двійкового файлу: {data}")
            return data
    except FileNotFoundError:
        print(f"Файл {filename} не знайдено.")
    except pickle.UnpicklingError:
        print("Помилка читання двійкового файлу.")

def main():
    """Головна функція програми."""
    try:
        x_input = int(input("Введіть значення x (градуси): "))
        
        # 1. Обчислення
        result = calculate_expression(x_input)
        print(f"Результат y = {result}")
        
        # 2. Робота з текстовим файлом
        txt_file = "lab8_result.txt"
        write_txt(txt_file, result)
        read_txt(txt_file)
        
        # 3. Робота з двійковим файлом
        bin_file = "lab8_result.bin"
        write_bin(bin_file, result)
        read_bin(bin_file)
        
    except ValueError:
        print("Помилка: введіть коректне ціле число.")
    except CalcException as e:
        print(f"Арифметична помилка: {e}")
    except Exception as e:
        print(f"Невідома помилка: {e}")

if __name__ == "__main__":
    main()