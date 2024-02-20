////////////////////////////////////////////////////////////////////////// Sum of a digit
public class NumberUtils {

    public int getSumOfDigits(int number) {
        // Write your code here
        if (number<0){
            return -1;
        }
        if (number ==0){
            return 0;
        }
        
        int sum =0;
        int lastDigit = 0;
        while (number>0){
            lastDigit = number%10;
            number = number / 10;
            System.out.println(lastDigit);
            sum+=lastDigit;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println("Result:");
        NumberUtils utils = new NumberUtils();
        System.out.println(utils.getSumOfDigits(123));   // Output: 6
    }
}

////////////////////////////////////////////////////////////////////////// Reverse a Number
public class NumberUtils {
    public int reverseNumber(int number) {
        // TODO: Write your code here
        if (number==0){
            return 0;
        }
        
        if (number<0){
            return -1;
        }
        
        int reversedNumber=0;
        int lastDigit =0;
        while(number>0){
            lastDigit = number % 10;
            reversedNumber = reversedNumber*10 + lastDigit;
            number = number / 10;
        }
        return reversedNumber;
    }
}

////////////////////////////////////////////////////////////////////////// least common multiple (LCM) of two integers 
public class BiNumber_F {
    private int number1;
    private int number2;

    public BiNumber_F(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int calculateLCM() {
        // Handle edge cases
        if (number1 == 0 || number2 == 0) {
            return 0; // LCM of 0 and any other number is 0
        }
        if (number1 < 0 || number2 < 0) {
            return -1; // LCM for negative numbers is undefined
        }

        // Find the maximum of the two numbers
        int max = Math.max(number1, number2);
        // Initialize lcm to the maximum number
        int lcm = max;

        // Loop until lcm is found
        while (true) {
            if (lcm % number1 == 0 && lcm % number2 == 0) {
                // lcm is found, break the loop
                break;
            }
            // Increment lcm by max
            lcm += max;
        }

        // Return the calculated lcm
        return lcm;
    }

    public int calculateGCD() {
        // Edge case: when either number is zero
        if (number1 == 0 || number2 == 0) {
            return 0; // GCD of 0 and any other number is 0
        }
        // Edge case: when either number is negative
        if (number1 < 0 || number2 < 0) {
            return 1; // GCD of negative numbers is 1
        }
        // Edge case: when both numbers are equal
        if (number1 == number2) {
            return number1; // GCD of two equal numbers is the number itself
        }

        int smallerNumber = Math.min(number1, number2); // The smaller of the two numbers

        // Loop from the smaller number down to 1
        for (int i = smallerNumber; i >= 1; i--) {
            // If i divides both numbers evenly, then it's the GCD
            if (number1 % i == 0 && number2 % i == 0) {
                return i;
            }
        }

        return 1; // If no other GCD has been found, it's 1
    }


}
