/*
-------------------------
Interview java topics
-------------------------
Java OOPS /
file handling / 
exception handling / 

Wrapper class[
    wrapper class in Java provides the mechanism to convert primitive into object and object into primitive using
    autoboxing and unboxing.

    Autoboxing:

    The automatic conversion of primitive data type into its corresponding wrapper class is known as autoboxing
    int a = 5;
    Integer x = a;

    Unboxing:
    
    The automatic conversion of wrapper type into its corresponding primitive type is known as unboxing.
    Integer x = new Integer(5);
    int a = x;
]

Premitive v/s Non-premitive
Threads / 
stringbuffer vs builder / 
inner classes / 
collection framework /
concurrent collection /
interfaces and abstract classes /
nested interfaces /

marker interface[
    It is an empty interface (no field or methods). 
    Examples of marker interface are Serializable, Clonnable and Remote interface. 
    All these interfaces are empty interfaces.
]

c++ v/s python v/s java 
java features /
Synchronization /
jvm, jdk, jre, jit
advantage of packages
lambda expression,
diff b/w c++/java/python
user defined exception
association, aggregation, composition,
different types of garbage collector,

singleton class
[
     must read -> https://www.geeksforgeeks.org/singleton-class-java/
     a singleton class is a class that can have only one object (an instance of the class) at a time.
     After first time, if we try to instantiate the Singleton class, 
     the new variable also points to the first instance created.

     To design a singleton class:
       a) Make constructor as private.
       b) Write a static method that has return type object of this singleton class
]

blank final variable
[
    -A blank instance level final variable cannot be left uninitialized.

    -The blank Instance level final variable must be initialized in each constructor.

    -The blank Instance level final variable cannot be initialized in class methods.

    -A blank static final variable cannot be left uninitialized.

    -The static final variable must be initialized in a static block.

    -A static final variable cannot be initialized in constructor or class methods.
]

[
generics wildcard -  https://www.geeksforgeeks.org/wildcards-in-java/

- upper bound (parameter in a function) eg -> List< ? extends Number> numbers (used to get values)
- lower bound eg -> List< ? super Number> numbers (used to put values)
- unbounded eg -> List<?> numbers

]

[var type
In Java 10, the var keyword allows local variable type inference, 
which means the type for the local variable will be inferred by the compiler, so you don't need to declare that.

eg. var map = new HashMap<String,Integer>();
]

[generics 

- Using Generics, it is possible to create classes that work with different data types
- generics add the type saftey feature -> make errors to appear compile time than at run time
- type casting not required
- two types -> generic classes, generic methods
- works with reference type -> wrapper classes (Integer,String,Float,Long etc)
]


[Comparator vs Comparable interface

Comparable -> writer of the class speficies the sorting order by implementing Comparable interface

Comparator -> external user (outside of that class) spefices the sorting order by implementing Comparator interface
]

[serialization and deserialization / -> Saving the states of the object in a file

Serial-
 Test obj = new Test();
 Here Test class must implement Serializable interface(marker)
 FileOutputStream fis = new FileOutputStream("file.txt");
 ObjectOutputStream ois = new ObjectOutputStream(fis);
 ois.writeObject(obj);

Deserial-
 FileInputStream fis = new FileInputStream("file.txt");
 ObjectInputStream ois = new ObjectInputStream(fis);
 Test obj = (Test) ois.readObject();
]

multithreading [ we use multithreading than multiprocessing because threads use a shared memory area. 
They don't allocate separate memory area so saves memory, 
and context-switching between the threads takes less time than process.]

[Java IO - 
FileReader, FileWriter -> Prefered for characters 
FileInputStream, FileOutputStream -> Prefered for bytes (fos.write(str.getBytes()))
BufferedReader, BufferedWriter -> Java BufferedReader class is used to read the text from a character-based input stream. 
                                  It can be used to read data line by line by readLine() method. It makes the performance fast
PrintWriter ->
]

--------------------------------
*/

/*

1) Outer class can only have "Public, abstract and final modifiers"
2) A final class can not be inherited

-------------------------
    nested Inner class
-------------------------
1) provides logical grouping and more security

2) inner class private members can be accessed by outer class members,
    because inner class itself is a member of outer class so logically outer class can have access to it

3) inner class can be private, public, abstract, final

4) Accessing from outside the class if "Public"
    Outer outer = new Outer();
    Outer.Inner obj = outer.new Inner();

5) we can’t have static method in a nested inner class because an inner class is 
implicitly associated with an object of its outer class so it cannot define any static method for itself.

6) Both static and non static members of outer class can be accessed directly.
-------------------------
    local inner class
-------------------------
1) only abstract and final modifier is permitted to class 
2) class members can have any type of modifier
3) object can not be created outside the method
4) Method Local inner classes can’t use local variable of outer method until that local variable is not declared as final. 
   The main reason we need to declare a local variable as a final is that local variable lives on stack till method is on 
   the stack but there might be a case the object of inner class still lives on the heap.

5) we cant have static members
6) Both static and non static members of outer class can be accessed directly.

-------------------------
    static inner class
-------------------------
1) Static nested classes are not technically an inner class. They are like a static member of outer class.
2) we can have static members
3) Only a static member of outer class can be accessed directly.
4) Accessing "Public" static inner class from different class
   Company.Boss b = new Company.Boss();

----------------------------
    anonymous inner class
----------------------------
1) Anonymous inner class are mainly created in two ways:
    -(1) Class (may be abstract or concrete)
    -(2) Interface

2) It is an inner class without a name and for which only a single object is created. 
An anonymous inner class can be useful when making an instance of an object with certain “extras” such as overloading 
methods of a class or interface, without having to actually subclass a class.

3) Anonymous inner classes are useful in writing implementation classes for listener interfaces in graphics programming.

4) anonymous inner class can implement only one interface at a time

5) anonymous Inner class can extend a class or can implement an interface but not both at a time

6) we cant write any constructor for anonymous Inner class because anonymous 
class does not have any name and while defining constructor class name and constructor name must be same.

7) An anonymous class cannot access->modify local variables
8) members are not accesible from outside the anonymous class
};
*/

/*
git handbook

https://guides.github.com/introduction/git-handbook/

*/

