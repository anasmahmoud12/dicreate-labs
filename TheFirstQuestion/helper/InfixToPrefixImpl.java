package TheFirstQuestion.helper;

import java.util.Stack;

 public class InfixToPrefixImpl  {

    int precedence(char operator) {
        switch (operator) {
            case '~':
                return 3;
            case '^':
                return 2;
            case 'v':
                return 1;
            case '>':
                return 0;
        }
        return -1;
    }

    boolean ifOperator(char digit) {
        return digit == '~' || digit == 'v' || digit == '^' || digit == '>';
    }


public     String infixToPrefix(String infix) throws RuntimeException{
 boolean open_prethence=false;

        int n = infix.length();
        Stack<Character> s = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; ++i) {

            char digit = infix.charAt(i);
            if (digit==' '){
                continue;
            }
            if (digit=='('){
                open_prethence=true;
s.push(digit);
continue;
            }
        if (digit==')'){
            if(!open_prethence){
                throw new RuntimeException();
            }
            open_prethence=false;
            while (s.peek()!='('){
                prefix.append(s.pop());
            }
            s.pop();
            continue;
        }

        if (!this.ifOperator(digit)) {
                prefix.append(digit);

            }
            else {
                int p = this.precedence(digit);
                if (s.empty()||s.peek()=='(') {
                    s.push(digit);
                }
                else {

                    while (!s.empty() &&  p <= this.precedence(s.peek()) &&s.peek()!='(') {
                        prefix.append(s.pop());

                    }


                        s.push(digit);


                }
            }


        }
        while (!s.empty()){
            prefix.append(s.pop());
        }
        String result = prefix.toString();

        if(open_prethence){
            throw new  RuntimeException("not valid prence");
        }
        return result;
    }


}
