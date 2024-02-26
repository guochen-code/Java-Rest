public class StringMagic {

    public int countUppercaseLetters(String str) {
        // TODO: Write your code here
        int count=0;
        for (int i=0; i<str.length();i++){
            if (Character.isUpperCase(str.charAt(i))){
                count++;
            }
        }
        return count;

    }

    public boolean hasConsecutiveDuplicates(String str) {

        // TODO: Write your code here
        if (str.length()<=1){
            return false;
        }

        char temp = ' '; ////////// ' ' for char and " " for string
//        char temp = str.charAt(0);
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == temp) {
                return true;
            }
            temp = str.charAt(i);
        }
        return false;
    }

    public int getRightmostDigit(String str) {


        if (str.isEmpty()) {
            return -1;
        }

        int length = str.length();

        // TODO: Write your code here
        for (int i = length - 1; i >= 0; i--){   /// need i-- because of right most digit
            if (Character.isDigit(str.charAt(i))) {
                return Character.getNumericValue(str.charAt(i));
            }
        }

        return -1;
    }
}

//
public class MyString {
 
    public String str;
 
    public MyString(String str) {
        this.str = str;
    }
    
    public boolean isHexadecimalChar(char ch) {
        // Check if the character is in the range for hexadecimal digits (A-F or a-f)
        return (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f');
    }
 
    public boolean isHexadecimal() {
        // A null string or an empty string is not a valid hexadecimal
        if (str == null || str.length() == 0) {
            return false;
        }
 
        for (char ch : str.toCharArray()) {
            // If any character is not a digit or a hexadecimal character, it's not a valid hexadecimal
            if (!Character.isDigit(ch) && !isHexadecimalChar(ch)) {
                return false;
            }
        }
 
        // If we have gone through all characters and they are all valid,
        // then the string is a valid hexadecimal
        return true;
    }
 
    
}

//
import java.util.Arrays;
 
public class StringMagic {
    public boolean areAnagrams(String str1, String str2) {
        // Handle null strings
        if (str1 == null || str2 == null) {
            return false;
        }
 
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
 
        // Check if the lengths of the strings are different
        if (str1.length() != str2.length()) {
            return false;
        }
 
        // Convert strings to char arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
 
        // Sort the char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
 
        // Check if the sorted char arrays are the same
        return Arrays.equals(charArray1, charArray2);
    }
}

//
public class StringMagic {
 
    public String reverseWordsInSentence(String sentence) {
        // Edge case: if the sentence is null, return "INVALID"
        if (sentence == null) {
            return "INVALID";
        }
 
        // Edge case: if the sentence is empty, return an empty string
        if (sentence.isEmpty()) {
            return "";
        }
 
        // Split the sentence into words
        String[] words = sentence.split(" ");
 
        // Initialize a StringBuilder to store the reversed sentence
        StringBuilder reversedSentence = new StringBuilder();
 
        // Iterate over each word and reverse it
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedSentence.append(reversedWord).append(" ");
        }
 
        // Trim any trailing whitespace and return the reversed sentence
        return reversedSentence.toString().trim();
    }
}

