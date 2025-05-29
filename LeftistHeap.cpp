#include<stdio.h>
#include<stdlib.h>
typedef struct Leftist* Heap;
struct Leftist{
	Heap left;
	Heap right;
	int data;
	int NPL;
};
Heap create(int key){
	Heap HP=(Heap)malloc(sizeof(Leftist));
	if(HP!=NULL){
		HP->data=key;
		HP->left=NULL;
		HP->right=NULL;
		HP->NPL=0;
		return HP;
	}
	else{
		printf("No room!!!\n");
		return NULL;
	}
}
int GetNPL(Heap HP){
	if(HP!=NULL){
		return HP->NPL;
	}
	else{
		return -1;
	}
}
int MIN(int a,int b){
	if(a>b){
		return b;
	}
	else{
		return a;
	}
}
Heap Swap(Heap root){
	Heap right=root->right;
	root->right=root->left;
	root->left=right;
	return root;
}
Heap merge(Heap HP1,Heap HP2){
	Heap back=create(-100);
	if(HP1!=NULL&&HP2!=NULL){
		if(HP1->data<HP2->data){
			if(HP1->left==NULL){
				HP1->left=HP2;
			}
			else{
				HP1->right=merge(HP1->right,HP2);
			}
			back= HP1;
		}
		else{
			if(HP2->left==NULL){
				HP2->left=HP1;
			}
			else{
				HP2->right=merge(HP2->right,HP1);
			}
			back= HP2;
		}
	}
	else{
		if(HP1==NULL){
			back= HP2;
		}
		else{
			back= HP1;
		}
	}
	if(GetNPL(back->right)>GetNPL(back->left)){
		back=Swap(back);
	}
	back->NPL=MIN(GetNPL(back->left),GetNPL(back->right))+1;
	return back;
}
Heap insert(int key,Heap HP){
	Heap HPnew=create(key);
	HPnew=merge(HPnew,HP);
	return HPnew;
}
void travse(Heap HP){
	if(HP!=NULL){
		travse(HP->left);
	    printf("%d:%d\n",HP->data,HP->NPL);
	    travse(HP->right);
	}	
}
Heap del(Heap HP){
	return merge(HP->left,HP->right);
}
int main(){
	Heap root=create(1);
	root=insert(2,root);
	root=insert(3,root);
	root=insert(4,root);
	root=insert(5,root);
	root=del(root);
	travse(root);
	//printf("%d",root->left->data);
}
