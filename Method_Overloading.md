# Complete Java Method Overloading Guide with Corrected Examples

## **1. Basic Overloading (Primitive Types)**
```java
package com.codemaster.test;

public class BasicOverloading {
    void print(int x) { 
        System.out.println("int: " + x); 
    }
    
    void print(double x) { 
        System.out.println("double: " + x); 
    }

    public static void main(String[] args) {
        BasicOverloading demo = new BasicOverloading();
        demo.print(10);    // Output: "int: 10"
        demo.print(10.0);  // Output: "double: 10.0"
    }
}
```
**Key Point**: The JVM picks the **most specific** method (e.g., `int` over `double` for `10`).

---

## **2. Ambiguity with Autoboxing**
```java
package com.codemaster.test;

public class AutoboxingExample {
    void print(Integer x) { 
        System.out.println("Integer: " + x); 
    }
    
    void print(double x) { 
        System.out.println("double: " + x); 
    }

    public static void main(String[] args) {
        AutoboxingExample demo = new AutoboxingExample();
        demo.print(10); // Output: "double: 10.0" (widening beats autoboxing)
    }
}
```
**Corrected Explanation**: Widening (`int → double`) is preferred over autoboxing (`int → Integer`).

---

## **3. Varargs vs. Array**
```java
package com.codemaster.test;

public class VarargsExample {
    void print(String... strs) { 
        System.out.println("Varargs"); 
    }
    
    void print(String[] strs) { 
        System.out.println("Array"); 
    }

    public static void main(String[] args) {
        VarargsExample demo = new VarargsExample();
        // demo.print(new String[]{"A"}); // Compile error: ambiguous!
        demo.print("A", "B"); // Output: "Varargs" (explicit varargs call)
    }
}
```
**Key Point**: Varargs and arrays are **indistinguishable** for overloading when passing arrays.

---

## **4. Null Argument Ambiguity**
```java
package com.codemaster.test;

public class NullAmbiguityExample {
    void print(String s) { 
        System.out.println("String"); 
    }
    
    void print(Object o) { 
        System.out.println("Object"); 
    }

    public static void main(String[] args) {
        NullAmbiguityExample demo = new NullAmbiguityExample();
        demo.print(null); // Output: "String" (more specific type wins)
        demo.print("hello"); // Output: "String"
        demo.print((Object)"hello"); // Output: "Object" (explicit cast)
    }
}
```
**Key Point**: `String` is more specific than `Object`, so the JVM chooses it for `null`.

---

## **5. Inheritance and Overloading**
```java
package com.codemaster.test;

class Parent {
    void run(String s) { 
        System.out.println("Parent"); 
    }
}

class Child extends Parent {
    void run(Object o) { 
        System.out.println("Child"); 
    }
}

public class InheritanceOverloadingExample {
    public static void main(String[] args) {
        Child child = new Child();
        child.run("hello"); // Output: "Parent" (overloading doesn't override!)
        child.run((Object)"hello"); // Output: "Child" (explicit cast)
    }
}
```
**Key Point**: Overloaded methods in child classes **do not override** parent methods with different signatures.

---

## **6. Primitive vs. Wrapper Ambiguity**
```java
package com.codemaster.test;

public class PrimitiveWrapperExample {
    void print(int x) { 
        System.out.println("int"); 
    }
    
    void print(Integer x) { 
        System.out.println("Integer"); 
    }

    public static void main(String[] args) {
        PrimitiveWrapperExample demo = new PrimitiveWrapperExample();
        demo.print(10);   // Output: "int" (exact match)
        demo.print((Integer)null); // Output: "Integer" (only valid option)
    }
}
```
**Key Point**: `null` can only bind to non-primitive parameters (`Integer`).

---

## **7. Static vs. Instance Methods**
```java
package com.codemaster.test;

public class StaticInstanceExample {
    static void print(String s) { 
        System.out.println("Static"); 
    }
    
    void print(Object o) { 
        System.out.println("Instance"); 
    }

    public static void main(String[] args) {
        StaticInstanceExample demo = new StaticInstanceExample();
        demo.print("hello"); // Output: "Instance" (instance method called)
        StaticInstanceExample.print("hello"); // Output: "Static" (static method called)
    }
}
```
**Corrected Explanation**: Static and instance methods can coexist with same signature, but are resolved based on how they're called.

---

## **8. Widening vs. Autoboxing vs. Varargs**
```java
package com.codemaster.test;

public class PriorityExample {
    void print(long x) { 
        System.out.println("long"); 
    }
    
    void print(Integer x) { 
        System.out.println("Integer"); 
    }
    
    void print(int... x) { 
        System.out.println("varargs"); 
    }

    public static void main(String[] args) {
        PriorityExample demo = new PriorityExample();
        demo.print(10); // Output: "long" (widening beats autoboxing and varargs)
    }
}
```
**Order of Preference**:
1. Exact match (`int`)
2. Widening (`int → long`)
3. Autoboxing (`int → Integer`)
4. Varargs (`int...`)

---

## **9. Generics and Overloading**
```java
package com.codemaster.test;

import java.util.List;
import java.util.ArrayList;

public class GenericsExample {
    // This won't compile - type erasure makes them identical
    /*
    void print(List<String> list) { 
        System.out.println("Strings"); 
    }
    
    void print(List<Integer> list) { 
        System.out.println("Integers"); 
    }
    */
    
    // Corrected version using different method names
    void printStrings(List<String> list) { 
        System.out.println("Strings"); 
    }
    
    void printIntegers(List<Integer> list) { 
        System.out.println("Integers"); 
    }

    public static void main(String[] args) {
        GenericsExample demo = new GenericsExample();
        demo.printStrings(new ArrayList<>());
        demo.printIntegers(new ArrayList<>());
    }
}
```
**Key Point**: Due to **type erasure**, generic parameter types cannot be overloaded.

---

## **10. Return Type Ignored**
```java
package com.codemaster.test;

public class ReturnTypeExample {
    int calculate(int x) { 
        return x; 
    }
    
    // This won't compile - return type ignored for overloading
    /*
    double calculate(int x) { 
        return x; 
    }
    */
    
    // Corrected version with different parameter
    double calculate(double x) { 
        return x; 
    }

    public static void main(String[] args) {
        ReturnTypeExample demo = new ReturnTypeExample();
        System.out.println(demo.calculate(10));    // Output: 10
        System.out.println(demo.calculate(10.5));  // Output: 10.5
    }
}
```
**Key Point**: Overloading **only considers method names and parameter types**, not return types.

---

## **11. Interface Default Method Conflict**
```java
package com.codemaster.test;

interface A { 
    default void run() { 
        System.out.println("A"); 
    } 
}

interface B { 
    default void run() { 
        System.out.println("B"); 
    } 
}

class C implements A, B { 
    @Override 
    public void run() { 
        A.super.run(); // Must override to resolve conflict
    }
}

public class InterfaceConflictExample {
    public static void main(String[] args) {
        C c = new C();
        c.run(); // Output: "A"
    }
}
```
**Key Point**: Default methods with the same signature cause **conflicts**, requiring explicit overrides.

---

## **12. Constructor Overloading**
```java
package com.codemaster.test;

public class ConstructorOverloadingExample {
    ConstructorOverloadingExample(int x) { 
        System.out.println("int"); 
    }
    
    ConstructorOverloadingExample(double x) { 
        System.out.println("double"); 
    }
    
    ConstructorOverloadingExample(Integer x) { 
        System.out.println("Integer"); 
    }

    public static void main(String[] args) {
        new ConstructorOverloadingExample(10);   // Output: "int" (exact match)
        new ConstructorOverloadingExample(10.0); // Output: "double"
        new ConstructorOverloadingExample((Integer)null); // Output: "Integer"
    }
}
```
**Key Point**: Constructor overloading follows the same rules as methods.

---

## **13. Method Reference Ambiguity**
```java
package com.codemaster.test;

interface Processor { 
    void process(String s); 
}

interface Converter { 
    void convert(String s); 
}

public class MethodReferenceExample {
    static void print(String s) { 
        System.out.println(s); 
    }

    public static void main(String[] args) {
        Processor p = MethodReferenceExample::print; // OK
        Converter c = MethodReferenceExample::print; // Also OK (same descriptor)
        
        p.process("Hello from Processor");
        c.convert("Hello from Converter");
    }
}
```
**Key Point**: Method references **do not cause overloading conflicts** if functional interfaces differ.

---

## **14. Widening Primitive Conversion (Promotion)**
```java
package com.codemaster.test;

public class WideningExample {
    void print(double x) { 
        System.out.println("double: " + x); 
    }

    public static void main(String[] args) {
        WideningExample demo = new WideningExample();
        demo.print(10); // Output: "double: 10.0" (int → double)
    }
}
```
**Promotion Hierarchy**:  
`byte → short → int → long → float → double`  
`char → int`

---

## **15. Autoboxing vs. Widening**
```java
package com.codemaster.test;

public class AutoboxingVsWideningExample {
    void print(double x) { 
        System.out.println("double"); 
    }
    
    void print(Integer x) { 
        System.out.println("Integer"); 
    }

    public static void main(String[] args) {
        AutoboxingVsWideningExample demo = new AutoboxingVsWideningExample();
        demo.print(10); // Output: "double" (widening beats autoboxing)
    }
}
```
**Key Point**: Autoboxing (to wrapper classes) is **less preferred** than widening.

---

## **16. Ambiguity in Promotion**
```java
package com.codemaster.test;

public class AmbiguousPromotionExample {
    void print(long x) { 
        System.out.println("long"); 
    }
    
    void print(float x) { 
        System.out.println("float"); 
    }

    public static void main(String[] args) {
        AmbiguousPromotionExample demo = new AmbiguousPromotionExample();
        // demo.print(10); // Compile error: ambiguous (int → long or int → float?)
        demo.print(10L); // Output: "long" (explicit long literal)
        demo.print(10.0f); // Output: "float" (explicit float literal)
    }
}
```
**Key Point**: If two methods are equally promotable, it causes ambiguity.

---

## **17. Char Promotion**
```java
package com.codemaster.test;

public class CharPromotionExample {
    void print(int x) { 
        System.out.println("int: " + x); 
    }

    public static void main(String[] args) {
        CharPromotionExample demo = new CharPromotionExample();
        demo.print('A'); // Output: "int: 65" (char → int)
    }
}
```
**Key Point**: `char` promotes to `int` if no exact match exists.

---

## **18. Varargs as Last Resort**
```java
package com.codemaster.test;

public class VarargsLastResortExample {
    void print(int x, int y) { 
        System.out.println("Exact"); 
    }
    
    void print(int... x) { 
        System.out.println("Varargs"); 
    }

    public static void main(String[] args) {
        VarargsLastResortExample demo = new VarargsLastResortExample();
        demo.print(1, 2); // Output: "Exact" (exact match preferred)
        demo.print(1, 2, 3); // Output: "Varargs" (no exact match available)
    }
}
```
**Key Point**: Varargs are chosen only if no other option exists.

---

## **Summary Tables**

### **Method Overloading Resolution Rules**
| Scenario                  | Resolution Logic                                                                 |
|---------------------------|---------------------------------------------------------------------------------|
| Exact match               | `print(int)` → `print(int)`                                                     |
| Widening                  | `print(int)` → `print(long)`                                                    |
| Autoboxing                | `print(int)` → `print(Integer)`                                                 |
| Varargs                   | Lowest priority (`print(int...)`)                                               |
| Null argument             | Most specific non-primitive type (`String` over `Object`)                       |
| Static vs. instance       | Resolved based on calling context                                               |
| Generics                  | Erasure prevents overloading (`List<String>` vs. `List<Integer>`)               |

### **Promotion Priority Order**
| Input Type | Method Signature Choices (Order of Priority)               |
|------------|------------------------------------------------------------|
| `int`      | `print(int)` → `print(long)` → `print(Integer)` → `print(int...)` |
| `char`     | `print(char)` → `print(int)` → `print(long)` → ...        |
| `null`     | `print(String)` → `print(Object)` → `print(Integer)` (no primitives) |

---

## **Key Takeaways**
1. **Precedence Order**: Exact → Widen → Autobox → Varargs
2. **No Return-Type Overloading**: Only parameter types matter
3. **Nulls Bind to Non-Primitives**: `null` chooses the most specific reference type
4. **Avoid Ambiguity**: Varargs/arrays and generics often cause conflicts
5. **Inheritance ≠ Overloading**: Child class methods with different signatures don't override parents
6. **Widening beats autoboxing** (e.g., `int → double` over `int → Integer`)
7. **Ambiguity arises** if two methods are equally promotable (e.g., `long` vs. `float`)
8. **Char is treated as `int`** if no `char` overload exists
9. **Varargs are the least preferred**
10. **Static and instance methods** are resolved based on calling context, not overloading rules

For performance-critical code, minimize overloading ambiguity as it adds JVM resolution overhead. Use distinct method names when possible!