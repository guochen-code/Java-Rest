
//fetch some data from database in initialization

//clean up before the bean is removed out from container, like close database connection

public SomeClass(SomeDependency someDependency){
  super();
  this.someDependency=someDependency;
  System.out.println("All dependencies are ready!");
}

@OpstConstruct
public void initialize(){
  someDependency.getReady();
}

@PreDestroy
public void cleanup(){
  System.out.println("clean up!");
}

