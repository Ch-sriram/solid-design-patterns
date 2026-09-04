# SOLID Principles & Design Patterns using Java

- This repository contains code and implementation related to SOLID principles, and Design Patterns, all implemented using Java.
- The entire repository will be well structured, and have a table of contents to reflect each topic, and where to find related to text along with the code.

## Table of Contents

1. [SOLID Principles](#solid-principles)
   - [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
     - [Code &mdash; SRP Violation](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L30-L120)
     - [Code &mdash; SRP Violation: Resolved](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L1-L29)
     - [Full Code](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple)
   - [Open Closed Principle (OCP)](#open-closed-principle-ocp)
     - [Code &mdash; OCP Violation](./src/main/java/com/ram/java/solid/openclosedprinciple/violation/)
     - [Code &mdash; OCP Violation: Resolved](./src/main/java/com/ram/java/solid/openclosedprinciple/resolved/)
   - [Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
     - [Code &mdash; LSP Violation](./src/main/java/com/ram/java/solid/liskovsubstitutionprinciple/violation/)
     - [Code &mdash; LSP Violation: Resolved](./src/main/java/com/ram/java/solid/liskovsubstitutionprinciple/resolved/)
   - [Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
     - [Code &mdash; ISP Violation](./src/main/java/com/ram/java/solid/interfacesegregation/services/violation/)
     - [Code &mdash; ISP Violation: 1st Resolution](./src/main/java/com/ram/java/solid/interfacesegregation/resolved_1/)

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

#### Open Closed Principle (OCP)

- OCP states that: __Software entities (classes, modules, methods, etc) should be Open for extension, but Closed for modification__.
- **Open for Extension** &mdash; `extend` existing behaviour (IS-A relationship establishment in OOP).
- **Closed for Modification** &mdash; Existing code remains unchanged.
- Example:
  - _Base_ class is `extend`ed by a _Derived_ class, where the _Base_ class should not be changed again, since it's already well tested.
  - But since it's a _Base_ class, it's Open for extension via the _Derived_ class.
  - Therefore:
    1. Open for Extension => can derive from base, and override methods.
    2. Closed for Modification => avoid modifying base class.

[ꜛ️](#table-of-contents)

#### Liskov Substitution Principle (LSP)

- LSP states that: __We should be able to substitute *Base* class objects with *Child* class objects & this should not alter the desired behaviour/characteristics of the program__.
- Here, we're not simply talking about type level replacement of *Base* class object with *Child* class object.
  We're also talking about the behaviour being unaffected for the overall program if there's a change from *Base* class' object, to *Child* class' object.


[ꜛ️](#table-of-contents)

#### Interface Segregation Principle (ISP)

- ISP states that: __Clients should not be forced to depend upon interfaces that they do NOT use__.
- In particular, we're talking about methods. Clients shouldn't have to depend on methods that are defined in interfaces that they don't use.
- More in particular, we're talking about a term known as Interface Pollution.
  - __Interface Pollution__:
    1. Unnecessarily Large Interfaces.
    2. Crammed-in, Unrelated Methods into the Interface.
  - __Signs of Interface Pollution__:
    1. Classes have empty method implementations.
    2. Method implementations throw UnsupportedOperationException (or similar).
    3. Method implementations return null or default/dummy values.
- In essense, ISP is asking to __Write Highly Cohesive Interfaces__, meaning, break down larger interfaces, so that methods or behaviours/contracts that are defined in an interface,
  are cohesive, and are related to each other, and we don't run into a situation where a class is forced to provide an implementation for a method, for which it doesn't make any sense.


[ꜛ️](#table-of-contents)
