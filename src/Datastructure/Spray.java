package Datastructure;

/**
 * @author shkstart
 * @create 2023-04-25 18:58
 */
public class Spray {
    public static void main(String[] args) {
        operation op=new operation();
        SprayNode root=new SprayNode(2,null,null,null);
       for(int i=0;i<5;i++){
           root=op.insert(root,i);
       }
    }
}
class SprayNode{
    SprayNode P;
    int data;
    SprayNode L;
    SprayNode R;
    public SprayNode(int key,SprayNode P,SprayNode L,SprayNode R){
        this.data=key;
        this.P=P;
        this.L=L;
        this.R=R;
    }
    public SprayNode(){}
}
class operation{
   SprayNode insert(SprayNode root,int key){
       SprayNode rec=root;
       SprayNode Parent=null;
      while(root!=null){
          if(key<root.data){
              Parent=root;
              root=root.L;
          }
          else{
              Parent=root;
              root=root.R;
          }
      }
      SprayNode RootNew=new SprayNode(key,Parent,null,null);
      if(key<Parent.data){
          Parent.L=RootNew;
      }
      else{
          Parent.R=RootNew;
      }
       return spray(RootNew);
   }
    SprayNode del(SprayNode root,int key){
        root=Find(root,key);
        root.L.R=root.R;
        return root;
    }
    SprayNode Find(SprayNode root,int key){
        if(root==null){
            System.out.println("Failed:No subject!!!");
        }
        else{
            if(root.data==key){
               // root=spray(root);
            }
            else{
                if(root.data>key){
                    root=Find(root.L,key);
                }
                else{
                    root=Find(root.R,key);
                }
            }
        }
        return root;
    }
    SprayNode Findmini(SprayNode root){
        while(root.L!=null){
            root=root.L;
        }
        return root;
    }
    void travse(SprayNode root){
        if (root != null) {
            travse(root.L);
            travse(root.R);
            System.out.println(root.data );
        }
    }
    SprayNode RightRo(SprayNode root,int button){
       SprayNode recP=root.P;
       SprayNode recR=root.R;
       if(root.P==null){
           return root;
       }
       else{
           root.P=root.P.P;
           if(root.P!=null){
               if(button==1){
                   root.P.L=root;
               }
               else{
                   root.P.R=root;
               }
           }
           root.R=recP;
           recP.P=root;
           root.R.L=recR;
           if(recR!=null){
               recR.P=root;
           }
           return root;
       }
    }
    SprayNode LeftRo(SprayNode root,int button){
        SprayNode recP=root.P;
        SprayNode recL=root.L;
        if(root.P==null){
            return root;
        }
        else{
            root.P=root.P.P;
            if(root.P!=null){
                if(button==1){
                    root.P.L=root;
                }
                else{
                    root.P.R=root;
                }
            }
            root.L=recP;
            recP.P=root;
            root.L.R=recL;
            if(recL!=null){
                recL.P=root;
            }
            return root;
        }
    }
    SprayNode spray(SprayNode root){
            while(root.P!=null){
                if(root.P.P==null){
                    if(root.data>root.P.data){
                        root= LeftRo(root,1);
                    }
                    else{
                        root= RightRo(root,1);
                    }
                }
                else{
                    if(root.data>root.P.data){
                        if(root.P.data>root.P.P.data){
                            root=LeftRo(root,2);
                            root=LeftRo(root,2);
                        }
                        else{
                            root=LeftRo(root,1);
                            root=RightRo(root,1);
                        }
                    }
                    else {
                        if(root.P.data<root.P.P.data){
                            root=RightRo(root,1);
                            root=RightRo(root,1);
                        }
                        else{
                            root=RightRo(root,2);
                            root=LeftRo(root,2);
                        }
                    }
                }
            }

        return root;
    }
}