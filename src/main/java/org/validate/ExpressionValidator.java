package org.validate;

import java.util.Stack;

/**
 * Created by aman on 22/7/15.
 */
public class ExpressionValidator {


    private char[] arr;

    public ExpressionValidator(char[] arr) {

        this.arr = arr;
    }

    public boolean isValidExpression(char[] arr) {

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
