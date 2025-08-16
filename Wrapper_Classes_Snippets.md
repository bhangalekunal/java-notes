# Complete Java Wrapper Classes Guide with Corrected Examples

## **1. Integer Caching and `==`**
```java
package com.codemaster.wrapper;

public class IntegerCachingExample {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);  // true

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);  // false
        
        System.out.println(c.equals(d)); // true (correct way to compare)
    }
}
```
**Explanation**: Java caches `Integer` values between **-128 to 127** for performance. For cached values, the same object is returned. For non-cached values, new objects are created.

---

## **2. Autoboxing and NullPointerException**
```java
package com.codemaster.wrapper;

public class AutoboxingNPEExample {
    public static void main(String[] args) {
        Integer num = null;
        try {
            int val = num;  // Throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
        
        // Safe way
        if (num != null) {
            int val = num; // Safe auto-unboxing
        }
    }
}
```
**Explanation**: Auto-unboxing calls the wrapper's value method (`intValue()`). If the wrapper is `null`, it throws `NullPointerException`.

---

## **3. Boolean Wrapper Equality**
```java
package com.codemaster.wrapper;

public class BooleanEqualityExample {
    public static void main(String[] args) {
        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);  // true

        Boolean b3 = new Boolean(true);  // Deprecated in Java 9+
        Boolean b4 = new Boolean(true);  // Deprecated in Java 9+
        System.out.println(b3 == b4);  // false
        System.out.println(b3.equals(b4));  // true
        
        // Preferred way (Java 9+)
        Boolean b5 = Boolean.valueOf(true);
        Boolean b6 = Boolean.valueOf(true);
        System.out.println(b5 == b6);  // true (cached)
    }
}
```
**Explanation**: `Boolean` has cached instances for `true` and `false`. The `Boolean` constructor is deprecated; use `Boolean.valueOf()` instead.

---

## **4. Double NaN Comparison**
```java
package com.codemaster.wrapper;

public class DoubleNaNExample {
    public static void main(String[] args) {
        Double d1 = Double.NaN;
        Double d2 = Double.NaN;
        System.out.println(d1 == d2);       // false
        System.out.println(d1.equals(d2));  // true
        
        // Proper way to check NaN
        System.out.println(Double.isNaN(d1)); // true
        
        // Primitive behavior is the same
        double p1 = Double.NaN;
        double p2 = Double.NaN;
        System.out.println(p1 == p2);       // false
        System.out.println(Double.isNaN(p1)); // true
    }
}
```
**Explanation**: `NaN` is not equal to itself in floating-point arithmetic, but `Double.equals()` handles this special case.

---

## **5. Integer Division vs. Double Division**
```java
package com.codemaster.wrapper;

public class WrapperDivisionExample {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 2;
        System.out.println(a / b);  // 2 (int division - truncated)

        Double c = 5.0;
        Double d = 2.0;
        System.out.println(c / d);  // 2.5 (double division)
        
        // Mixed division
        System.out.println(a / d);  // 2.5 (int auto-unboxed, promoted to double)
    }
}
```
**Explanation**: Wrapper classes follow the same arithmetic rules as their primitive counterparts.

---

## **6. Wrapper Class Mutability**
```java
package com.codemaster.wrapper;

public class WrapperMutabilityExample {
    public static void main(String[] args) {
        Integer x = 10;
        Integer original = x;
        x++;  // Auto-unbox, increment, auto-box
        System.out.println("x: " + x);        // 11
        System.out.println("original: " + original); // 10
        System.out.println("x == original: " + (x == original)); // false
        
        // What actually happens:
        Integer y = 10;
        y = Integer.valueOf(y.intValue() + 1); // New object created
    }
}
```
**Explanation**: Wrapper classes are immutable. Operations like `++` create new objects.

---

## **7. Integer.parseInt() vs. Integer.valueOf()**
```java
package com.codemaster.wrapper;

public class ParseVsValueOfExample {
    public static void main(String[] args) {
        int a = Integer.parseInt("123");      // returns primitive int
        Integer b = Integer.valueOf("123");   // returns Integer object
        System.out.println(a == b);           // true (auto-unboxing for comparison)
        
        // Performance difference
        int primitive = Integer.parseInt("100"); // Direct primitive
        Integer wrapper = Integer.valueOf("100"); // May use cached object
        
        System.out.println("Type of a: primitive int");
        System.out.println("Type of b: " + b.getClass().getSimpleName());
    }
}
```
**Explanation**: `parseInt()` returns a primitive, while `valueOf()` returns a wrapper object (with potential caching).

---

## **8. Long Wrapper Equality**
```java
package com.codemaster.wrapper;

public class LongEqualityExample {
    public static void main(String[] args) {
        Long l1 = 100L;
        Long l2 = 100L;
        System.out.println(l1 == l2);  // true (cached)

        Long l3 = 1000L;
        Long l4 = 1000L;
        System.out.println(l3 == l4);  // false (not cached)
        System.out.println(l3.equals(l4)); // true (correct way)
        
        // Cache range is same as Integer: -128 to 127
        Long cached = 127L;
        Long alsoCached = 127L;
        System.out.println(cached == alsoCached); // true
    }
}
```
**Explanation**: `Long` also caches values between -128 to 127, same as `Integer`.

---

## **9. Character Wrapper Methods**
```java
package com.codemaster.wrapper;

public class CharacterMethodsExample {
    public static void main(String[] args) {
        Character ch = 'A';
        System.out.println(Character.isLetter(ch));      // true
        System.out.println(Character.isDigit('7'));      // true
        System.out.println(Character.isWhitespace(' ')); // true
        System.out.println(Character.isUpperCase(ch));   // true
        System.out.println(Character.toLowerCase(ch));   // 'a'
        
        // Also works with char primitives
        char c = '5';
        System.out.println(Character.getNumericValue(c)); // 5
        System.out.println(Character.isLetterOrDigit(c)); // true
    }
}
```
**Explanation**: `Character` class provides many static utility methods for character manipulation and testing.

---

## **10. Wrapper Class in Collections**
```java
package com.codemaster.wrapper;

import java.util.*;

public class WrapperInCollectionsExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);        // auto-boxing (int → Integer)
        list.add(2);
        
        int num = list.get(0);  // auto-unboxing (Integer → int)
        System.out.println("Retrieved: " + num);
        
        // Potential NPE issue
        List<Integer> listWithNull = Arrays.asList(1, null, 3);
        try {
            for (int value : listWithNull) { // Auto-unboxing happens here
                System.out.println(value);
            }
        } catch (NullPointerException e) {
            System.out.println("NPE when unboxing null");
        }
    }
}
```
**Explanation**: Collections require wrapper classes. Be careful of `NullPointerException` when auto-unboxing null values.

---

## **11. Integer Overflow in Wrappers**
```java
package com.codemaster.wrapper;

public class WrapperOverflowExample {
    public static void main(String[] args) {
        Integer max = Integer.MAX_VALUE;
        System.out.println("Max value: " + max);
        System.out.println("Max + 1: " + (max + 1));  // -2147483648 (overflow)
        
        // Safe arithmetic (Java 8+)
        try {
            int safe = Math.addExact(max, 1);
        } catch (ArithmeticException e) {
            System.out.println("Overflow detected: " + e.getMessage());
        }
        
        // BigInteger for really large numbers
        java.math.BigInteger bigMax = java.math.BigInteger.valueOf(max);
        System.out.println("BigInteger + 1: " + bigMax.add(java.math.BigInteger.ONE));
    }
}
```
**Explanation**: Wrapper classes don't prevent overflow. Use `Math.addExact()` or `BigInteger` for safe arithmetic.

---

## **12. Comparing Different Wrappers**
```java
package com.codemaster.wrapper;

public class DifferentWrapperComparisonExample {
    public static void main(String[] args) {
        Integer i = 10;
        Double d = 10.0;
        Long l = 10L;
        
        System.out.println(i.equals(d));  // false (different types)
        System.out.println(i.equals(l));  // false (different types)
        
        // Value comparison across types
        System.out.println(i.intValue() == d.intValue()); // true
        System.out.println(i.doubleValue() == d.doubleValue()); // true
        
        // Using Number superclass
        Number n1 = i;
        Number n2 = d;
        System.out.println(n1.doubleValue() == n2.doubleValue()); // true
    }
}
```
**Explanation**: `.equals()` checks both type and value. Different wrapper types are never equal.

---

## **13. System.out.println() and Wrapper Overloading**
```java
package com.codemaster.wrapper;

public class PrintlnOverloadingExample {
    public static void main(String[] args) {
        System.out.println(100);      // Prints "100" (int overload)
        System.out.println(Integer.valueOf(100)); // Prints "100" (Object overload)
        
        // Both produce same output, but use different overloads
        System.out.println("Direct int: " + 100);
        System.out.println("Integer object: " + Integer.valueOf(100));
        
        // toString() is called automatically for Object overload
        Integer wrapper = 100;
        System.out.println("Wrapper toString(): " + wrapper.toString());
    }
}
```
**Explanation**: `println` has overloads for primitives and `Object`. Integer wrappers use the `Object` overload.

---

## **14. Wrapper Class Serialization**
```java
package com.codemaster.wrapper;

import java.io.*;

public class WrapperSerializationExample {
    public static void main(String[] args) throws Exception {
        Integer original = 100; // Cached value
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(original);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Integer deserialized = (Integer) ois.readObject();
        ois.close();
        
        System.out.println("Original: " + original);
        System.out.println("Deserialized: " + deserialized);
        System.out.println("== comparison: " + (original == deserialized)); // May be false!
        System.out.println("equals() comparison: " + original.equals(deserialized)); // true
    }
}
```
**Explanation**: Deserialization may not preserve object identity for cached values. Always use `.equals()`.

---

## **15. Integer.valueOf() with Radix**
```java
package com.codemaster.wrapper;

public class RadixParsingExample {
    public static void main(String[] args) {
        Integer hex = Integer.valueOf("FF", 16);    // Hexadecimal
        Integer binary = Integer.valueOf("1010", 2); // Binary
        Integer octal = Integer.valueOf("77", 8);    // Octal
        
        System.out.println("FF (hex): " + hex);     // 255
        System.out.println("1010 (bin): " + binary); // 10
        System.out.println("77 (oct): " + octal);   // 63
        
        try {
            Integer invalid = Integer.valueOf("GG", 16); // Invalid hex
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
}
```
**Explanation**: `valueOf(String, radix)` can parse numbers in different bases.

---

## **16. Boolean.getBoolean() vs Boolean.parseBoolean()**
```java
package com.codemaster.wrapper;

public class BooleanParsingExample {
    public static void main(String[] args) {
        // Set system property
        System.setProperty("myFlag", "true");
        
        System.out.println(Boolean.getBoolean("myFlag"));      // true (reads system property)
        System.out.println(Boolean.getBoolean("nonexistent")); // false (property doesn't exist)
        
        System.out.println(Boolean.parseBoolean("TRUE"));      // true (case-insensitive)
        System.out.println(Boolean.parseBoolean("false"));     // false
        System.out.println(Boolean.parseBoolean("random"));    // false (anything except "true")
        
        // Common mistake
        System.out.println(Boolean.getBoolean("true"));        // false! (no system property named "true")
    }
}
```
**Explanation**: `getBoolean()` reads system properties, while `parseBoolean()` parses strings directly.

---

## **17. Integer Bit Manipulation Methods**
```java
package com.codemaster.wrapper;

public class IntegerBitManipulationExample {
    public static void main(String[] args) {
        int num = 12; // Binary: 1100
        
        System.out.println("Original: " + num + " (binary: " + Integer.toBinaryString(num) + ")");
        System.out.println("Bit count: " + Integer.bitCount(num));           // 2 (number of 1s)
        System.out.println("Leading zeros: " + Integer.numberOfLeadingZeros(num)); // 28
        System.out.println("Trailing zeros: " + Integer.numberOfTrailingZeros(num)); // 2
        
        int reversed = Integer.reverse(num);
        System.out.println("Reversed bits: " + reversed + " (binary: " + Integer.toBinaryString(reversed) + ")");
        
        int rotated = Integer.rotateLeft(num, 1);
        System.out.println("Rotate left by 1: " + rotated + " (binary: " + Integer.toBinaryString(rotated) + ")");
    }
}
```
**Explanation**: Integer class provides many bit manipulation utility methods.

---

## **18. Number Superclass Behavior**
```java
package com.codemaster.wrapper;

public class NumberSuperclassExample {
    public static void main(String[] args) {
        Number[] numbers = {
            Integer.valueOf(10),
            Double.valueOf(10.5),
            Long.valueOf(100L),
            Float.valueOf(3.14f)
        };
        
        for (Number num : numbers) {
            System.out.println("Value: " + num);
            System.out.println("  as int: " + num.intValue());
            System.out.println("  as double: " + num.doubleValue());
            System.out.println("  as long: " + num.longValue());
            System.out.println("  class: " + num.getClass().getSimpleName());
            System.out.println();
        }
    }
}
```
**Explanation**: All numeric wrapper classes extend `Number`, providing conversion methods.

---

## **19. Integer Unsigned Operations (Java 8+)**
```java
package com.codemaster.wrapper;

public class UnsignedOperationsExample {
    public static void main(String[] args) {
        int negative = -1;
        int positive = 1;
        
        // Signed comparison
        System.out.println("Signed compare(-1, 1): " + Integer.compare(negative, positive)); // -1
        
        // Unsigned comparison (treats -1 as 0xFFFFFFFF)
        System.out.println("Unsigned compare(-1, 1): " + Integer.compareUnsigned(negative, positive)); // 1
        
        // Unsigned division
        System.out.println("Unsigned divide(-1, 2): " + Integer.divideUnsigned(negative, 2)); // 2147483647
        
        // Unsigned string representation
        System.out.println("Unsigned string(-1): " + Integer.toUnsignedString(negative)); // 4294967295
        System.out.println("Unsigned long(-1): " + Integer.toUnsignedLong(negative)); // 4294967295
    }
}
```
**Explanation**: Java 8+ added unsigned operations for `Integer` and `Long` classes.

---

## **20. Wrapper Class Hash Codes**
```java
package com.codemaster.wrapper;

import java.util.HashMap;
import java.util.Map;

public class WrapperHashCodeExample {
    public static void main(String[] args) {
        System.out.println("Integer(10) hashCode: " + Integer.valueOf(10).hashCode()); // 10
        System.out.println("Integer(0) hashCode: " + Integer.valueOf(0).hashCode());   // 0
        
        System.out.println("Double(10.5) hashCode: " + Double.valueOf(10.5).hashCode());
        System.out.println("Double(10.0) hashCode: " + Double.valueOf(10.0).hashCode());
        
        System.out.println("Boolean(true) hashCode: " + Boolean.TRUE.hashCode());  // 1231
        System.out.println("Boolean(false) hashCode: " + Boolean.FALSE.hashCode()); // 1237
        
        // HashMap usage
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "ten");
        System.out.println("Map get with int: " + map.get(10)); // Works due to auto-boxing
        
        Map<Double, String> doubleMap = new HashMap<>();
        doubleMap.put(10.0, "ten point zero");
        System.out.println("Map get with double: " + doubleMap.get(10.0));
    }
}
```
**Explanation**: Hash codes are crucial for `HashMap`/`HashSet`. Integer returns the value itself, while Double uses bit representation.

---

## **Key Takeaways:**
1. **Always use `.equals()` instead of `==`** for wrapper class comparisons
2. **Beware of `NullPointerException`** in auto-unboxing scenarios
3. **Wrapper classes are immutable** - operations create new objects
4. **Caching applies to small values** (-128 to 127) for Integer, Long, etc.
5. **Serialization may break reference equality** even for cached values
6. **Use appropriate parsing methods** (`parseInt()` vs `valueOf()`)
7. **Be careful with mixed-type comparisons** - different wrapper types are never equal
8. **Leverage utility methods** for character testing, bit manipulation, etc.
9. **Consider unsigned operations** for specific use cases (networking, bit manipulation)
10. **Understand hash code behavior** for proper collection usage