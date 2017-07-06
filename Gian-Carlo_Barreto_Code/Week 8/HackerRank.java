// Challange 1: Java Regex
class MyRegex {
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;
}

// Challange 2: Java Regex 2 - Duplicate Words
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "(\\b\\w+)(\\s+\\1\\b)*";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}

// Challange 3: Java Regex 3 - Username Checker
String pattern = "^[a-zA-Z]([a-zA-Z0-9_]){7,29}$";

// Challenge 4: Tag Content Extractor
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String line = in.nextLine();
             //Write your code here
         int count = 0;
         Pattern r = Pattern.compile("<(.+?)>([^<]+)</\\1>");
         Matcher m = r.matcher(line);
         while(m.find()) {
             if (m.group(2).length() !=0) {
                 System.out.println(m.group(2));
             count++;
             }
         }
         if (count == 0) System.out.println("None");
         testCases--;
      }
   }
}

// Challenge 5: Java BigDecimal
Arrays.sort(s, 0, n, Collections.reverseOrder(new Comparator<String>() {
   @Override
   public int compare(String s1, String s2) {
       BigDecimal a = new BigDecimal(s1);
       BigDecimal b = new BigDecimal(s2);
       return a.compareTo(b);
   }
}));

// Challenge 6: Java 1D Array (Part 2)
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            if (isSolvable(m, array, 0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }
}

// Challenge 7: Java Stack
import java.util.*;
class Solution{
   
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
         String input=sc.next();
            //Complete the code
         if (isBalanced(input))
             System.out.println("true");
          else 
             System.out.println("false");
      }
   }
    
    public static boolean isBalanced(String input) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            }
            else if (!s.empty()) {
                if (c == ')' && s.peek() == '(') {
                    s.pop();
                }
                else if (c == '}' && s.peek() == '{') {
                    s.pop();
                }
                else if (c == ']' && s.peek() == '[') {
                    s.pop();
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        if (s.empty())
            return true;
        else
            return false;
    }
}

// Challege 8: Java Comparator
class Checker implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        if (p1.score != p2.score)
            return p2.score - p1.score;
        else
            return p1.name.compareTo(p2.name);
    }
}

// Challege 9: Java Inheritance I
class Bird extends Animal{
	void fly(){
		System.out.println("I am flying");
	}
    void sing() {
        System.out.println("I am singing");
    }
}

// Challege 10: Java Exception Handling
class MyCalculator {
    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0)
            throw new Exception("n and p should be non-negative");
        return ((int) Math.pow(n, p));
    }
}