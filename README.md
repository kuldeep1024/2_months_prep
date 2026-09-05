# 2_months_prep

# Java 21 Playground

## Daily Log

| Day | Date       | What I built                                                      | What was difficult              |
|-----|------------|-------------------------------------------------------------------|---------------------------------|
| 1   | 2026-09-01 | Java 21 examples , Java 8 → 21 Evolution                          | Flow scoping                    |
| 2   | 2026-09-02 | Records, Sealed Types & Immutable Domain Modelling                | Record vs Lombok @Value vs POJO |
| 3   | 2026-09-03 | Pattern Matching for switch, Record Patterns & Switch Expressions | Visitor Pattern, exhaustiveness |
| 4   | 2026-09-04 | Collections Deep Dive, Sequenced Collections & Advanced Streams   |                                 |
| 5   | 2026-09-05 | Strings, Generics & Week 1 Consolidation                          | PECS                            |
|     |            |                                                                   |                                 |
|     |            |                                                                   |                                 |


| Feature                   | Record       | Lombok `@Value`                            | POJO    |
| ------------------------- | ------------ | ------------------------------------------ | ------- |
| Boilerplate               | Very low     | Low                                        | High    |
| Immutable by design       | Yes          | Yes                                        | Depends |
| Extends another class     | No           | Usually possible depending on class design | Yes     |
| Good for DTO              | Excellent    | Excellent                                  | Good    |
| JPA entity                | Generally no | Possible                                   | Yes     |
| Generated equals/hashCode | Yes          | Yes                                        | Manual  |
| Compact validation        | Yes          | No equivalent                              | Manual  |
| Clear data-carrier intent | Excellent    | Good                                       | Depends |

# Visitor vs Pattern Matching

## Visitor vs Pattern Matching Comparison

| Aspect                 | Classical Visitor                       | Pattern Matching                  |
| ---------------------- | --------------------------------------- | --------------------------------- |
| Boilerplate            | High                                    | Low                               |
| Type handling          | `accept()` + `visit()` methods          | `switch` cases                    |
| Adding a new operation | Easy                                    | Easy                              |
| Adding a new type      | More work                               | Compiler highlights missing cases |
| Exhaustiveness         | Not automatic                           | Supported with sealed types       |
| Record support         | Not required                            | Works very well                   |
| Readability            | More complex for small hierarchies      | Usually simpler                   |
| Double dispatch        | Yes                                     | Not required                      |
| Best suited for        | Stable type hierarchy + many operations | Modern Java closed hierarchies    |

## What became simpler?

Pattern matching removes much of the boilerplate required by the classical Visitor pattern. With Visitor, every type needs an `accept()` method, a visitor interface needs a `visit()` method for every type, and each operation usually requires another visitor implementation. With sealed types and pattern matching, the processing logic can be written directly in one `switch`. Record patterns make this even simpler because record components can be extracted directly from the pattern. The compiler can also check exhaustiveness when the hierarchy is sealed.

## When would I still choose Visitor?

I would still choose Visitor when the set of element types is stable but many different operations need to be added independently. Visitor keeps each operation in a separate class and follows the traditional double-dispatch approach. It can also be useful when working with an existing class hierarchy or when the design requires Visitor-specific behavior. For a small, closed hierarchy in modern Java, however, sealed types and pattern matching usually provide a simpler and more readable solution.

## Immutable Collections
### Rule of thumb:
    List.of() → "I'm creating an immutable list."
    List.copyOf() → "I'm taking an immutable copy of this list."
    unmodifiableList() → "I want a read-only window onto this existing list."

| Feature | `List.of()` | `Collections.unmodifiableList()` | `List.copyOf()` |
|---|---|---|---|
| Creates a new list? | Yes | No — creates a read-only view | Yes, effectively an immutable copy |
| Can modify through returned list? | ❌ | ❌ | ❌ |
| Changes to original list visible? | ❌ | ✅ Yes | ❌ |
| Allows `null`? | ❌ | Usually ✅ | ❌ |
| Immutable? | ✅ | ❌ (only the view is unmodifiable) | ✅ |
| Best use | Creating small immutable lists | Exposing an existing mutable list safely | Taking an immutable snapshot |


## String benchmark

| Iterations | `String +=` | `StringBuilder` | Winner                         |
| ---------: |------------:|----------------:|--------------------------------|
|         10 |       0.149 |           0.043 | StringBuilder (~3.5x faster)   |
|      1,000 |      57.646 |           2.404 | StringBuilder (~24x faster)    |
|    100,000 |  529744.440 |         332.521 | StringBuilder (~1,593x faster) |
