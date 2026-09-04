# SOLID Principles & Design Patterns using Java

- This repository contains code and implementation related to SOLID principles, and Design Patterns, all implemented using Java.
- The entire repository will be well structured, and have a table of contents to reflect each topic, and where to find related to text along with the code.

## Table of Contents

1. [SOLID Principles](#solid-principles)
   - [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
     - [Code With SRP Violations](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L30-L120)
     - [Clean Code](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L1-L29)
     - [Full Code](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple)


### SOLID Principles

- SOLID is an acronym for the following principles underlying:
  1. _**S**ingle Responsibility Principle (SRP)_
  2. _**O**pen Closed Principle (OCP)_
  3. _**L**iskov Substitution Principle (LSP)_
  4. _**I**nterface Segregation Principle (ISP)_
  5. _**D**ependency Inversion Principle (DI)_

[ꜛ️](#table-of-contents)

#### Single Responsibility Principle (SRP)

- SRP states that: __there should never be more than one reason for a class to change__.
- The class should provide a focussed, single functionality, and address a specific concern.
- If you've a class called `AwesomeClass`, that is responsible for communicating with the server.
  In that case, the class should never change, if any of the following changes:
  1. Communication Protocol: Code changes shouldn't occur if the underlying communication protocol changes from `HTTP` to `HTTPS`.
  2. Message Format: Code changes shouldn't occur if the underlying message format changes, like `JSON` -> `gRPC`, or `JSON` -> `XML`, or `XML` -> `GraphQL`.
  3. Communication Security: Code shouldn't be changed if a new Authentication methodology is addedas a measure of security.
- If you see now, SRP says that there might multiple reasons why our class'/API's code needs to be changed, and this is what is to be avoided following SRP.
- As aformentioned in the example, if there are 3 separate responsibilities, then there should be 3 separate classes/modules to handle those responsibilities.
  - This way, whenever something changes, our code can be changed in an organised manner, ensuring that the core class/module isn't changed, and the changes are minimal in nature.

SRP: **THERE SHOULD NEVER BE MORE THAN ONE REASON FOR A CLASS TO CHANGE**.

[ꜛ️](#table-of-contents)
