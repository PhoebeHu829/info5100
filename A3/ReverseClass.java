
import java.util.Stack;

public class ReverseClass {
	 public static String reverseString(String s) {
		 s = s.trim();
		 Stack<String> reverse = new Stack<String>();
		 String[] elements = s.split(" ");
		 for(String word: elements) {
			 if(word.trim().length() != 0) {
				 reverse.push(word);
			 }
		 }
		 String res = "";
		 while(!reverse.isEmpty()) {
			 res += reverse.pop() + " ";
		 }
		 
	       return res.trim();
	    }

	    public static void main(String[] args) {
	    	String ans = ReverseClass.reverseString("   the!  sky ! is        blue     ");
	    	System.out.println(ans);
	    	System.out.println("     ".trim().length());
	    }
}
