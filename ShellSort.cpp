#include<stdio.h>
#include<stdlib.h>
#define N 10
int getPrior(int a[],int num,int increment){
	if(num-increment>=0){
		return a[num-increment];
	}
	else{
		return -100000;
	}
}
int main(){
	 int a[]={9,8,7,6,5,4,3,2,1,0};
        int increment=N/2;
        while(increment>0){
            for(int i=0;i<N-increment;i++){
                for(int j=i;j<N;j+=increment){
                    int tempt=a[j],p=j;
                    while(tempt<getPrior(a,p,increment)){
                        a[p]=a[p-increment];
                        p-=increment;
                    }
                    a[p]=tempt;
                }
            }
            increment/=2;
        }
        for(int i=0;i<N;i++){
            printf("%d\t",a[i]);
        }
}
