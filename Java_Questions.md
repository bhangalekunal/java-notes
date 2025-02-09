# **Why Java Is Not 100% Object-Oriented?**  

Java is not **100% object-oriented** because it incorporates features that break pure object-oriented principles. These include:  

### **1. Primitive Data Types**  
Java supports **primitive types** (`int`, `char`, `double`, etc.), which are **not objects**. A purely object-oriented language would treat everything as an object.  
Example:  
```java
int number = 10; // Primitive, not an object
Integer numObj = Integer.valueOf(10); // Object
```
Though Java provides wrapper classes (like `Integer`, `Double`), primitives are still widely used.  

---

### **2. Static Methods and Variables**  
Java allows **static methods and variables**, which belong to the class itself rather than an object. This contradicts OOP principles, where methods should be invoked on objects.  
Example:  
```java
class Utility {
    static void printMessage() {
        System.out.println("Hello, World!");
    }
}

public class Main {
    public static void main(String[] args) {
        Utility.printMessage(); // No object required
    }
}
```
- In pure OOP, you would need to create an object of `Utility` before calling `printMessage()`.  

---

### **3. Functional Programming Features (Java 8+)**  
Java introduced **functional programming concepts**, allowing developers to write code without defining objects explicitly.  

#### **Lambda Expressions**
- Java allows **anonymous functions** (lambda expressions) that are not part of any class instance.  
```java
import java.util.function.Consumer;

public class LambdaExample {
    public static void main(String[] args) {
        Consumer<String> greet = message -> System.out.println(message);
        greet.accept("Hello, Java!");
    }
}
```
- Here, `greet` is a function that is not tied to an object.  

#### **Streams API and Method References**
- Java allows **stateless functional programming**, bypassing objects entirely.  
```java
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.forEach(System.out::println); // Functional style, no object invocation
    }
}
```

---

### **4. `instanceof` Operator (Breaking Encapsulation)**
- Java allows checking an object’s type using `instanceof`, which breaks encapsulation principles of OOP.  
```java
class Animal {}
class Dog extends Animal {}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a instanceof Dog); // True
    }
}
```
- Ideally, the type of an object should be hidden from the user, but `instanceof` exposes it.  

---

# **Why Are Pointers Not Allowed in Java?**  

In Java, **pointers are not allowed** mainly due to **security, simplicity, and memory management** reasons. Instead, Java uses **references** to access objects in memory.  

---

### **1. Security and Memory Safety**  
- Pointers allow **direct memory access**, which can lead to **memory corruption, buffer overflow, and unauthorized access**.  
- Java's design focuses on security, and allowing pointers could make programs vulnerable to **hacks and segmentation faults** (like in C/C++).  
- Example in C++ (where memory can be manipulated unsafely):  
  ```cpp
  int *ptr;
  ptr = (int*)0x123456;  // Dangerous: Direct memory access
  *ptr = 100;  // Can cause undefined behavior
  ```
  - In Java, you **cannot** access memory locations directly.

---

### **2. Simplicity and Readability**  
- Pointers make code **complex and error-prone** (e.g., null pointer dereferencing, dangling pointers).  
- Java eliminates the need for manual pointer management, making programs **easier to write, read, and maintain**.  

---

### **3. Automatic Memory Management (Garbage Collection)**  
- Java uses **automatic garbage collection (GC)** to manage memory efficiently.  
- In languages with pointers (like C/C++), developers must manually allocate (`malloc`) and deallocate (`free`) memory, leading to **memory leaks**.  
- Example:  
  ```cpp
  int *ptr = new int(10); // Memory allocated
  delete ptr; // Must be freed manually, or memory leak occurs
  ```
- In Java, memory is managed automatically:  
  ```java
  Integer num = new Integer(10); // No need to delete, GC handles it
  ```

---

### **4. No Dangling or Wild Pointers**  
- In languages with pointers, accessing memory after deallocation leads to **dangling pointers**.  
- Java prevents this by **removing direct memory access** and letting the garbage collector clean up unused objects.  

Example in C++ (dangling pointer):  
```cpp
int *ptr = new int(5);
delete ptr; 
cout << *ptr; // Undefined behavior: Accessing deleted memory
```
Java avoids this by not allowing explicit pointer use.

---

### **5. Prevents Pointer Arithmetic**  
- C/C++ allows pointer arithmetic (`ptr + 1`), which can lead to **segmentation faults** or memory corruption.  
- Java does not allow pointer arithmetic, ensuring **better memory safety**.  

Example in C++ (pointer arithmetic):  
```cpp
int arr[] = {10, 20, 30};
int *ptr = arr;
ptr++; // Moves to the next memory location
cout << *ptr; // 20
```
- Java avoids this, reducing **accidental memory access violations**.

---

# **What is JIT compiler in java?**
### **Just-In-Time (JIT) Compiler in Java** 🚀  

The **Just-In-Time (JIT) compiler** in Java is a component of the **Java Virtual Machine (JVM)** that improves the performance of Java applications by **compiling bytecode into native machine code at runtime**. This makes Java **faster and more efficient** compared to purely interpreted execution.  

---

## **How Does JIT Work?** 🛠️  
1. **Compilation to Bytecode:**  
   - Java source code (`.java`) is compiled by the **Java Compiler (javac)** into **bytecode** (`.class` file).  
   - Bytecode is **platform-independent** and runs on the **JVM**, not directly on the CPU.  
     
2. **Interpretation vs. Compilation:**  
   - JVM **interprets** the bytecode line by line, which is **slower**.  
   - To optimize performance, JIT compiles frequently used bytecode **into native machine code** for faster execution.  
     
3. **JIT Compilation Process:**  
   - The **JVM monitors methods that are executed frequently** (hot methods).  
   - When a method is used **multiple times**, the JIT compiler **compiles it into machine code**.  
   - The next time the method runs, the JVM **executes the compiled native code directly**, improving performance.  

---

## **Types of JIT Compilation Modes**  
Java JIT operates in different modes for performance optimization:  

1. **Client (C1) Compiler (Tier 1) 📌**  
   - Used for **quick startup and lightweight performance improvements**.  
   - Ideal for **GUI applications or small programs**.  

2. **Server (C2) Compiler (Tier 4) 🔥**  
   - Focuses on **advanced optimizations** like **inlining, loop unrolling, and dead code elimination**.  
   - Used for **long-running applications** (e.g., enterprise applications, servers).  

3. **Tiered Compilation ⚙️**  
   - Combines **Client (C1) and Server (C2)** modes to balance **fast startup and high performance**.  
   - JVM first compiles methods using **C1 (faster, less optimized)**, then upgrades them using **C2 (slower, highly optimized)**.  

---

## **JIT Optimization Techniques** 🚀  
JIT applies various optimizations to speed up execution:  

✅ **Method Inlining:** Replaces a method call with its actual code to reduce function call overhead.  
✅ **Loop Unrolling:** Expands loops to decrease iteration overhead.  
✅ **Dead Code Elimination:** Removes unused or unnecessary code.  
✅ **Constant Folding:** Replaces expressions with their precomputed constant values.  

---

## **JIT vs. AOT (Ahead-of-Time) Compilation**  
| Feature | JIT (Just-In-Time) | AOT (Ahead-of-Time) |
|---------|------------------|------------------|
| Compilation Time | At runtime | Before execution |
| Performance | Improves over time | Fast from the start |
| Optimization | Dynamic, based on execution patterns | Static, fixed at compile-time |
| Use Cases | Java, JVM-based languages | Native executables (GraalVM, Android ART) |

---

# **Why is String Immutable in Java?** 🛠️🔒  

In Java, the **`String` class is immutable**, meaning once a `String` object is created, its value **cannot be changed**. Instead, any modification results in the creation of a **new `String` object**.  

This immutability is by **design** and has several important benefits. Let's explore the **reasons** behind making `String` immutable in Java.  

---

## **1️⃣ Security Reasons 🔐**  
- `String` is widely used for storing **sensitive data** such as **passwords, usernames, database connection URLs, and file paths**.  
- If `String` were mutable, hackers could modify its contents, leading to **security vulnerabilities** in authentication and file handling.  

**Example:**  
```java
String dbUrl = "jdbc:mysql://localhost:3306/mydb";
dbUrl.replace("localhost", "malicious_host"); // If mutable, this would be a security risk!
```
➡ **Since `String` is immutable, such modifications create a new object instead of altering the original one.**  

---

## **2️⃣ Performance Optimization (String Pool) ⚡**  
- Java maintains a special **"String Pool" (String Constant Pool)** in memory to optimize storage and performance.  
- When a `String` is created using **string literals**, it is stored in the pool and reused if another identical `String` is created.  

**Example:**  
```java
String s1 = "Java";
String s2 = "Java"; // Reuses the same object from the String Pool
System.out.println(s1 == s2); // true (same reference)
```
➡ **If `String` were mutable, changes to one reference would affect all references, breaking this optimization.**  

---

## **3️⃣ Thread Safety 🧵**  
- Since `String` is immutable, it is **automatically thread-safe**.  
- Multiple threads can share the same `String` instance **without synchronization issues**.  

**Example (Multi-threading scenario):**  
```java
class MyThread extends Thread {
    String message = "Hello";
    
    public void run() {
        message.concat(" World"); // Creates a new String but doesn't modify the original
    }
}
```
➡ **If `String` were mutable, multiple threads modifying the same `String` instance could cause inconsistent behavior.**  

---

## **4️⃣ Hashcode Caching (Used in HashMap & HashSet) 🗂️**  
- `String`'s `hashCode()` is frequently used in **HashMap, HashSet, and HashTable** for **fast retrieval**.  
- Since `String` is immutable, the hashcode is **calculated only once and stored**.  

**Example:**  
```java
String key = "username";
Map<String, Integer> map = new HashMap<>();
map.put(key, 123);

// Hashcode remains the same even if the original reference is reassigned
key = "password"; // Doesn't affect map.get("username")
```
➡ **If `String` were mutable, changing its value would alter its `hashCode()`, breaking HashMap integrity.**  

---

## **5️⃣ Class Loading Mechanism 📂**  
- `String` is heavily used in **class loading** (e.g., `Class.forName("com.mysql.Driver")`).  
- If `String` were mutable, malicious code could **modify the class name dynamically** and load an unintended class, causing security breaches.  

---

## **🔹 Conclusion: Why String is Immutable?**  
| **Reason** | **Benefit** |
|------------|------------|
| **Security** | Prevents unauthorized modifications to sensitive data |
| **Performance Optimization** | Enables String Pooling for memory efficiency |
| **Thread Safety** | No synchronization required, avoids race conditions |
| **Hashcode Caching** | Ensures stable keys in HashMap & HashSet |
| **Class Loading Safety** | Prevents runtime security vulnerabilities |

✅ **Java designers made `String` immutable to improve security, performance, and reliability in multi-threaded environments.** 🚀

# **What is a Marker Interface in Java?** 🏷️  

A **Marker Interface** in Java is an **interface with no methods or fields**. It is used to **mark** a class so that the Java runtime or framework can identify and apply specific behavior to objects of that class.  

---

## **🔹 Key Features of Marker Interface**  
1. **No Methods or Fields** – It is an **empty interface** (also called a "tagging interface").  
2. **Used for Type Identification** – Helps Java runtime or frameworks recognize classes that implement it.  
3. **Used for Special Behaviors** – Classes implementing marker interfaces are treated differently by JVM or libraries.  

---

## **🔹 Examples of Built-in Marker Interfaces in Java**  

### **1️⃣ `Serializable` (java.io.Serializable) – Enables Object Serialization**  
- A class implementing `Serializable` **can be converted into a byte stream** and saved to a file or sent over a network.  

**Example:**  
```java
import java.io.*;

class Employee implements Serializable {  
    int id;  
    String name;  
    Employee(int id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
}  
```
➡ **Since `Serializable` has no methods, the JVM simply checks if a class implements it before serialization.**  

---

### **2️⃣ `Cloneable` (java.lang.Cloneable) – Enables Cloning of Objects**  
- If a class implements `Cloneable`, its objects can be **cloned** using the `clone()` method.  
- Without `Cloneable`, calling `clone()` on an object **throws `CloneNotSupportedException`**.  

**Example:**  
```java
class Person implements Cloneable {
    String name;
    
    Person(String name) { this.name = name; }

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Allowed because of Cloneable
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("John");
        Person p2 = (Person) p1.clone();
        System.out.println(p2.name); // Output: John
    }
}
```
➡ **JVM allows cloning only if the class implements `Cloneable`.**  

---

### **3️⃣ `Remote` (java.rmi.Remote) – Enables Remote Method Invocation (RMI)**  
- Used in **distributed computing** where an object can be accessed remotely.  
- A class implementing `Remote` can expose methods that can be **invoked from another JVM over the network**.  

---

## **🔹 Can We Create Custom Marker Interfaces?**  
Yes! You can create your **own marker interface** for custom behavior.  

**Example:**  
```java
interface VIP {}  // Custom marker interface

class Customer implements VIP { 
    String name;
    Customer(String name) { this.name = name; }
}

// Method to check if a customer is VIP
public class Test {
    public static void main(String[] args) {
        Customer c = new Customer("Alice");
        
        if (c instanceof VIP) {  // Checking marker interface
            System.out.println(c.name + " is a VIP Customer!");
        } else {
            System.out.println(c.name + " is a Regular Customer.");
        }
    }
}
```
✅ **Output:**  
```
Alice is a VIP Customer!
```
➡ **Even without methods, the marker interface helps identify special classes.**  

---

## **🔹 Alternative to Marker Interfaces: Annotations 📌**  
Since Java 5, **Annotations** (e.g., `@Override`, `@Deprecated`) have replaced many marker interfaces.  
🔹 Instead of:  
```java
interface Auditable {}  
class User implements Auditable {}  
```
🔹 We can use an annotation:  
```java
@interface Auditable {}  
@Auditable  
class User {}  
```
✅ **Annotations provide more flexibility and metadata compared to marker interfaces.**  

---

## **🔹 Conclusion: Why Use Marker Interfaces?**  

| **Feature** | **Marker Interface** | **Annotations** |
|------------|----------------------|----------------|
| **Purpose** | Type identification | Additional metadata |
| **Methods?** | No | Can have attributes |
| **JVM Processing** | Checked at runtime | Processed at compile/runtime |
| **Example** | `Serializable`, `Cloneable` | `@Override`, `@Deprecated` |

📌 **Today, marker interfaces are mostly replaced by annotations, but they are still useful in legacy systems and for JVM-based checks like serialization and cloning.** 🚀

# **Can You Override `private` or `static` Methods in Java?**  

#### **1️⃣ Can You Override a `private` Method?** 🚫  
**No**, **private methods cannot be overridden** because they are **not inherited** by subclasses.  

**Example:**  
```java
class Parent {
    private void show() {  // Private method
        System.out.println("Parent's show() method");
    }
}

class Child extends Parent {
    private void show() {  // This is NOT overriding, it's a separate method
        System.out.println("Child's show() method");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        // p.show();  // ❌ Compilation error: show() is private in Parent
    }
}
```
🔹 **Explanation:**  
- `private` methods **belong only to the class** in which they are defined.  
- The `Child` class defines a new `show()` method, but it does not override the one in `Parent`.  
- **Solution:** If you want to override, you should use `protected` or `public` instead of `private`.

---

#### **2️⃣ Can You Override a `static` Method?** 🚫  
**No**, **static methods cannot be overridden** because they are **associated with the class, not instances**. However, they **can be hidden** by defining a method with the same signature in the subclass.  

**Example:**  
```java
class Parent {
    static void show() {  // Static method
        System.out.println("Parent's static show()");
    }
}

class Child extends Parent {
    static void show() {  // This is method hiding, NOT overriding
        System.out.println("Child's static show()");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();  // Output: Parent's static show()
    }
}
```
🔹 **Explanation:**  
- Since `show()` is static, **method hiding occurs instead of overriding**.  
- **Method is called based on the reference type (`Parent`), not the object (`Child`).**  
- If it were a normal (non-static) method, dynamic method dispatch (runtime polymorphism) would happen, and the `Child` method would be called.

---

### **🔹 Summary**
| **Method Type** | **Can Be Overridden?** | **Reason** |
|---------------|-----------------|-------------|
| `private` | ❌ No | Not inherited by subclasses |
| `static` | ❌ No (but can be hidden) | Belongs to the class, not instances |

🚀 **If you want method overriding, use `protected` or `public` methods instead!**

# **Does `finally` Always Execute in Java?**  

In Java, the `finally` block is **guaranteed to execute** **except in a few special cases**. Let's explore when it executes and when it might not.

---

### ✅ **`finally` Executes in Most Cases**
The `finally` block **always executes** after the `try` block, regardless of whether an exception occurs or not.

**Example 1: `finally` executes after `try` block (No Exception)**
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block");
        }
    }
}
```
**Output:**
```
Inside try block
Inside finally block
```

---

**Example 2: `finally` executes even if an exception occurs**
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            int a = 5 / 0;  // This causes ArithmeticException
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Inside finally block");
        }
    }
}
```
**Output:**
```
Inside try block
Inside catch block
Inside finally block
```

---

### ❌ **When `finally` Does NOT Execute**
Although `finally` **almost always executes**, there are a few special cases where it does **not**:

1. **System.exit() is called inside `try` or `catch`**
   ```java
   public class FinallyNotExecuted {
       public static void main(String[] args) {
           try {
               System.out.println("Inside try block");
               System.exit(0);  // Terminates JVM
           } finally {
               System.out.println("Inside finally block");
           }
       }
   }
   ```
   **Output:**
   ```
   Inside try block
   ```
   🚨 **Explanation:** Since `System.exit(0)` **immediately stops the JVM**, the `finally` block **will not execute**.

---

2. **The JVM crashes due to an error (e.g., `OutOfMemoryError`)**
   ```java
   public class FinallyNotExecuted {
       public static void main(String[] args) {
           try {
               int[] arr = new int[Integer.MAX_VALUE];  // Causes OutOfMemoryError
           } finally {
               System.out.println("Inside finally block");
           }
       }
   }
   ```
   **Output:**
   ```
   (Program crashes with OutOfMemoryError, finally may not execute)
   ```

---

3. **Infinite loop or program termination in `try` or `catch`**
   ```java
   public class FinallyNotExecuted {
       public static void main(String[] args) {
           try {
               while (true) {}  // Infinite loop
           } finally {
               System.out.println("Inside finally block");
           }
       }
   }
   ```
   **Output:**
   ```
   (Program runs forever, finally never executes)
   ```

---

### **🔹 Summary Table**
| Case | Does `finally` Execute? | Reason |
|------|----------------|--------|
| Normal execution | ✅ Yes | Always executes |
| Exception occurs | ✅ Yes | Executes after `catch` block |
| `return` inside `try/catch` | ✅ Yes | Executes before returning |
| `System.exit(0)` inside `try/catch` | ❌ No | JVM shuts down |
| JVM crashes (OutOfMemoryError, StackOverflowError) | ❌ No | Uncontrolled crash |
| Infinite loop in `try` or `catch` | ❌ No | Execution never reaches `finally` |

### **🔹 Conclusion**
🚀 **In 99% of cases, `finally` executes!** However, if the JVM shuts down (`System.exit(0)`) or crashes, `finally` **might not** run.

Would you like an example where `finally` executes even when a `return` statement is used? 😊

# **What Methods Does the Object Class Have?**
The `Object` class in Java is the root class of the Java class hierarchy. Every class in Java implicitly inherits from `Object`. It provides several important methods that are available to all Java objects. Here are the key methods of the `Object` class:

1. **`clone()`**  
   - **Description:** Creates and returns a copy of the object. The object must implement the `Cloneable` interface to allow cloning.  
   - **Signature:** `protected Object clone() throws CloneNotSupportedException`

2. **`equals(Object obj)`**  
   - **Description:** Compares this object to the specified object for equality. The default implementation compares memory addresses, but it can be overridden for meaningful comparison.  
   - **Signature:** `public boolean equals(Object obj)`

3. **`finalize()`**  
   - **Description:** Called by the garbage collector when there are no more references to the object. It is used to perform cleanup before an object is destroyed.  
   - **Signature:** `protected void finalize() throws Throwable`

4. **`getClass()`**  
   - **Description:** Returns the runtime class of the object. This can be useful to obtain the class type of an object.  
   - **Signature:** `public final Class<?> getClass()`

5. **`hashCode()`**  
   - **Description:** Returns a hash code for the object. This method is used in hashing-based collections like `HashMap` or `HashSet`. The default implementation returns a unique integer for the object, but it is often overridden.  
   - **Signature:** `public int hashCode()`

6. **`notify()`**  
   - **Description:** Wakes up one thread that is waiting on the object’s monitor. This method is used in synchronized blocks for inter-thread communication.  
   - **Signature:** `public final void notify()`

7. **`notifyAll()`**  
   - **Description:** Wakes up all threads that are waiting on the object’s monitor. Like `notify()`, it is used for inter-thread communication.  
   - **Signature:** `public final void notifyAll()`

8. **`toString()`**  
   - **Description:** Returns a string representation of the object. By default, it returns a string containing the class name and the object’s hash code, but this method can be overridden to provide a more meaningful representation.  
   - **Signature:** `public String toString()`

9. **`wait()`**  
   - **Description:** Causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the same object. It can also be used with a timeout.  
   - **Signature:**  
     - `public final void wait() throws InterruptedException`
     - `public final void wait(long timeout) throws InterruptedException`
     - `public final void wait(long timeout, int nanos) throws InterruptedException`

These methods are inherited by all classes in Java, and many of them can be overridden for specific behavior in user-defined classes.

# **How Can You Make a Class Immutable?**
To make a class **immutable** in Java, you need to follow a set of design principles that ensure that once an object is created, its state cannot be changed. Here are the steps to create an immutable class:

### 1. **Make the Class `final`**
   - Declare the class as `final` so that it cannot be subclassed. This prevents subclasses from altering its immutable behavior.
   ```java
   public final class MyClass {
       // Class implementation
   }
   ```

### 2. **Make All Fields `final` and `private`**
   - Declare all fields of the class as `final` so that they cannot be reassigned after the object is constructed.
   - Declare all fields as `private` so they are not directly accessible outside the class.
   ```java
   private final String name;
   private final int age;
   ```

### 3. **Do Not Provide "Setter" Methods**
   - Avoid providing setter methods for modifying the fields after the object is created. This ensures that the object's state remains unchanged.
   ```java
   // No setter methods
   ```

### 4. **Initialize Fields Only in the Constructor**
   - Set the values of fields only in the constructor and make sure the constructor initializes every field.
   - If the class has mutable objects as fields (e.g., arrays, lists), make sure to clone them before storing them. This prevents external modification of mutable objects.
   ```java
   public MyClass(String name, int age) {
       this.name = name;
       this.age = age;
   }
   ```

### 5. **Ensure Deep Copies for Mutable Fields**
   - If the class contains fields that are references to mutable objects (like arrays, collections, or custom objects), make sure to create a **deep copy** of the objects in the constructor and return a deep copy when accessing them via getters. This ensures that the caller cannot modify the internal state of the immutable class.

   For example, if your class has an array:
   ```java
   private final int[] scores;

   public MyClass(int[] scores) {
       this.scores = scores.clone();  // Create a deep copy
   }

   public int[] getScores() {
       return scores.clone();  // Return a copy of the array
   }
   ```

### 6. **Override the `toString()`, `hashCode()`, and `equals()` Methods (Optional but Recommended)**
   - Override `toString()`, `hashCode()`, and `equals()` methods to ensure that the object behaves correctly when used in collections or printed.

### Example of an Immutable Class:

```java
public final class Person {
    private final String name;
    private final int age;
    private final int[] scores;

    // Constructor
    public Person(String name, int age, int[] scores) {
        this.name = name;
        this.age = age;
        this.scores = scores.clone(); // Ensuring deep copy for mutable object
    }

    // Getter methods (no setters)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getScores() {
        return scores.clone();  // Returning a copy of the array
    }

    // Optional: Override equals, hashCode, and toString
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

### Key Points:
- **Final class:** Prevents subclassing, which could otherwise alter the immutable behavior.
- **Final fields:** Ensures the fields cannot be reassigned after initialization.
- **Private fields:** Protects fields from direct modification.
- **No setters:** Ensures the object cannot be modified externally after creation.
- **Deep copying:** Protects the object from changes to mutable fields.

By following these steps, you can ensure that your class remains immutable, providing a robust and thread-safe design.

# **What is singleton class in Java and how can we make a class singleton?**
### **What is a Singleton Class in Java?**

A **Singleton class** in Java is a class that allows only **one instance** of itself to be created and provides a global point of access to that instance. This ensures that there is a single, shared instance of the class, which is often useful for managing resources like database connections, configuration settings, or thread pools.

### **How to Make a Class Singleton in Java?**

To make a class **Singleton** in Java, we must ensure the following characteristics:

1. **Private Constructor**: The constructor of the class should be private to prevent instantiation from outside the class.
2. **Static Instance**: A static instance of the class should be created, which will be the only instance available.
3. **Global Access Method**: A public method (usually named `getInstance()`) should be provided to give access to the single instance.
4. **Thread Safety**: If the class is used in a multithreaded environment, proper synchronization mechanisms should be implemented to ensure thread safety.
5. **Reflection Safety**: Prevent the instance from being created via reflection (which could bypass the private constructor).
6. **Serialization Safety**: Ensure that the Singleton class does not break during serialization/deserialization (this is done using the `readResolve()` method).
7. **Clone Safety**: Prevent the Singleton class from being cloned, which could create another instance of the class.

### **Singleton Class Example with All Safety Guards:**

```java
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
    // volatile ensures that multiple threads handle the instance variable correctly
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent reflection from creating a new instance
        if (instance != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }

    // Public method to get the instance, uses double-checked locking for thread safety
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // Lazy initialization
                }
            }
        }
        return instance;
    }

    // This method ensures that when the object is deserialized, the same instance is returned
    protected Object readResolve() {
        return getInstance();
    }

    // Override clone method to prevent cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for Singleton class!");
    }
    
    // Example method for Singleton class
    public void doSomething() {
        System.out.println("Doing something with the Singleton instance!");
    }
}
```

### **Explanation of Key Elements:**

1. **Private Constructor**:
   - The constructor is private to prevent any external instantiation.

2. **Static `getInstance()` Method**:
   - The static method `getInstance()` is used to provide access to the Singleton instance.
   - **Double-Checked Locking**: This ensures lazy initialization and minimizes the synchronization overhead.
   - The `volatile` keyword is used to ensure that multiple threads handle the instance correctly.

3. **Reflection Safety**:
   - In the constructor, we check if the instance is already created and throw an `IllegalStateException` if any attempt is made to create a new instance through reflection.

4. **Serialization Safety**:
   - The `readResolve()` method ensures that when the object is deserialized, it returns the existing instance instead of creating a new one.

5. **Clone Safety**:
   - The `clone()` method is overridden to throw a `CloneNotSupportedException` to prevent cloning of the Singleton class.

### **Usage Example:**

```java
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Verifying that both references point to the same instance
        System.out.println(singleton1 == singleton2); // Should print true

        // Using the Singleton instance
        singleton1.doSomething();
        
        // Try to clone (will throw CloneNotSupportedException)
        try {
            Singleton singletonClone = (Singleton) singleton1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage()); // Should print: "Cloning not allowed for Singleton class!"
        }
    }
}
```

### **Summary:**
To make a class a Singleton in Java, follow these steps:
1. Make the constructor private.
2. Provide a public static method (`getInstance()`) to access the Singleton instance.
3. Implement thread safety (using `synchronized` or `volatile` for lazy initialization).
4. Add **reflection**, **serialization**, and **clone safety** to ensure the integrity of the Singleton pattern.

By following these steps, you can ensure that the class is a properly implemented Singleton in Java.
