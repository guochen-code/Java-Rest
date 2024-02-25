List<Integer> numbers = List.of(3,4,5,6,7);

Predicate<Integer> evenNumberPredicate = number -> number %2 ==0;

numbers.stream().filter(evenNumberPredicate)).forEach(System.out::println);
numbers.stream().filter(evenNumberPredicate.negate())).forEach(System.out::println);

public class PredicateNotRunner{
public void boolean is Even(Integer number){
  return number%2==0;
}
}

numbers.stream().filter(PredicateNotRunner::isEven).forEach(System.out::println);
numbers.stream().filter(Predicate.not(PredicateNotRunner::isEven)).forEach(System.out::println);

