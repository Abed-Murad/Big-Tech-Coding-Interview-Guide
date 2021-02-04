# Problem Solving Notes

* **How to extract each digit form an Int?**
    - Works Only with Non-Negative Numbers
``` kotlin
fun printDigits(number: Int) {
    var remains = number  // 1234
    while (remains > 0) { 
    val mostRightDigit = remains % 10 // 123,4 
    remains /=10 // 123
    println("mostRightDigit: $mostRightDigit") // 4
    println("remains: $remains") // 123
    }
}
```