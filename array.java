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

    public boolean isSorted(int[] array) {
 
        // Edge case: If the array length is 1 or less, it is technically sorted, so return true.
        if (array.length <= 1) {
            return true;
        }
 
        // Iterate over the array, starting from the second element
        for (int i = 1; i < array.length; i++) {
            // If the current element is less than the previous one, the array is not sorted, so return false.
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
 
        // If the method has not returned yet, that means no elements were out of order, so the array is sorted.
        return true;
    }

    /**
     * This method reverses an array.
     * 
     * @param array the array to reverse
     * @return a new array with elements in reverse order
     */
    public int[] reverseArray(int[] array) {
 
        // Edge case: If the array is empty or contains only one element, return the array as is.
        if (array.length <= 1) {
            return array;
        }
 
        // Initialize pointers at the start and end of the array.
        int start = 0;
        int end = array.length - 1;
 
        // Create a new array to store the reversed elements.
        int[] reversedArray = new int[array.length];
 
        // Traverse the array from both ends towards the middle.
        while (start <= end) {
            // Swap the elements at the start and end indices.
            reversedArray[start] = array[end];
            reversedArray[end] = array[start];
 
            // Move the pointers towards the middle.
            start++;
            end--;
        }
 
        return reversedArray;
    }

    public int[] reverseArray(int[] array) {
    // Edge case: If the array is empty or contains only one element, return the array as is.
    if (array.length <= 1) {
        return array;
    }

    // Initialize pointers at the start and end of the array.
    int start = 0;
    int end = array.length - 1;

    // Traverse the array from both ends towards the middle.
    while (start < end) {
        // Swap the elements at the start and end indices.
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        // Move the pointers towards the middle.
        start++;
        end--;
    }

    return array;
}

}
