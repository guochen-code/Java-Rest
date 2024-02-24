//script-001 - main
@Configuration
@ComponentScan
public class ApplicationRunner {

	public static void main(String[] args) {
		try(var context =
				new AnnotationConfigApplicationContext (ApplicationRunner.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
		
	}

}

//script-002 - interface
public interface DataService {
	
	int[] retrieveData();

}

//script-003 - interface implementation-001
@Component
@Primary
public class MySQLDataService implements DataService{
	
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}
}

//script-004 - interface implementation-002
@Component
public class MongoDbDataService implements DataService{
	
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}
}


//script-005 - business logics
@Component
public class BusinessCalculationService {
	
	@Autowired
	private DataService dataservice;
	
	public int findMax() {
		return Arrays.stream(dataservice.retrieveData()).max().orElse(0);
	}
}

// @Component - generic annotation applicable for any class
// specializations of @Compoenent
- @Service - indicates that an annotated class has business logic;
- @Controller - used to define controllers in your web applications and REST API;
- @Repository - retrieve and or manipulate data in a database
