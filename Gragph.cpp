#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 10  // ��󶥵���

// ���ڵ�ṹ���ߣ�
typedef struct ArcNode {
    int adjvex;               // �ڽӵ������
    struct ArcNode* nextarc; // ָ����һ���ڽӵ�
} ArcNode;

// ����ڵ�ṹ
typedef struct VNode {
    char data;                // ����ֵ���� 'A', 'B'��
    ArcNode* firstarc;        // ָ���һ���ߵ�ָ��
} VNode;

// ͼ�ṹ
typedef struct {
    VNode adjlist[MAX];       // ��������
    int vexnum, arcnum;       // ������ �� ����
} ALGraph;

// ���Ҷ����������е��±�
int locateVertex(ALGraph* G, char v) {
    for (int i = 0; i < G->vexnum; i++) {
        if (G->adjlist[i].data == v)
            return i;
    }
    return -1;
}

// ����ͼ
void createGraph(ALGraph* G, char vertices[], int vCount, char edges[][2], int eCount) {
    G->vexnum = vCount;
    G->arcnum = eCount;

    // ��ʼ������
    for (int i = 0; i < vCount; i++) {
        G->adjlist[i].data = vertices[i];
        G->adjlist[i].firstarc = NULL;
    }

    // �����
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

// ��ӡͼ
void printGraph(ALGraph* G) {
    for (int i = 0; i < G->vexnum; i++) {
        printf("Vertex %c: ", G->adjlist[i].data);
        ArcNode* p = G->adjlist[i].firstarc;
        while (p) {
            printf("�� %c ", G->adjlist[p->adjvex].data);
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

