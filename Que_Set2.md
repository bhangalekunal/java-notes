# 1. What is Overloading in Java?
Overloading in Java refers to defining multiple methods in the same class with the same name but different method signatures. This means the methods must have different parameter lists (different number, type, or order of parameters).

### **Key Points of Method Overloading**
- Overloaded methods must have the same method name but different parameters.
- The return type of overloaded methods **can be different**, but it **does not differentiate overloading** on its own.
- Method overloading happens at **compile-time** (also known as **compile-time polymorphism**).
- Overloading can occur within the **same class** or **in a subclass** (if the method is inherited).
- Overloading is commonly used in constructors and utility methods (e.g., `println()` in `System.out`).

### **Example of Method Overloading**
```java
class OverloadExample {
    // Method with one parameter
    void display(int a) {
        System.out.println("Integer: " + a);
    }

    // Overloaded method with different parameter type
    void display(double a) {
        System.out.println("Double: " + a);
    }

    // Overloaded method with different number of parameters
    void display(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    public static void main(String[] args) {
        OverloadExample obj = new OverloadExample();
        obj.display(5);       // Calls display(int)
        obj.display(5.5);     // Calls display(double)
        obj.display(5, 10);   // Calls display(int, int)
    }
}
```
### **Output**
```
Integer: 5  
Double: 5.5  
Sum: 15  
```

### **Advantages of Method Overloading**
1. **Increases Readability** – Methods with the same functionality but different input types can use the same name.
2. **Improves Code Maintainability** – Reduces confusion by logically grouping similar functionalities.
3. **Supports Polymorphism** – Enables **compile-time polymorphism** for better performance and flexibility.

### **Common Use Cases of Method Overloading**
- **Constructors** (Constructor Overloading)
- **Mathematical Utility Methods** (e.g., `Math.max(int, int)` and `Math.max(double, double)`)
- **String Operations** (e.g., `substring(int start)`, `substring(int start, int end)`)
- **Custom Utility Methods** (e.g., logging, parsing, and data formatting methods)

# 2. What is the difference between method overloading and method overriding?

| Feature            | Method Overloading | Method Overriding |
|--------------------|-------------------|-------------------|
| **Definition**     | Defining multiple methods with the same name but different parameter lists in the same class. | Redefining a method in a subclass that already exists in the parent class with the same signature. |
| **Purpose**        | Provides flexibility by allowing different ways to call a method with different parameters. | Provides specific implementation in a subclass for a method defined in the superclass. |
| **Parameters**     | Must be different (either in number, type, or order). | Must be the **same** as in the parent class. |
| **Return Type**    | Can be different (but must change the parameters). | Must be **same** or **covariant** (a subclass of the return type in the parent class). |
| **Access Modifier** | Can have any access modifier. | Cannot reduce the visibility (e.g., `public` in parent must stay `public` in child). |
| **Static Methods** | Can be overloaded. | Cannot be overridden, but can be hidden. |
| **Final Methods**  | Can be overloaded. | Cannot be overridden if the method is declared `final` in the parent class. |
| **Checked Exceptions** | Each overloaded method can declare its own exceptions. | Cannot throw **new or broader** checked exceptions than the overridden method. |
| **Happens In**     | The same class. | Parent-child (inheritance) relationship. |
| **Polymorphism Type** | **Compile-time (static binding)**. | **Runtime (dynamic binding)**. |

# 3. How does method resolution work in case of method overloading?
In Java, **method overloading** allows multiple methods in the same class to have the same name but different parameter lists. When calling an overloaded method, **Java resolves the method at compile-time** based on the **best match** for the provided arguments.

### **Method Resolution Process**
1. **Exact Match:** If an exact match is found (same method name and exact parameter types), that method is invoked.
2. **Type Promotion (Widening Conversion):** If an exact match is not found, Java looks for a method where **smaller data types can be promoted to larger compatible types** (e.g., `int` → `long`, `float` → `double`).
3. **Autoboxing/Unboxing:** If no exact or widened match is found, Java tries to match **primitive types with their wrapper classes** (e.g., `int` → `Integer`).
4. **Varargs (Variable Arguments):** If no better match is found, Java considers methods that use **varargs (`...`)**, treating them as the least preferred option.

### **Example: Method Resolution in Action**
```java
class OverloadExample {
    void show(int a) {
        System.out.println("int method: " + a);
    }

    void show(long a) {
        System.out.println("long method: " + a);
    }

    void show(Integer a) {
        System.out.println("Integer method: " + a);
    }

    void show(double a) {
        System.out.println("double method: " + a);
    }

    void show(String a) {
        System.out.println("String method: " + a);
    }

    void show(int... a) {
        System.out.println("Varargs method");
    }

    public static void main(String[] args) {
        OverloadExample obj = new OverloadExample();
        
        obj.show(5);       // int method (Exact match)
        obj.show(5L);      // long method (Exact match)
        obj.show(5.5);     // double method (Exact match)
        obj.show("Hello"); // String method (Exact match)
        obj.show(5.5f);    // double method (float → double widening)
        obj.show(new Integer(10)); // Integer method (Exact match)
        obj.show();        // Varargs method (No parameters)
    }
}
```
### **Expected Output**
```
int method: 5
long method: 5
double method: 5.5
String method: Hello
double method: 5.5
Integer method: 10
Varargs method
```

### **Method Resolution Scenarios**
| **Scenario**                           | **Method Chosen**  | **Reason** |
|-----------------------------------------|--------------------|------------|
| `obj.show(5);`                          | `void show(int)`   | Exact match |
| `obj.show(5L);`                         | `void show(long)`  | Exact match |
| `obj.show(5.5);`                        | `void show(double)` | Exact match |
| `obj.show(5.5f);`                       | `void show(double)` | Widening (`float → double`) |
| `obj.show("Hello");`                    | `void show(String)` | Exact match |
| `obj.show(new Integer(10));`            | `void show(Integer)` | Exact match |
| `obj.show();`                           | `void show(int...)` | Varargs chosen as last resort |


# 4. Can we overload the main method in Java?

Yes, **we can overload the `main` method in Java** like any other method. However, the JVM **only** calls the standard `public static void main(String[] args)` method when executing a Java application.

### **Example: Overloading `main` Method**
```java
public class MainOverloading {
    // Standard main method (Entry Point)
    public static void main(String[] args) {
        System.out.println("Standard main method called.");
        
        // Calling overloaded main methods
        main(10);
        main("Hello");
    }

    // Overloaded main methods
    public static void main(int num) {
        System.out.println("Overloaded main method with int: " + num);
    }

    public static void main(String message) {
        System.out.println("Overloaded main method with String: " + message);
    }
}
```

### **Output**
```
Standard main method called.
Overloaded main method with int: 10
Overloaded main method with String: Hello
```
# 5. What happens if two methods have the same name but different return types in Java?
If two methods have the same name but different return types in Java, the behavior depends on whether their parameter lists are the same or different.

### **Case 1: Different Return Types but Same Parameter List (Compilation Error)**
Java does **not** allow two methods in the same class to have the same name and parameter list but different return types. This is because method overloading is based on method signatures, which consist of the **method name and parameter list** (but not the return type). The compiler cannot distinguish between two methods solely based on their return types.

#### **Example (Compilation Error)**
```java
class Example {
    int show() {
        return 10;
    }

    double show() { // Compilation Error: Duplicate method 'show()' in 'Example'
        return 10.5;
    }
}
```
**Error:**
> "Duplicate method show() in type Example."

### **Case 2: Different Return Types and Different Parameter Lists (Method Overloading Allowed)**
Java **allows** method overloading, where multiple methods have the same name but **different parameter lists**. In this case, having different return types is acceptable.

#### **Example (Valid Overloading)**
```java
class Example {
    int show(int a) {  // Method 1
        return a;
    }

    double show(double a) { // Method 2 (Different parameter type, valid overloading)
        return a;
    }
    
    String show(String a) { // Method 3 (Different parameter type, valid overloading)
        return a;
    }
}

public class Test {
    public static void main(String[] args) {
        Example obj = new Example();
        System.out.println(obj.show(5));       // Calls show(int), returns 5
        System.out.println(obj.show(5.5));     // Calls show(double), returns 5.5
        System.out.println(obj.show("Java"));  // Calls show(String), returns "Java"
    }
}
```

### **Case 3: Overriding with Covariant Return Type (Allowed)**
In method overriding, a subclass can **change the return type** of an overridden method if the return type is a **subclass of the original return type** (this is called **covariant return type**).

#### **Example (Valid Overriding with Covariant Return Type)**
```java
class Parent {
    Number getValue() { // Superclass method
        return 100;
    }
}

class Child extends Parent {
    @Override
    Integer getValue() { // Overriding with a subclass return type (Valid)
        return 200;
    }
}

public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.getValue()); // Output: 200
    }
}
```


# 6. Can we change only the return type while overloading a method?
No, we **cannot** change only the return type while overloading a method in Java. Method overloading is based on **method signatures**, which consist of the method name and parameter list (**but not the return type**).

Java does not consider the return type as part of the method signature. If two methods have the same name and the exact same parameters but different return types, the compiler cannot distinguish between them, leading to a compilation error.

#### **Example (Compilation Error)**
```java
class Example {
    int show() {
        return 10;
    }

    double show() { // Compilation Error: Duplicate method 'show()' in 'Example'
        return 10.5;
    }
}
```
**Error:**
> "Duplicate method show() in type Example."

To successfully overload a method, we must **change the parameter list**, not just the return type.

#### **Example (Valid Overloading)**
```java
class Example {
    int show(int a) {  // Method 1
        return a;
    }

    double show(double a) { // Method 2 (Different parameter type, valid overloading)
        return a;
    }
}

public class Test {
    public static void main(String[] args) {
        Example obj = new Example();
        System.out.println(obj.show(5));   // Calls show(int), returns 5
        System.out.println(obj.show(5.5)); // Calls show(double), returns 5.5
    }
}
```

# 7. Can we override a private method in Java?
No, **we cannot override a private method in Java** because private methods are **not inherited** by subclasses. Since method overriding requires inheritance and a method with the **same signature in the child class**, a private method in the parent class is **not accessible** in the child class and, therefore, **cannot be overridden**.

### **Example:**
```java
class Parent {
    private void show() {  // Private method in Parent class
        System.out.println("Private method in Parent");
    }
}

class Child extends Parent {
    public void show() {  // This is NOT overriding, it's a new method
        System.out.println("Method in Child");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();
        // obj.show();  // Compilation error: cannot access show() in Parent
    }
}
```
### **Explanation:**
- The `show()` method in the `Parent` class is **private**, so it is **not visible** to the `Child` class.
- The `show()` method in the `Child` class is a **completely new method** (not an overridden version of `Parent`'s `show()`).
- If we try to call `obj.show()`, it will result in a **compilation error** because `show()` in `Parent` is not accessible outside its class.


# 8. Can a static method be overridden in Java?
No, a static method cannot be overridden in Java. However, it can be hidden if a subclass defines a static method with the same name and signature as a static method in the parent class.

Method overriding is based on runtime polymorphism (dynamic binding), but static methods are bound at compile time (static binding). Since static methods belong to the class rather than an instance, they do not participate in polymorphism. When you define a static method in a subclass with the same signature as in the parent class, it does not override the parent method but instead hides it.

```java
class Parent {
    static void show() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void show() {  // Hiding the static method of Parent
        System.out.println("Static method in Child");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        obj1.show();  // Calls Parent's show()

        Child obj2 = new Child();
        obj2.show();  // Calls Child's show()

        Parent obj3 = new Child();
        obj3.show();  // Calls Parent's show(), NOT Child's (no polymorphism)
    }
}
```

```
Static method in Parent
Static method in Child
Static method in Parent
```

`Parent.show()` and `Child.show()` are separate static methods. `obj1.show();` calls Parent's static method. `obj2.show();` calls Child's static method. `obj3.show();` calls Parent's static method because static methods do not support runtime polymorphism.

Static methods belong to the class, not the instance, so they cannot be overridden. If a subclass defines a static method with the same signature as a static method in the parent class, it hides the parent method instead of overriding it. Method calls on references of the parent class will always invoke the parent’s static method, even if the actual object is of the child class. Polymorphism does not apply to static methods.

# 9. Why can't we override static methods?

Static methods cannot be overridden in Java because method overriding is based on **runtime polymorphism (dynamic method dispatch)**, whereas static methods are bound to the class and resolved at **compile-time (static binding).**

### Reasons Why Static Methods Cannot Be Overridden:

1. **Static Methods Belong to the Class, Not the Instance**
    - Static methods are associated with the class rather than an instance of the class. Overriding works based on dynamic method dispatch, which involves objects and runtime method resolution. Since static methods do not belong to objects, they cannot be overridden.

2. **No Runtime Polymorphism for Static Methods**
    - Overriding relies on method calls being determined at runtime based on the actual object's type (dynamic binding). However, static methods are resolved at compile time based on the reference type (static binding). This prevents static methods from participating in polymorphism.

3. **Method Hiding Instead of Overriding**
    - If a subclass defines a static method with the same signature as a static method in the parent class, it does not override the parent method but instead **hides** it. This means the method in the parent class remains accessible, but calling it depends on the reference type.

### Example Demonstrating Method Hiding

```java
class Parent {
    static void display() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void display() { // Hiding Parent's static method
        System.out.println("Static method in Child");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        obj1.display(); // Calls Parent's display()

        Child obj2 = new Child();
        obj2.display(); // Calls Child's display()

        Parent obj3 = new Child();
        obj3.display(); // Calls Parent's display(), not Child's (No overriding)
    }
}
```

### Output:
```
Static method in Parent
Static method in Child
Static method in Parent
```

### Explanation:
- `obj1.display();` → Calls `Parent.display()`
- `obj2.display();` → Calls `Child.display()`
- `obj3.display();` → Calls `Parent.display()` (because static methods are resolved based on reference type, not object type)

# 10. Can we override the main method in Java?

No, we **cannot override** the `main` method in Java because it is a **static method**. Static methods are not part of an object's method inheritance, and overriding applies to instance methods, not static ones. Method overriding requires dynamic method dispatch (runtime polymorphism), but since `main` is static, it is resolved at compile time, and there's no runtime dispatch.

Even if we define a `main` method in a subclass, it does **not override** the `main` method in the superclass. Instead, it is treated as a separate static method.

```java
class Parent {
    public static void main(String[] args) {
        System.out.println("Main method in Parent class");
    }
}

class Child extends Parent {
    public static void main(String[] args) {
        System.out.println("Main method in Child class");
    }
}
```

#### **Output**
```sh
$ java Parent
Main method in Parent class

$ java Child
Main method in Child class
```

Even though `Child` extends `Parent`, calling `java Child` executes `Child`'s `main` method. This proves that `main` is **not overridden** but rather **hidden** due to method hiding in Java.

Overriding only works for instance methods, not static methods. If we define a `main` method in a subclass, it does not override the parent class's `main` method. Instead, it hides it. Java resolves static methods at **compile-time**, not runtime.


# 11. What is covariant return type in Java?

### **Covariant Return Type in Java**

In Java, **covariant return types** allow an **overridden method** in a subclass to return a more **specific (subclass) type** than the return type defined in the superclass method. This feature was introduced in **Java 5** to improve type safety and avoid unnecessary type casting.


### **Example of Covariant Return Type**
```java
class Parent {
    Parent getInstance() {
        return new Parent();
    }
}

class Child extends Parent {
    @Override
    Child getInstance() {  // Returning a more specific type (Child instead of Parent)
        return new Child();
    }
}

public class CovariantExample {
    public static void main(String[] args) {
        Parent obj = new Child();
        Parent parentInstance = obj.getInstance(); // Returns Child object but stored as Parent
        System.out.println("Returned instance: " + parentInstance.getClass().getSimpleName());
    }
}
```
### **Output**
```
Returned instance: Child
```

### **Key Rules of Covariant Return Type**
1. The method in the **child class must override** the method in the **parent class**.
2. The **return type of the overridden method in the child class** must be a **subclass** of the return type in the **parent class**.
3. The **method signature (except return type) must remain the same**.


### **Reason to use Covariant Return Type**
Before Java 5, **method overriding did not allow different return types**, forcing developers to return the parent type and manually cast it.  
**Without covariant return type:**
```java
class Parent {
    Parent getInstance() {
        return new Parent();
    }
}

class Child extends Parent {
    @Override
    Parent getInstance() { // Must return Parent type (not ideal)
        return new Child(); // Requires explicit casting when used
    }
}

public class CovariantExample {
    public static void main(String[] args) {
        Child child = (Child) new Child().getInstance(); // Explicit casting required
        System.out.println("Returned instance: " + child.getClass().getSimpleName());
    }
}
```
This is error-prone because if `getInstance()` does not return a `Child`, the cast would fail at runtime. **Covariant return types eliminate this issue.**

### **Benefits of Covariant Return Type**
✅ **Avoids unnecessary type casting**  
✅ **Improves readability and maintainability**  
✅ **Enhances type safety in object-oriented designs**  
✅ **Allows more flexible API design**

# 12. What is the default constructor, and when is it provided?

A **default constructor** is a **no-argument constructor** that is automatically provided by the Java compiler if no constructor is explicitly defined in a class. It initializes objects with default values.

### Example of a Default Constructor:
```java
class Student {
    int id;
    String name;

    // Default constructor (automatically provided by Java)
    public static void main(String[] args) {
        Student s = new Student();  // No error, as default constructor exists
        System.out.println(s.id);   // 0 (default value for int)
        System.out.println(s.name); // null (default value for String)
    }
}
```
Since there is **no explicit constructor**, Java provides the default constructor, which initializes instance variables with their **default values** (`0` for integers, `null` for objects, `false` for boolean, etc.).

However, if a **parameterized constructor** is defined, Java **does not** generate a default constructor, and objects cannot be created without arguments unless an explicit **no-argument constructor** is provided.

# 13. Can we overload constructors in Java?
Yes, **constructors can be overloaded** in Java. **Constructor overloading** means defining multiple constructors in the same class with different **parameters (type, number, or order).** This allows object creation with varying initial values.

### Example of Constructor Overloading:
```java
class Person {
    String name;
    int age;

    // Default constructor
    Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with one parameter
    Person(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with two parameters
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person(); // Calls default constructor
        Person p2 = new Person("Alice"); // Calls constructor with one parameter
        Person p3 = new Person("Bob", 25); // Calls constructor with two parameters

        p1.display();
        p2.display();
        p3.display();
    }
}
```
### Output:
```
Name: Unknown, Age: 0
Name: Alice, Age: 0
Name: Bob, Age: 25
```

# 14. Can we call a constructor inside another constructor? (Constructor Chaining)
Yes, **we can call a constructor inside another constructor** in Java using **constructor chaining**. This allows one constructor to call another within the same class using `this()` or in a parent class using `super()`.

### **Types of Constructor Chaining**
1. **Within the same class** → Using `this()`
2. **Between parent and child classes** → Using `super()`


### **Example 1: Constructor Chaining in the Same Class (Using `this()`)**
```java
class Employee {
    String name;
    int age;
    String department;

    // Constructor 1: Default constructor
    Employee() {
        this("Unknown", 18); // Calls Constructor 2
    }

    // Constructor 2: Two parameters
    Employee(String name, int age) {
        this(name, age, "General"); // Calls Constructor 3
    }

    // Constructor 3: Three parameters
    Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(); // Calls default constructor
        emp1.display();
    }
}
```
### **Output:**
```
Name: Unknown, Age: 18, Department: General
```
### **Explanation:**
- `Employee()` calls `Employee(String, int)`.
- `Employee(String, int)` calls `Employee(String, int, String)`.
- The final constructor initializes values.


### **Example 2: Constructor Chaining Between Parent & Child Classes (Using `super()`)**
```java
class Animal {
    String species;

    Animal() {
        this("Unknown Species");
    }

    Animal(String species) {
        this.species = species;
    }
}

class Dog extends Animal {
    String breed;

    Dog() {
        super("Dog"); // Calls Animal(String) constructor
        this.breed = "Unknown Breed";
    }

    void display() {
        System.out.println("Species: " + species + ", Breed: " + breed);
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.display();
    }
}
```
### **Output:**
```
Species: Dog, Breed: Unknown Breed
```
### **Explanation:**
- `super("Dog")` calls `Animal(String species)`, setting `species = "Dog"`.
- The `Dog` constructor then initializes `breed`.




---

### **Method Overloading & Overriding Questions**
1. **Can we overload the `main` method in Java?**
2. **Can we override the `main` method in Java?**
3. **What is the difference between method overloading and method overriding?**
4. **Can we override a private method in Java?**
5. **Can a static method be overridden in Java?**
6. **Why can't we override static methods?**
7. **What happens if two methods have the same name but different return types in Java?**
8. **Can we change only the return type while overloading a method?**
9. **How does method resolution work in case of method overloading?**
10. **What is covariant return type in Java?**

---


### **Constructor & Static Block Questions**

1. **What is the default constructor, and when is it provided?**
2. **Can we overload constructors in Java?**
3. **Can we call a constructor inside another constructor? (Constructor Chaining)**
4. **Can we override a constructor in Java?**
5. **Can we inherit a constructor in Java?**
6. **What happens if the constructor is private? How can we create objects in that case?**
7. **Why can’t a constructor be `final`, `static`, or `abstract`?**
8. **What is the difference between instance block and static block?**
9. **Can a class have multiple static blocks?**
---

### **Static & Final Keyword Questions**
21. **Can we declare a static method inside an interface?**
22. **What happens if a static method tries to access a non-static variable?**
23. **What is the difference between `final`, `finally`, and `finalize`?**
24. **Can a class be both `final` and `abstract`?**
25. **Can we inherit a `final` method in Java?**
26. **Why is the `main` method declared as `public static void` in Java?**
27. **Can we make an abstract method static?**
28. **What happens if a static variable is modified by multiple threads in Java?**
29. **Why is the `volatile` keyword not enough for thread safety?**
30. **What is the purpose of `static` nested classes?**

---

### **Inheritance & Polymorphism Questions**
31. **What is the difference between abstract class and interface in Java?**
32. **Can an interface extend another interface?**
33. **Can an interface implement another interface?**
34. **Can an abstract class have a constructor?**
35. **What is multiple inheritance in Java? How does Java handle it?**
36. **What is the diamond problem in Java? How does Java resolve it?**
37. **How does dynamic method dispatch work in Java?**
38. **Can a class implement multiple interfaces in Java?**
39. **What is marker interface in Java?**
40. **How does polymorphism help in designing scalable applications?**

---

### **Exception Handling Questions**
41. **Can we override a method and throw a broader exception?**
42. **What is the difference between `throw` and `throws`?**
43. **What happens if an exception occurs inside a catch block?**
44. **Can a `finally` block throw an exception? What happens in that case?**
45. **What happens if we don't handle a checked exception?**
46. **What is the difference between checked and unchecked exceptions?**
47. **Can we have multiple catch blocks for a single try block?**
48. **Can we catch multiple exceptions in a single catch block?**
49. **Can we have a try block without a catch block?**
50. **Can we declare a try block inside a finally block?**
51. **What happens if an exception occurs inside a static block?**


---

### **Memory Management & GC Questions**
51. **How does Java handle memory management?**
52. **What are strong, weak, soft, and phantom references in Java?**
53. **Can we force garbage collection in Java?**
54. **What is the difference between Heap and Stack memory?**
55. **How does garbage collection work in Java?**
56. **What is the purpose of the `finalize()` method? Is it still recommended?**
57. **What are different types of garbage collectors in Java?**
58. **What is a memory leak in Java, and how can we prevent it?**
59. **What is `OutOfMemoryError`, and how can we handle it?**
60. **What is the purpose of the `WeakHashMap` class?**

---

Would you like me to provide sample answers or explanations for these? 🚀
