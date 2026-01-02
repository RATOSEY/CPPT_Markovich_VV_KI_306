package KI306.Markovich.Lab4;

/**
 * Клас власного виключення для арифметичних помилок.
 * @author Markovich
 */
public class CalcException extends ArithmeticException {
    
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}