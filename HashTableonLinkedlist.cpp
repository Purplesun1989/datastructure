#include<stdio.h>
#include<stdlib.h>
typedef struct ListNode* List;
struct ListNode{
	int data;
	List next;
};
typedef struct hash* Hash;
typedef struct ListNode** HashArray;
struct hash{
	int size;
	HashArray list;
};
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
Hash Creat(int size){
	Hash HT=(Hash)malloc(sizeof(hash));
	if(HT!=NULL){
		HT->size=prim(size);
		HT->list=(HashArray)malloc(sizeof(List)*HT->size);
		if(HT->list!=NULL){
			for(int i=0;i<HT->size;i++){
				HT->list[i]=(List)malloc(sizeof(ListNode));
				if(HT->list[i]!=NULL){
					HT->list[i]->data=-1;
					HT->list[i]->next=NULL;
				}
				else{
					printf("No room\n");
					break;
				}
			}
			return HT;
		}
		return NULL;
	}
	else{
		printf("No room\n");
		return NULL;
	}
}
int Hashing(int key,int size){
	return key%size;
}
List find(Hash HT, int key){
	List dump=HT->list[Hashing(key,HT->size)];
	while(dump!=NULL&&dump->data!=key){
		dump=dump->next;
	}
	if(dump!=NULL){
		return dump;
	}
	else{
		printf("Not found!!!");
		return NULL;
	}
}
void insert(int key,Hash HT){
	if(HT->list[Hashing(key,HT->size)]->data==0){
		HT->list[Hashing(key,HT->size)]->data=key;
	}
	else{
		List temp=(List)malloc(sizeof(ListNode));
		if(temp!=NULL){
			temp->data=key;
			temp->next=HT->list[Hashing(key,HT->size)]->next;
		}
		else{
			printf("No room\n");
		}
		HT->list[Hashing(key,HT->size)]->next=temp;
	}
}
void travse(Hash HT){
	for(int i=0;i<HT->size;i++){
		if(HT->list[i]->next!=NULL){
			printf("%d:",i);
			List Header=HT->list[i];
			while(Header!=NULL){
				printf("%d\t",Header->data);
				Header=Header->next;
			}
			printf("\n");
		}
	}
}
int main(){
	Hash HT=Creat(2);
	insert(15,HT);
	insert(26,HT);
	travse(HT);
}

