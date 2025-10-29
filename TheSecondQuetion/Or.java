package TheSecondQuetion;

public class Or {
    String Conclusion(String one ,String two){
        String s=two.substring(0,two.length()-1);


        if (two.equals("~"+one.charAt(0))){

return  ""+one.charAt(one.length()-1);

        }
        else if(s.equals("~"+one.charAt(0)+"v")){
            return  one.charAt(one.length()-1)+"v"+two.charAt(two.length()-1);
        }

        return "No inverense law";
    }

}
