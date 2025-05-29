package MetrolSys;

/**
 * @author shkstart
 * @create 2023-06-06 9:01
 */
 class MetrolMap{
    sites[]sites;
    int max;
    public MetrolMap(int max){
        this.max=max;
        sites=new sites[max];
        sites[0]=new sites("工研院",1);
        sites[1]=new sites("创新谷",1);
        sites[2]=new sites("园博园",1);
        sites[3]=new sites("大学城",1);
        sites[4]=new sites("紫薇路",1);
        sites[5]=new sites("赵营",1);
        sites[6]=new sites("玉符河",1);
        sites[7]=new sites("王府庄",12);
        sites[8]=new sites("大杨",1);
        sites[9]=new sites("济南西站",1);
        sites[10]=new sites("方特",1);
        sites[11]=new sites("任家庄",2);
        sites[12]=new sites("腊山",2);
        sites[13]=new sites("西二环",2);
        sites[14]=new sites("闫千户",2);
        sites[15]=new sites("八里桥",2);
        sites[16]=new sites("万盛北街",2);
        sites[17]=new sites("宝华街",2);
        sites[18]=new sites("长途汽车站",2);
        sites[19]=new sites("开源路",2);
        sites[20]=new sites("生产路",2);
        sites[21]=new sites("历黄路",2);
        sites[22]=new sites("历山北路",2);
        sites[23]=new sites("二环东路",2);
        sites[24]=new sites("辛筑路",2);
        sites[25]=new sites("八涧堡",23);
        sites[26]=new sites("烈士陵园",2);
        sites[27]=new sites("彭家庄",2);
        sites[28]=new sites("滩头",3);
        sites[29]=new sites("济南东站",3);
        sites[30]=new sites("裴家营",3);
        sites[31]=new sites("王舍人",3);
        sites[32]=new sites("张马屯",3);
        sites[33]=new sites("花园东路",3);
        sites[34]=new sites("丁家庄",3);
        sites[35]=new sites("礼耕路",3);
        sites[36]=new sites("奥体中心",3);
        sites[37]=new sites("龙奥大厦",3);
        sites[38]=new sites("孟家庄",3);
        sites[39]=new sites("龙洞",3);
        sites[40]=new sites("济钢新村",2);
        insert("工研院","创新谷");
        insert("创新谷","园博园");
        insert("园博园","大学城");
        insert("大学城","紫薇路");
        insert("紫薇路","赵营");
        insert("赵营","玉符河");
        insert("玉符河","王府庄");
        insert("王府庄","大杨");
        insert("王府庄","任家庄");
        insert("大杨","济南西站");
        insert("济南西站","方特");
        insert("任家庄","腊山");
        insert("腊山","西二环");
        insert("西二环","闫千户");
        insert("闫千户","八里桥");
        insert("八里桥","万盛北街");
        insert("万盛北街","宝华街");
        insert("宝华街","长途汽车站");
        insert("长途汽车站","生产路");
        insert("生产路","历黄路");
        insert("历黄路","历山北路");
        insert("历山北路","二环东路");
        insert("二环东路","辛筑路");
        insert("辛筑路","八涧堡");
        insert("八涧堡","开源路");
        insert("八涧堡","张马屯");
        insert("八涧堡","花园东路");
        insert("开源路","烈士陵园");
        insert("烈士陵园","济钢新村");
        insert("济钢新村","彭家庄");
        insert("花园东路","丁家庄");
        insert("丁家庄","礼耕路");
        insert("礼耕路","奥体中心");
        insert("奥体中心","龙奥大厦");
        insert("龙奥大厦","孟家庄");
        insert("孟家庄","龙洞");
        insert("张马屯","王舍人");
        insert("王舍人","裴家营");
        insert("裴家营","济南东站");
        insert("济南东站","滩头");
    }
    void insert(String site1,String site2){
        sites tempt1=sites[locate(site1)];
        Arcs tempt2=new Arcs(locate(site2),(int)(Math.random()*20)+5,1);
        Arcs tempt3=sites[locate(site2)].nextSite;
        boolean flag=false;
        tempt2.nextSite=tempt1.nextSite;
        tempt1.nextSite=tempt2;
        while(tempt3!=null){
            if(sites[tempt3.tag].sitename.equals(site1)){
                flag=true;
                break;
            }
            tempt3=tempt3.nextSite;
        }
        if(!flag){
            insertReverse(site2,site1);
        }
    }
    void insertReverse(String site1,String site2){
        sites tempt1=sites[locate(site1)];
        Arcs tempt2=new Arcs(locate(site2),2,1);
        tempt2.nextSite=tempt1.nextSite;
        tempt1.nextSite=tempt2;

    }
    int locate(String sitename){
        boolean flag=false;
        int i;
        for(i=0;i<max;i++){
            if(sitename.equals(this.sites[i].sitename)){
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
    void travsel(){
        for(int i=0;i<max;i++){
            System.out.print(sites[i].sitename+":");
            Arcs tempt=sites[i].nextSite;
            while(tempt!=null){
                System.out.print(sites[tempt.tag].sitename+"\t");
                tempt=tempt.nextSite;
            }
            System.out.println("");
        }
    }
    void fresh(){
        for(int i=0;i<max;i++){
            sites[i].cost=9999;
            sites[i].route=null;
        }
    }
}
class sites{
    String sitename;
    int cost;
    Arcs nextSite;
    String route;
    boolean known;
    String line;

    public void setCost(int cost) {
        this.cost = cost;
    }

    public sites(String name, int line){
        this.sitename=name;
        cost=9999;
        this.line=Integer.toString(line);
        nextSite=null;
        route=null;
        known=false;
    }
    public sites(){}
}
class Arcs{
    int tag;
    Arcs nextSite;
    int ticket;
    int time;
    public Arcs(int tag,int time,int ticket){
        this.tag=tag;
        this.time=time;
        this.ticket=ticket;
        nextSite=null;
    }
}