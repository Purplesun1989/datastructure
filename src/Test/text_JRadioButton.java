package Test;


import java.util.Arrays;

public class text_JRadioButton{
       static void quickSort(int[]sites, int i, int j){
        swap(sites,j,(i+j)/2);
        int left=i;
        int right=j-1;
        int pivot=j;
        if(j-i>=3){
            while(true){
                while(sites[left]<sites[pivot]){
                    left++;
                }
                while(sites[right]>=sites[pivot]){
                    right--;
                }
                if(left<right){
                    swap(sites,left,right);
                }
                else{
                    break;
                }
            }
            swap(sites,left,j);
            quickSort(sites,i,left-1);
            quickSort(sites,left+1,j);
        }
        else{
            insertsort(sites);
        }
    }
    static void insertsort(int[] sites){
        for(int i=0;i<sites.length;i++){
            int tempt=sites[i];
            int j=i;
            while(tempt<getPrior(j,sites)){
                sites[j]=sites[j-1];
                j--;
            }
            sites[j]=tempt;
        }
    }
    static void swap(int[] sites, int i, int j){
        int tempt=sites[i];
        sites[i]=sites[j];
        sites[j]=tempt;
    }
    static int getPrior(int i, int[] sites){
        if(i==0){
            return -1000;
        }
        else{
            return sites[i-1];
        }
    }
    public static void main(String[] args) {
        int[]a={2,5,10,8,12,-1,0,8};
        quickSort(a,0,7);
        System.out.println(Arrays.toString(a));
    }
}

