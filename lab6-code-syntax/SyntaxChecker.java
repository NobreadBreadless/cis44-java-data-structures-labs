// You will need a functioning Stack implementation (like ArrayStack) for this to work.
// interface Stack { ... }
// class ArrayStack implements Stack { ... }

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack<Character> buffer = new ArrayStack<Character>(line.length());


        // Your implementation here...
        for (char c : line.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (buffer.isEmpty()) {
                    return false;
                }
                
                // Pop
                char popped = buffer.pop();

                // Check if close match opening
                if (!(
                    (c == ')' && popped == '(') || 
                    (c == ']' && popped == '[') || 
                    (c == '}' && popped == '{'))) {
                    return false;
                }
            }
        }
        // After iterating through the entire string, if the stack is empty, the string is balanced. If the stack is not empty, it means there are unmatched opening symbols, so the string is unbalanced.

        if (buffer.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
