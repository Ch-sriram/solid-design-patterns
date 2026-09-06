# SOLID Principles & Design Patterns using Java

- This repository contains code and implementation related to SOLID principles, and Design Patterns, all implemented using Java.
- The entire repository will be well structured, and have a table of contents to reflect each topic, and where to find related to text along with the code.

## Table of Contents

1. [SOLID Principles](#solid-principles)
   1. [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
      - [Code &mdash; SRP Violation](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L30-L120)
      - [Code &mdash; SRP Violation: Resolved](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple/UserController.java#L1-L29)
      - [Full Code](./src/main/java/com/ram/java/solid/singleresponsibilityprinciple)
   2. [Open Closed Principle (OCP)](#open-closed-principle-ocp)
      - [Code &mdash; OCP Violation](./src/main/java/com/ram/java/solid/openclosedprinciple/violation/)
      - [Code &mdash; OCP Violation: Resolved](./src/main/java/com/ram/java/solid/openclosedprinciple/resolved/)
   3. [Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
      - [Code &mdash; LSP Violation](./src/main/java/com/ram/java/solid/liskovsubstitutionprinciple/violation/)
      - [Code &mdash; LSP Violation: Resolved](./src/main/java/com/ram/java/solid/liskovsubstitutionprinciple/resolved/)
   4. [Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
      - [Code &mdash; ISP Violation](./src/main/java/com/ram/java/solid/interfacesegregation/services/violation/)
      - [Code &mdash; ISP Violation: 1st Resolution](./src/main/java/com/ram/java/solid/interfacesegregation/services/resolved_1/)
      - [Code &mdash; ISP Violation: 2nd Resolution](./src/main/java/com/ram/java/solid/interfacesegregation/services/resolved_2/)
   5. [Dependency Injection Principle (DI)](#dependency-inversion-principle-di)
      - [Code &mdash; DI Violation](./src/main/java/com/ram/java/solid/dependencyinversion/services/violation/)
      - [Code &mdash; DI Violation: Resolved](./src/main/java/com/ram/java/solid/dependencyinversion/services/resolved/)

2. [Design Patterns](#design-patterns)
   1. [Creational Design Patterns](#creational-design-patterns)

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
		writer.write(report);											// We're NOT creating the dependency here as well.
	}
    ```
    
    > Anyone who now wants to fulfil the previous requirements like:
    > 1. Write the report in HTML format: The caller can simply pass in a different implementation of the `Formatter`, and this should work as expected.
    > 2. Write the report to memory/network, instead of disk: The caller can simply pass in a different implementation of the `Writer`, and that should take care of the report being written to memory/network.

- Best example of Dependency Inversion can be seen inside Spring & Spring Boot, which uses DI for almost everything &mdash;
  `@Autowire`, `@Bean`, etc., are all injected via Spring Dependency Injection via Dependency Inversion Principle.

DI:

1. __HIGH LEVEL MODULES SHOULD NOT DEPEND UPON LOW LEVEL MODULES__ &mdash; __BOTH SHOULD DEPEND UPON ABSTRACTIONS__.
2. __ABSTRACTIONS SHOULD NOT DEPEND UPON DETAILS__ &mdash; __DETAILS SHOULD DEPEND UPON ABSTRACTIONS__.

[ꜛ️](#table-of-contents)

---

### Design Patterns

- There are 26 design patterns, and remembering every design pattern is almost impossible.
- That's why, all these 26 design patterns are divided into 3 categories:
  1. CREATIONAL: patterns that deal with the process of creation of objects of classes.
  2. STRUCTURAL: patterns that deal with how classes and objects are arranged or composed.
     These design patterns deal with how we can arrange our classes and objects so that we can derive a functionality out of them.
  3. BEHAVIORAL: patterns that deal with how classes and objects interact & communicate with each other.
     Mainly, these patterns are responsible for how we can design the interaction/communication between classes and objects,
     so that we can achieve the desired goal with these objects.

[ꜛ️](#table-of-contents)

#### Creational Design Patterns

- Creational design patterns deal with the process of creation of objects of classes.
- Why do we need a category of design patterns to create the object of a class when we already have the `new` operator?
  - Answer: __It's not that simple__!
  - In real life software development, a single object may need multiple other objects before it can even be instantiated.
  - Sometimes there might be a requirement that there should only be a single object of your class in the entire application.
    That class might just be representing something like a Configuration, and therefore, you want only 1 object of that class,
    from which the entire application can read the configuration, from a single source of truth, which is a single object.
- The following are some of the Creational Design Patterns:
  1. Builder
  2. Simple Factory
  3. Factory Method
  4. Prototype
  5. Singleton
  6. Abstract Factory
  7. Object Pool

[ꜛ️](#table-of-contents)

##### Builder Design Pattern

- Why use Builder pattern?
  - Let's say, you want a `Product` class that needs to have its object, to be immutable => once `Product`'s object is created, none of its internal values should ever change.
  - Therefore, for an object (like `Product`) that needs to be immutable (whose state cannot change once created), we've an example of that in Java, which is `String` class object.
  - But when you, as a programmer, is writing a class whose instance needs to be immutable, you might have a scenario where the class' constructor can have many parameters,
    and therefore, it can become really difficult to keep track of which argument is to be sent where, whenever the object is to be created for that class.
    - Example-1: let's take a real-world example of `Product` class:

      ```java
      class Product {
		public Product(int weight, double price, int shipVolume, int shipCode) {
			// Code to initialize the class members
		}
		
		// Other code for methods and behaviour
	  }
      ```

	  > IMPORTANT NOTE
	  > --------------
      > In this class, as can be seen, there are different data typed variables like <int, double, int, int>, that can be confused when passing via `new` keyword to create a `Product`
      > class' instance, and there can be an argument made where the variable name themselves can be considered a self-documentation of what values to be passed where.
      > But that assumption quickly fails &mdash; the code when shared to another vendor, or imported as a library, is usually shared as a JAR/WAR file, which goes through the phases
      > of compilation, where variable names are usually replaced with generic variable names decided by the compiler during compilation. Therefore, self-documenting variable naming
      > also doesn't help in this case.
   
	  - Therefore, Builder design pattern helps us mitigate this in 2 ways:
	    1. Builder makes it easy to make use of such (relatively large) constructors, so that we can create immutable objects of such a class.
	    2. Builder pattern also helps us avoid writing a constructor so large, and force us to think about writing constructors which are smaller in nature, and easier to deal with as well.
	
	- Example-2: Objects that need other objects, or "parts" of other objects to construct them, would be a good place, to make use of Builder pattern, to replace such instances for
	  maintaining clean code. If you've an `Address` object, which is used as a part of `User` object, then, you need to be able to build the `Address` object first, and then build the
	  `User` object post that.

	  ```java
	  class Address {
		public Address(String houseNumber, String street, ...) {
			// Initialisation code for Address object...
		}
		
		// Other code
	  }
	  ```

	  ```java
	  class User {
		public User(String name, Address address, LocalDate birthdate, List<Role> roles) {
			//														   ^^^^^^^^^^  <----------- List of Role objects also have to be maintained immutably.
			//                   ^^^^^^^  <---------------------------------------------------- Address object being used here.
			// Initialising code for User object...
		}
		
		// Other code
	  }
	  ```
	  
	  > In such a situation, the Builder design pattern makes a lot of sense.

- What is a Builder?
  - Whenever we've a complex process to construct an object involving multiple steps, thinking of clean coding using _Builder_ design pattern, can help us.
  - In _Builder_, we abstract away (or more precisely, obscure away) the burden of creation from the caller (client) code, to a separate class, which when used
    by the user of the object, makes it really easy to create the object, in an immutable way, makes a lot of sense to the user (the code to generate the
    following UML diagram can be found inside [/resources/uml/builder-design-pattern-product-example.puml](./resources/uml/builder-design-pattern-product-example.puml))

    ![builder-pattern-example-design](./resources/images/Builder-Design-Pattern-Example.svg)
    

    > Usually, there's an abstract `Builder` class, which is implemented by a `ConcreteBuilder` class, which loosely associates and is composed of the actual
    > immutable instance the user wants to create, in this instance, it's `Product` class' instance.
    >
    > The `Director` class loosely composes of `Builder` class' instance (meaning `Builder` is created inside `Director`), and from the `Builder` instance,
    > we get the the required class' immutable instance &mdash; `Product` instance. Therefore, `Director` class is like a driver program which drives the
    > building of the instance in question.

- How to implement a Builder?
  - We start by creating a `Builder` class:
    - Identify the "__parts__" of the class you want to build builder for (in this case `Product`), and provide methods to create methods for those "__parts__".
    - Provide a method to "__assemble__" of build the final object (in this case `Product` object is to be provided).
    - The builder must provide a way/method to get the fully built object out. _Optionally_, the builder can keep the instance of the object that was built
      (`Product` in this case), so the same reference can be returned again in future.
  - A `Director` can be a separate class, OR, the client (wherever the `Builder` instance is created) themselves can play the role of director.
    - __NOTE__: Flow, and logic related to `Builder` class' instance creation is almost always taken care by a client/caller class, creating a separate
    `Director` class is really rare nowadays.

[ꜛ️](#table-of-contents)
