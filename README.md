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
     - [Code &mdash; ISP Violation: 1st Resolution](./src/main/java/com/ram/java/solid/interfacesegregation/services/resolved_1/)
     - [Code &mdash; ISP Violation: 2nd Resolution](./src/main/java/com/ram/java/solid/interfacesegregation/services/resolved_2/)
   - [Dependency Injection Principle (DI)](#dependency-inversion-principle-di)
     - [Code &mdash; DI Violation](./src/main/java/com/ram/java/solid/dependencyinversion/services/violation/)
     - [Code &mdash; DI Violation: Resolved](./src/main/java/com/ram/java/solid/dependencyinversion/services/resolved/)

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
    
 OCP: **SOFTWARE ENTITIES (CLASSES, MODULES, METHODS, etc) SHOULD BE OPEN FOR EXTENSION, BUT CLOSED FOR MODIFICATION**

[ꜛ️](#table-of-contents)

#### Liskov Substitution Principle (LSP)

- LSP states that: __We should be able to substitute *Base* class objects with *Child* class objects & this should not alter the desired behaviour/characteristics of the program__.
- Here, we're not simply talking about type level replacement of *Base* class object with *Child* class object.
  We're also talking about the behaviour being unaffected for the overall program if there's a change from *Base* class' object, to *Child* class' object.

LSP: **WE SHOULD BE ABLE TO SUBSTITUTE BASE CLASS OBJECTS WITH CHILD CLASS OBJECTS, AND THIS SUBSTITUTION SHOULD NOT ALTER THE DESIRED BEHAVIOUR/CHARACTERISTIC OF THE PROGRAM**

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

ISP: **CLIENTS SHOULD NOT BE FORCED TO DEPEND UPON INTERFACES THAT THEY DO NOT USE**

[ꜛ️](#table-of-contents)

#### Dependency Inversion Principle (DI)

- DI states the following:
  1. __High level modules should not depend upon low level modules__ &mdash; __both should depend upon abstractions__.
  2. __Abstractions should not depend upon details__ &mdash; __details should depend upon abstractions__.
- What exactly is a _Dependency_?
  - E.g. 1: Let's say we've our own method called `printMe`:

    ```java
    public void printMe() {
		System.out.println("Hello!");
		//     ^^^	<------------------------------------------ Dependency (makes use of `out` object from inside System class)
	}
    ```

    > `out` object is the _dependency_ in this situation, for the code inside `printMe` method.

  - E.g. 2: Let's say we're writing a method that will generate a report in JSON format, and the method will write that JSON formatted report on the disk:
  
    ```java
    public void writeReport() {
		Report report = new Report(); 	// This is NOT a Dependency because this method is supposed to write a Report.

		// Build the report
		JSONFormatter formatter = new JSONFormatter();
		//            ^^^^^^^^^ <------------------------------ Dependency (being created inside `writeReport` method)

		String report = formatter.format(report);
		FileWriter writer = new FileWriter("report.json");
		//		   ^^^^^^ <------------------------------------ Dependency (being created inside `writeReport` method)

		// Write out the report
		writer.write();
		writer.close();
	}
    ```

    > `writeReport` is dependent on `formatter` and `writer`, therefore, both `formatter` and `writer` are dependencies in `writeReport` method.

- Dependency Inversion is asking the programmer to not create dependencies inside the `writeReport` method, but those dependencies must be provided to `writeReport` method.
  - Because both `formatter` and `writer` objects are created inside the `writeReport` method, 
    the `writeReport`'s implementation is now tightly coupled to the implementation of `JSONFormatter`'s object,
    and `Writer` object, specifically `FileWriter` object.
  - __WRENCH IN THE WORKS__: If there's a new requirement that asks for the following changes?
    1. Write the report in HTML format.
    2. Write the report to memory/network, instead of disk.
    > Just these bunch of changes would invoke a change in the existing `writeReport` method, which is something we, as developers should avoid.
    > The more code changes we do, the more there's a good chance of breaking existing behaviour of already tested code, and more inclusion of bugs.
  - DI basically is asking for the High level module(s) (the module that defines the business rules, like `writeReport` method)
    NOT to depend on Low level module(s) (the modules that are basic functionalities and can be used anywhere, a good example is `JSONFormatter`).
  - Both High level module(s) and Low level module(s) should NOT be tightly coupled, and ideally, both should depend on Abstractions.
    - Instead of creating `JSONFormatter` and `FileWriter` objects inside `writeReport` method, why not let the caller of the method provide those
      dependencies for you, so that you don't have the responsibilit of creating such objects at your end.
    - Also, this way, `writeReport` only knows that it's dealing with some instance of `Formatter` and `Writer` (as interfaces, and not actual instances).

    ```java
    public void writeReport(Formatter formatter, Writer writer) {		// Both Formatter & Writer are interface references provided to `writeReport` method.
		Report report = new Report();

		// Build the report
		String report = formatter.format(report);						// We're NOT creating the dependency here anymore.
		
		// Write out the report
		writer.write(report, "myreport.json");							// We're NOT creating the dependency here as well.
	}
    ```
    
    > Anyone who now wants to fulfil the previous requirements like:
    > 1. Write the report in HTML format: The caller can simply pass in a different implementation of the `Formatter`, and this should work as expected.
    > 2. Write the report to memory/network, instead of disk: The caller can simply pass in a different implementation of the `Writer`, and that should take care of the report being written to memory/network.

DI:

1. __HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW LEVEL MODULES__ &mdash; __BOTH SHOULD DEPEND UPON ABSTRACTIONS__.
2. __ABSTRACTIONS SHOULD NOT DEPEND UPON DETAILS__ &mdash; __DETAILS SHOULD DEPEND UPON ABSTRACTIONS__.

[ꜛ️](#table-of-contents)
