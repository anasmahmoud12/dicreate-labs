package TheSecondQuetion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input=new Scanner(System.in);
boolean or=false;
boolean im=false;
        String expression=input.nextLine();
        StringBuilder stringBuilder=new StringBuilder(expression);
       int[] ind=new int[4];
// for(int i=0;i<expression.lent)
        int index=0;
        for (int i=0;i<stringBuilder.length();++i){
            if (stringBuilder.charAt(i)==' '){
                stringBuilder.deleteCharAt(i);
            }
        }
for (int i=0;i<stringBuilder.length();++i){
if (stringBuilder.charAt(i)=='>'){
    im=true;
}
if(stringBuilder.charAt(i)=='v'){
    or=true;
}
    if (stringBuilder.charAt(i)=='\"'){
        ind[index]=i;
        ++index;
    }
}
expression=stringBuilder.toString();
String exp1=expression.substring(ind[0]+1,ind[1]);
String exp2=expression.substring(ind[2]+1,ind[3]);
System.out.println(exp1);
System.out.println(exp2);
Imply imply=new Imply();
Or or1=new Or();
if (or){
    System.out.println(or1.Conclusion(exp1,exp2));
}
if(im){

    System.out.println(imply.Conclusion(exp1,exp2));

}


    }



}
