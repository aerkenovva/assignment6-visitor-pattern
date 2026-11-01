# Assignment 6 — Visitor Pattern

Java 17 implementation of the **Visitor behavioral design pattern** using the official **Option A — File System Visitor** topic.

## Topic and Requirements Coverage

The project contains the required Visitor roles:

- `FileSystemElement` — Element interface with `accept(FileSystemVisitor visitor)`
- `RegularFile` and `Directory` — two Concrete Elements
- `FileSystemVisitor` — Visitor interface with one overloaded `visit(...)` method for each Concrete Element
- `SizeCalculatorVisitor` and `SearchVisitor` — two Concrete Visitors
- `FileSystem` — Object Structure
- `Main` — Client and live demonstration

The same file-system structure is processed by both visitors without changing the element classes.

## Double Dispatch

Double dispatch is implemented by the `accept()` / `visit()` pair:

```java
@Override
public void accept(FileSystemVisitor visitor) {
    visitor.visit(this);
}
```

Flow:

1. The client applies a Visitor to an Element with `accept(visitor)`.
2. The concrete element calls `visitor.visit(this)`.
3. The concrete element passes itself to the Visitor, so the matching overloaded visit(...) method is called for that specific element type.
4. The selected Concrete Visitor performs its operation.

There is **no `instanceof` or type-checking chain** anywhere in the implementation.

## Project Structure

```text
assignment6-visitor-pattern/
├── pom.xml
├── README.md
├── DEFENSE_CHEATSHEET.md
├── docs/
│   ├── sample-output.txt
│   ├── uml.png
│   ├── uml.puml
│   └── uml.dot
├── report/
│   └── REPORT_DRAFT.md
└── src/
    ├── main/java/com/assignment6/visitor/
    │   ├── Main.java
    │   ├── element/
    │   │   ├── FileSystemElement.java
    │   │   ├── RegularFile.java
    │   │   └── Directory.java
    │   ├── structure/
    │   │   └── FileSystem.java
    │   └── visitor/
    │       ├── FileSystemVisitor.java
    │       ├── SizeCalculatorVisitor.java
    │       └── SearchVisitor.java
    └── test/java/com/assignment6/visitor/
        └── VisitorPatternTest.java
```

## Sample Output

```text
VISITOR PATTERN - FILE SYSTEM
=============================
Total size: 12500 bytes
Files matching '.txt': [notes.txt, todo.txt]
```

## Clean Code — Chapters 12 and 13

The project and report demonstrate at least five principles from the required chapters:

1. **Runs All the Tests** — Chapter 12
2. **No Duplication** — Chapter 12
3. **Expressive Code** — Chapter 12
4. **Minimal Classes and Methods** — Chapter 12
5. **Limit the Scope of Data** — Chapter 13
6. **Use Copies of Data** — Chapter 13

Each principle has an annotated code excerpt in `report/REPORT_DRAFT.md`.

## UML

The ready UML diagram is in:

- `docs/uml.png`
- `docs/uml.puml` — editable PlantUML source

## Run in IntelliJ IDEA

1. Open this folder as a project.
2. Select **JDK 17**.
3. Let IntelliJ import the Maven project.
4. Run `Main.java`.
5. Run `VisitorPatternTest.java` to execute the tests.

Terminal commands with Maven:

```bash
mvn clean test
mvn package
```

## GitHub

After you create and push your repository, replace this placeholder with your real link:

`https://github.com/aerkenovva/assignment6-visitor-pattern`
