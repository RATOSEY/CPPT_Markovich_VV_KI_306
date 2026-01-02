import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab1MarkovichKI306 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        String fillInput;
        char fillChar;

        
        try {
            System.out.print("Введіть розмір квадратної матриці (ціле число): ");
            size = scanner.nextInt();
            scanner.nextLine(); // 
        } catch (Exception e) {
            System.err.println("Помилка: введено не число.");
            return;
        }

       
        System.out.print("Введіть один символ-заповнювач: ");
        fillInput = scanner.nextLine();

        if (fillInput.length() != 1) {
            System.err.println("Помилка: необхідно ввести рівно один символ.");
            return;
        }
        fillChar = fillInput.charAt(0);

       
        char[][] matrix = new char[size][];
        int half = size / 2;

        for (int i = 0; i < size; i++) {
            if (i < half) {
                
                matrix[i] = new char[half];
            } else {
               
                matrix[i] = new char[size - half];
            }

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = fillChar;
            }
        }

       
        printResult(matrix, size, half, "result.txt");
        
        scanner.close();
    }

    private static void printResult(char[][] matrix, int size, int half, String fileName) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i < half) {
                for (char c : matrix[i]) sb.append(c).append(" ");
                for (int j = 0; j < (size - half); j++) sb.append("  ");
            } else {
                for (int j = 0; j < half; j++) sb.append("  ");
                for (char c : matrix[i]) sb.append(c).append(" ");
            }
            sb.append("\n");
        }

        String result = sb.toString();
        System.out.println("Результат виконання:");
        System.out.print(result);

        try (PrintWriter out = new PrintWriter(new File(fileName))) {
            out.print(result);
        } catch (FileNotFoundException e) {
            System.err.println("Помилка запису у файл");
        }
    }
}