Encapsulation: 
This one is pretty simple, it's just putting data and methods together in a class. nothing much to explain. 

Inheritance: 
Classes inherit from super classes. The keyword is extends. 

Note on private vs protected:
private does not allow data members to be accessed by subclasses. So if you need to access the superclasses data members within a subclass,
the only way again is to use the super classes getter methods. 

protected allows subclasses to directly access the data members of the class. 

Polymorphism: 
Runtime Polymorphism: 
Method Overriding: 
A method can have a different definition or do different things depending on the type of object that is calling it. This
is resolved at runtime. 
keyword: @Override
Useful when you want the same method to do something different in a subclass. 

Compile-Time Polymorphism: 
Method overloading: 
Different definitions of the same method for the same class with perhaps different parameters as well so that the same method 
can do different things depending on what parameters are being passed to it. This is all resolved at compile-time because the way to 
determine which particular version of the method runs is by modifying the parameter list being passed to the method. 

Abstraction: 
Abstraction allows one to hide lower level implementations/details from the programmer while allowing them to focus on higher level 
functionality. 
Abstract classes: 
An abstract class is a class whose object you cannot directly create. Why? Cos the class is just an abstract template that other classes can then
implement in their own unique ways. 
The same principle also applies to abstract methods. WHen you create an abstract method, you do not write out a block of code for the method
to execute. That part is handled by other classes that implement this abstract method, and they will handle it in their own ways. 
Note: if you create an abstract class, it MUST be inherited to be used properly. and if you create an abstract method, it MUST be implemented
in all the subclasses of the Class. 

Use abstract classes and methods when there is a clear hierarchical relationship between the class that is abstract and the classes that implement
the abstract class. 

Interfaces: 
Sometimes you have some common methods that you want some classes to implement, but there is no clear hierarchical relationship involved. 
Example, if Item was an abstract class and Fruit implements it, it makes sense cos every Fruit is an Item. 
AN interface just declares methods that classes that implement the interface (using implements) can implement. Any data stored 
in the interface definition is static and final. 
The other use case is that you can have a class implement any number of interfaces. A class can also inherit from another class and implement
others at the same time. This simulates the effect of multiple inheritance (although multiple inheritance itself is not a feature of Java by design).
