package Algorithm.Graph;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2023-05-23 20:00
 */
public class DFS {
    public static void main(String[] args) {
        String cites="ABCDEFG";
        DFSGraph gph=new DFSGraph(7,cites);
        gph.insert("AB");
        gph.insert("AD");
        gph.insert("AC");
        gph.insert("BE");
        gph.insert("BD");
        gph.insert("CE");
        gph.insert("DF");
        gph.insert("DG");
        gph.insert("DE");
        gph.insert("DC");
        gph.insert("ED");
        gph.insert("EG");
        gph.insert("GF");
        gph.DFStravsel('A');
    }
}
class DFSGraph{
    int max;
    DFSVertax[]vertaxs;
    public DFSGraph(int max,String vertaxs){
        this.max=max;
        this.vertaxs=new DFSVertax[max];
        for(int i=0;i<this.max;i++){
            this.vertaxs[i]=new DFSVertax(vertaxs.charAt(i));
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
        DFSVertax temp1=vertaxs[Locate(RootandSon.charAt(0))];
        DFSArc temp2=new DFSArc(Locate(RootandSon.charAt(1)));
        temp2.nextArc=temp1.nextArc;
        temp1.nextArc=temp2;
    }
    void DFStravsel(char head){
        DFSVertax header=this.vertaxs[Locate(head)];
        header.known=true;
        Stack<DFSVertax> stack=new Stack<>();
        stack.push(header);
        while(stack!=null){
            DFSVertax tempt=stack.pop();
            System.out.print(tempt.cite);
            DFSArc tempt1=tempt.nextArc;
            while(tempt1!=null){
                if(!this.vertaxs[tempt1.tag].known){
                    stack.push(this.vertaxs[tempt1.tag]);
                    this.vertaxs[tempt1.tag].known=true;
                }
                tempt1=tempt1.nextArc;
            }
        }
    }
}
class DFSVertax{
    Character cite;
    DFSArc nextArc;
    boolean known;
    public DFSVertax(char cite){
        this.cite=new Character(cite);
        nextArc=null;
        known=false;
    }
}
class DFSArc{
    int tag;
    DFSArc nextArc;
    public DFSArc(int tag){
        this.tag=tag;
        this.nextArc=null;
    }
}