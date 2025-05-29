package Datastructure;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2023-04-05 10:37
 * The pre,in,post traversal based in binaryTree,and a calculaor on it.
 */
public class searchingTree {
    public static void main(String[] args) {
        Stack<Node>stack=new Stack<Node>();
        String str="12+123+**";
        for(int i=0;i<str.length();i++){
            if((int)str.charAt(i)<=48||(int)str.charAt(i)>=57){
                Node a=stack.pop();
                Node b=stack.pop();
                Node rootChar=new Node(str.charAt(i),a,b);
                stack.push(rootChar);
            }
            else{
                Node rootNum=new Node((double)str.charAt(i)-48);
                stack.push(rootNum);
            }
        }
        System.out.println(new calculate(stack).calcu());
    }
    static void preorder(Node root){
        if(root!=null){
            preorder(root.leftTree);
            preorder(root.rightTree);
            if(root.rootNum!=0){
                System.out.print(root.rootNum);
            }
            if((int)root.rootChar!=0){
                System.out.print(root.rootChar);
            }
        }
    }
    static void Inorder(Node root){
        if(root!=null){
            Inorder(root.leftTree);
            if(root.rootNum!=0){
                System.out.print(root.rootNum);
            }
            if((int)root.rootChar!=0){
                System.out.print(root.rootChar);
            }
            Inorder(root.rightTree);
            System.out.println(root.rootNum);
        }
    }
    static void postorder(Node root){
        if(root!=null){
            postorder(root.leftTree);
            postorder(root.rightTree);
            if(root.rootNum!=0){
                System.out.print(root.rootNum);
            }
            if((int)root.rootChar!=0){
                System.out.print(root.rootChar);
            }
        }
    }
}
class Node{
    char rootChar;
    double rootNum;
    Node leftTree;
    Node rightTree;
    public Node(char root,Node left,Node right){
        this.leftTree=left;
        this.rightTree=right;
        this.rootChar=root;
    }
    public Node(double root){
        this.rootNum=root;
    }
}
class calculate{
    Stack<Node> stack;
    public calculate(Stack<Node> stack){
        this.stack=stack;
    }
    double calcu(){
        double res=0;
        cal(stack.peek());
        res=stack.peek().rootNum;
        return res;
    }
    void cal(Node root){
        if(root.leftTree!=null&&root.rightTree!=null){
            cal(root.leftTree);
            cal(root.rightTree);
            if(root.rootChar=='*'){
                root.rootNum=root.leftTree.rootNum*root.rightTree.rootNum;
                root.rightTree=null;
                root.leftTree=null;
            }
            if(root.rootChar=='/'){
                root.rootNum=root.leftTree.rootNum/root.rightTree.rootNum;
                root.rightTree=null;
                root.leftTree=null;
            }
            if(root.rootChar=='+'){
                root.rootNum=root.leftTree.rootNum+root.rightTree.rootNum;
                root.rightTree=null;
                root.leftTree=null;
            }
            if(root.rootChar=='-'){
                root.rootNum=root.leftTree.rootNum-root.rightTree.rootNum;
                root.rightTree=null;
                root.leftTree=null;
            }
        }
    }
}

