# 🔥 Top Java Array Interview Questions with Code Examples

Arrays are one of the most commonly asked topics in coding interviews. Mastering array-based questions helps you crack beginner-to-intermediate level interviews at companies.

In this article, we’ll cover **important Java programs on arrays**, their logic, and optimized implementations.

---

## ✅ 1. Check if Array is Sorted (Ascending / Descending)

👉 Problem: Write a program to check whether a given array is sorted in **ascending** or **descending** order.

### Code:

```java
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(isArraySortedAsc(arr)); // true
        System.out.println(isArraySortedDesc(arr)); // false
    }

    // Check ascending
    private static boolean isArraySortedAsc(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }

    // Check descending
    private static boolean isArraySortedDesc(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) return false;
        }
        return true;
    }
}
```

✅ Output:

```
true
false
```

---

## ✅ 2. Find the Maximum Element in an Array

👉 Problem: Find the largest element in an array.

### Code:

```java
public class Demo {
    public static void main(String[] args) {
        int[] arr = {3, 9, 1, 44, 7, 21};
        System.out.println(max(arr)); // 44
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
}
```

✅ Output:

```
44
```

---

## ✅ 3. Find the Minimum Element in an Array

👉 Problem: Find the smallest element in an array.

### Code:

```java
public class Demo {
    public static void main(String[] args) {
        int[] arr = {3, 9, 1, 44, 7, 21};
        System.out.println(min(arr)); // 1
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
}
```

✅ Output:

```
1
```

---

## ✅ 4. Reverse an Array (In-Place, Without Extra Array)

👉 Problem: Reverse an array without using extra space.

### Code:

```java
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
```

✅ Output:

```
[5, 4, 3, 2, 1]
```

---

## ✅ 5. Find Second Largest Element

👉 Problem: Find the **second largest** element in the array.

### Code:

```java
public class Demo {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second Largest: " + secondLargest);
    }

    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
```

✅ Output:

```
Second Largest: 34
```

---

## ✅ 6. Find Frequency of Each Element

👉 Problem: Count how many times each element appears in the array.

### Code:

```java
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        Map<Integer, Integer> freqMap = findFrequency(arr);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> findFrequency(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : array) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return freqMap;
    }
}
```

✅ Output:

```
1 -> 2
2 -> 3
3 -> 1
4 -> 1
```

---

## ✅ 7. Rotate an Array by `d` (Counterclockwise / Left Rotation)

👉 Problem: Rotate the array by `d` positions to the left.

### Code:

```java
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        rotateLeft(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    // Reverse helper
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Rotate left by d
    public static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n; // handle d > n

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }
}
```

✅ Output:

```
[3, 4, 5, 6, 1, 2]
```

---

