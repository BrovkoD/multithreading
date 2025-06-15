# ⚙️ Java Multithreading Exercises

This project demonstrates advanced multithreading techniques using Java. Two practical simulations (`HW2` and `HW3`) showcase data synchronization, thread lifecycle control, lock coordination, and producer-consumer behavior — backed by utility components for reproducibility and timing.

---

## 📂 Project Structure

```
multithreading/
├── pom.xml
├── README.md
├── src/
│ └── main/
│ ├── java/
│ │ ├── Application.java
│ │ ├── hw2/
│ │ │ ├── HW2.java
│ │ │ ├── model/
│ │ │ │ ├── BaseDTO.java
│ │ │ │ ├── FirstDTO.java
│ │ │ │ └── SecondDTO.java
│ │ │ └── thread/
│ │ │ ├── BaseThread.java
│ │ │ ├── FirstThread.java
│ │ │ └── SecondThread.java
│ │ ├── hw3/
│ │ │ ├── HW3.java
│ │ │ └── thread/
│ │ │ └── CustomThread.java
│ │ └── utils/
│ │ ├── CustomRandom.java
│ │ └── CustomTimer.java
│ └── resources/
```

---

## 🧠 Homework Descriptions

### ✅ HW2 – Synchronized DTO Modification with Bidirectional Threads

- Creates shared DTOs: `FirstDTO` and `SecondDTO` (both hold a `double` number)
- Spawns a random number of threads (10–20), split between:
  - `FirstThread`: modifies `FirstDTO` first, then `SecondDTO`
  - `SecondThread`: modifies `SecondDTO` first, then `FirstDTO`
- Both thread types extend `BaseThread`, use separate locks, and call `changeDTO()` methods
- Uses `CustomTimer` for timekeeping and `CustomRandom` for thread count

🧪 **Purpose:** Test lock acquisition order, avoid deadlocks, and simulate cross-dependency in shared state updates.

---

### ✅ HW3 – Collatz Sequence with Producer-like Threads

- Generates a random list of integers `[1, 100]`
- Splits the list across `N = availableProcessors()` using `CustomThread`
- Each `CustomThread`:
  - Polls a number from a queue
  - Applies the **Collatz transformation**:
    - If even: `x → x / 2`
    - If odd: `x → 3x + 1`
  - If result ≠ 1, puts it back in the queue for further processing
  - Logs the current queue

🧪 **Purpose:** Simulate a simplified **worker pool** or recursive task expansion using shared queues.

---

## 🔧 Utilities

- `CustomRandom` — reproducible and bounded random generator
- `CustomTimer` — timer with countdown and log support for elapsed time

---

## 🚀 Run Instructions

### Compile & Package
```bash
mvn clean install
```

Run via IDE or CLI
```bash
mvn exec:java -Dexec.mainClass="Application"
```

Or directly invoke:
```bash
java hw2.HW2
java hw3.HW3
```

📦 Tech Stack
- Java 17+
- Maven
- SLF4J Logging
- No external dependencies
