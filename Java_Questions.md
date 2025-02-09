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
