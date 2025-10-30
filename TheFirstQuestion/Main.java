package TheFirstQuestion;

import TheFirstQuestion.helper.InfixToPrefixImpl;
import TheFirstQuestion.helper.Validator;
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

     public String ex(String input){
         int k=0;
         StringBuilder stringBuilder=new StringBuilder();
         for( k=0;k<input.length();++k){
             char a=input.charAt(k);

            if(a=='('||(a>='A'&&a<='Z')){
                 for (int i=k;i<input.length();++i){
                     a=input.charAt(i);
                     if(a<='z' && a>='a'&& a!='v'){
                         break;
                     }

                     stringBuilder.append(a);

                 }
                 break;
             }
         }
   return stringBuilder.toString();
     }

public void  addSymbol(Character key,String value)throws RuntimeException {
    int a=0;
    if(value.equals("true")||value.equals("1")){
        a=1;
    }
    else if(value.equals("false")||value.equals("0")) {}
    else{
        throw new RuntimeException("not valid value enter true or one false or zero ");
    }

    this.keysValues.put(key,a);

}

    public static void main (String[]args) throws EmptyStackException {

Main object=new Main();
        Scanner input = new Scanner(System.in);
        String expression;



        System.out.println("Enter the Expression : ");
//        remove white spaces and qutation \" specail char
     expression=  input.nextLine().replaceAll("[\\s\"”]+","");
     expression=object.ex(expression);
        Expression expression1=new ExpressionImpl();
        expression1.setRepresentation(expression);

        String infix = expression1.getRepresentation();
System.out.printf("the expression is : %s \n",infix);


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
        InfixToPrefixImpl infixToPrefix=new InfixToPrefixImpl();
        String prefix=infixToPrefix.infixToPrefix(infix);
System.out.printf("the prefix is :  %s \n",prefix);
        //intilal add for symbols
        for (int i=0;i<prefix.length();++i){
            char a=prefix.charAt(i);


            if((a>='A' && a<='Z')  ){

                object.keysValues.put(a ,0);
            }
        }





        for (Character c:object.keysValues.keySet()){
while (true){
            System.out.printf("the value of proposition  %c : ",c);
            String value =input.nextLine().trim();
            try {
                object.addSymbol(c,value.toLowerCase());

break;

            }
            catch (RuntimeException e){
             System.out.printf("the value of %c not appropirate enter again  ",c);

            }


        }
        }






        LogicalExpressionSolver logicalExpressionSolver=new LogicalExpressionSolverImpl(object.keysValues);

        System.out.println(logicalExpressionSolver.evaluateExpression(expression1));






    }

}


