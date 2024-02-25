Eliminate verbosity in creating java beans
- public asscessor methods, constructor, equals, hashcode and toString are automatically created
- can create custom implementation if you want
- compact constructors are only allowed in Records
- can add static fields, static initializer, and static methods
- but cannot add instance variables or instance initializer

record Person(String name, String email, String phoneNumber) {
  Person{
    if(name==null)
      throw ne IllegalArgumentException("Name is null.");
}
}
