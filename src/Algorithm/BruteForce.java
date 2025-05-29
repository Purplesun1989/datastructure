package Algorithm;

/**
 * @author shkstart
 * @create 2023-03-28 20:15
 */
public class BruteForce {
    public static void main(String[] args) {
        System.out.println(new bf("abcdef","cd").compare());
    }
}
class bf{
    String s;
    String t;
    public bf(String s,String t){
        this.t=t;
        this.s=s;
    }
    int compare(){
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;
            }
        }
        if(j>=t.length()){
            return (i-t.length());
        }
        else{
            return -1;
        }
    }
}