package Algorithm.KMP;

/**
 * @author shkstart
 * @create 2023-03-30 21:31
 */
public class  KMP3{
    public static void main(String[] args) {
        int a[]=new next(8, "&ababac").buildnext();/*111231*/
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
class next{
    String s=new String();
    int size,now=1,x=2;
    int[]next;
    public next(int size,String s){
        this.s=s;
        this.size=size;
    }
    int [] buildnext(){
        next=new int[size];
        for(int i=0;i<next.length;i++){
            next[i]=1;
        }
        while(x<s.length()){
            if(s.charAt(now)==s.charAt(x)){
                next[++x]=++now;
            }
            else if(now!=1){
                now=next[now];
            }
            else{
                next[x]=now;
                x++;
            }
        }
        return next;
    }
}
