# **2. Object-Oriented Programming (OOPs)**

1. Why is Java not 100% object-oriented?
2. What is inheritance?
3. What is the purpose of inheritance in OOP?
4. What is the superclass of all classes in Java?
5. What is the `super` keyword in Java?
6. Can we use both `this()` and `super()` in a constructor?
7. What is method overloading?
8. How does method overloading enhance the readability of a program?
9. Is it possible to overload methods by changing the return type?
10. What happens if two methods have the same name but different return types in Java?
11. Can we change only the return type while overloading a method?
12. What is method overriding?
13. What is the difference between method overriding and method overloading?
14. Is it possible to override an overloaded method?
15. Can we inherit a final method in Java?
16. Can we override a start() method of Thread in Java?
17. What is method hiding in Java?
18. Can we override a static method in Java?
19. Why can’t we override static methods?
20. Can we override a final method in Java?
21. Can we override a private method in Java?
22. Can we override a non-abstract method of an abstract class in a non-abstract class?
23. Can we override a synchronized method with a non-synchronized one?
24. Can we change the return type of a method to its subclass while overriding?
25. What is the @Override annotation in method overriding? What happens if you omit this annotation?
26. Do virtual methods exist in Java?
27. How does dynamic method dispatch work in Java?
28. How does polymorphism help in designing scalable applications?
29. What is a constructor?
30. What are the characteristics of a constructor?
31. What is a default constructor, and when is it provided?
32. Do child classes inherit the constructor of parent classes?
33. Can we overload a constructor?
34. Can we override a constructor?
35. Can we make a constructor final?
36. Can we inherit a constructor in Java?
37. What happens if the constructor is private? How can we create objects in that case?
38. Why can’t a constructor be final, static, or abstract?
39. Why can’t you use return in a constructor? What happens if you try?
40. What happens if you call `super()` and `this()` in the same constructor?
41. What happens if you call `super()` in a constructor, but there is no explicit call to `super()`?
42. Can we call a constructor inside another constructor? (Constructor Chaining)
43. What is the difference between an abstract class and an interface in Java?
44. What are the performance implications of Interfaces over Abstract Classes?
45. What can we put in an interface?
46. What is the difference between abstract classes and interfaces?
47. Can an abstract class have a constructor?
48. Can we make a class abstract without an abstract method?
49. Can a class be both final and abstract at the same time?
50. Can an interface extend another interface?
51. Can an interface implement another interface?
52. Can an interface have constructors?
53. Can we define a class within an interface?
54. Can we define an interface within a class?
55. Can a class implement multiple interfaces in Java?
56. What is multiple inheritance in Java? How does Java handle it?
57. What is the diamond problem in Java? How does Java resolve it?
58. Can we declare a static method inside an interface?
59. What happens if a static method tries to access a non-static variable?
60. What happens if you try to invoke a static method on a null object reference?
61. What is the purpose of static nested classes?
62. Can a class have multiple static blocks?
63. What is the difference between an instance block and a static block?
64. Can we make an abstract method static?
65. What happens if an exception is thrown in a constructor?
66. How does Java’s garbage collector work when an object becomes unreachable but still has references?
67. What happens if a static variable is modified by multiple threads in Java?
68. Why is the `volatile` keyword not enough for thread safety?
69. Why is the main method declared as public static void in Java?
70. What is the difference between `final`, `finally`, and `finalize`?
71. What is a marker interface in Java?
72. How do you decide if an inner class is required?
73. What is a singleton class? Give a practical example of its usage.
74. Can we call the constructor of a class more than once for an object?
75. Can a class be both a superclass and a subclass at the same time? Give an example.
76. Can we have two methods in a class with the same name?
77. How can we make a copy of a Java object?
78. What's the benefit of using inheritance?
79. How can we restrict inheritance for a class so that no class can inherit from it?
80. Can an abstract class have instance variables?
81. What is the difference between shallow copy and deep copy in Java?
82. What is the result of comparing two objects with `==` if they are not the same instance but contain the same value?
83. Can we define a class within an interface?
84. What does a final method mean?
85. Where can a blank final variable be initialized?
86. Can a class be both final and abstract at the same time?

## **Chapter 3: Strings in Java**

### **1. Basics of Strings**
1. **What is a String in Java?**
2. **Why is String immutable in Java?**
3. **What is the difference between `String`, `StringBuilder`, and `StringBuffer`?**
4. **How is a String object created in Java?**
5. **What is the difference between `String s = new String("abc")` and `String s = "abc"`?**
6. **What is the String Pool in Java?**
7. **How does the `intern()` method work in Java?**
8. **What is the difference between `==` and `.equals()` when comparing Strings?**
9. **How do you check if two Strings are equal in Java?**
10. **What is the difference between `String.valueOf()` and `toString()`?**
11. **How do you reverse a String in Java?**
12. **How do you check if a String is a palindrome?**
13. **How do you remove whitespace from a String in Java?**
14. **How do you convert a String to uppercase or lowercase?**
15. **How do you split a String in Java?**
16. **How do you join multiple Strings in Java?**
17. **How do you replace characters in a String?**
18. **How do you check if a String contains only digits?**
19. **How do you check if a String contains only alphabets?**
20. **How do you count the number of words in a String?**
21. **What is the purpose of the `charAt()` method in Java?**
22. **What is the purpose of the `substring()` method in Java?**
23. **What is the purpose of the `indexOf()` method in Java?**
24. **What is the purpose of the `length()` method in Java?**
25. **What is the purpose of the `trim()` method in Java?**
26. **What is the purpose of the `replace()` method in Java?**
27. **What is the purpose of the `startsWith()` and `endsWith()` methods in Java?**
28. **What is the purpose of the `compareTo()` method in Java?**
29. **What is the purpose of the `concat()` method in Java?**
30. **What is the purpose of the `toCharArray()` method in Java?**
31. **What is the difference between `StringBuilder` and `StringBuffer`?**
32. **Why is `StringBuilder` faster than `StringBuffer`?**
33. **How do you convert a String to an integer in Java?**
34. **How do you convert an integer to a String in Java?**
35. **How do you convert a String to a character array?**
36. **How do you convert a character array to a String?**
37. **How do you check if two Strings are anagrams?**
38. **How do you find the first non-repeated character in a String?**
39. **How do you find the most repeated character in a String?**
40. **How do you count the occurrences of a character in a String?**
41. **Why is String concatenation using `+` operator inefficient?**
42. **How does `StringBuilder` improve performance over String concatenation?**
43. **What is the memory overhead of using Strings in Java?**
44. **How does the String Pool help in memory optimization?**
45. **What is the impact of creating too many String objects in Java?**
46. **How do you optimize String operations for performance?**
47. **What is the difference between `StringBuilder` and `String` in terms of memory usage?**
48. **How do you handle large Strings in Java?**
49. **What is the impact of using `intern()` on memory?**
50. **How do you avoid memory leaks with Strings?**
51. **How do you validate an email address using a String in Java?**
52. **How do you extract a substring from a URL?**
53. **How do you parse a CSV file using Strings in Java?**
54. **How do you handle multi-line Strings in Java?**
55. **How do you compare two Strings ignoring case?**
56. **How do you remove duplicate characters from a String?**
57. **How do you find the longest substring without repeating characters?**
58. **How do you check if a String is a valid number?**
59. **How do you implement a custom `toString()` method for a class?**
60. **How do you handle encoding and decoding of Strings in Java?**
61. **What happens if you call `toString()` on a `null` String?**
62. **What is the output of `"abc" == new String("abc")`?**
63. **What is the output of `"abc".equals(new String("abc"))`?**
64. **What is the output of `"abc".substring(0, 100)`?**
65. **What is the output of `"abc".charAt(10)`?**
66. **What is the output of `"abc".replace('a', 'A').replace('A', 'B')`?**
67. **What is the output of `"abc".concat(null)`?**
68. **What is the output of `"abc".toUpperCase().toLowerCase()`?**
69. **What is the output of `"abc".equalsIgnoreCase("ABC")`?**
70. **What is the output of `"abc".compareTo("def")`?**
71. **Write a program to reverse a String without using `StringBuilder` or `StringBuffer`.**
72. **Write a program to check if two Strings are anagrams.**
73. **Write a program to find the first non-repeated character in a String.**
74. **Write a program to count the number of vowels in a String.**
75. **Write a program to remove all whitespace from a String.**
76. **Write a program to check if a String is a palindrome.**
77. **Write a program to find the longest palindrome in a String.**
78. **Write a program to count the occurrences of each character in a String.**
79. **Write a program to find the most repeated word in a String.**
80. **Write a program to capitalize the first letter of each word in a String.**
81. **When should you use `StringBuilder` instead of `String`?**
82. **Why should you avoid using `+` for String concatenation in loops?**
83. **How do you handle large String concatenation efficiently?**
84. **What are the best practices for using the `intern()` method?**
85. **How do you handle String encoding and decoding in Java?**
86. **What are the best practices for comparing Strings in Java?**
87. **How do you handle multi-line Strings in Java?**
88. **What are the best practices for using `String.format()`?**
89. **How do you handle String manipulation in multi-threaded environments?**
90. **What are the best practices for using `StringTokenizer` vs `split()`?**
91. **What is the difference between `String.format()` and `StringBuilder`?**
92. **How do you handle String localization in Java?**
93. **What is the difference between `String.getBytes()` and `String.toCharArray()`?**
94. **How do you handle String compression in Java?**
95. **What is the difference between `String` and `CharSequence`?**
96. **How do you handle String encryption and decryption in Java?**
97. **What is the difference between `String` and `StringBuffer` in terms of thread safety?**
98. **How do you handle String manipulation in functional programming?**
99. **What is the difference between `String` and `StringBuilder` in terms of immutability?**
100. **How do you handle String manipulation in Java 8 and above?**


## **Chapter 5: Generics in Java**

1. **What are Generics in Java?**  
2. **Why were Generics introduced in Java?**  
3. **What is the difference between raw types and generic types?**  
4. **What is type erasure in Generics?**  
5. **What are the advantages of using Generics?**  
6. **What is the difference between `List` and `List<Object>`?**  
7. **What is the difference between `List<?>` and `List<Object>`?**  
8. **What is the purpose of the diamond operator (`<>`) in Generics?**  
9. **Can you use primitive types with Generics?**  
10. **What is the difference between `List<String>` and `List<Integer>`?**  
11. **How do you define a generic class in Java?**  
12. **How do you define a generic interface in Java?**  
13. **Can you create an instance of a generic type?**  
14. **What is a bounded type parameter in Generics?**  
15. **How do you define a bounded type parameter in a generic class?**  
16. **What is the difference between `extends` and `super` in Generics?**  
17. **Can you use multiple bounds in Generics?**  
18. **What is the difference between `List<? extends Number>` and `List<? super Number>`?**  
19. **How do you create a generic method in Java?**  
20. **What is the difference between a generic class and a generic method?**  
21. **What is a wildcard in Generics?**  
22. **What is the difference between `List<?>` and `List<T>`?**  
23. **What is the purpose of the upper-bounded wildcard (`<? extends T>`)?**  
24. **What is the purpose of the lower-bounded wildcard (`<? super T>`)?**  
25. **What is the difference between `List<? extends Number>` and `List<Number>`?**  
26. **Can you add elements to a `List<?>`?**  
27. **Can you add elements to a `List<? extends Number>`?**  
28. **Can you add elements to a `List<? super Number>`?**  
29. **What is the difference between `List<?>` and `List<Object>`?**  
30. **What is the difference between `List<? extends Number>` and `List<? super Number>`?**  
31. **What is type erasure in Generics?**  
32. **How does type erasure work in Java?**  
33. **What happens to generic type information at runtime?**  
34. **Can you use instanceof with generic types?**  
35. **What is the difference between `List<String>` and `List<Integer>` at runtime?**  
36. **How do you overcome the limitations of type erasure?**  
37. **What is reifiable and non-reifiable types in Generics?**  
38. **What is the difference between `List<String>` and `List<?>` at runtime?**  
39. **Can you create an array of generic types?**  
40. **What is the difference between `List<String>[]` and `List<?>[]`?**  
41. **What is the difference between `List<?>` and `List<T>`?**  
42. **What is the difference between `List<? extends T>` and `List<T>`?**  
43. **What is the difference between `List<? super T>` and `List<T>`?**  
44. **What is the difference between `List<?>` and `List<Object>`?**  
45. **What is the difference between `List<? extends Number>` and `List<Number>`?**  
46. **What is the difference between `List<? super Number>` and `List<Number>`?**  
47. **What is the difference between `List<?>` and `List<? extends Object>`?**  
48. **What is the difference between `List<?>` and `List<? super Object>`?**  
49. **What is the difference between `List<?>` and `List<? extends Number>`?**  
50. **What is the difference between `List<?>` and `List<? super Number>`?**  
51. **How do you use Generics in collections like `ArrayList` and `HashMap`?**  
52. **How do you create a generic utility class in Java?**  
53. **How do you handle type safety in a generic class?**  
54. **How do you handle type safety in a generic method?**  
55. **How do you handle type safety in a generic interface?**  
56. **How do you handle type safety in a generic constructor?**  
57. **How do you handle type safety in a generic static method?**  
58. **How do you handle type safety in a generic enum?**  
59. **How do you handle type safety in a generic annotation?**  
60. **How do you handle type safety in a generic lambda expression?**  
61. **When should you use Generics in Java?**  
62. **What are the best practices for using Generics in Java?**  
63. **How do you handle type safety in Generics?**  
64. **What are the best practices for using wildcards in Generics?**  
65. **How do you handle type erasure in Generics?**  
66. **What are the best practices for using bounded type parameters in Generics?**  
67. **How do you handle type safety in generic methods?**  
68. **What are the best practices for using generic classes?**  
69. **How do you handle type safety in generic interfaces?**  
70. **What are the best practices for using generic constructors?**  
