package main.java;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        record Case(String description, boolean expected, String input) {
        }
        Case[] cases = {
                new Case("empty string", true, ""),
                new Case("single pair ()", true, "(a)"),
                new Case("single pair []", true, "[]"),
                new Case("single pair {}", true, "{}"),
                new Case("multiple pairs ()()", true, "()()"),
                new Case("nested ()[]{}", true, "()[]{}"),
                new Case("nested {[()]}", true, "{[()]}"),
                new Case("deeply nested", true, "(({{[[]]}}))"),
                new Case("single open (", false, "("),
                new Case("single close )", false, ")"),
                new Case("mismatched (]", false, "(]"),
                new Case("mismatched ([)]", false, "([)]"),
                new Case("extra close ())", false, "())"),
                new Case("wrong order }{", false, "}{"),
                new Case("close before open ][", false, "]["),
                new Case("only opens {{{", false, "{{{"),
        };

        int passed = 0;
        for (Case c : cases) {
            boolean result = isValidParentheses(c.input);
            boolean ok = result == c.expected;
            System.out.printf("[%s] %s — expected=%b got=%b%n",
                    ok ? "PASS" : "FAIL", c.description, c.expected, result);
            if (ok) passed++;
        }
        System.out.printf("%nResult: %d/%d passed%n", passed, cases.length);
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
