#include<stdio.h>
#include<stdlib.h>
typedef unsigned char * byte_point;
void showBytes(byte_point start, int len){
	for(int i=0;i<len;i++){
		printf("%x",start[i]);
		//printf("%d",sizeof(byte_point));
	}
}
float sum_ele(signed len,float a[]){
	float result=0;
	for(int i=0;i<len-1;i++){
		result+=a[i];
	}
	return result;
}
int main(){
	float a[]={1,2,3,4,5};
	printf("%f",sum_ele(5,a));
} 

