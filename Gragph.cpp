#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10  // 最大顶点数

// 弧节点结构（边）
typedef struct ArcNode {
    int adjvex;               // 邻接点的索引
    struct ArcNode* nextarc; // 指向下一个邻接点
} ArcNode;

// 顶点节点结构
typedef struct VNode {
    char data;                // 顶点值（如 'A', 'B'）
    ArcNode* firstarc;        // 指向第一条边的指针
} VNode;

// 图结构
typedef struct {
    VNode adjlist[MAX];       // 顶点数组
    int vexnum, arcnum;       // 顶点数 和 弧数
} ALGraph;

// 查找顶点在数组中的下标
int locateVertex(ALGraph* G, char v) {
    for (int i = 0; i < G->vexnum; i++) {
        if (G->adjlist[i].data == v)
            return i;
    }
    return -1;
}

// 创建图
void createGraph(ALGraph* G, char vertices[], int vCount, char edges[][2], int eCount) {
    G->vexnum = vCount;
    G->arcnum = eCount;

    // 初始化顶点
    for (int i = 0; i < vCount; i++) {
        G->adjlist[i].data = vertices[i];
        G->adjlist[i].firstarc = NULL;
    }

    // 插入边
    for (int i = 0; i < eCount; i++) {
        char src = edges[i][0];
        char dest = edges[i][1];

        int srcIdx = locateVertex(G, src);
        int destIdx = locateVertex(G, dest);

        ArcNode* newArc = (ArcNode*)malloc(sizeof(ArcNode));
        newArc->adjvex = destIdx;
        newArc->nextarc = G->adjlist[srcIdx].firstarc;
        G->adjlist[srcIdx].firstarc = newArc;
    }
}

// 打印图
void printGraph(ALGraph* G) {
    for (int i = 0; i < G->vexnum; i++) {
        printf("Vertex %c: ", G->adjlist[i].data);
        ArcNode* p = G->adjlist[i].firstarc;
        while (p) {
            printf("→ %c ", G->adjlist[p->adjvex].data);
            p = p->nextarc;
        }
        printf("\n");
    }
}

int main() {
    ALGraph G;
    char vertices[] = {'A', 'B', 'C', 'D'};
    char edges[][2] = { {'A','B'}, {'A','C'}, {'B','D'} };

    createGraph(&G, vertices, 4, edges, 3);
    printGraph(&G);

    return 0;
}

