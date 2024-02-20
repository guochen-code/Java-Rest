public class ArrayMagic {
    /**
     * This method determines whether there's an element greater than a given number in an array.
     *
     * @param array The array to search through.
     * @param number The number to compare with the array elements.
     * @return True if there's an element greater than the given number in the array, false otherwise.
     */
    public boolean doesHaveElementGreaterThan(int[] array, int number) {

        // Edge Case: If the array is empty, return false.
        if (array.length == 0) {
            return false;
        }

        // Iterate through each element in the array
        for (int element : array) {

            // If the current element is greater than the given number, immediately return true.
            if (element > number) {
                return true;
            }
        }

        // If no element is found that is greater than the given number, return false.
        return false;
    }
    /**
     * This method finds and returns the second largest element in the given array.
     *
     * @param array the array in which to find the second largest element
     * @return the second largest element in the array
     */

    public int findSecondLargestElement(int[] array) {
        //TODO: Write your code here
        if (array.length<2){
            return -1;
        }

        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;

        for (int element:array){
            if (element>num1){
                num2=num1;
                num1=element;

            }
            else if (element > num2 && element<num1){
                num2=element;
            }

        }

        if (num2 == Integer.MIN_VALUE) {
            return -1;
        }
        return num2;

    }
}
