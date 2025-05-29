package Algorithm;

import java.util.*;
import java.util.Stack;

/**
 * @author shkstart
 * @create 2023-04-05 11:02
 */
public class CalcularOnstack {
    public static void main(String[] args) {
        Map operator= new HashMap();
        operator.put('+',1);
        operator.put('-',1);
        operator.put('*',2);
        operator.put('/',2);
        operator.put('^',3);
        operator.put('(',10);
        operator.put(')',10);
        Stack stack=new java.util.Stack();
        convert convert=new convert("2*(1+3*4^2)",operator);
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < convert.convert().size(); i++) {
            sb=sb.append(convert.convert().get(i));
        }
        calculate calculate=new calculate(sb.toString(),operator);
        System.out.println(calculate.cal());
    }
}
class convert{
    String bmul;
    Stack op;
    Map operator;
    public  convert(String mul,Map operator){
        this.bmul=mul;
        this.operator=operator;
    }
    LinkedList convert(){
         op=new Stack();
        LinkedList amul=new LinkedList();
        for(int i=0;i<bmul.length();i++){
            char t=bmul.charAt(i);
            if(!operator.containsKey(t)&&(t!=')')){
                amul.addLast(t);
            }
            else if(op.isEmpty()||(int)operator.get(t)==(int)operator.get(op.lastElement())){
                op.push(t);
            }
            else if(((int)operator.get(t)>(int)operator.get(op.lastElement()))&&(t!=')')){
                op.push(t);
            }
            else if((int)operator.get(t)<(int)operator.get(op.lastElement())&&(t!=')')){
                if((char)op.peek()!='('){
                    amul.addLast(op.lastElement());
                    op.pop();while(op.size()>0&&(char)op.lastElement()!='('){
                        amul.addLast(op.lastElement());
                        op.pop();
                    }
                    op.push(t);
                }
                else{
                    op.push(t);
                }
            }
            else if(t==')'){
                while(!op.isEmpty()&&(char)op.lastElement()!='('){
                    char e=(char)op.pop();
                    amul.addLast(e);
                }
                op.pop();
            }
            else if(t=='('){
                op.push(t);
            }
        }
        if(!op.isEmpty()){
            while(op.size()>0){
                amul.addLast(op.lastElement());
                op.pop();
            }
        }
        return amul;
    }
}
class calculate{
    String mul;
    Stack stack;
    Map map;
    public calculate(String mul,Map map){
        this.mul=mul;
        this.map=map;
    }
    double cal(){
        double t1;
        double t2;
        stack=new Stack();
        for(int i=0;i<mul.length();i++){
            if(!map.containsKey(mul.charAt(i))){
                stack.push(mul.charAt(i));
            }
            else{
                t1=Double.parseDouble(String.valueOf(stack.lastElement()));
                stack.pop();
                t2=Double.parseDouble(String.valueOf(stack.lastElement()));
                stack.pop();
                if(mul.charAt(i)=='+') stack.push(t1 + t2);
                if(mul.charAt(i)=='-') stack.push(t2 - t1);
                if(mul.charAt(i)=='*') stack.push(t1 * t2);
                if(mul.charAt(i)=='/') stack.push(t2 / t1);
                if(mul.charAt(i)=='^') stack.push(Math.pow(t2,t1));
            }
        }
        return Double.parseDouble(String.valueOf(stack.lastElement()));
    }
}