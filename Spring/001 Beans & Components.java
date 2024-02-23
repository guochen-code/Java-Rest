Spring Bean is any Java object that is managed by Spring Framework. Spring uses IOC Container (Bean Factory or Application Context) to manage these objects.

(1) launch a spring context (*** in main file)
(2) confiture the things that we want spring to manage - @Configuration @Bean (*** in configuration file)
(3) retrieve beans managed by spring

var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class); 
// try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){context.getBean("name");} //avoid context leak
System.out.println(context.getBean("name"));  --> Ravi


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

***********************************************************************************************************************************************
// print out all beans
Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out.println);

// primary bean
@Bean(name="address2")
@primary
public String address() {
    return new Address("xx","yy");
  }

@Bean(name="address2")
@Qualifier("address3qualifier")
public String address() {
    return new Address("xx","yy");
  }

@Bean
public Person person3Parameters(String name, int age, @Qualifier("address3qualifier") Address address) {
  return new Person(name, age, address3);
}

System.out.println(context.getBean("address3qualifier"));

*********************************************************************************************************************************************** components like beans

@Component
@Primary
public class MarioGame implements GamingConsole{}

@Component
public class PacmanGame implements GamingConsole{}

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{}

// autowiring using constructor injection:
public class GameRunner {
  private GamingConsole game;

  public GameRunner(GamingConsole game) { //constructor injection for autowiring
    this.game = game;
  }

// how to use Qualifier for autowiring
public class GameRunner {
  private GamingConsole game;

  public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) { //constructor injection for autowiring
    this.game = game;
  }  


- just @Autowired: give me primary object
- @Autowired + @Qualifier: only want specific object
