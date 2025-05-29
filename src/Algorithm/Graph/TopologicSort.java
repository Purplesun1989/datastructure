package Algorithm.Graph;


import java.util.Stack;

/**
 * @author shkstart
 * @create 2023-05-23 20:00
 */
public class TopologicSort {
    public static void main(String[] args) {
        String cites="ABCDEFG";
        TopGraph gph=new TopGraph(7,cites);
        gph.insert("AB");
        gph.insert("AD");
        gph.insert("AC");
        gph.insert("BE");
        gph.insert("BD");
        gph.insert("DF");
        gph.insert("DG");
        gph.insert("DC");
        gph.insert("ED");
        gph.insert("EG");
        gph.insert("GF");
        gph.top();
    }
}
class TopGraph{
    int max;
    Vertax[]vertaxs;
    public TopGraph(int max,String vertaxs){
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
    void insert(String RootandSon){
        Vertax temp1=vertaxs[Locate(RootandSon.charAt(0))];
        Arc temp2=new Arc(Locate(RootandSon.charAt(1)));
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
        vertaxs[temp2.tag].indegree++;
    }
    void top(){
        Stack<Vertax>stack=new Stack<>();
        int tag=entry();
        int count=1;
        vertaxs[tag].TopNumber=count++;
        vertaxs[tag].known=true;
        stack.push(vertaxs[tag]);
        while(stack!=null){
            Vertax tempt=stack.pop();
            System.out.println(tempt.cite+":"+tempt.TopNumber);
            Arc tempt1=tempt.nextArc;
            while(tempt1!=null){
                vertaxs[tempt1.tag].indegree--;
                if(vertaxs[tempt1.tag].indegree==0&&!vertaxs[tempt1.tag].known){
                    stack.push(vertaxs[tempt1.tag]);
                    vertaxs[tempt1.tag].known=true;
                    vertaxs[tempt1.tag].TopNumber=count++;
                }
                tempt1=tempt1.nextArc;
            }
        }
    }
    int entry(){
        int i=0;
        boolean flag=false;
        for(i=0;i<max;i++){
            if(vertaxs[i].indegree==0&&!vertaxs[i].known){
                flag=true;
                break;
            }
        }
        if(flag){
            return i;
        }
        else{
            return -1;
        }
    }
}
class Vertax{
    int TopNumber;
    int indegree;
    Character cite;
    Arc nextArc;
    boolean known;
    public Vertax(char cite){
        this.cite=new Character(cite);
        this.TopNumber=0;
        nextArc=null;
        indegree=0;
        known=false;
    }
}
class Arc{
    int tag;
    Arc nextArc;
    public Arc(int tag){
        this.tag=tag;
        this.nextArc=null;
    }
}