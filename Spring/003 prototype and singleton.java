// by default all the beans are created in the spring framework are singletons
// when you ask for a bean, the same instance will return back
// if you want a different instance return each time, you need to use:

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{}

System.out.println(context.getBean(PrototypeClass.class)); // each time is different instance

// use prototype
stateful beans, for example, hold user information

// use singleton
stateless beans

