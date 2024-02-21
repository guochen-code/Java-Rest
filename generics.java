// generics with type
public MyCustomObject<T>{} // accept all objects
public MyCustomObject<T extends Number>{} // only accept numbers, string will not work // Byte, Double, Float, Integer, Long and Short are all subclasses of Number

// generics with methods
static <X> X doubleValue(X value){
  return value;
}

// pass any type
String value1 = doubleValue(new String());
Integer number1 = doubleValue(Integer.valueOf(5));
ArrayList list1 = doubleValue(new ArrayList());

// application - duplicate list
static <X extends List> void duplicate(X list){
  list.addAll(list); // you can use any method from List class, like above you can use any method associated with the Number class
}
ArrayList<Integer> numbers = new ArrayList<>(List.of(1,2,3));
dupilcate(numers);
System.out.println(numbers); --> [1,2,3,1,2,3]

****************************************************************************************************************************************************************************************************** wild card
// sum of any type of lists - return double and same data type across the input list
static double sumOfNumberList(List<? extends Number> numbers){ ///////////////////////////////////////////////upper bounded wild card: implement common logic for all the lists which are extending Number, which are subclasses of Number
  double sum=0.0;
  for (Number number:numbers) {
    sum+=number.doubleValue();
  }
  return sum;
}
System.out.println(sumOfNumberList(List.of(1,2,3,4));
System.out.println(sumOfNumberList(List.of(1.0,2.0,3.0,4.0));
System.out.println(sumOfNumberList(List.of(1l,2l,3l,4l)); // Long


static void addACoupleOfValues(List<? super Number> numbers){ /////////////////////////////////////////////////lower bounded wild card: add a lot of different values of the types which are sub-types of Number
  numbers.add(1);
  numbers.add(1.0);
  numbers.add(1.0f);
  numbers.add(1l);
}

List<? extends Number> when you only need to read elements from the list, and you want to accept any subtype of Number.
List<? super Number> when you only need to add elements to the list, and you want to accept any supertype of Number.

Here is a quick summary:
Upper Bounded Wildcard (<? extends T>): You can read from the collection, but you cannot add elements because the exact subtype is unknown. It provides read-only access to a collection of a certain type and its subclasses.
Lower Bounded Wildcard (<? super T>): You can add elements to the collection, but the exact type of the elements you read might be broader than the specified type. 
It provides write access to a collection of a certain type and its superclasses.

******************************************************************************************************************************************************************************************************
/*
List<? extends Number> and List<? super Number> are both examples of wildcard types in Java generics, but they have different meanings and use cases.

List<? extends Number>:

This represents a list of elements of a type that is a subclass of Number, or Number itself.
You can read elements from this list, but you cannot add elements to it because the compiler cannot guarantee the exact type of elements in the list. It could be Number, or any subclass of Number.
Example: You can safely assign a List<Integer> or a List<Double> to a variable of type List<? extends Number>, but you cannot add any elements to it.
List<? super Number>:

This represents a list of elements of a type that is a superclass of Number, or Number itself.
You can add elements to this list, but you cannot guarantee the exact type of elements that are already in the list when you read from it. They could be of type Object, Number, or any superclass of Number.
Example: You can add Number instances or any subclass of Number (e.g., Integer, Double) to a List<? super Number>, but you cannot safely retrieve elements from it without casting 
because the compiler only knows that the list contains elements that are superclasses of Number.
In summary:

Use List<? extends Number> when you want to consume elements from the list, and you're not concerned about the specific subclass of Number.
Use List<? super Number> when you want to add elements to the list and you're not concerned about the specific superclass of Number.
In both cases, wildcard types provide flexibility in dealing with generic types, but they come with certain limitations and require careful handling to avoid runtime errors.
*/
******************************************************************************************************************************************************************************************************
