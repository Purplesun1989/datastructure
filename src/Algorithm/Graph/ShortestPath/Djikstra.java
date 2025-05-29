package Algorithm.Graph.ShortestPath;

/**
 * @author shkstart
 * @create 2023-05-17 23:11
 */
public class Djikstra {
    public static void main(String[] args) {
        String cites="ABCDEFG";
        DGraph gph=new DGraph(7,cites);
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
        Vertax[] table=gph.vertaxs;
        Djikstra(gph,gph.vertaxs,'A');
    }
    static Vertax FindMinipoer( Vertax[] table){
        Vertax mini=new Vertax(999);
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
    static void Djikstra(DGraph gph,Vertax[]Table,char key){
        int i=gph.Locate(key),total=0;
        Table[i].Power=0;
        Vertax temp1;
        while(true){
            temp1=FindMinipoer(Table);
            if(temp1==null){
                break;
            }
            else{
                temp1.Known=true;
                Arc temp2=temp1.nextArc;
                while(temp2!=null){
                    total=temp1.Power+temp2.cost;
                    if(total<Table[temp2.tag].Power){
                        Table[temp2.tag].Power=total;
                    }
                    temp2=temp2.nextArc;
                }
            }
        }
        for(int j=0;j<7;j++){
            System.out.println(gph.vertaxs[j].cite+":"+gph.vertaxs[j].Power);
        }
    }
}
class DGraph{
    int max;
    Vertax[]vertaxs;
    public DGraph(int max,String vertaxs){
        this.max=max;
        this.vertaxs=new Vertax[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new Vertax(vertaxs.charAt(i));
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
        Vertax temp1=this.vertaxs[Locate(RootandSon.charAt(0))];
        Arc temp2=new Arc(Locate(RootandSon.charAt(1)),power);
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
    }
    void travsel(){
        for(int i=0;i<this.max;i++){
            System.out.print(this.vertaxs[i].cite+":\t");
            Arc temp=this.vertaxs[i].nextArc;
            while(temp!=null){
                System.out.print(this.vertaxs[temp.tag].cite+"\t");
                temp=temp.nextArc;
            }
            System.out.println("");
        }
    }
}
class Vertax{
    int Power;
    boolean Known;
    Character cite;
    Arc nextArc;
    public Vertax(char cite){
        this.cite=new Character(cite);
        this.Power=9999;
        nextArc=null;
        this.Known=false;
    }
    public Vertax(int power){
        this.Power=power;
    }
}
class Arc{
    int tag;
    int cost;
    Arc nextArc;
    public Arc(int tag,int Power){
        this.tag=tag;
        this.cost=Power;
        this.nextArc=null;
    }
    public Arc(int val){
        this.cost=val;
    }
}

