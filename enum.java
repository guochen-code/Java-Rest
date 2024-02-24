enum Season {
  Summer, Winter, Fall, Spring;
}

Season season = Season.Fall;
Season.Spring.ordinal();
Arrays.toString(Season.values());

// ordinal changes along with position
// how to give a fixed id:

enum Season {
  Summer(1), Winter(2), Fall(3), Spring(4);

  private int value;

  private Season(int value) { ///////////// enum can have a constructor
    this.value=value;
  }

  public int getValue() { //////////////// enum can have method
    return value
      }
}

Season.Spring.getValue();

// enum can be in a separate script:
public enum Season {}
