package TheFirstQuestion;

import TheFirstQuestion.service.Expression;
import TheFirstQuestion.service.LogicalExpressionSolver;
import TheFirstQuestion.service.impl.ExpressionImpl;
import TheFirstQuestion.service.impl.LogicalExpressionSolverImpl;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class Main {
     Map<Character,Integer>keysValues=new HashMap<>();

public void  addSymbol(String key,String value) {
    int a=0;
    if(value.equals("true")){
        a=1;
    }

    this.keysValues.put(key.charAt(0),a);

}

    public static void main (String[]args) throws EmptyStackException {

Main object=new Main();
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        int k = 0;
        for (k = 0; k < expression.length(); ++k) {

            char a = expression.charAt(k);
            if (a == '\"') {
                break;
            }

        }


expression=expression.substring(k+1,expression.length()-1);
        Expression expression1=new ExpressionImpl();
        expression1.setRepresentation(expression);

      String infix = expression1.getRepresentation();
System.out.println(infix);



try {
    InfixToPrefixImpl infixToPrefix=new InfixToPrefixImpl();
    String prefix=infixToPrefix.infixToPrefix(infix);
    Validator validator=new Validator();
    validator.prefixToResult(prefix);
}

catch (EmptyStackException e  ){
    System.out.println("Wrong Expression");
    return;
}
catch (RuntimeException e  ){
    System.out.println("Wrong Expression not valid prethenes");
    return;
}
//to get values of symbols
        String date = input.nextLine();
        String[] values = date.split(",|and");
        int num_values = values.length;
        for (int i = 0; i < num_values; ++i) {
            String a = values[i];
            String[] keyValue = a.split("=");
object.addSymbol(keyValue[0].trim(),keyValue[1].trim());
        }

        LogicalExpressionSolver logicalExpressionSolver=new LogicalExpressionSolverImpl(object.keysValues);

        System.out.println(logicalExpressionSolver.evaluateExpression(expression1));






    }

}


