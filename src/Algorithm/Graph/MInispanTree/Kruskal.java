package Algorithm.Graph.MInispanTree;

/**
 * @author shkstart
 * @create 2023-05-22 12:03
 */
public class Kruskal {
    public static void main(String[] args) {
        String cites="ABCDEFG";
        kruGraph gph=new kruGraph(7,cites,12);
        gph.insert('A','B',2);
        gph.insert('A','D',1);
        gph.insert('B','E',10);
        gph.insert('B','D',3);
        gph.insert('C','F',5);
        gph.insert('C','A',4);
        gph.insert('D','F',8);
        gph.insert('D','G',4);
        gph.insert('D','E',2);
        gph.insert('D','C',2);
        gph.insert('E','G',6);
        gph.insert('G','F',1);
        gph.Kruskal();
        gph.travsel();
    }
}
class kruGraph{
    int max;
    VertaxKru[]vertaxs;
    MiniHeap arcs;
    int[] FUset;
    public kruGraph(int max,String vertaxs,int heapmax){
        this.max=max;
        this.vertaxs=new VertaxKru[max];
        this.arcs=new MiniHeap(heapmax);
        FUset=new int[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new VertaxKru(vertaxs.charAt(i));
            FUset[i]=i;
        }
    }
    int Locate(char key){
        int i=0;
        for( i=0;i<this.max;i++){
            if(this.vertaxs[i].cite==key){
                break;
            }
        }
        return i;
    }
    void travsel(){
        for(int i=0;i<this.max;i++){
            ArcKru temp=this.vertaxs[i].nextArc;
            if(temp==null){
                continue;
            }
            else{
                System.out.print(this.vertaxs[i].cite+":\t");
            }
            while(temp!=null){
                System.out.print(this.vertaxs[temp.tag].cite+"\t");
                temp=temp.nextArc;
            }
            System.out.println("");
        }
    }
    void insert(char Root,char Son,int power){
        int i=Locate(Root);
        int j=Locate(Son);
        arcs.insert(i,j,power);
    }
    void Kruskal(){
        ArcKru temp;
        int count=0;
        while(true){
            temp=arcs.delete();
           if(find(temp.pretag,FUset)!=find(temp.tag,FUset)){
               ArcKru temp1=new ArcKru(temp.pretag,temp.cost,temp.tag);
               temp1.nextArc=vertaxs[temp.pretag].nextArc;
               vertaxs[temp.pretag].nextArc=temp1;
               FUset[temp.tag]=FUset[temp.pretag];
               count++;
           }
            if(count==max-1){
                break;
            }
        }
    }
   int find(int i,int[]set){
        if(set[i]==i){
            return i;
        }
        else{
            return find(set[i],set);
        }
   }
}

class VertaxKru{
    int Power;
    Character cite;
    ArcKru nextArc;
    public VertaxKru(char cite){
        this.cite=new Character(cite);
        this.Power=9999;
        nextArc=null;
    }
}
class ArcKru{
    int tag;
    int cost;
    ArcKru nextArc;
    int pretag;
    public ArcKru(int Root,int Power,int Son){
        this.tag=Son;
        this.cost=Power;
        this.nextArc=null;
        this.pretag=Root;
    }
    public ArcKru(int val){
        this.cost=val;
    }
}
class MiniHeap{
    ArcKru[] arcs;
    int max;
    int tos;
    public MiniHeap(int max){
        this.max=max;
        this.tos=0;
        arcs=new ArcKru[max+1];
        ArcKru temp=new ArcKru(-1000);
        arcs[0]=temp;
    }
    void insert(int Root,int Son,int power){
        ArcKru temp=new ArcKru(Root,power,Son);
        if(this.tos<this.max){
            this.arcs[++this.tos]=temp;
            int p=tos;
            while(arcs[p].cost<arcs[p/2].cost){
                ArcKru tempt=arcs[p];
                arcs[p]=arcs[p/2];
                arcs[p/2]=tempt;
                p=p/2;
            }
            arcs[p]=temp;
        }
        else{
            System.out.println("FULL!");
        }
    }
    ArcKru delete(){
        ArcKru mini=arcs[1];
        ArcKru temp1=arcs[tos--];
        int i=1;
        int kid;
        while(i*2<tos){
            kid=i*2;
            if(arcs[kid].cost>arcs[kid+1].cost){
                kid++;
            }
            if(arcs[kid].cost>= temp1.cost){
                break;
            }
            if(arcs[kid].cost<= temp1.cost){
                arcs[i]=arcs[kid];
                i=kid;
            }
        }
        arcs[i]=temp1;
        return mini;
    }
}