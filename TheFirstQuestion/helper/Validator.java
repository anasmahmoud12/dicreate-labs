package TheFirstQuestion.helper;

import java.util.EmptyStackException;
import java.util.Stack;

 public class Validator {

    boolean isOperand(char digit){
        return !( digit == '~' || digit == 'v' || digit == '^' || digit == '>');
    }
    Integer Negiation(Integer value){
        if (value==1){
            return 0;
        }
//  else {
        return 1;
//  }

    }
    Integer And(Integer x,Integer y){
        if (x==1&&y==1){
            return 1;
        }
        return 0;

    }
    Integer Or(Integer x,Integer y){
        if (x==0&&y==0){
            return 0;
        }
        return 1;
    }
    Integer Imply(Integer x,Integer y){
        if (y==1&&x==0){
            return 0;
        }
        return 1;

    }


    public Integer prefixToResult(String prefix)throws EmptyStackException {
        Stack<Integer> s=new Stack<>();
        int n=prefix.length();

        for (int i=0;i<n;++i){
            int stackSize=s.size();
            char digit= prefix.charAt(i);

            if (this.isOperand(digit)){
                s.push(1);
            }
            else{
                Integer x,y;
                switch (digit){
                    case '~':
                        x=s.pop();

                        s.push( this.Negiation(x));
                        break;
                    case '^':
                        x=s.pop();
                        y=s.pop();
                        s.push(And(x,y));
                        break;

                    case 'v':
                        x=s.pop();
                        y=s.pop();
                        s.push(Or(x,y));

                        break;
                    case '>':
                        x=s.pop();
                        y=s.pop();
                        s.push(Imply(x,y));
                        break;

                }
            }

        }

        return s.pop();
    }


}
