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
