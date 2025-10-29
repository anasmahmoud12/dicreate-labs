package TheSecondQuetion;

public class Imply {

    String Conclusion(String one,String two){
int l=one.length();
String result="";
String s=two.substring(0,two.length()-1);
        if( two.equals (one.substring(0,1) ) ){
return ""+one.charAt(one.length()-1);
        }

      else   if(two.equals("~"+one.charAt(one.length()-1))){
            result="~";
            return result+one.charAt(0);

        }
        else if(s.equals(one.charAt(one.length()-1)+">")) {
            result+=one.charAt(0);
            result+='>';
            result+=two.charAt(two.length()-1);
return result;
        }
else {
    return "NO Invernse rule";
        }

    }



}
