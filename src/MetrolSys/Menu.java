package MetrolSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author shkstart
 * @create 2023-06-06 11:52
 */
public class Menu extends JFrame {

    JPanel northpanel=new JPanel();
    JPanel southpanel=new JPanel();
    JButton plaBtn=new JButton("线路规划");
    JTextField searchText=new JTextField(15);
    JButton searchBtn=new JButton("搜索站点信息");
    JButton sortBtn=new JButton("排序");
    JScrollPane jScrollPane;
    JTable jTable;
    private JRadioButton time = new JRadioButton("最省时间");
    private JRadioButton tickets = new JRadioButton("最省钱");
    int flag;
    public Menu(){
        super("智慧泉城，畅达幸福");
        searchText.setText("本站为:工研院.默认以经济排序.");
        searchText.setPreferredSize(new Dimension(1000,30));
        Container contentPane=getContentPane();
        layoutNorth(contentPane);
        layoutCenter(contentPane);
        layoutSouth(contentPane);
        setIconImage(new ImageIcon("src/MetrolSys/tag.png").getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets screenInsets=Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
        setBounds(new Rectangle(screenInsets.left,screenInsets.top,screenSize.width-screenInsets.left-screenInsets.right,screenSize.height-screenInsets.top-screenInsets.bottom));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        plaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyFrame(flag);
            }
        });
        time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=1;
            }
        });
        tickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=2;
            }
        });
        searchText.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1) {
                    searchText.setText(null);
                }
            }
        });
        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Sort();
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchText.getText();
                new Siteinfo(searchText.getText());
            }
        });
    }
    private void layoutNorth(Container contentPane) {
        northpanel.add(plaBtn);
        northpanel.add(searchText);
        northpanel.add(searchBtn);
        ButtonGroup group = new ButtonGroup();
        group.add(tickets);
        group.add(time);
        northpanel.add(tickets);
        northpanel.add(time);
        contentPane.add(northpanel,BorderLayout.NORTH);
    }
    private void layoutSouth(Container contentPane) {
        southpanel.add(sortBtn);
        contentPane.add(southpanel,BorderLayout.SOUTH);
    }
    private void layoutCenter(Container contentPane) {
        SitesTable sitesTable=new SitesTable();
        sitesTable.setInfoUnsorted();
        jTable=sitesTable.getInfo();
        jScrollPane=new JScrollPane(jTable);
        contentPane.add(jScrollPane,BorderLayout.CENTER);
    }
}
