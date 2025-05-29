package Algorithm.KMP;

/**
 * @author shkstart
 * @create 2023-03-28 20:27
 * array next should 1 bits larger than tempt1(the one extended from tempt),because the last of array next represents the one after the last of tempt1;
 * by "abcc_", we could immedeatlt generate next[4];
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println(new getNext(9,"ababac","hjk").getnext());
    }
}
class compare{
    String s;
    String m;
    int i=0,j=0;
    int []next;
    public compare(String s, String m,int [] next){
       this.s=s;
       this.m=m;
       this.next=next;
    }
    int compare(){
        for (int i = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != m.charAt(j)) {
                j = next[j +1]-1;
            }
            if (s.charAt(i) == m.charAt(j)) {
                j++;
            }
            if (j == m.length() ) {
                return (i - m.length() + 1);
            }
        }
        return -1;
    }
}
class getNext{
    String t,m;
    int size;
    public getNext(int size,String t,String m){
        this.t=t;
        this.m=m;
        this.size=size;
    }
    int []next;
    int getnext(){
        next=new int[size];
        next[1]=0;
        next[0]=-1;
        int i=1;
        int j=0;
        String s=tochar();
        while(i<s.length()){
            if((s.charAt(i)==s.charAt(j))||j==0){
                ++i;
                next[i]=++j;
            }
            else{
                j=next[j];
            }

        }
        return new compare(t,m,next).compare();
        }
    String tochar(){
        char[] tempt=t.toCharArray();
        char[] tempt1=new char[tempt.length+1];
        tempt1[0]='#';
        for(int i=1;i<tempt1.length;i++){
            tempt1[i]=tempt[i-1];
        }
        String s=new String(tempt1);
        return s;
    }

}
