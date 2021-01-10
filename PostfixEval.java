// Name:
// Date:

import java.util.*;

public class PostfixEval
{
   public static final String operators = "+ - * / % ^ !";
   public static Stack<Double> stack = new Stack<Double>();
   
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
      postfixExp.add("3 4 5 * +");
      postfixExp.add("3 4 * 5 +");
      postfixExp.add("10 20 + -6 6 * +");
      postfixExp.add("3 4 + 5 6 + *");
      postfixExp.add("3 4 5 + * 2 - 5 /");
      postfixExp.add("8 1 2 * + 9 3 / -");
      postfixExp.add("2 3 ^");
      postfixExp.add("20 3 %");
      postfixExp.add("21 3 %");
      postfixExp.add("22 3 %");
      postfixExp.add("23 3 %");
      postfixExp.add("5 !");
      postfixExp.add("1 1 1 1 1 + + + + !");
      
      
   
   
      
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   public static double eval(String pf)
   {
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      /*  enter your code here  */
      
      for(int i=0; i<postfixParts.size(); i++){
         String token = postfixParts.get(i);
         if(!isOperator(token)) { //token is operand
            stack.push(Double.parseDouble(token));
         } else { //token is operator
            double operand2 = stack.pop();
            double operand1 = 0;
            if(!token.equals("!")) {
               operand1 = stack.pop();
            }
            eval(operand1, operand2, token);
         }
      }
      return stack.peek();
   }
   
   public static double eval(double a, double b, String ch)
   {
      if(ch.equals("+")) {
         stack.push(a+b);
      }
      if(ch.equals("-")) {
         stack.push(a-b);
      }
      if(ch.equals("*")) {
         stack.push(a*b);
      }
      if(ch.equals("/")) {
         stack.push(a/b);
      }
      if(ch.equals("%")) {
         stack.push(a%b);
      }
      if(ch.equals("^")) {
         stack.push(Math.pow(a,b));
      }
      if(ch.equals("!")) {
         stack.push(factorial(b));
      }
      return 0; 
   }
   
   public static boolean isOperator(String op)
   {
      return operators.contains(op);
   }
   
   public static double factorial(double n) {
      if(n==0 || n==1) 
         return 1;
      return n * factorial(n-1); 
   }
}

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/