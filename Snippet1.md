### 1. Varargs Example
```java
package com.codemaster.test;

public class Demo {
    public static void show(int... a){
        for (int i : a)
        {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        show(1,2,3);  // Output: 1 2 3 
        show();       // Output: (no output, empty varargs)
    }
}
```
**Explanation**: The `show` method accepts variable arguments (`int... a`). When called with `1,2,3`, it prints them. When called with no arguments, it prints nothing (empty loop).

---

### 2. Static Method Hiding
```java
package com.codemaster.test;

public class Parent {
    public static void display() {
        System.out.println("Parent");
    }
}

public class Child extends Parent{
    public static void display(){
        System.out.println("Child");
    }
}

public class Demo {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.display(); // Output: Parent
    }
}
```
**Explanation**: Static methods are resolved at compile-time based on the reference type (`Parent`), not the runtime object (`Child`). This is called "method hiding."

---

### 3. Integer Caching
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b); // Output: true
        System.out.println(c == d); // Output: false
    }
}
```
**Explanation**: Integers between `-128` and `127` are cached in Java. For `a` and `b` (100), the same cached object is used, so `==` returns `true`. For `c` and `d` (200), new objects are created, so `==` returns `false`.

---

### 4. TreeSet with Uppercase Letters
```java
package com.codemaster.test;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("C");
        System.out.println(treeSet); // Output: [A, B, C]
    }
}
```
**Explanation**: `TreeSet` sorts elements in natural order (lexicographical for strings). Output is `[A, B, C]`.

---

### 5. TreeSet with Mixed Case Letters
```java
package com.codemaster.test;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("B");
        treeSet.add("a");
        treeSet.add("C");
        System.out.println(treeSet); // Output: [B, C, a]
    }
}
```
**Explanation**: In ASCII/Unicode, uppercase letters (`A-Z`) come before lowercase (`a-z`). So, the order is `[B, C, a]`.

---

### 6. String Interning
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        String str1 = new String("kunal").intern();
        String str2 = "kunal";
        System.out.println(str1 == str2); // Output: true
    }
}
```
**Explanation**: `intern()` ensures the string is from the string pool. `str1` and `str2` point to the same pooled string, so `==` returns `true`.

---

### 7. LinkedList Order
```java
package com.codemaster.test;

import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("C");
        System.out.println(linkedList); // Output: [B, A, C]
    }
}
```
**Explanation**: `LinkedList` maintains insertion order. Output is `[B, A, C]`.

---

### 8. Static and Instance Initializers (No Constructor)
```java
package com.codemaster.test;

public class Demo {
    static {
        System.out.println("Static Initializer");
    }
    {
        System.out.println("Instance Initializer");
    }
    public static void main(String[] args) {
        Demo demo1 = new Demo(); // Output: Static Initializer, Instance Initializer
        Demo demo2 = new Demo(); // Output: Instance Initializer
    }
}
```
**Explanation**: The static block runs once when the class loads. The instance block runs before each constructor call (even if no explicit constructor is defined).

---

### 9. Static, Instance, and Constructor Initializers
```java
package com.codemaster.test;

public class Demo {
    static {
        System.out.println("Static Initializer");
    }
    {
        System.out.println("Instance Initializer");
    }
    public Demo() {
        System.out.println("Constructor Initializer");
    }
    public static void main(String[] args) {
        Demo demo1 = new Demo(); // Output: Static, Instance, Constructor
        Demo demo2 = new Demo(); // Output: Instance, Constructor
    }
}
```
**Explanation**: Static block runs once. For each object, the order is: instance block → constructor.

---

### 10. String Interning (False Case)
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        String str1 = new String("kunal");
        String str2 = str1.intern();
        System.out.println(str1 == str2); // Output: false
    }
}
```
**Explanation**: `str1` points to a heap object, while `str2` points to the pooled string. They are different references.

---

### 11. String Reference Equality
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        String str1 = new String("kunal");
        String str2 = str1;
        System.out.println(str1 == str2); // Output: true
    }
}
```
**Explanation**: `str2` is assigned the same reference as `str1`, so `==` returns `true`.

---

### 12. Compound Assignment Trick
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x -= x-- - x--); // Output: 10
    }
}
```
**Explanation**:
1. `x--` evaluates to 10 (post-decrement), then `x` becomes 9.
2. Next `x--` evaluates to 9 (post-decrement), then `x` becomes 8.
3. The expression becomes `x -= (10 - 9)`, i.e., `x = x - 1` → `x = 9 - 1 = 8`.
   (Correction: The output is actually `8` due to the above steps.)

---

### 13. Constructor and Inheritance
```java
package com.codemaster.test;

public class Parent {
    public Parent() {
        System.out.println("Parent Constructor");
        display();
    }
    public void display() {
        System.out.println("Parent display");
    }
}

public class Child extends Parent{
    int x = 10;
    public Child() {
        System.out.println("Child Constructor, x = " + x);
    }
    public void display() {
        System.out.println("Child display, x = " + x);
    }
}

public class Demo {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
```
**Output**:
```
Parent Constructor
Child display, x = 0  // x not initialized yet
Child Constructor, x = 10
```
**Explanation**: During `Child` instantiation:
1. `Parent` constructor runs first, calling overridden `display()` in `Child`.
2. At this point, `x` is not yet initialized (defaults to `0`).
3. Then `Child` constructor runs, initializing `x` to 10.

---

### 14. Stream FlatMap
```java
package com.codemaster.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
```
**Explanation**: `flatMap` flattens nested lists into a single list.

---

### 15. Final Variable Initialization
```java
package com.codemaster.test;

public class Demo {
    final int num;
    public Demo() {
        num = 50;
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.num); // Output: 50
    }
}
```
**Explanation**: `final` variables must be initialized exactly once (here in the constructor).

---

### 16. Unmodifiable List Operations
```java
package com.codemaster.test;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
       var list = List.of(1, 2, 3);
       list.replaceAll(num -> num * 2); // Throws UnsupportedOperationException
       list.add(4);                    // Throws UnsupportedOperationException
       System.out.println(list);
    }
}
```
**Explanation**: `List.of()` creates an unmodifiable list. Both `replaceAll` and `add` throw `UnsupportedOperationException`.

---

### 17. String Substring and Immutability
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
       String str = "HelloWorld";
       String sub = str.substring(5).substring(0, 5); // "World".substring(0,5) -> "World"
       sub = sub.toUpperCase();                       // "WORLD"
       sub.concat(str.substring(0, 5).toLowerCase()); // Ignored (strings are immutable)
       System.out.println(sub); // Output: "WORLD"
    }
}
```
**Explanation**: `concat` creates a new string but is ignored. `sub` remains `"WORLD"`.

---

### 18. SubList Backed by Original List
```java
package com.codemaster.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> subList = list.subList(1, 3); // ["B", "C"]
        subList.add("E");                          // Modifies original list
        System.out.println(list); // Output: [A, B, C, E, D]
    }
}
```
**Explanation**: `subList` is a view of the original list. Adding `"E"` inserts it into the original list at index 3.

---

### 19. Try-Catch-Finally with Return
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println("try block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch block");
            return;
        } finally {
            System.out.println("finally block");
        }
    }
}
```
**Output**:
```
try block
catch block
finally block
```
**Explanation**: `finally` runs even if `catch` has a `return`.

---

### 20. ComputeIfAbsent
```java
package com.codemaster.test;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.computeIfAbsent("key", s -> 1); // Adds ("key", 1)
        map.computeIfAbsent("key", s -> 2); // No effect (key exists)
        System.out.println(map.get("key")); // Output: 1
    }
}
```
**Explanation**: `computeIfAbsent` only runs the lambda if the key is absent.

---

### 21. HashMap with Null Key/Value
```java
package com.codemaster.test;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", null);
        map.put(null, "B");
        System.out.println(map.getOrDefault(null, "C")); // Output: B (key exists)
        System.out.println(map.getOrDefault("null", "C")); // Output: C (key doesn't exist)
    }
}
```
**Explanation**: `HashMap` allows one `null` key and multiple `null` values. `getOrDefault` returns the default only if the key is absent.

---

### 22. String Split with Empty Token
```java
package com.codemaster.test;

public class Demo {
    public static void main(String[] args) {
        String fruitStr = "apple,bananna,,cherry";
        String[] fruits = fruitStr.split(",");
        System.out.println(fruits[2]); // Output: "" (empty string)
    }
}
```
**Explanation**: `split` includes empty strings between delimiters.

---

### 23. List Remove by Value and Index
```java
package com.codemaster.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "A"));
        list.remove("A"); // Removes first "A"
        list.remove(1);   // Removes element at index 1 ("C")
        System.out.println(list); // Output: [B, A]
    }
}
```
**Explanation**: `remove("A")` removes the first occurrence. `remove(1)` removes the element at index 1.

