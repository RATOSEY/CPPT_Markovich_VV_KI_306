package KI306.Markovich.Lab4;

/**
 * Клас для обчислення виразу y = sin(x) / tg(4x).
 * @author Markovich
 */
public class Equations {

    /**
     * Метод обчислює вираз y = sin(x) / tg(4x).
     * @param x Кут у градусах
     * @return Результат обчислення
     * @throws CalcException Якщо знаменник дорівнює нулю або тангенс не існує
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        
        // Переводимо градуси в радіани для функцій Math
        rad = Math.toRadians(x);

        // Обчислюємо знаменник: tg(4x)
        double denominator = Math.tan(4 * rad);

        // Перевірка на ділення на нуль (або дуже мале число)
        // tg(4x) = 0, коли 4x = 0, 180, 360... (тобто x = 0, 45, 90...)
        if (Math.abs(denominator) < 1e-9 || Double.isNaN(denominator)) {
            throw new CalcException("Помилка: знаменник tg(4x) дорівнює нулю (ділення на 0).");
        }
        
        // Обчислення виразу
        y = Math.sin(rad) / denominator;
        return y;
    }
}