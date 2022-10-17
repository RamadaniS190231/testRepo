

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class PostFixConverter {
    private String infix;
    private String postfixString;
    Deque<Character> stack = new ArrayDeque<Character>();
    private List<String> postfixList = new ArrayList<>();

    public PostFixConverter(String infix) {
        this.infix = infix;
        this.postfixString = "";
    }

    public boolean isOperator(char ch)
    {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            return true;

        return false;
    }

    public double evaluatePostfix()
    {
        String exp = convertExpression();
        Stack<Integer> postFix = new Stack<>();    // Create postfix stack
        int n = exp.length();

        for(int i=0;i<n;i++)
        {
            if(isOperator(exp.charAt(i)))
            {
                // pop top 2 operands.
                int op1 = postFix.pop();
                int op2 = postFix.pop();

                // evaluate in reverse order i.e. op2 operator op1.
                switch(exp.charAt(i))
                {
                    case '+': postFix.push(op2 + op1);
                        break;

                    case '-': postFix.push(op2 - op1);
                        break;

                    case '*': postFix.push(op2 * op1);
                        break;

                    case '/': postFix.push(op2 / op1);
                        break;

                }

            }
            // Current Char is Operand simple push into stack
            else
            {
                // convert to integer
                int operand = exp.charAt(i) - '0';
                postFix.push(operand);
            }
        }

        // Stack at End will contain result.
        return postFix.pop();
    }

    public String convertExpression(){

        String result = new String("");

        for (int i = 0; i < this.infix.length(); ++i) {
            char c = this.infix.charAt(i);


            if (Character.isLetterOrDigit(c)) {
                result += c;

            }else if (c == '(') {
                stack.push(c);

            }else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.peek();
            stack.pop();
        }
        return result;
    }

    static int getPrecedence(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
