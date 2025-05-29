#include<stdio.h>
#include<stdlib.h>
typedef struct OpenHash* Hash;
struct OpenHash{
	int size;
	int* array;
};
int DoubleHash(int mod, int key){
	return (mod-(key%mod));
}
int LastPrim(int now){
	int num,Now=now-1;
    while(true){
        int flag=1;
        for(int j=2;j<Now;j++){
            if(Now%j==0){
                flag=0;
                break;
            }
        }
            if(flag==1){
                num=Now;
                break;
            }
            else{
                Now--;
            }
    }
    return num;
}
int prim(int Now){
    int num;
    while(true){
        int flag=1;
        for(int j=2;j<Now;j++){
            if(Now%j==0){
                flag=0;
                break;
            }
        }
            if(flag==1){
                num=Now;
                break;
            }
            else{
                Now++;
            }
    }
    return num;
}
Hash create(int size){
	int sizenew=prim(2*size);
	Hash HT=(Hash)malloc(sizeof(OpenHash));
	if(HT!=NULL){
		HT->size=sizenew;
		HT->array=(int*)malloc(sizeof(int)*sizenew);
		for(int i=0;i<HT->size;i++){
			HT->array[i]=NULL;
		}
		return HT;
	}
	else{
		printf("No room!!!\n");
		return NULL;
	}
}
int Hashing(int key,Hash HT){
	return key%HT->size;
}
void insertLinear(int key,Hash HT){
	int sig=Hashing(key,HT),K=key,count=1;
	while(HT->array[sig]!=NULL){
		sig=Hashing(K+count,HT);
	}
	HT->array[sig]=key;
}
void insertQua(int key,Hash HT){
	int sig=Hashing(key,HT),K=key,count=1;
	while(HT->array[sig]!=NULL){
		sig=Hashing(K+(count*count),HT);
		count++;
	}
	HT->array[sig]=key;
}
void insertDouble(int key,Hash HT){
	int sig=Hashing(key,HT),K=key,count=1;
	while(HT->array[sig]!=NULL){
		sig=Hashing(K+(count*DoubleHash(LastPrim(HT->size),key)),HT);
		count++;
	}
	HT->array[sig]=key;
}
void travse(Hash HT){
	for(int i=0;i<HT->size;i++){
		if(HT->array[i]!=NULL){
			printf("%d:%d\n",i,HT->array[i]);
		}
	}
}
Hash reHash(Hash HT){
	Hash newHash=create(HT->size/*"*2"*/);
	for(int i=0;i<HT->size;i++){
		newHash->array[i]=HT->array[i];
	}
	free(HT);
	return newHash;
}
int main(){
	Hash HT=create(5);
	printf("%d",HT->size);
	travse(HT);
	printf("%d",reHash(HT)->size);
} 
