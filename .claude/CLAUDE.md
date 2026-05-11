# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java algorithm study project managed by IntelliJ IDEA. It contains LeetCode-style problem solutions with no build tool (no Maven/Gradle) — compilation is handled directly by the IDE or `javac`.

## Building and Running

Compile a single file from the project root:
```bash
javac -d out/production/Algorithm src/main/java/<FileName>.java
```

Run a compiled class:
```bash
java -cp out/production/Algorithm main.java.<ClassName>
```

## Code Structure

All solutions live in `src/main/java/` under the package `main.java`. Each file is a self-contained solution to a specific algorithm problem. There are no tests — correctness is typically verified via a `main()` method within the class.

## Conventions

- Each class solves one problem; the class name matches the problem name.
- Inner classes (e.g., `ListNode`) are defined as `static` nested classes when a data structure is needed.
- No external dependencies.

## Testing Convention

- **Never use JUnit or any test framework.** All test cases go directly in the `public static void main(String[] args)` method of the class being tested.
- **Never modify the solution method(s).** Only add or update the `main()` method; leave all existing logic untouched.
- Test cases should print `[PASS]` / `[FAIL]` per case and a summary line at the end (e.g., `Result: 6/6 passed`).