package KI306.Markovich.Lab3;

/**
 * Інтерфейс, що визначає можливість судноплавства.
 */
public interface Navigable {
    /**
     * Перевіряє, чи дозволено прохід кораблів.
     * @return true, якщо навігація дозволена
     */
    boolean isNavigationAllowed();

    /**
     * Оголошує штормове попередження.
     */
    void declareStormWarning();
}