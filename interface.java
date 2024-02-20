(1) reusability
The Operation interface promotes code reusability by allowing multiple classes (Add, Subtract, Multiply) to share a common behavior (the perform method). 
This encourages writing modular and maintainable code, as the same interface can be implemented by various classes to provide different functionalities.

(2) flexibility
If we want to add a new operation, such as multiplication, we can simply create a new class implementing the Operation interface without modifying existing code:
By adhering to the Operation interface, we can seamlessly integrate new operations (Multiply) into our existing codebase without modifying the Calculator class.

(3) Polymorphism
Polymorphism allows us to treat objects of different classes in a uniform manner. In the Calculator class, we create references of type Operation (add, subtract) and assign them instances of concrete classes (Add, Subtract). 
We can then call the perform method on these references without knowing their specific implementations at compile time.


// Operation interface
interface Operation {
    int perform(int x, int y);
}

// Concrete implementation: Add
class Add implements Operation {
    @Override
    public int perform(int x, int y) {
        return x + y;
    }
}

// Concrete implementation: Subtract
class Subtract implements Operation {
    @Override
    public int perform(int x, int y) {
        return x - y;
    }
}

// Client code using the Operation interface
public class Calculator {
    public static void main(String[] args) {
        Operation add = new Add(); // Polymorphic behavior
        Operation subtract = new Subtract(); // Polymorphic behavior
        
        // Perform addition
        int resultAdd = add.perform(5, 3);
        System.out.println("Addition result: " + resultAdd); // Output: 8
        
        // Perform subtraction
        int resultSubtract = subtract.perform(10, 4);
        System.out.println("Subtraction result: " + resultSubtract); // Output: 6
    }
}
