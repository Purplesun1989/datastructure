package Datastructure;

/**
 * @author shkstart
 * @create 2023-04-24 12:33
 */
public class AVL {
    public static void main(String[] args) {
        AVLnode root = new AVLnode();
        boolean flag=false;
        for(int i=1;i<=1000000;i++){
            root=insert(root,i);
        }
       if(find(root,99999,flag)){
           System.out.println("OK");
       }
    }

    static AVLnode insert(AVLnode root, int key) {
        if (root == null) {
            root = new AVLnode(key);
        } else {
            if (root.data > key) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }
        }
        return Rebalance(root);
    }
    static AVLnode del(AVLnode root, int key) {
        if (root != null) {
            if (root.data == key) {
                if (root.right != null && root.left != null) {
                    AVLnode temp = FindMini(root.right);
                    root.data = temp.data;
                    root.right = del(root.right, root.data);
                } else {
                    if (root.left != null) {
                        root = root.left;
                    } else {
                        root = root.right;
                    }
                }
            } else {
                if (root.data > key) {
                    root.left = del(root.left, key);
                } else {
                    root.right = del(root.right, key);
                }
            }

            if(root!=null){
               return  Rebalance(root);
            }
            else{
                return null;
            }
        } else {
            System.out.println("Failed:Subject not found!!");
            return null;
        }
    }
    static AVLnode FindMini(AVLnode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static void trav(AVLnode root) {
        if (root != null) {
            trav(root.left);
            System.out.println(root.data + ":" + root.height);
            trav(root.right);
        }
    }
    static AVLnode Rebalance(AVLnode root){
        if (root.GetHeight(root.left) -root. GetHeight(root.right) == 2) {
            if (root.GetHeight(root.left.left)>root.GetHeight(root.left.right)) {
                root = new rotation().RightRo(root);
            } else {
                rotation ro = new rotation();
                root = ro.LeftRo(ro.RightRo(root));
            }

        }
        if (root.GetHeight(root.right) -root. GetHeight(root.left) == 2) {
            if (root.GetHeight(root.right.right)>root.GetHeight(root.right.left)) {
                root = new rotation().LeftRo(root);
            } else {
                rotation ro = new rotation();
                root = ro.RightRo(ro.LeftRo(root));
            }
        }
        root.height = Math.max(root.GetHeight(root.left), root.GetHeight(root.right)) + 1;
        return root;
    }
    static boolean find(AVLnode root,int key,boolean flag){
        if(root!=null){
            if(root.data==key){
                flag=true;
            }
            else if(root.data>key){
                flag=find(root.left,key,flag);
            }
            else{
                flag=find(root.right,key,flag);
            }
        }
        return flag;
    }
}

class rotation {
    AVLnode RightRo(AVLnode root) {
        AVLnode newRoot = root.left;
        root.left = newRoot.right;
        root.height = Math.max(root.GetHeight(root.left), root.GetHeight(root.right)) + 1;
        newRoot.height = Math.max(newRoot.GetHeight(newRoot.left), newRoot.GetHeight(newRoot.right)) + 1;
        return newRoot;
    }

    AVLnode LeftRo(AVLnode root) {
        AVLnode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = Math.max(root.GetHeight(root.left), root.GetHeight(root.right)) + 1;
        newRoot.height = Math.max(newRoot.GetHeight(newRoot.left), newRoot.GetHeight(newRoot.right)) + 1;
        return newRoot;
    }

}
class AVLnode {
    AVLnode left;
    AVLnode right;
    int height;
    int data ;

    public AVLnode(int key) {
        this.data = key;
        left = null;
        right = null;
    }

    public AVLnode() {
        this.data = 0;
        left = null;
        right = null;
    }
    int GetHeight(AVLnode root) {
        if (root == null) {
            return 0;
        } else {
            return root.height;
        }
    }
}