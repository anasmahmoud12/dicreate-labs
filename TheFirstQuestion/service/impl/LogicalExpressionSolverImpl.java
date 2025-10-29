package TheFirstQuestion.service.impl;

import TheFirstQuestion.helper.InfixToPrefixImpl;
import TheFirstQuestion.helper.PrefixToResultImpl;
import TheFirstQuestion.service.Expression;
import TheFirstQuestion.service.LogicalExpressionSolver;

import java.util.HashMap;
import java.util.Map;

public class LogicalExpressionSolverImpl implements LogicalExpressionSolver {
    Map<Character,Integer> keysValues=new HashMap<>();
    public LogicalExpressionSolverImpl(Map<Character,Integer> keysValues){
        this.keysValues=keysValues;
    }


  public   boolean evaluateExpression(Expression expression){

        InfixToPrefixImpl infixToPrefix=new InfixToPrefixImpl();
        PrefixToResultImpl prefixToResult=new PrefixToResultImpl(this.keysValues);

     String infix=expression.getRepresentation();
     String prefix=infixToPrefix.infixToPrefix(infix);
     Integer result= prefixToResult.prefixToResult(prefix);

     return result==1;


    }
}
