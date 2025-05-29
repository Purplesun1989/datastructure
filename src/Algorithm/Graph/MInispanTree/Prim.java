package Algorithm.Graph.MInispanTree;

/**
 * @author shkstart
 * @create 2023-05-22 10:10
 */
public class Prim {
    public static void main(String[] args) {
        String cites="ABCDEFG";
        PriGraph gph=new PriGraph(7,cites);
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
        gph.Prim();
    }
}
class PriGraph{
    int max;
    VertaxPri[]vertaxs;
    public PriGraph(int max,String vertaxs){
        this.max=max;
        this.vertaxs=new VertaxPri[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new VertaxPri(vertaxs.charAt(i));
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
    void insert(char Root,char Son,int power){
        VertaxPri temp1=this.vertaxs[Locate(Root)];
        ArcPri temp2=new ArcPri(Locate(Son),power);
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
    }
    void travsel(){
        for(int i=0;i<this.max;i++){
            System.out.print(this.vertaxs[i].cite+":\t");
            ArcPri temp=this.vertaxs[i].nextArc;
            while(temp!=null){
                System.out.print(this.vertaxs[temp.tag].cite+"\t");
                temp=temp.nextArc;
            }
            System.out.println("");
        }
    }
    void Prim(){
        VertaxPri[]Table=this.vertaxs;
        VertaxPri mini=Table[0];
        mini.Power=0;
        while(true){
            VertaxPri temp=FindMinipoer(Table);
            if(temp==null){
               break;
            }
            else{
                temp.Known=true;
                ArcPri temp1=temp.nextArc;
                while(temp1!=null){
                    if(temp1.cost<Table[temp1.tag].Power){
                        Table[temp1.tag].Power=temp1.cost;
                    }
                    temp1=temp1.nextArc;
                }
            }
        }
        for(int j=0;j<7;j++){
            System.out.println(this.vertaxs[j].cite+":"+this.vertaxs[j].Power);
        }
    }
    VertaxPri FindMinipoer(VertaxPri[] table){
        VertaxPri mini=new VertaxPri(999);
        for(int i=0;i<table.length;i++){
            if(mini.Power>table[i].Power&&(!table[i].Known)){
                mini=table[i];
            }
        }
        if(mini.Power==999){
            return null;
        }
        else{
            return mini;
        }
    }
}
class VertaxPri{
    int Power;
    boolean Known;
    Character cite;
    ArcPri nextArc;
    public VertaxPri(char cite){
        this.cite=new Character(cite);
        this.Power=9999;
        nextArc=null;
        this.Known=false;
    }
    public VertaxPri(int power){
        this.Power=power;
    }
}
class ArcPri{
    int tag;
    int cost;
    ArcPri nextArc;
    public ArcPri(int tag,int Power){
        this.tag=tag;
        this.cost=Power;
        this.nextArc=null;
    }
    public ArcPri(int val){
        this.cost=val;
    }
}

