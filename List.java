(1) Type:
int[]: This is an array of primitive int values. It stores actual integer values directly in memory.
List<Integer>: This is a generic list that can hold Integer objects. Each element in the list is a reference to an Integer object, which wraps the primitive int value.

(2) Mutability:
int[]: Arrays have a fixed size once they are created. The length of the array is determined at initialization and cannot be changed.
List<Integer>: Lists are resizable and can dynamically grow or shrink in size. You can add or remove elements from a list as needed.

(3) Generics:
int[] does not support generics since it deals with primitive types directly.
List<Integer> is a generic type, which means it can work with any reference type. In this case, Integer is the reference type used to store integer values.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.List;
 
public class NumberMagic {
 
    /**
     * This method returns all factors of a given number in an ArrayList.
     * 
     * @param number the number to find factors of
     * @return a List of factors of the number
     */
    public List<Integer> determineAllFactors(int number) {
 
        // Edge case: If the number is 0 or negative, return an empty list.
        // Factorization is usually defined for positive integers.
        if (number <= 0) {
            return new ArrayList<>();
        }
 
        List<Integer> factors = new ArrayList<>();//////////////////////////////////////////////////////////////////////////////// empty list
 
        // Start from 1 and iterate up to the given number.
        // Check if the number is divisible by the current iterator value (i.e., if it's a factor).
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If it is, add it to the factors list.
                factors.add(i);//////////////////////////////////////////////////////////////////////////////// == append list
            }
        }
 
        return factors;
    }
}
