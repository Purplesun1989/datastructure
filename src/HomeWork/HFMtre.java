package HomeWork;

/**
 * @author shkstart
 * @create 2023-04-23 12:02
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

class HTNode 						//哈夫曼树结点类
{
    char data;						//结点值,假设为单个字符
    double weight;					//权值
    public HTNode parent;			//双亲结点
    HTNode lchild;					//左孩子结点
    HTNode rchild;					//右孩子结点
    boolean flag;					//标识是双亲的左或者右孩子
    public HTNode()					//构造方法
    {
        parent=null;
        lchild=null;
        rchild=null;
        //data='A';
    }
    public double getw()			//取结点权值的方法
    {
        return weight;
    }
}
 class HuffmanClass
{
    final int MAXN=100;				//最多结点个数
    double [] w;					//权值数组
    String str;						//存放字符串
    int n0;							//权值个数
    HTNode[] ht;					//存放哈夫曼树
    String[] hcd;					//存放哈夫曼编码
    public HuffmanClass()			//构造方法
    {
        ht=new HTNode[MAXN];
        hcd=new String[MAXN];
        w=new double[MAXN];
    }
    public void Setdata(int n0,int[] w,String str)	//设置初始值
    {
        this.n0=n0;
        for (int i=0;i<n0;i++)
            this.w[i]=w[i];
        this.str=str;
    }
    public void CreateHT()		//构造哈夫曼树
    {
        Comparator<HTNode> priComparator  			//定义priComparator
                = new Comparator<HTNode>()
        {	public int compare(HTNode o1,HTNode o2)	//用于创建小根堆
        {
            return (int)(o1.getw()-o2.getw());	//按weight越小越优先
        }
        };
        PriorityQueue<HTNode> pq=new PriorityQueue<>(MAXN,priComparator); //定义优先队列
        for (int i=0;i<n0;i++)					//建立n0个叶子结点并进队
        {
            ht[i]=new HTNode();					//建立ht[i]结点
            ht[i].parent=null;					//双亲设置为空
            ht[i].data=str.charAt(i);
            ht[i].weight=w[i];
            pq.offer(ht[i]);
        }
        for (int i=n0;i<(2*n0-1);i++)			//合并操作
        {
            HTNode p1=pq.poll();				//出队两个权值最小的结点p1后p2
            HTNode p2=pq.poll();
            //System.out.println("取"+p1.weight+" "+p2.weight);
            ht[i]=new HTNode();					//建立ht[i]结点
            p1.parent=ht[i];					//设置p1和p2的双亲为ht[i]
            p2.parent=ht[i];
            ht[i].weight=p1.weight+p2.weight; 	//求权值和
            ht[i].lchild=p1;					//p1作为双亲ht[i]的左孩子
            p1.flag=true;
            ht[i].rchild=p2;					//p2作为双亲ht[i]的右孩子
            p2.flag=false;
            pq.offer(ht[i]);					//ht[i]结点进队
        }
    }
    private String reverse(String s)			//逆置字符串s
    {
        String t="";
        for (int i=s.length()-1;i>=0;i--)
            t+=s.charAt(i);
        return t;
    }

    public void CreateHCode()					//根据哈夫曼树求哈夫曼编码
    {
        for (int i=0;i<n0;i++)					//遍历下标从0到n0-1的叶子结点
        {
            hcd[i]="";
            HTNode p=ht[i];						//从ht[i]开始找双亲结点
            while (p.parent!=null)
            {
                if (p.flag)						//p结点是双亲的左孩子
                    hcd[i]+='0';
                else							//p结点是双亲的右孩子
                    hcd[i]+='1';
                p=p.parent;
            }
            //System.out.println("hcd:"+hcd[i]);
            hcd[i]=reverse(hcd[i]);				//逆置
        }
    }
    public void DispHuffman()					//输出哈夫曼编号
    {
        for (int i=0;i<n0;i++)
            System.out.println(ht[i].data+" "+hcd[i]);
    }

}
class insertFile{
    Map<Character,Integer> list=new<Character,Integer>HashMap();
    int HFT[]=new int[52];
    String lines="";
    void insert() throws Exception{
        BufferedReader bf=new BufferedReader(new FileReader(new File("C:\\Users\\xjh22\\Desktop\\TEST.txt")));
        String str= bf.readLine();
        while(str!=null){
            for(int i=0;i<str.length();i++){
                if(list.containsKey(str.charAt(i))){
                    int values=list.get(str.charAt(i));
                    values++;
                    list.put(str.charAt(i),values);
                }
                else{
                    list.put(str.charAt(i),1);
                }
            }
            str=bf.readLine();
        }
        int i=0;
        Iterator<Map.Entry<Character, Integer>> it = list.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character, Integer> entry = it.next();
            HFT[i]=entry.getValue();
            lines+=entry.getKey();
            i++;
        }
    }

    public int[] getHFT() {
        return HFT;
    }

    public String getLines() {
        return lines;
    }
}
public class HFMtre{
    public static void main(String[] args) throws Exception {
        HuffmanClass hft=new HuffmanClass();
        insertFile is=new insertFile();
        is.insert();
        String str=is.getLines();
        int test[]=is.getHFT();
        hft.Setdata(str.length(),test,str);
        hft.CreateHT();
        hft.CreateHCode();
        hft.DispHuffman();
    }
}


