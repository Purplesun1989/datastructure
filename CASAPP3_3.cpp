#include<stdio.h>
#include<math.h>
long arith(long x,long y,long z){
	long t1=x^y;
	long t2=t1 & 0x2; 
	return t2; 
}
int fib(int num){
	int counter=0,a=1,b=1,c=0;
	while(counter<=num){
		goto loop;
	loop:
		if(counter==0||counter==1||counter==2){
			c=1;
		}
		else{
			a=b;
			b=c;
			c=a+b;
		}
		counter++;
	}
	goto done;
    done:	
	return c;
}
int main(){
	printf("%d",fib(6)); 
}

