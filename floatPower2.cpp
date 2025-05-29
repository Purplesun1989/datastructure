#include<stdio.h>
/* 
 * floatPower2 - Return bit-level equivalent of the expression 2.0^x
 *   (2.0 raised to the power x) for any 32-bit integer x.
 *
 *   The unsigned value that is returned should have the identical bit
 *   representation as the single-precision floating-point number 2.0^x.
 *   If the result is too small to be represented as a denorm, return
 *   0. If too large, return +INF.
 * 
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. Also if, while 
 *   Max ops: 30 
 *   Rating: 4
 */
unsigned floatPower2(int x) {
	int exponent=(x+127);
	//printf("%d\n",exponent);
	if(exponent==0){
		//printf("11111");
		if(x>0){
			printf("22222");
			return 0x7f800000;
		}
		return 0;
	} 
	else if(exponent<0){
		//printf("33333");
		return 0;
	}
	else if(!(exponent^0xff)){
		//printf("44444");
		return 0x7f800000;
	}
	else{
		if(exponent>255){
			return 0x7f800000;
		}
		//printf("55555");
		return exponent<<23;
	}
}
unsigned float2unsign(float x){
	unsigned x2=x&0xffffffff;
	return x2;
}
int main(){
	printf("%u",float2unsign(1));
} 
