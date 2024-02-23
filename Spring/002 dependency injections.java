Spring team recommends constructor-based injection as dependencies are automatically set when an object is created.
constructor-based: set by creating the Bean using its Constructor;
setter-based: set by calling setter methods on your beans;
field: no setter or constructor, injected using reflection;

@Component
class YourBusinessClass{
  Dependency1 dependency1;
  Dependency2 dependency2;

public String toString(){
  return "Using " + dependency1 +" and " + dependency2;
  }
}

@Component
class Dependency1{}

@Component
class Dependency2{}

Array.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
--->
YourBusinessClass
Dependency1  
Dependency2
other internal objects

System.out.println(context.getBean(YourBusinessClass.class));
---> Using null and null


//field injection
@Component
class YourBusinessClass{
  @Autowired
  Dependency1 dependency1;
  @Autowired
  Dependency2 dependency2;

public String toString(){
  return "Using " + dependency1 +" and " + dependency2;
  }
}


//setter-based
@Component
class YourBusinessClass{
  Dependency1 dependency1;
  Dependency2 dependency2;

@Autowired
public void setDependency1(Dependency1 dependency1){
  this.dependency1=dependency1;
}

@Autowired
public void setDependency1(Dependency2 dependency2){
  this.dependency2=dependency2;
}

public String toString(){
  return "Using " + dependency1 +" and " + dependency2;
  }
}

//constructor-based
@Component
class YourBusinessClass{
  Dependency1 dependency1;
  Dependency2 dependency2;

@Autowired // this can be removed to work the same, not mandatory
public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
  super();
  this.dependency1=dependency1;
  this.dependency2=dependency2;
}

public String toString(){
  return "Using " + dependency1 +" and " + dependency2;
  }
}
