package MetrolSys;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author shkstart
 * @create 2023-06-06 11:49
 */
 class RoutePlan{
    MetrolMap map;
    String direct=null;

    public String getDirect() {
        return direct;
    }

    public RoutePlan(MetrolMap map){
        this.map=map;
    }
    void Dijistra(String site1,String site2,int button){
        sites tempt1=map.sites[map.locate(site1)];
        tempt1.cost=0;
        tempt1.route=""+map.locate(site1);
        sites tempt2;
        while(true){
            int index=FindMini();
            if(index==-1){
                break;
            }
            else{
                tempt2=map.sites[index];
                tempt2.known=true;
                Arcs tempt3=tempt2.nextSite;
                while(tempt3!=null){
                    int total;
                    if(button==1){
                        total=tempt2.cost+tempt3.time;
                    }
                    else{
                        total=tempt2.cost+tempt3.ticket;
                    }
                    if(total<map.sites[tempt3.tag].cost){
                        map.sites[tempt3.tag].cost=total;
                        map.sites[tempt3.tag].route=tempt2.route+" "+tempt3.tag;
                    }
                    tempt3=tempt3.nextSite;
                }
            }
        }
        for(int i = 0; i< map.max; i++){
            int count=0,cost=0;
            if(map.sites[i].sitename.equals(site2)){
                String[]split=map.sites[i].route.split(" ");
                sites tempt=map.sites[Integer.parseInt(split[0])];
                direct="在"+tempt.sitename+"上车，乘坐";
                if(tempt.line.length()==1){
                    direct+=tempt.line+"号线";
                }
                else{
                    tempt=map.sites[Integer.parseInt(split[1])];
                    direct+=tempt.line+"号线";
                }
                for(int j=1;j<split.length;j++){
                    count++;
                    if(map.sites[Integer.parseInt(split[j])].sitename.equals(site2)){
                        break;
                    }
                    if(map.sites[Integer.parseInt(split[j])].line.length()>1){
                        direct+=count+"站后到达"+map.sites[Integer.parseInt(split[j])].sitename+",换乘"+map.sites[Integer.parseInt(split[j+1])].line+"号线";
                        count=0;
                        cost=map.sites[Integer.parseInt(split[j])].cost;
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Calendar nowTime = Calendar.getInstance();
                nowTime.add(Calendar.MINUTE,cost);
                if(button==1){
                    direct+="乘坐"+count+"站后下车"+",全程"+cost+"分钟,现在出发，大概"+sdf.format(nowTime.getTime())+"到达";
                }
               else{
                    direct+="乘坐"+count+"站后下车"+",全程"+cost+"元,现在出发，大概"+sdf.format(nowTime.getTime())+"到达";
                }
                break;
            }
        }
    }
    int FindMini(){
        sites mini=new sites();
        int count=0;
        mini.cost=999;
        for(int i=0;i<map.max;i++){
            if(map.sites[i].cost<mini.cost&&!map.sites[i].known){
                count++;
                mini=map.sites[i];
            }
        }
        if(count==0){
            return -1;
        }
        else{
            return map.locate(mini.sitename);
        }
    }
}