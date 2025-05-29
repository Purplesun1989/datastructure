#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
typedef struct GraphNode* Graph;
typedef struct LinkedNode* Link;
typedef struct Queque* Que;
struct LinkedNode {
	int indegree;
	Link next;
	int power;
};
struct GraphNode{
	Link* arrs;
	int max;
};
struct Queque{
	Link* Que;
	int front;
	int rear;
	int max;
	int tos;
};
Link createLinkNode(int key){
	Link temp=(Link)malloc(sizeof(LinkedNode));
	temp->indegree=0;
	temp->next=NULL;
	temp->power=key;
	return temp;
}
Link createLinkPoint(Link header,int key){
	Link temp=(Link)malloc(sizeof(LinkedNode));
	temp->indegree=-1;
	temp->next=header->next;
	temp->power=key;
	header->next=temp;
	return header;
}
Que createQ(int max){
	Que Q=(Que)malloc(sizeof(Queque));
	Q->front=0;
	Q->max=max;
	Q->rear=0;
	Q->tos=0;
	Q->Que=(Link*)malloc(sizeof(LinkedNode)*max);
	for(int i=0;i<max;i++){
		Q->Que[i]=createLinkNode(0);
	}
	return Q;
}
void insertQ(Que Q,Link node){
	if(Q->tos<=Q->max){
	    Q->Que[Q->rear]=node;
	    Q->rear++;
	    Q->tos++;
	}
	else{
		printf("No room!\n");
	}
}
Link deQue(Que Q){
	Q->rear--;
	Q->tos--;
	return Q->Que[Q->tos];
}
bool isQempty(Que Q){
	if(Q->tos==0){
		return true;
	}
	else{
		return false;
	}
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
		gph->arrs[iS]->indegree++;
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
Link getEntry(Graph gph){
	int tar;
	for(tar=0;tar<gph->max;tar++){
		if(gph->arrs[tar]->indegree==0){
			break;
		}
	}
	return gph->arrs[tar];
}
void Topological(Graph gph){
	Que Q=createQ(gph->max);
	insertQ(Q,getEntry(gph));
	getEntry(gph)->indegree=-1;
	while(!isQempty(Q)){
		Link temp=deQue(Q);
		printf("%d\t",temp->power);
		temp=temp->next;
		while(temp!=NULL){
			Link T=getSub(gph,temp->power);
			T->indegree--;
			temp=temp->next;
		}
		Link buf=getEntry(gph);
		insertQ(Q,buf);
		buf->indegree=-1;
	}
}
void travsel(Graph gph){
	for(int i=0;i<gph->max;i++){
		Link temp=gph->arrs[i];
		while(temp!=NULL){
			temp=temp->next;
		}
		printf("\n");
	}
}
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
	Topological(test);	
}
