List<Integer> list = List.of(1,4,7,9);
list.stream().forEach(
  element -> System.out.println(element)
  );

list.stream()
  .filter(element -> element.endWith("at"))
  .forEach(elment -> System.out.println(element));

// sum of a list of numbers
list.stream().reduce(0,(number,number2) -> number1 + number2);

numbers.stream().sorted().forEach(e->System.out.println(e));

numbers.stream().distinct().forEach(e->System.out.println(e));

numbers.stream().distinct().sorted().forEach(e->System.out.println(e));

numbers.stream().distinct().map(e->e*e).forEach(e->System.out.println(e));

IntStream.range(1,11).forEach(p->System.out.println(p));

list.stream().map(s->s.toLowerCase()).forEach(e->System.out.println(e));

************************************************************************************************************
List.of(23,12,34,55).stream().max() -> error, need comparator
List.of(23,12,34,55).stream().max((n1,n2) -> Integer.compare(n1,n2)) --> Optional[55]
List.of(23,12,34,55).stream().max((n1,n2) -> Integer.compare(n1,n2)).get() --> 53
List.of(23,12,34,55).stream().min((n1,n2) -> Integer.compare(n1,n2)).get() --> 12
List.of(23,12,34,55).stream().filter(e->e%2==1).collect(Collectors.toList()) --> [23,55]

IntStream(1,11).map(e->e*e).boxed().collect(Collectors.toList());

Optional class:
<optional class>.get();
<optional class>.isPresent();
<optional class>.orElse(0); // if null, return 0

************************************************************************************************************ Functional Interface
List.of(23,12,34,55).stream().filter(e->e%2==0).forEach(e->System.out.println(e));
List.of(23,12,34,55).stream().filter(new EvenNumberPredicate()).forEach(e->System.out.println(e));

class EvenNumberPredicate implements Predicate<Integer>{ /////////////////////////////////////////////////////////// predicate: either true or false
  @Override
  public boolean test(Integer number){
    return number%2==0;
  }
}

List.of(23,12,34,55).stream().filter(new EvenNumberPredicate()).forEach(new SystemOutConsumer());

class SystemOutConsumer implements Consumer<Integer>{ /////////////////////////////////////////////////////////// consumer: takes input and consumes it. not return anything back
  @Override
  public void accept(Integer number){
    System.out.println(number);
  }
}


map.(n->n*n); ---------------------- .map(new NumberSquareMapper());

class NumberSquareMapper implements Function<Integer,Integer>{ /////////////////////////////////////////////////////////// function: get an input and give you an output
  @Override
  public Integer apply (Interger number){
    return number*number;
  }
}

// create implementations of functional interfaces and an instance of that implementation

************************************************************************************************************ method references
List.of(23,12,34,55).stream().filter(new EvenNumberPredicate()).forEach(e->System.out.println(e));
List.of(23,12,34,55).stream().filter(new EvenNumberPredicate()).forEach(System.out::println);

.map(s->s.length() ------ .map(String::length)

Integer max = List.of(23,45,67,34).stream()
  .filter(n->n%2==0)
  .max((n1,n2)->Integer.compare(n1,n2))
  .orElse(0);

Integer max = List.of(23,45,67,34).stream()
  .filter(MethodReferencesRunner::isEven) // isEven is defined under MethodReferenceRunner
  .max(Integer::compare)
  .orElse(0);
