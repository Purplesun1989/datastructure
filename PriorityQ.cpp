#include<stdio.h>
#include<stdlib.h>
typedef struct HeapNode* Heap;
struct HeapNode{
	int sizeNow;
	int Capc;
	int* array;
};
int mini(int left,int right){
	if(left>right){
		return 2;
	}
	else{
		return 1;
	}
}
int find(int x,Heap HP){
	int flag=0;
	for(int i=1;i<HP->Capc;i++){
		if(HP->array[i]==x){
			flag=i;
			break;
		}
	}
	return flag;
}
Heap create(int size){
	Heap HP=(Heap)malloc(sizeof(HeapNode));
	if(HP!=NULL){
		HP->Capc=size+1;
		HP->array=(int*)malloc(sizeof(int)*HP->Capc);
		HP->sizeNow=0;
		if(HP->array!=NULL){
			for(int i=0;i<HP->Capc;i++){
				HP->array[i]=NULL;
			}
			HP->array[0]=-10000; 
			return HP;
		}
		else{
			printf("No room!!!\n");
			return NULL;
		}
	}
	else{
		printf("No room!!!\n");
		return NULL;
	}
}
Heap adjust(Heap HP,int key){
	int size=find(key,HP);
	while(HP->array[size/2]>key){
		HP->array[size]=HP->array[size/2];
		HP->array[size/2]=key;
		size=size/2;
	}
	return HP;
}
void insert(int key,Heap HP){
	if(find(key,HP)==0&&HP->Capc-1>HP->sizeNow){
		HP->sizeNow++;
	    HP->array[HP->sizeNow]=key;
	    HP=adjust(HP,key);
	}
	else{
		printf("Failed!!!\n");
	}
}
void del(int key,Heap HP){
	if(find(key,HP)!=0){
		int sig=find(key,HP);
		int last=HP->array[HP->sizeNow];
		HP->sizeNow--;
		while(sig*2<=HP->sizeNow){
			int child=sig*2;
			if(child!=HP->sizeNow&&(HP->array[child]>HP->array[child+1])){
				child++;
			}
			if(last>HP->array[child]){
				HP->array[sig]=HP->array[child];
				sig=child;
			}
			else{
				break;
			}
		}
		HP->array[sig]=last;
	}
	else{
		printf("Not found!\n");
	}
}
void travse(Heap HP){
	for(int i=1;i<=HP->sizeNow;i++){
		printf("%d:%d\t",i,HP->array[i]);
	}
	printf("\n");
}
int main(){
	Heap HP=create(10);
	insert(14,HP);
	insert(18,HP);
	insert(16,HP);
	insert(100,HP);
	insert(21,HP);
	insert(101,HP);
	insert(102,HP);
	insert(22,HP);
	travse(HP);
	del(100,HP);
	travse(HP);
} 
