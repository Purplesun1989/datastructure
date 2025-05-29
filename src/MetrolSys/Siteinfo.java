package MetrolSys;

/**
 * @author shkstart
 * @create 2023-06-06 17:50
 */

import javax.swing.*;

public class Siteinfo extends JFrame {
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextArea code = new JTextArea();
    String nsitename=null;
    JScrollPane jScrollPane;
    JPanel jPanel=new JPanel();
    public Siteinfo(String name) {
        nsitename=name;
        initJFrame();
        initView();
        this.setVisible(true);
    }
    public void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("src/MetrolSys/manager2.jpg"));
        usernameText.setBounds(20, 60, 163, 172);
        this.getContentPane().add(usernameText);
        username.setBounds(195, 60, 150, 30);
        username.setText("站点名："+nsitename);
        this.getContentPane().add(username);
        password.setBounds(195, 100, 150, 30);
        password.setText("值班站长："+createname());
        this.getContentPane().add(password);
        code.setBounds(195, 140, 250, 100);
        code.setLineWrap(true);
        code.setText(createintro());
        jPanel.add(code);
        jScrollPane=new JScrollPane(jPanel);
        jScrollPane.setBounds(195, 140, 250, 100);
        this.getContentPane().add(jScrollPane);
    }
    public void initJFrame() {
        setIconImage(new ImageIcon("src/MetrolSys/tag.png").getImage());
        setSize(500, 350);
        setTitle("智慧泉城，畅达幸福");
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    String createintro(){
        String str="";
        String[]library={"本站位于泉城的中心，交通十分发达。","此站点为6月模范站点，全济南铁路工作者的榜样。","这个地铁站点外观简洁大方。","本站位于泉城的中心，交通十分发达","这个地铁站点外观简洁大方。","站内的安保设施齐全，乘客出行更加安心。","通过地铁站点，可以方便地到达本地区的重要商业中心。","地铁站点周围的交通组织得非常好，换乘其他公共交通工具非常方便。","这个地铁站点的公告音量适宜，没有影响乘客休息和沟通。","站点设计考虑人性化，符合国际标准。","站内干净整洁，人流量大时也不会显得拥挤。","自助售票机和自动闸机设备先进，操作简单方便。","可以在该站点上车下车的列车频率非常高，乘坐体验非常良好。","周边地貌布局合理，站点选择非常优越。","室内照明充足，让人感觉很舒适。","该站点附近有多家美食店和购物中心，游客可凭借这些设施特别体验当地文化。","在该站点等待列车时间较短，不用担心浪费时间。","车站内外安装的监控设备齐全，能够确保乘客的人身和财产安全。","站点周边是市中心区域，景观美观，商业环境极佳。","这个地铁站既美观又现代，具有时尚的感觉。","该站点设施齐全，方便乘客出入。","这个地铁站非常繁忙，每天都有大量的旅客经过这里。","该站点交通便利，可以很容易地到达市中心和其他主要景点。","这个地铁站充满生气，是城市中的重要交通枢纽。","站点周围有许多商店、餐馆和公共设施，为游客提供了便利条件。","这个地铁站点外观简洁大方。","该站点拥有高效的列车运营系统，乘坐火车非常安全可靠。","该站点拥有高效的列车运营系统，乘坐火车非常安全可靠。","新近修建的站点，装修非常现代，引来了不少游客的喜爱。","这个地铁站点是一个繁忙的交通枢纽，在日常生活中，它扮演着无数人的接驳口，把他们带往目的地，成为城市运转不可或缺的一部分。","这个地铁站点外观简洁大方。","快速移动的噪音和来自不同方向的人流成了这个地铁站的标志，混杂着各种声音和气味，形成一种特殊的氛围。","这座地铁站坐落在城市的东北方向，是连接市中心和远郊地区的重要枢纽交通站点。它毗邻一个绿色公园，周边环境优美，让人感到舒适和放松。","这个地铁站点外观简洁大方。","这个地铁站通过先进的安全设施来确保每个乘客的安全。有高清摄像头覆盖站内每个角落，以及火灾自动报警系统和紧急电话设备等应急设施，确保紧急情况下的快速响应。","这个地铁站提供了广泛的服务设施，如无障碍电梯、测试广告板、可信赖的Wi-Fi信号等，方便和支持各种类型的旅客出行。此外, 设施设备还定期维护和更新，维持着良好的运转状态。","地铁站的候车区域安排得井井有条，人流有序。双向出入口和专门的上下车导引，为乘客提供了更快捷、便利、高效的出行体验。","站厅空间光线充足，呈现出开阔的感觉。主题风格简洁明了，让人一眼就能找到自己需要的设施。同时配备了现代化品牌商店和餐厅，将出行和消费贯穿起来。","该地铁站通过合理规划人流、车流、货流的交叉点， 统筹考虑车站旅客的人性化服务, 以及保证列车时刻表上的准确性，有效减少误点率, 为忙碌的城市生活带来了便利和效率。","地铁站的绿色动力系统是当地环境友好型出行的标志之一。它采用储能回馈技术，配备高效集中供电系统及水源热泵空调等设施，可以降低整个城市的能耗并大幅降低二氧化碳排放量，为改善城市环境做出积极贡献。","安全操作管理团队对该地铁站一直进行精心的规划与管理，制定严格而具有可操作性的安全规范, 同时对人员培训和物料设备的保养进行精细把控,确保该地铁站安全有序运营","地铁站通过ABCD等级应急预案将风险降到最低，实现各部门职责相互配合，保证旅客出行安全。在极端恶劣天气或其他特殊情况下，地铁站能够迅速响应和处理，为市民出行提供了可靠的支持。"};
        int num=(int)(3*Math.random()+3);
        for(int i=0;i<num;i++){
            if(library[(int)(42*Math.random())]!=null){
                str+=library[(int)(42*Math.random())];
            }
        }
        return str;
    }
    String createname(){
        String[]librarylast={"徐","贾","李","王","张","刘","陈","杨","赵","黄","周","吴","孙","胡","朱","高","林","何","郭","马","罗","梁","宋","邓","谢","韩","唐","冯","于","懂","萧","程","曹","元","邓","许","傅","沈","曾"};
        String[]libraryfirst={"继伟","国强","国瑞","建军","瑞","媛","强","震叚","中冰","问好","文豪","若男","胜男","亚楠","文翰","文宣","文轩","子睿","子瑞","建业","波","博","全德","佳乐","文卓","海来","锋","亮","文","佳","子文","中正","靖康","启辰","启节","好文","好武","世友","恩来","洁"};
        String str=librarylast[(int)(39*Math.random())]+libraryfirst[(int)(40*Math.random())];
        return str;
    }
}

