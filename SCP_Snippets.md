### **1. String Literal vs. `new String()`**
```java
String s1 = "hello";          // Goes to the constant pool
String s2 = new String("hello"); // Creates a new heap object
System.out.println(s1 == s2); // false (different references)
```
**Explanation**:
- `s1` points to the pooled "hello".
- `s2` forces a new heap object, bypassing the pool.
- **Always use `.equals()` for value comparison**.

---

### **2. `intern()` Method Behavior**
```java
String s1 = new String("world").intern(); // Forces pooling
String s2 = "world";
System.out.println(s1 == s2); // true (both point to the pooled "world")
```
**Explanation**:
- `intern()` checks if the string exists in the pool. If yes, returns the pooled reference; if no, adds it.
- **Critical for deduplicating strings in memory**.

---

### **3. Compile-Time Concatenation**
```java
String s1 = "he" + "llo"; // Compile-time optimization → "hello"
String s2 = "hello";
System.out.println(s1 == s2); // true (same pooled object)
```
**Explanation**:
- Compiler merges literals at compile-time.
- **Only works with constant expressions**.

---

### **4. Runtime Concatenation (No Pooling)**
```java
String s1 = "he";
String s2 = s1 + "llo"; // Runtime concatenation → new heap object
String s3 = "hello";
System.out.println(s2 == s3); // false (s2 is not pooled)
```
**Explanation**:
- Concatenation with non-constants happens at runtime, creating new objects.
- **Use `StringBuilder` for dynamic concatenation in loops**.

---

### **5. `intern()` on Dynamic Strings**
```java
String s1 = new StringBuilder("ja").append("va").toString();
System.out.println(s1.intern() == s1); // false ("java" is already in the pool)
```
**Explanation**:
- JVM pre-loads some strings (e.g., "java") into the pool during startup.
- `intern()` returns the existing pooled reference, not the new object.

---

### **6. String Pool Garbage Collection**
```java
String s1 = "hello";
String s2 = new String("hello");
s2 = s2.intern(); // Moves s2 to the pool (if not already present)
System.out.println(s1 == s2); // true
```
**Explanation**:
- Pooled strings are **garbage-collected** if no references exist.
- `intern()` can migrate heap strings to the pool.

---

### **7. Unicode and Escape Sequences**
```java
String s1 = "✔"; // Unicode character
String s2 = "\u2714"; // Unicode escape
System.out.println(s1.equals(s2)); // true (same content)
System.out.println(s1 == s2); // true (pooled at compile-time)
```
**Explanation**:
- Unicode escapes are resolved early, so both literals point to the same pooled string.

---

### **8. `substring()` and Pool Behavior**
```java
String s1 = "hello".substring(0, 4); // "hell" (new heap object)
String s2 = "hell";
System.out.println(s1 == s2); // false (substring doesn't use pooling)
```
**Explanation**:
- `substring()` creates a new object unless the entire string is returned.
- **Java 7+ changed `substring` to copy the underlying array**.

---

### **9. String Pool in `switch` Statements**
```java
String s = "java";
switch (s) { // Uses pooled string's reference
    case "java": System.out.println("Pooled!"); break; // This executes
    default: System.out.println("Not pooled");
}
```
**Explanation**:
- `switch` compares string references, so pooled strings work efficiently.
- **Non-pooled strings will fail** unless `.equals()` is used.

---

### **10. Reflection and Pool Bypassing**
```java
String s1 = "hello";
String s2 = new String(s1.toCharArray()); // Bypasses pool
System.out.println(s1 == s2); // false
```
**Explanation**:
- Constructors using `char[]` or `byte[]` always create new objects.
- **No way to force these into the pool without `intern()`**.

---

### **11. Empty String Pooling**
```java
String s1 = ""; // Pooled empty string
String s2 = new String(); // New empty string
System.out.println(s1 == s2); // false
System.out.println(s1.equals(s2)); // true
```
**Explanation**:
- Empty strings (`""`) are pooled like any other literal.
- `new String()` creates a distinct object.

---

### **12. `replace()` and Pooling**
```java
String s1 = "hello".replace('h', 'H'); // "Hello" (new object)
String s2 = "Hello";
System.out.println(s1 == s2); // false (not pooled unless interned)
```
**Explanation**:
- Most string methods (`replace()`, `toUpperCase()`, etc.) create new objects.
- **Results are not automatically pooled**.

---

### **13. Classloading and Pool Isolation**
```java
// Across different classloaders:
String s1 = "hello";
// In another classloader: s2 = "hello"
// System.out.println(s1 == s2); // false (per-classloader pools in some JVMs)
```
**Explanation**:
- Some JVMs (e.g., older versions) maintain **per-classloader string pools**.
- Modern JVMs typically share the pool globally.

---

### **Key Takeaways**
| Scenario                  | Pool Behavior                                                                 |
|---------------------------|-------------------------------------------------------------------------------|
| Literals (`"hello"`)      | Always pooled.                                                                |
| `new String("hello")`     | Bypasses pool (creates heap object).                                          |
| `intern()`                | Forces pooling (returns existing reference or adds new one).                  |
| Compile-time concatenation| Pooled if all parts are constants.                                            |
| Runtime concatenation     | Not pooled (new heap object).                                                 |
| `substring()`/`replace()` | Not pooled unless `intern()` is called.                                       |
| `switch` statements       | Uses pooled references for comparison.                                        |

---

### **Final Note**
The String Pool exists to **save memory** by deduplicating immutable strings. Use `intern()` judiciously (it can cause performance overhead if overused). For dynamic strings, prefer `StringBuilder` or explicit pooling libraries like `StringTable` in performance-critical code.
