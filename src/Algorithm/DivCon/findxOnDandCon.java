package Algorithm.DivCon;

/**
 * @author shkstart
 * @create 2023-03-10 15:41
 */
public class findxOnDandCon {
    public static void main(String[] args) {
        int b[]={1,2,3,4,5,6,7};
        new find().findx(b,0,6,5);
    }
}
class find{
    void findx(int a[],int left,int right,int x){
        int center;
        center=(left+right)/2;
        if(a[center]==x){
            System.out.println(center+1);
        }
        if(a[center]>x){
            findx(a,left,center-1,x);
        }
        if(a[center]<x){
            findx(a,center+1,right,x);
        }
    }
}