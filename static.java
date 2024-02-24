class Player {
  private String name;
  private static int count =0;

public Player(String name){
  super();
  this.name=name;
  count++
    }
static public int getCount() {
  return count;
}
}

// count is shared variable across all instances of this class.
// you can call static method directly using class object.
// static method can also be called from instance, not recommended.
// in static method, cannot access non-static variable such as name, and also cannot call non-static method

// static means it's a class variable
// final means this value cannot change
