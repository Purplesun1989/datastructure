#include<stdio.h>
#include<stdlib.h>
int main(){
	int* a;
	a=(int *)malloc(sizeof(int));
	a=1;
	printf("%d",*a);
}
