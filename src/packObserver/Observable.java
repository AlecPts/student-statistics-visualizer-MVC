package packObserver;

public interface Observable {
    public static void addObserver(Observer observer) {}
    public static void removeObserver(Observer observer) {}
    public static void notifyObservers() {}
}
