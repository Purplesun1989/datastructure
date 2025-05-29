package Algorithm.Sort;

/**
 * @author shkstart
 * @create 2023-05-09 18:45
 */
public class ShellSort {
    static int num=10;
    public static void main(String[] args) {
        int []a={9,8,7,6,5,4,3,2,1,0};
        int increment=num/2;
        while(increment>0){
            for(int i=0;i<num;i++){
                    int tempt=a[i],p=i;
                    while(tempt<getPrior(a,p,increment)){
                        a[p]=a[p-increment];
                        p-=increment;
                    }
                    a[p]=tempt;
            }
            increment/=2;
        }
        for(int i=0;i<num;i++){
            System.out.print(a[i]+" ");
        }
    }
    static int getPrior(int []a,int num,int increment){
        if(num-increment>=0){
            return a[num-increment];
        }
        else{
            return -10000;
        }
    }
}