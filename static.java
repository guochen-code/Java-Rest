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

// count is shared variable across all instances of this class
// you can call static method directly using class object
