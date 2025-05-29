package Algorithm.Graph.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2023-05-17 10:19
 */
public class NegativeWDG {
    public static void main(String[] args) {
        String vert="ABCDEFG";
        Graph gph=new Graph(7,vert);
        gph.insert("AB",2);
        gph.insert("AD",1);
        gph.insert("BE",10);
        gph.insert("BD",3);
        gph.insert("CF",5);
        gph.insert("CA",4);
        gph.insert("DF",8);
        gph.insert("DG",4);
        gph.insert("DE",2);
        gph.insert("DC",2);
        gph.insert("EG",6);
        gph.insert("GF",1);
        Table[] table=new Table[gph.max];
        for(int i=0;i<gph.max;i++){
            table[i]=new Table(vert.charAt(i));
        }
        Dijkstrasort(gph,table,'A');
    }
    static void Dijkstrasort(Graph gph,Table[] table,char cite){
        Queue<Vnode>queue=new LinkedList<>();
        int i=gph.Locate(cite);
        Vnode temp=gph.vertaxs[i];
        table[i].val=0;
        temp.Power=0;
        queue.add(temp);
        while(!queue.isEmpty()){
            Vnode temp1=queue.remove();
            ArcNode temp2=temp1.nextArc;
            while(temp2!=null){
                int total=temp1.Power+temp2.cost;
                if(total<table[temp2.tag].val){
                    table[temp2.tag].val=total;
                    gph.vertaxs[temp2.tag].Power=total;
                    queue.add(gph.vertaxs[temp2.tag]);
                }
                temp2=temp2.nextArc;
            }
        }
        for(int j=0;j<table.length;j++){
            System.out.println(table[j].site+":"+table[j].val);
        }
    }
}
class Graph{
    int max;
    Vnode[]vertaxs;
    public Graph(int max,String vertaxs){
        this.max=max;
        this.vertaxs=new Vnode[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new Vnode(vertaxs.charAt(i));
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
    void insert(String RootandSon,int power){
        Vnode temp1=this.vertaxs[Locate(RootandSon.charAt(0))];
        ArcNode temp2=new ArcNode(Locate(RootandSon.charAt(1)),power);
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
    }
    void travsel(){
        for(int i=0;i<this.max;i++){
            System.out.print(this.vertaxs[i].cite+":\t");
            ArcNode temp=this.vertaxs[i].nextArc;
            while(temp!=null){
                System.out.print(this.vertaxs[temp.tag].cite+"\t");
                temp=temp.nextArc;
            }
            System.out.println("");
        }
    }
}
class Vnode{
    int Power;
    Character cite;
    ArcNode nextArc;
    public Vnode(char cite){
        this.cite=new Character(cite);
        this.Power=999;
        nextArc=null;
    }
}
class ArcNode{
    int tag;
    int cost;
    ArcNode nextArc;
    public ArcNode(int tag,int Power){
        this.tag=tag;
        this.cost=Power;
        this.nextArc=null;
    }
}
class Table{
    int val;
    char site;
    public Table(char site){
        this.val=99999;
        this.site=site;
    }
}