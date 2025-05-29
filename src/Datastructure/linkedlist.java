package Datastructure;

/**
 * @author shkstart
 * @create 2023-03-21 18:43
 */
class linkedlist {
    public static void main(String[] args) {
        LinkNode header=new LinkNode();
        addfirst(header);
        while(header.next!=null){
            System.out.println(header.code);
            header=header.next;
        }
    }
    static void addfirst(LinkNode dummy){
        LinkNode s;
        int flag=9;
        int a[]=new int[10];
       for(int i=0;i<10;i++){
           a[i]=i;
       }
        for(int i=0;i< a.length;i++){
           s=new LinkNode(a[i]);
           s.next=dummy.next;
           dummy.next=s;
        }
    }
    static void addlast(LinkNode dummy){
        LinkNode s = null;
        int flag=9;
        int a[]=new int[10];
        for(int i=0;i<10;i++){
            a[i]=i;
        }
        for(int i=0;i< a.length;i++){
            s=new LinkNode(a[i]);
            s.next=null;
        }

    }
}
class LinkNode<E>{
    int code;
    LinkNode<E>next;
    public LinkNode(int code){
        this.code=code;
        next=null;
    }
    public LinkNode(){
        next=null;
    }
}