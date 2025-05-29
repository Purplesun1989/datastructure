package Algorithm.KMP;

/**
 * @author shkstart
 * @create 2023-03-30 9:23
 */
public class KMP2 {
    public static void main(String[] args) {
        int []a=new createNext(8,"#ababac").next();
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
}
class createNext{
    int size;
    String s;
    int []next;
    public createNext(int size,String s){
        this.size=size;
        this.s=s;
    }
    int[] next(){
        int x=2,now=1;
        next=new int[8];
        while(x<s.length()){
            if(s.charAt(now)==s.charAt(x)){
                next[x]=now;
                ++now;
                ++x;
            }
            else if(now!=1){
                now=next[now];
            }
            else{
                while (now != 1&&s.charAt(now)!=s.charAt(x))
                {
                    now=next[now];
                }
                next[x]=now;
                ++x;
            }
        }
        return next;
    }
}