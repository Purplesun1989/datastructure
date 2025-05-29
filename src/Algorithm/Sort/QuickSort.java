package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2023-05-12 10:55
 */
public class QuickSort {
    public static void main(String[] args) {
        int []a= {5,9,9,6,4,12};
        quickSort_insertSort(a,0,a.length-1);
        //quickSortonly(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static int getPivot(int[]arr,int left,int right){
        int center=(right+left)/2;
        if(arr[left]>arr[center]){
            swap(arr,left,center);
        }
        if(arr[left]>arr[right]){
            swap(arr,left,right);
        }
        if(arr[center]>arr[right]){
            swap(arr,center,right);
        }
        swap(arr,center,right-1);
        return arr[right-1];
    }
    static void swap(int[]arr,int i,int j){
        int tempt;
        tempt=arr[i];
        arr[i]=arr[j];
        arr[j]=tempt;
    }
    static void quickSort_insertSort(int[]arr,int left,int right){
        int Pivot=getPivot(arr,left,right);
        int i=left+1;
        int j=right-2;
        if(left+3<=right){
            while(true){
                while(arr[i]<Pivot){
                    i++;
                }
                while(arr[j]>Pivot){
                    j--;
                }
                if(i<j){
                    swap(arr,i,j);
                }
                else{
                    break;
                }
            }
            swap(arr,i,right-1);
            quickSort_insertSort(arr,left,i-1);
            quickSort_insertSort(arr,i+1,right);
        }
        else{
            In_sort(arr);
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
    static void quickSortonly(int[]arr,int left,int right){
        swap(arr,right,(left+right)/2);
        int Pivot=arr[right];
        int i=left;
        int j=right-1;
        if(left<=right){
            while(true){
                while(arr[i]<Pivot){
                    i++;
                }
                while(arr[j]>Pivot){
                    j--;
                }
                if(i<j){
                    swap(arr,i,j);
                }
                else{
                    break;
                }
            }
            swap(arr,i,right);
            quickSortonly(arr,left,i-1);
            quickSortonly(arr,i+1,right);
        }
    }
}
