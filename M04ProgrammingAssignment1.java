import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class M04ProgrammingAssignment1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolChecker <filename>");
            return;
        }

        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Stack<Character> stack = new Stack<>();
          

            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (isOpenGroupingSymbol(c)) {
                        stack.push(c);
                    } else if (isCloseGroupingSymbol(c)) {
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                            System.out.println("Error: Mismatched grouping symbol");
                            return;
                        }
                    }
                }
                
            }

            if (!stack.isEmpty()) {
                System.out.println("Error: Mismatched grouping symbol at the end of file");
            } else {
                System.out.println("No errors. Grouping symbols are correctly matched.");
            }
        } 
    }

    private static boolean isOpenGroupingSymbol(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isCloseGroupingSymbol(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}