package Algorithm;

/**
 * @author shkstart
 * @create 2023-04-03 12:40
 */
import java.util.Scanner;

public class charStackbalance {
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Type the string here");
        s=sc.next();
        Stack stack=new Stack(s.length());
        buildstack bd=new buildstack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                bd.push(stack, s.charAt(i));
            }
            else if(s.charAt(i)==')'&&bd.isEmpty(stack)){
                System.out.println("Error!");
            }
            else if(s.charAt(i)==')'&&!bd.isEmpty(stack)){
                if(bd.top(stack)!='('){
                    System.out.println("Error!");
                }
            }
        }
        if(s.charAt(s.length()-1)!=')'&&!bd.isEmpty(stack)){
            System.out.print("Error!");
        }
    }
}
class Stack{
    int size;
    char[] operator;
    int tos=-1;
    public Stack(int size){
        this.size=size;
        operator=new char[size];
    }
}
class buildstack{
    void push(Stack stack,char x){
        if(isFull(stack)){
            System.out.println("No room");
        }
        else{
            stack.operator[++stack.tos]=x;
        }
    }
    char top(Stack stack){

        return stack.operator[stack.tos];
    }
    void pop(Stack stack){
        if(isEmpty(stack)){
            System.out.println("Empty");}
        else{
            stack.tos--;
        }
    }
    void pintStack(Stack stack){
        for(int i=stack.tos;i>=0;i--){
            System.out.print(stack.operator[i]);
        }
    }
    boolean isFull(Stack stack){
        return stack.tos==stack.size-1;
    }
    boolean isEmpty(Stack stack){
        return stack.tos==-1;
    }

}
