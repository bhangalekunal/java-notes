import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    // Volatile instance to ensure visibility across threads
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent instantiation using reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create an instance!");
        }
    }

    // Public method to provide global access point (Thread-safe with Double-Checked Locking)
    public static Singleton getInstance() {
        if (instance == null) {  // First check
            synchronized (Singleton.class) {
                if (instance == null) {  // Second check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Prevents creating a new instance during deserialization
    protected Object readResolve() {
        return getInstance();
    }

    // Prevents cloning of the singleton instance
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
