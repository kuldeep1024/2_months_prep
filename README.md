# 2_months_prep

# Java 21 Playground

## Daily Log

| Day | Date       | What I built                                       | What was difficult |
|---|------------|----------------------------------------------------|---|
| 1 | 2026-09-01 | Java 21 examples , Java 8 → 21 Evolution                                | Flow scoping |
| 1 | 2026-09-02 | Records, Sealed Types & Immutable Domain Modelling | Flow scoping |
| 2 |            |                                                    | |
| 3 |            |                                                    | |


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
