import java.util.*; // Import the Scanner class

/** A class to alter strings
 * @author Jake Model
 */


public class P1PT2 {

    public static String inputString;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nWelcome\nEnter string: ");
        inputString = scanner.nextLine();
        start();
    }

    // method for start screen
    public static void start() {
        try {
            System.out.println("\nWelcome\n 1. Palindrome Check \n 2. Anagram Check \n 3. Add Substring \n 4. Get Length \n 5. Count Occurences \n 6. Reverse Sentence \n 7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    // palindrome check
                    palindromeRecursive(inputString);
                    start();
                    break;
                case 2:
                    // anagram check
                    anagramChecker(inputString, "");
                    start();
                    break;
                case 3:
                    // add substring
                    addSubstring(inputString, "", -1);
                    start();
                    break;
                case 4:
                    // get length
                    getLength(inputString);
                    start();
                    break;
                case 5:
                    // count occurances
                    occurenceCounter(inputString, "");
                    start();
                    break;
                case 6:
                    // reverse sentence
                    System.out.println("\n" + sentenceReversal(inputString) + "\n");
                    start();
                    break;
                case 7:
                    // quit
                    System.out.println("Have a nice day :)");
                    break;
                default:
                    // return to start
                    System.out.println("Invalid choice");
                    start();
                    break;
            }
        }
        // if an entry is not valid
        catch (Exception e) {
            System.out.println("Invalid choice");
            start();
        }
    }

    // method to check if it is a palindrome
    public static boolean palindromeRecursive(String input) {
        input = input.toLowerCase();
        int length = input.length() - 1;
        StringBuilder input2 = new StringBuilder();

        // check string input is not empty
        if ((input.isEmpty()) || (length == 1)) {
            System.out.println("\ntrue\n");
            return true;
        }
        else {
            for (int index = 1; index < length; index++) {
                if (input.charAt(index) != ' ') {
                    input2.append(input.charAt(index));
                }
            }
        }

        // check for palindrome
        if ((input.isEmpty() != true) && ((input.charAt(0) == input.charAt(length)) && (palindromeRecursive(input2.toString()))))
            return true;
        else {
            System.out.println("\nfalse\n");
            return false;
        }
    }

    // return true if a string is an anagram of another
    public static boolean anagramChecker(String x, String y) {
        System.out.print("\nEnter string to compare: ");
        
        while (y.equals("")) {
            y = scanner.nextLine();
        }

        if (x.length() == y.length()) {
            int countx = 0;
            int county = 0;

            x.toLowerCase();
            y.toLowerCase();

            // turn strings to sorted arrays
            char charArrayX[] = x.toCharArray();
            char charArrayY[] = y.toCharArray();
            Arrays.sort(charArrayX);
            Arrays.sort(charArrayY);

            // compare each index of the array
            for (int index = 0; index < (charArrayX.length); index++) {
                if (charArrayX[index] != charArrayY[index]) {
                    System.out.println("false");
                    return false;
                }
            }
            System.out.println("\ntrue\n");
            return (countx == county);
        }
        System.out.println("false");
        return false;
    }

    // return the substring added at a given index
    public static String addSubstring(String input, String substring, int index) throws NullPointerException{

        System.out.print("\nSubstring to be inserted: ");
        boolean checker = true;

        // obtain substring & index
        while (substring.equals("")) {
            substring = scanner.nextLine();
            while (!substring.equals("") && (checker)) {
                System.out.println("Index placement:");
                index = scanner.nextInt();
                if (index != -1)
                    checker = false;
            }
            if (!substring.equals("") && (index != -1))
                break;
        }
        
        // ensure valid index
        if (index > input.length()) {
            System.out.println("\nIndex too large");
            throw new NullPointerException();
        }
        if (index < 0) {
            System.out.println("Index too small");
            throw new NullPointerException();
        }

        // insert substring
        StringBuilder newString = new StringBuilder();
        for (int counter = 0; counter < index; counter++) {
            newString.append(input.charAt(counter));
        }
        for (int counter = 0; counter < substring.length(); counter++) {
            newString.append(substring.charAt(counter));
        }
        for (int counter = (index); counter < input.length(); counter++) {
            newString.append(input.charAt(counter));
        }
        
        System.out.println("\n" + newString + "\n");
        return newString.toString();
   }

    // return the length of a string
    public static int getLength(String input) {
        System.out.println("\nLength is " + input.length() + "\n");
        return input.length();
   }

    // return # of occurrences of a substring in the string
    public static int occurenceCounter(String input, String substring) {
        System.out.print("\nEnter substring: ");

        // aquire substring
        while (substring.equals("")) {
            substring = scanner.nextLine();
        }

        // split input string to different array inputs
        int count = 0;
        String[] inputArray = input.split(" ");

        // check if the input array value equals substring
        for (String x : inputArray) {
            if (x.equals(substring)) {
                count++;
            }
        }

        System.out.println("\n" + count + "\n");
        return count;
    }

    // return the sentence in a reversed order
    public static String sentenceReversal(String input) {

        // find spaces
        int index = input.indexOf(" ");

        // base case
        if (index == -1) {
            return input;
        }

        // recursive return call
        return
            sentenceReversal(input.substring(index + 1)) + " " + input.substring(0, index);
    }
}