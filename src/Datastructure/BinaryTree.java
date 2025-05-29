package Datastructure;

/**
 * @author shkstart
 * @create 2023-04-16 12:49
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryNode root=new BinaryNode(0);
        for(int i=1;i<=5;i++){
            insert(root,i);
        }

    }
    static BinaryNode insert(BinaryNode root, int key){
        if(root!=null){
            if(key<root.data){
                root.left=insert(root.left,key);
                return root;
            }
            else {
                root.right=insert(root.right,key);
                return root;
            }
        }
        else{
            return new BinaryNode(key);
        }
    }
    static BinaryNode Findmin(BinaryNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.left;
    }
    static BinaryNode del(BinaryNode root,int key){
        if(root!=null){
            if(root.data==key){
                if(root.left!=null&&root.right!=null){
                    root.data=Findmin(root.right).data;
                    root.right=del(root.right,root.data);

                    return root;
                }
                else{
                    if(root.left!=null){
                        root=root.left;
                        return root;
                    }
                    else if(root.right!=null){
                        root=root.right;
                        return root;
                    }
                    else{
                        return null;
                    }
                }
            }
            else{
                if(root.data>key){
                    root.left=del(root.left,key);
                    return root;
                }
                else{
                    root.right=del(root.right,key);
                    return root;
                }
            }
        }
        else{
            System.out.println("Failed");
            return null;
        }
    }
}
class BinaryNode{
    int data;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int data){
        this.data=data;
    }
}
