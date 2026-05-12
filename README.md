# Math Parser Library

[![](https://jitpack.io/v/developer62beta/math-parser-lib.svg)](https://jitpack.io/#developer62beta/math-parser-lib)

A simple math parser library written in Kotlin.

Supports:

- Addition `+`
- Subtraction `-`
- Multiplication `*`
- Division `/`
- Percentage `%`
- Parentheses `()`
- Negative numbers
- Float numbers

---

# Installation

## Step 1. Add JitPack Repository

Add this in your `settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(
        RepositoriesMode.FAIL_ON_PROJECT_REPOS
    )

    repositories {

        mavenCentral()

        maven {
            url = uri("https://jitpack.io")
        }
    }
}
```

---

## Step 2. Add Dependency

```kotlin
dependencies {
    implementation(
        "com.github.developer62beta:math-parser-lib:a8f89d94"
    )
}
```

---

# Usage

```kotlin
import com.developer62.parser.Parser

fun main() {

    val result = Parser(
        "2+4*(10-2)"
    ).parse()

    println(result)
}
```

Output:

```text
34.0
```

---

# Examples

```kotlin
Parser("2+3").parse()
```

Result:

```text
5.0
```

---

```kotlin
Parser("(2+3)*4").parse()
```

Result:

```text
20.0
```

---

```kotlin
Parser("-5+2").parse()
```

Result:

```text
-3.0
```

---

# Percentage Operator

Current `%` behavior:

```text
a % b
```

Formula:

```text
(b / a) * 100
```

Example:

```kotlin
Parser("1000%30").parse()
```

Result:

```text
3.0
```

---

# Compile Local Project

```bash
./gradlew build
```

---

# Run

```bash
java -jar build/libs/math-parser-lib.jar
```

---

# License

MIT
