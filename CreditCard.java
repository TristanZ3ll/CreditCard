import java.util.Scanner;

public class CreditCard {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter credit card number. ");
        long userName = myObj.nextLong();
        System.out.println(sumOfDoubleEvenPlace(userName) + " " + sumOfOddPlace(userName));
        System.out.println(userName + " is " + (isValid(userName) ? "valid" : "invalid"));
        myObj.close();
    }


    //Return True if the card number is valid 
    public static boolean isValid(long number){
        boolean valid =
        //(getSize(number) >= 13 && getSize(number) <= 16) &&
       // (prefixMatched(number, 4) || prefixMatched(number, 5) ||
       // prefixMatched(number, 37) || prefixMatched(number, 6)) &&
        ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

    return valid;
}




    //get the result from step 2
    public static int sumOfDoubleEvenPlace(long number){
        int totalSum=0;
        String stringNum= Long.toString(number); 
        for (int i=stringNum.length() - 2; i > 0; i-=2){  
            int numValTimesTwo = Character.getNumericValue(stringNum.charAt(i)) * 2;
            numValTimesTwo = getDigit(numValTimesTwo);
            totalSum += numValTimesTwo;
        }
        return totalSum -1;
    }

    //Return this number if it is a single digit, otherwise return the sum of the 2 digits
    public static int getDigit(int number){
        if(number > 9){
                String s=String.valueOf(number);
                number = Character.getNumericValue(s.charAt(1)) + Character.getNumericValue(s.charAt(0));
                return number;
            }
            else{
                return number;
            }

    }

    //return sum of odd place digits in number
    public static int sumOfOddPlace(long number){
        int totalSum=0;
        String stringNum= Long.toString(number); 
        for (int i=stringNum.length()-1; i > 0; i-=2){
            totalSum += Character.getNumericValue(stringNum.charAt(i));
        }
        return totalSum -1;
    }

    /** Return true if the number d is a prefix for number */ 
    public static boolean prefixMatched(long number, int d){
        return getPrefix(number, getSize(d)) == d;
            
    }
/** Return the number of digits in d */ 
    public static int getSize(long d){
       String dee = Long.toString(d);
       return dee.length();

    } 

    /** Return the first k number of digits from number. If the * number of digits in number is less than k, return number. */ 
    public static long getPrefix(long number, int k){
        if (getSize(number) > k)  {
			String numberStr = Long.toString(number);
			return  Long.parseLong(numberStr.substring(0, k));
		}
		return number;
    }

}