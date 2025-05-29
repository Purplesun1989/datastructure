package Algorithm.Graph.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2023-05-18 11:23
 */
public class UDG {
    public static void main(String[] args) {
        UDGraph gph=new UDGraph(7,"ABCDEFG");
        gph.insert("AB");
        gph.insert("AD");
        gph.insert("BE");
        gph.insert("BD");
        gph.insert("CF");
        gph.insert("CA");
        gph.insert("DF");
        gph.insert("DG");
        gph.insert("DE");
        gph.insert("DC");
        gph.insert("EG");
        gph.insert("GF");
        BFS(gph,'A');
    }
    static void BFS(UDGraph gph,char key){
        Queue<UDGnode> Q=new LinkedList();
        int i=gph.Locate(key);
        UDGnode temp1=gph.vertaxs[i];
        temp1.Power=0;
        temp1.known=true;
        Q.add(temp1);
        while(!Q.isEmpty()){
            UDGnode temp2=Q.remove();
            Arcs temp3=temp2.nextArc;
            while(temp3!=null){
                if(!gph.vertaxs[temp3.tag].known){
                    gph.vertaxs[temp3.tag].known=true;
                    gph.vertaxs[temp3.tag].Power=temp2.Power+1;
                    Q.add(gph.vertaxs[temp3.tag]);
                }
                temp3=temp3.nextArc;
            }
        }
        for(int j=0;j<gph.max;j++){
            System.out.println(gph.vertaxs[j].cite+":"+gph.vertaxs[j].Power);
        }
    }
}
class UDGraph{
    int max;
    UDGnode[]vertaxs;
    public UDGraph(int max,String vertaxs){
        this.max=max;
        this.vertaxs=new UDGnode[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new UDGnode(vertaxs.charAt(i));
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
    void insert(String RootandSon){
        UDGnode temp1=this.vertaxs[Locate(RootandSon.charAt(0))];
        Arcs temp2=new Arcs(Locate(RootandSon.charAt(1)));
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
    }
    void travsel(){
        for(int i=0;i<this.max;i++){
            System.out.print(this.vertaxs[i].cite+":\t");
            Arcs temp=this.vertaxs[i].nextArc;
            while(temp!=null){
                System.out.print(this.vertaxs[temp.tag].cite+"\t");
                temp=temp.nextArc;
            }
            System.out.println("");
        }
    }
}
class UDGnode{
    int Power;
    Character cite;
    Arcs nextArc;
    boolean known;
    public UDGnode(char cite){
        this.cite=new Character(cite);
        this.Power=-1;
        nextArc=null;
        this.known=false;
    }
}
class Arcs{
    int tag;
    Arcs nextArc;
    public Arcs(int tag){
        this.tag=tag;
        this.nextArc=null;
    }
}