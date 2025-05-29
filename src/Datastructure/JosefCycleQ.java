package Datastructure;

/**
 * @author shkstart
 * @create 2023-04-18 19:30
 */
class CycleQ {
    void offer(CycleQnode cycleQnode,int key){
        if(cycleQnode.now<cycleQnode.max){
            if(cycleQnode.rear!=cycleQnode.max-1){
                cycleQnode.rear++;
                cycleQnode.data[cycleQnode.rear]=key;
            }
            else{
                cycleQnode.rear=0;
                cycleQnode.data[cycleQnode.rear]=key;
            }
            cycleQnode.now++;
        }
        else{
            System.out.println("No room");
        }
    }
   void outQ(CycleQnode cycleQnode){
            if(cycleQnode.front!=cycleQnode.max-1){
                cycleQnode.front++;
                cycleQnode.now--;
            }
            else{
                cycleQnode.front=0;
            }
    }
    void printQ(CycleQnode cycleQnode){
        if(cycleQnode.rear>=cycleQnode.front){
            for(int i=cycleQnode.front;i<=cycleQnode.rear;i++){
                System.out.println(cycleQnode.data[i]);
            }
        }
        else{
            for(int i=cycleQnode.front;i<cycleQnode.max;i++){
                System.out.println(cycleQnode.data[i]);
            }
            for(int i=0;i<=cycleQnode.rear;i++){
                System.out.println(cycleQnode.data[i]);
            }
        }
    }
}
class CycleQnode{
    int front=0;
    int rear=-1;
    int now=0;
    int max;
    int []data;
    public CycleQnode(int max){
        this.max=max;
        data=new int[max];
    }
}
public class JosefCycleQ{
    public static void main(String[] args) {
        CycleQnode JorsefR=new CycleQnode(41);
    }
}