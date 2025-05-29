package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2023-05-10 10:52
 */
public class InsertSort {
    public static void main(String[] args) {
       //insertSort();
        int []arr={2,1};
        In_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertSort(){
        int []a=new int[15];
        int nu=15,temp=0,j=0;
        for(int i=0;i<15;i++){
            a[i]=nu;
            nu--;
        }
        a[0]=-1000;
        for(int p=2;p<15;p++){
            temp=a[p];
            j=p;
            while(temp<a[j-1]){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
        }
        for(int i=1;i<15;i++){
            System.out.print(a[i]+" ");
        }
    }
    static void In_sort(int[]arr){
        int i,j=0;
        while(j<arr.length){
            i=j;
            int tempt=arr[i];
            while(tempt<getPrior(arr,i)){
                arr[i]=arr[i-1];
                i--;
            }
            arr[i]=tempt;
            j++;
        }
    }
    static int getPrior(int[]arr,int key){
        if(key==0){
            return -10000;
        }
        else{
            return arr[key-1];
        }
    }
}
