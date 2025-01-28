Here’s a list of **similar questions** related to designing and understanding immutability and related concepts in Java:

---

### **Immutability and Object Design Questions:**

1. **What are the differences between mutable and immutable classes?**  
   - Explain with examples of mutable (`ArrayList`) and immutable (`String`) classes.

2. **Why are `String` objects immutable in Java?**  
   - Discuss the design decisions and benefits of `String` immutability.

3. **How can immutability improve thread safety?**  
   - Explain how immutable objects help in concurrent programming.

4. **What is defensive copying, and why is it important in immutable classes?**  
   - Provide examples of defensive copying in constructors and getters.

5. **How can you make a collection (e.g., List, Map) immutable in Java?**  
   - Demonstrate using `Collections.unmodifiableList` or `List.of()`.

6. **What are some real-life scenarios where you should use immutable classes?**  
   - Examples: caching, constants, multi-threading.

7. **Can immutable objects have mutable fields? How can we handle this?**  
   - Discuss deep copying and unmodifiable views for mutable fields.

8. **What are the differences between immutability and final keyword in Java?**  
   - Explain how `final` impacts variables, methods, and classes.

9. **How does immutability impact performance in Java?**  
   - Discuss the trade-offs in terms of memory usage and efficiency.

10. **What are the limitations of immutability, and when should you avoid it?**  
    - Scenarios where immutability may not be ideal.

---

### **Advanced and Related Topics:**

11. **How does immutability help in functional programming?**  
    - Discuss the role of immutability in functional paradigms (e.g., lambdas, streams).

12. **What is the Flyweight design pattern, and how does it relate to immutability?**  
    - Explain shared instances and memory optimization using immutability.

13. **How can you implement immutability in an inherited class?**  
    - Discuss challenges and approaches to making subclasses immutable.

14. **What is the difference between shallow copy and deep copy?**  
    - How does this relate to immutability?

15. **How does immutability help in designing value objects?**  
    - Explain the importance of immutability in representing values like `Money` or `Coordinates`.

16. **Can you make a class immutable without declaring it final?**  
    - Explore how encapsulation and private constructors help.

17. **What is the difference between `Collections.unmodifiableList` and `List.of()`?**  
    - Explain how they create immutable collections.

18. **How does immutability interact with serialization in Java?**  
    - Discuss the role of `readResolve()` in maintaining immutability during deserialization.

19. **How does immutability simplify debugging and testing?**  
    - Explore how predictable state aids in these processes.

20. **What is an effectively immutable object, and how is it different from a strictly immutable object?**  
    - Explain how immutability is achieved in objects that are modified only during initialization.

---

### **Practical Implementation Questions:**

21. **How do you create an immutable class with nested objects?**  
    - Discuss deep copying nested mutable objects.

22. **What changes are required to make an existing mutable class immutable?**  
    - Steps to refactor a class for immutability.

23. **Can we create an immutable class with only static methods? Why or why not?**  
    - Explore design choices and use cases.

24. **How can you test if a class is truly immutable?**  
    - Write a test to verify immutability (e.g., by attempting reflection, cloning, etc.).

25. **How does immutability affect garbage collection in Java?**  
    - Explain how fewer object mutations lead to fewer allocations.

---

These questions are perfect for deep-diving into the principles of immutability, object-oriented design, and Java programming practices. Let me know if you'd like detailed answers to any of these! 😊



# Que 1
### **Differences Between Mutable and Immutable Classes**

| **Aspect**                  | **Mutable Classes**                          | **Immutable Classes**                           |
|-----------------------------|----------------------------------------------|------------------------------------------------|
| **Definition**              | Objects can be modified after creation.     | Objects cannot be modified after creation.     |
| **State**                   | The internal state can change over time.    | The internal state remains constant.           |
| **Thread-Safety**           | Not thread-safe unless explicitly handled.  | Thread-safe due to unchanging state.           |
| **Examples**                | `ArrayList`, `HashMap`, `StringBuilder`     | `String`, `Integer`, `BigDecimal`              |
| **Performance**             | Better for frequent modifications.          | Better for situations with constant values.    |
| **Usage**                   | Used where changes to data are required.    | Used where data consistency and safety are important. |
| **Memory Efficiency**       | May reuse memory but risk side effects.     | May create more objects but avoids side effects. |

---

### **Mutable Class Example: `ArrayList`**

`ArrayList` is a mutable class because you can modify its contents after creation.

```java
import java.util.ArrayList;

public class MutableExample {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        
        System.out.println("Original List: " + list);

        // Modify the list
        list.add("Cherry");
        list.remove("Banana");
        
        System.out.println("Modified List: " + list);
    }
}
```

**Output:**
```
Original List: [Apple, Banana]
Modified List: [Apple, Cherry]
```

**Key Points:**
- `list.add()` and `list.remove()` modify the original object.
- The state of the `ArrayList` changes after modifications.

---

### **Immutable Class Example: `String`**

`String` is an immutable class because any modification creates a new object rather than altering the original.

```java
public class ImmutableExample {
    public static void main(String[] args) {
        // Create a String
        String str = "Hello";
        System.out.println("Original String: " + str);

        // Modify the String
        String newStr = str.concat(" World");
        System.out.println("Modified String: " + newStr);

        // Check if original String changed
        System.out.println("Original String remains: " + str);
    }
}
```

**Output:**
```
Original String: Hello
Modified String: Hello World
Original String remains: Hello
```

**Key Points:**
- The `concat()` method does not modify `str`; instead, it creates a new `String` object.
- The original `str` remains unchanged.

---

### **Why Choose Mutable or Immutable Classes?**

#### **Use Mutable Classes When:**
1. You need to frequently modify the object's state (e.g., `ArrayList` for dynamic collections).
2. Performance matters, and creating new objects is expensive.

#### **Use Immutable Classes When:**
1. You need thread-safe operations without synchronization (e.g., `String` in multi-threaded environments).
2. Data consistency and integrity are critical (e.g., keys in a `HashMap`).

---

### **Additional Notes:**
- **Immutable Objects in Collections:** Immutable objects (e.g., `String`) are safe as keys in collections because their hash code won't change after being added to the collection.
- **Custom Immutable Classes:** You can create your own immutable classes by following the principles [outlined here](#).

Let me know if you'd like a deeper dive into any specific aspect! 😊

# Que 2
### **Why Are String Objects Immutable in Java?**

String objects in Java are **immutable**, meaning their value cannot be changed after creation. This is a deliberate design decision made by the Java creators to ensure performance, security, and efficient memory usage. Below, we’ll discuss the **reasons for String immutability** and its **benefits**.

---

### **Reasons for String Immutability**

1. **Security Reasons**  
   - Strings are often used to handle sensitive data like database credentials, file paths, network URLs, etc.
   - If `String` were mutable, malicious code could alter the content of a `String` reference, causing security vulnerabilities.
     - Example: A mutable `String` containing a file path could be modified by another thread to access unintended files.

2. **String Pooling (Performance Optimization)**  
   - Java uses a **String Pool** to manage memory efficiently. When two `String` objects have the same content, they can point to the same memory location.
   - If `String` were mutable, modifying one instance would unintentionally affect all references to that instance, breaking the integrity of the String Pool.

     ```java
     String str1 = "Hello";
     String str2 = "Hello";
     System.out.println(str1 == str2); // true (same reference from the String Pool)
     ```

3. **Thread Safety**  
   - Immutability ensures that `String` objects can be safely shared across threads without requiring synchronization.
   - In multi-threaded environments, this avoids race conditions and the need for additional locking mechanisms.

4. **HashCode Consistency**  
   - Strings are frequently used as keys in collections like `HashMap` or `HashSet`. Their immutability ensures that their **hash code remains consistent** throughout their lifetime.
     - If `String` were mutable, changing its content would require updating its hash code, which could corrupt data structures like `HashMap`.

5. **Ease of Use in Java APIs**  
   - Many Java APIs (e.g., `ClassLoader`, `SecurityManager`) use `String` for configuration and identification. The immutability of `String` ensures these APIs remain reliable and predictable.

6. **Encapsulation of Internals**  
   - Making `String` immutable ensures that internal data structures (like character arrays) are not directly exposed or modified.

---

### **Benefits of String Immutability**

1. **Memory Efficiency**  
   - **String Pooling** minimizes memory usage by reusing objects. For example, literals like `"Hello"` are created once and reused wherever needed.
   - Without immutability, pooling would not be safe, and each `String` would need to have its own instance.

2. **Security**  
   - Sensitive data remains safe, as it cannot be accidentally or maliciously altered. For example:
     ```java
     String dbPassword = "MySecretPassword";
     // Cannot be modified by another part of the program
     ```

3. **Thread Safety Without Synchronization**  
   - Immutable `String` objects eliminate the need for complex synchronization mechanisms when shared across multiple threads.

4. **Improved Performance in Hash-Based Collections**  
   - The immutability of `String` ensures that the **hash code** and **equality comparison** remain stable, making operations like `HashMap` lookups faster and more reliable.

5. **Predictable Behavior**  
   - The immutability of `String` eliminates unintended side effects. Modifying a `String` reference does not impact other parts of the program holding the same reference.

6. **Consistency in APIs**  
   - Many Java APIs rely on `String` immutability. For example:
     - `String` literals are stored and reused efficiently.
     - `StringBuffer` and `StringBuilder` exist for mutable string operations, maintaining separation of concerns.

---

### **Illustrative Example of String Immutability**

```java
public class StringImmutability {
    public static void main(String[] args) {
        String str = "Hello";

        // Modify String
        String newStr = str.concat(" World");
        
        // Original String remains unchanged
        System.out.println("Original String: " + str); // Hello
        System.out.println("Modified String: " + newStr); // Hello World
    }
}
```

**Output:**
```
Original String: Hello
Modified String: Hello World
```

- The original `str` remains unchanged, and a new `String` object is created for `newStr`.

---

### **Counterpart: Mutable String Objects**

Java provides mutable string alternatives:
1. **`StringBuilder`** (not thread-safe)  
2. **`StringBuffer`** (thread-safe)  

These classes allow modification of strings and should be used in scenarios where frequent modifications are required.

---

### **Conclusion**

The immutability of `String` in Java is a well-thought-out design decision that improves **security**, **performance**, **memory management**, and **thread safety**. While immutability introduces a slight overhead in terms of object creation, its benefits far outweigh the costs, making `String` a reliable and efficient part of the Java language.



# Que 3
### **How Can Immutability Improve Thread Safety?**

Immutability simplifies **thread safety** because immutable objects cannot be changed after they are created. This ensures that multiple threads can safely access and share the same object without any risk of data corruption, race conditions, or inconsistent states.

---

### **How Immutable Objects Help in Concurrent Programming**

1. **No State Modification**
   - Since immutable objects cannot be modified, multiple threads can access the same instance without synchronization. There is no need to worry about one thread altering the state of the object while another is reading it.

   Example:
   ```java
   public class ImmutableExample {
       public static void main(String[] args) {
           String str = "Hello";
           
           Thread thread1 = new Thread(() -> System.out.println("Thread 1: " + str));
           Thread thread2 = new Thread(() -> System.out.println("Thread 2: " + str));
           
           thread1.start();
           thread2.start();
       }
   }
   ```
   **Output (Safe Execution):**
   ```
   Thread 1: Hello
   Thread 2: Hello
   ```
   Both threads can safely access the same `String` object since it is immutable.

---

2. **Consistency Across Threads**
   - Immutable objects guarantee that their state remains the same across all threads, regardless of how many threads use them.
   - This consistency eliminates bugs caused by unexpected changes to shared data.

   For example, consider a shared object holding a configuration:
   ```java
   public final class ImmutableConfig {
       private final String url;
       
       public ImmutableConfig(String url) {
           this.url = url;
       }

       public String getUrl() {
           return url;
       }
   }

   // Shared immutable instance
   ImmutableConfig config = new ImmutableConfig("http://example.com");
   ```
   Since the `ImmutableConfig` object is immutable, multiple threads can use it without fear of one thread modifying the URL.

---

3. **Eliminates Synchronization**
   - With mutable objects, you need locks or other synchronization mechanisms to ensure thread safety, which can introduce complexity, deadlocks, and performance issues.
   - Immutable objects eliminate the need for synchronization because they cannot be altered after creation.

   Example:
   Without immutability:
   ```java
   public class MutableCounter {
       private int count = 0;

       public synchronized void increment() {
           count++;
       }

       public synchronized int getCount() {
           return count;
       }
   }
   ```
   With immutability:
   ```java
   public final class ImmutableCounter {
       private final int count;

       public ImmutableCounter(int count) {
           this.count = count;
       }

       public ImmutableCounter increment() {
           return new ImmutableCounter(count + 1);
       }

       public int getCount() {
           return count;
       }
   }
   ```

   - In the immutable version, no locks are needed because each modification creates a new object, leaving the original unchanged.

---

4. **Easier Debugging**
   - Immutable objects simplify debugging in concurrent programming. Since the state of the object cannot change, you don't need to track changes caused by other threads.
   - With mutable objects, debugging thread-related bugs can be challenging, especially when data changes unexpectedly.

---

5. **Safe Publication**
   - Immutability ensures **safe publication**, meaning once an object is created and made visible to other threads, they will always see the same state.
   - With mutable objects, without proper synchronization, threads may see stale or inconsistent data.

   Example (Safe with Immutability):
   ```java
   public class ImmutableSharedData {
       private final String data;

       public ImmutableSharedData(String data) {
           this.data = data;
       }

       public String getData() {
           return data;
       }
   }

   public class SafePublication {
       private static final ImmutableSharedData sharedData = new ImmutableSharedData("Shared Value");

       public static ImmutableSharedData getSharedData() {
           return sharedData;
       }
   }
   ```
   Here, `sharedData` is immutable and safely published without requiring additional synchronization.

---

### **Key Characteristics of Immutable Objects That Aid Thread Safety**

1. **Final Fields:**
   - All fields in an immutable object are `final`, ensuring they cannot be reassigned after the object is constructed.
   
   Example:
   ```java
   public final class Immutable {
       private final String value;
       
       public Immutable(String value) {
           this.value = value;
       }

       public String getValue() {
           return value;
       }
   }
   ```

2. **No Setter Methods:**
   - Immutable objects do not provide methods to modify their state, further ensuring their immutability.

3. **Defensive Copies:**
   - When returning internal mutable objects (like arrays or collections), immutable classes use defensive copies to prevent external modification.
   
   Example:
   ```java
   public final class ImmutableArray {
       private final int[] array;

       public ImmutableArray(int[] array) {
           this.array = array.clone(); // Defensive copy
       }

       public int[] getArray() {
           return array.clone(); // Defensive copy
       }
   }
   ```

---

### **When to Use Immutable Objects in Concurrent Programming**

1. **Shared Resources:** When multiple threads access shared objects, immutable objects ensure safety without locking.
2. **Keys in Collections:** Immutable objects like `String` are ideal as keys in concurrent collections (`ConcurrentHashMap`) because their hash codes never change.
3. **Cache or Configuration:** Immutable objects are often used in caching mechanisms or shared configurations for reliability and consistency.

---

### **Conclusion**

Immutable objects are an essential tool in concurrent programming. They simplify thread safety by eliminating the need for synchronization, ensuring consistency, and preventing shared state modification. This leads to more predictable, reliable, and bug-free code in multi-threaded applications.

# Que 4
### **What is Defensive Copying?**

**Defensive copying** is the practice of creating a new copy of an object or data when passing it into or returning it from a method. This ensures that the original object remains unmodified, maintaining the integrity of an object's state.

Defensive copying is particularly important in **immutable classes** to prevent external code from modifying internal mutable fields, thus violating the immutability guarantee.

---

### **Why is Defensive Copying Important in Immutable Classes?**

1. **Ensures Immutability:**
   - Even if a class is declared as immutable, any internal mutable objects (like arrays, collections) can compromise its immutability if they are directly exposed.
   
2. **Prevents External Modification:**
   - Without defensive copying, external code could modify the internal state of an immutable object, leading to unpredictable behavior.

3. **Preserves Encapsulation:**
   - Defensive copying ensures that internal state is fully encapsulated within the object, preventing unintended side effects.

---

### **Examples of Defensive Copying**

#### 1. **In Constructors**
When an object with mutable fields is passed into the constructor, a defensive copy should be made to avoid directly referencing the mutable object.

**Example:**
```java
import java.util.Date;

public final class ImmutableClass {
    private final String name;
    private final Date dateOfBirth; // Mutable field

    public ImmutableClass(String name, Date dateOfBirth) {
        if (name == null || dateOfBirth == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        this.name = name;

        // Defensive copy of the mutable field
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    public String getName() {
        return name;
    }

    // Getter with defensive copy
    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }
}
```

**Explanation:**
- The constructor creates a **new `Date` instance** using the provided `dateOfBirth` object, preventing external modification.
- The getter also returns a new `Date` instance to ensure that the caller cannot modify the original `dateOfBirth` field.

---

#### 2. **In Getters**
Getters for mutable fields should return a new copy of the object rather than exposing the internal reference.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableList {
    private final List<String> items;

    public ImmutableList(List<String> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items cannot be null");
        }

        // Defensive copy in the constructor
        this.items = new ArrayList<>(items);
    }

    // Getter with defensive copy
    public List<String> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(items));
    }
}
```

**Explanation:**
- The constructor creates a new `ArrayList` from the provided `items` list to prevent external modification.
- The getter returns an **unmodifiable view** of the copy, ensuring the internal list remains immutable.

---

### **What Happens Without Defensive Copying?**

If defensive copying is not implemented, the immutability of the class can be compromised.

**Example (Without Defensive Copying):**
```java
import java.util.Date;

public final class MutableImmutableClass {
    private final Date dateOfBirth;

    public MutableImmutableClass(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth; // No defensive copy
    }

    public Date getDateOfBirth() {
        return dateOfBirth; // Exposes internal reference
    }
}

public class Test {
    public static void main(String[] args) {
        Date dob = new Date();
        MutableImmutableClass obj = new MutableImmutableClass(dob);

        // Modifying the original object
        dob.setTime(0);
        System.out.println(obj.getDateOfBirth()); // Prints altered date
    }
}
```

**Output:**
```
Thu Jan 01 05:30:00 IST 1970
```

In this case, the `dateOfBirth` field of the supposedly immutable class was modified, breaking immutability.

---

### **Benefits of Defensive Copying**

1. **Data Integrity:**
   - Ensures that the internal state of an object cannot be altered by external code.

2. **Thread Safety:**
   - Prevents concurrent threads from unintentionally corrupting shared mutable data.

3. **Robustness:**
   - Protects against unexpected bugs caused by modifications to shared objects.

---

### **Best Practices for Defensive Copying**

1. **Copy All Mutable Fields:**
   - Ensure that every mutable field is defensively copied, both in constructors and getters.

2. **Use `final` Keyword:**
   - Declare fields as `final` to prevent reassignment.

3. **Immutable Wrappers:**
   - For collections, use immutable wrappers like `Collections.unmodifiableList` for added safety.

4. **Immutable Data Structures:**
   - Prefer using immutable alternatives (e.g., `List.of()`, `Set.of()`, `LocalDate`) when possible.

---

### **Conclusion**

Defensive copying is a vital technique for creating truly immutable classes in Java. By making defensive copies in constructors and getters, you can protect the internal state of an object from external modification, ensuring immutability, thread safety, and data integrity.

# Que 5
### **How to Make a Collection Immutable in Java**

In Java, an **immutable collection** is a collection whose elements cannot be modified after creation. There are two main ways to make a collection immutable:

1. **Using `Collections.unmodifiableList` (Legacy Approach)**
2. **Using `List.of()` or `Set.of()` (Modern Approach introduced in Java 9)**

---

### **1. Using `Collections.unmodifiableList`**

The `Collections.unmodifiableList` method wraps an existing collection in an unmodifiable wrapper. Any attempt to modify the wrapper results in an `UnsupportedOperationException`. However, the original collection is still modifiable unless you explicitly prevent it.

#### Example:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListExample {
    public static void main(String[] args) {
        // Create a mutable list
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Apple");
        mutableList.add("Banana");
        mutableList.add("Cherry");

        // Wrap the list in an unmodifiable wrapper
        List<String> unmodifiableList = Collections.unmodifiableList(mutableList);

        System.out.println("Unmodifiable List: " + unmodifiableList);

        // Attempting to modify the unmodifiable list will throw an exception
        try {
            unmodifiableList.add("Date");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification attempt failed: " + e);
        }

        // Changes to the original list are reflected in the unmodifiable list
        mutableList.add("Date");
        System.out.println("Unmodifiable List after modifying original list: " + unmodifiableList);
    }
}
```

#### Output:
```
Unmodifiable List: [Apple, Banana, Cherry]
Modification attempt failed: java.lang.UnsupportedOperationException
Unmodifiable List after modifying original list: [Apple, Banana, Cherry, Date]
```

**Key Notes:**
- The `unmodifiableList` reflects changes in the original `mutableList`.
- To truly prevent changes, the original list must not be modified after wrapping.

---

### **2. Using `List.of()` (Java 9 and Later)**

The `List.of()` method creates an **immutable list** directly. Any attempt to modify this list will result in an `UnsupportedOperationException`.

#### Example:
```java
import java.util.List;

public class ImmutableListExample {
    public static void main(String[] args) {
        // Create an immutable list
        List<String> immutableList = List.of("Apple", "Banana", "Cherry");

        System.out.println("Immutable List: " + immutableList);

        // Attempting to modify the immutable list will throw an exception
        try {
            immutableList.add("Date");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification attempt failed: " + e);
        }
    }
}
```

#### Output:
```
Immutable List: [Apple, Banana, Cherry]
Modification attempt failed: java.lang.UnsupportedOperationException
```

**Key Notes:**
- The `List.of()` method directly creates an immutable list that does not allow modification or null values.
- It's a concise and modern way to create immutable collections.

---

### **3. Using `Collections.unmodifiableMap` and `Map.of()` for Maps**

#### Using `Collections.unmodifiableMap`:
```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapExample {
    public static void main(String[] args) {
        // Create a mutable map
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("Key1", "Value1");
        mutableMap.put("Key2", "Value2");

        // Wrap the map in an unmodifiable wrapper
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);

        System.out.println("Unmodifiable Map: " + unmodifiableMap);

        // Attempting to modify the unmodifiable map will throw an exception
        try {
            unmodifiableMap.put("Key3", "Value3");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification attempt failed: " + e);
        }

        // Changes to the original map are reflected in the unmodifiable map
        mutableMap.put("Key3", "Value3");
        System.out.println("Unmodifiable Map after modifying original map: " + unmodifiableMap);
    }
}
```

#### Using `Map.of()` (Java 9 and Later):
```java
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        // Create an immutable map
        Map<String, String> immutableMap = Map.of(
                "Key1", "Value1",
                "Key2", "Value2",
                "Key3", "Value3"
        );

        System.out.println("Immutable Map: " + immutableMap);

        // Attempting to modify the immutable map will throw an exception
        try {
            immutableMap.put("Key4", "Value4");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification attempt failed: " + e);
        }
    }
}
```

#### Output:
```
Immutable Map: {Key1=Value1, Key2=Value2, Key3=Value3}
Modification attempt failed: java.lang.UnsupportedOperationException
```

---

### **Comparison of Approaches**

| Feature                              | `Collections.unmodifiableList` / `unmodifiableMap` | `List.of()` / `Map.of()` |
|--------------------------------------|----------------------------------------------------|--------------------------|
| **Introduced In**                    | Java 1.2                                          | Java 9                   |
| **Modification Attempts**            | Throws `UnsupportedOperationException`            | Throws `UnsupportedOperationException` |
| **Reflection of Original Changes**   | Yes (if wrapping a mutable collection)            | No                       |
| **Allows Null Values**               | Yes                                               | No                       |
| **Thread-Safe**                      | No (requires external synchronization)            | Yes (for the collection itself) |

---

### **Conclusion**

- Use `List.of()` or `Map.of()` when working in Java 9+ for concise and modern immutable collection creation.
- Use `Collections.unmodifiableList` for backward compatibility with earlier Java versions. However, ensure that the original collection is not modified to maintain immutability.
