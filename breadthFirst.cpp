#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
typedef struct GraphNode* Graph;
typedef struct LinkedNode* Link;
struct LinkedNode {
	int length;
	Link next;
	int power;
	bool konwn;
};
struct GraphNode{
	Link* arrs;
	int max;
};
Link createLinkNode(int key){
	Link temp=(Link)malloc(sizeof(LinkedNode));
	temp->length;
	temp->next=NULL;
	temp->power=key;
	return temp;
}
Link createLinkPoint(Link header,int key){
	Link temp=(Link)malloc(sizeof(LinkedNode));
	temp->konwn=false;
	temp->length=1;
	temp->next=header->next;
	temp->power=key;
	header->next=temp;
	return header;
}
Graph createGrapharr(Graph graph,int arr[]){
	for(int i=0;i<graph->max;i++){
		graph->arrs[i]->power=arr[i];
	}
	return graph;
}
Graph createGraph(int max,int arr[]){
	Graph gph=(Graph)malloc(sizeof(GraphNode));
	gph->max=max;
	gph->arrs=(Link*)malloc(sizeof(Link)*max);
	for(int i=0;i<gph->max;i++){
		gph->arrs[i]=createLinkNode(0);
	}
	gph=createGrapharr(gph,arr);
	return gph;
}
Graph insertGraph(Graph gph,int root,int key){
	bool flagroot=false,flagkey=false;
	int iF=0,iS=0;
	for(iF=0;iF<gph->max;iF++){
		if(gph->arrs[iF]->power==root){
			flagroot=true;
			break;
		}
	}
	for(iS=0;iS<gph->max;iS++){
		if(gph->arrs[iS]->power==key){
			flagkey=true;
			break;
		}
	}
	if(flagroot&&flagkey){
		gph->arrs[iF]=createLinkPoint(gph->arrs[iF],key);
	}
	else{
		printf("Not found!\n");
	}
	return gph;
}
Link getSub(Graph gph,int key){
	int tar;
	for(tar=0;tar<gph->max;tar++){
		if(gph->arrs[tar]->power==key){
			break;
		}
	}
	return gph->arrs[tar];
}
void travsel(Graph gph){
	for(int i=0;i<gph->max;i++){
		Link temp=gph->arrs[i];
		while(temp!=NULL){
			printf("%d:%d\t",temp->power);
			temp=temp->next;
		}
		printf("\n");
	}
}
// void breadthFirst(Graph gph,int key){
// 	int curdis=0;
// 	for(curdis=0;i<gph->max;curdis++){
// 		//t
// 	}
// }
int main(){
	int a[]={1,2,3,4,5,6,7};
	Graph test=createGraph(7,a);
	test=insertGraph(test,1,2);
	test=insertGraph(test,1,4);
	test=insertGraph(test,1,3);
	test=insertGraph(test,2,5);	
	test=insertGraph(test,2,4);
	test=insertGraph(test,3,6);
	test=insertGraph(test,4,6);
	test=insertGraph(test,4,7);
	test=insertGraph(test,4,3);
	test=insertGraph(test,5,7);
	test=insertGraph(test,5,4);
	test=insertGraph(test,7,6);
	travsel(test);
} 
