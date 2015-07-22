package org.validate;

import java.util.Stack;

/**
 * Created by aman on 22/7/15.
 */
public class ValidatorTask implements Runnable {
    private int index;
    private String line;

    public ValidatorTask(int index, String line) {
        this.index = index;
        this.line = line;
    }

    @Override
    public void run() {
        boolean isValid = isValidExpression();
        System.out.println(index + ":" + isValid);
    }

    /*****
     * Method to validate the expression
     * as per given conditions
     *
     * @return true  if expression is valid
     */
    public boolean isValidExpression() {
        char[] arr = line.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '(':
                    if (i + 1 < arr.length && (arr[i + 1] == '{' || arr[i + 1] == ')')) {
                        stack.push(arr[i]);
                    } else return false;
                    break;
                case '{':
                    if (i + 1 < arr.length && (arr[i + 1] == '[' || arr[i + 1] == '}')) {
                        stack.push(arr[i]);
                    } else return false;
                    break;
                case '[':
                    if (i + 1 < arr.length && (arr[i + 1] == '[' || arr[i + 1] == '{' || arr[i + 1] == '(' || arr[i + 1] == ']')) {
                        stack.push(arr[i]);
                    } else return false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else return false;
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else return false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
