package KI306.Markovich.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас для обчислення виразу та роботи з файлами (txt/bin).
 * @author Markovich
 */
public class CalcWFio {
    
    private double result;

    /**
     * Обчислює вираз y = sin(x) / tg(4x).
     * @param x Кут у градусах
     * @throws CalcException Якщо знаменник = 0
     */
    public void calculate(int x) throws CalcException {
        double rad = Math.toRadians(x);
        double denominator = Math.tan(4 * rad);

        if (Math.abs(denominator) < 1e-9 || Double.isNaN(denominator)) {
            throw new CalcException("Знаменник tg(4x) дорівнює нулю.");
        }
        
        result = Math.sin(rad) / denominator;
    }

    /**
     * Повертає збережений результат.
     */
    public double getResult() {
        return result;
    }

    /**
     * Записує результат у текстовий файл.
     * @param fName Ім'я файлу
     * @throws FileNotFoundException
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f", result);
        f.close();
    }

    /**
     * Зчитує результат з текстового файлу.
     * @param fName Ім'я файлу
     * @throws FileNotFoundException
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("Файл " + fName + " не знайдено.");
            }
        } catch (FileNotFoundException ex) {
            System.err.print(ex.getMessage());
        }
    }

    /**
     * Записує результат у двійковий файл.
     * @param fName Ім'я файлу
     * @throws IOException
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Зчитує результат з двійкового файлу.
     * @param fName Ім'я файлу
     * @throws IOException
     */
    public void readResBin(String fName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
}