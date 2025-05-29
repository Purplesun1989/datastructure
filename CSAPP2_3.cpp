#include<stdio.h>
#include<math.h>
int uadd(unsigned x, unsigned y){
	if(x+y>x&&x+y>y){
		return 1;
	}
	else{
		return 0;
	}
}
int Sum(int count){
	int sum=0;
	for(int i=0;i<count;i++){
		sum+=pow(2,i);
	}
	return sum;
}
int RshiftDiv(int a){
	int bias=-1*(a>>63)*(15);
	return (a+bias)>>4;
}
int main(){
	//printf("%d",uadd(100,200));
	int a=-33;
	//printf("%d %d",a>>2,a/4);
	//printf("%d %f",Sum(4),pow(2,4));
	//printf("%d",a>>63);
	printf("%d",RshiftDiv(a));
}
