(1) launch a spring context
(2) confiture the things that we want spring to manage - @Configuration @Bean
(3) retrieve beans managed by spring

var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
System.out.println(context.getBean("name");  --> Ravi


record Address(String firstLine, String city){}; //like dataclass
@Configuration
public class HelloWorldConfiguration {
  @Bean
  public String name() {
    return "Ravi";
  }
  @Bean(name="address2")
  public String address() {
    return new Address("xx","yy");
  }
}

System.out.println(context.getBean(Address.class));

// different beans can interact with each other
@Bean
public Person person2Methodcall(){
    return new Person(name(),age(),address()); // name(),age(),address() are beans
}

@Bean
public Person person3Parameters(String name, int age, Address address3) {
  return new Person(name, age, address3);
}
