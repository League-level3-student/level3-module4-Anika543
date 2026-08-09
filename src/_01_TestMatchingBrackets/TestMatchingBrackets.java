package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {

    	
    	char[] chars = b.toCharArray();
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(int i = 0; i<chars.length; i++) {
    		if(chars[i] == '{') {
    			stack.add('{');
    		}
    		else if(chars[i] == '}' && stack.size()>=1) {
    			stack.pop(); 
    		}
    	}
    	
    	boolean val = false; 
    	if(stack.isEmpty()) {
    		val = true;
    	}
    	
        return val;
    }
}



