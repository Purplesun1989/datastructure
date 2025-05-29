package Studentsystem.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shkstart
 * @create 2022-12-11 19:46
 */
class sort extends JFrame {

    DefaultTableModel defaultTableModel;
    Container container=null;
    Object[][]data=new Object[1000][3];
    Object[]column={"name","ID","score"};
    JTable info=new JTable(data,column);
    JScrollPane jScrollPane=new JScrollPane(info);
    public sort(){
        super("Table");
        data=new sortout(data).insert2();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        info.setRowHeight(30);
        container=getContentPane();
        container.add(jScrollPane);
    }
}
class sortout{
    Object[][]data=null;
    int counter=0;
    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    public sortout(Object[][] objects){
        this.data=objects;
    }
    Object[][] insert2() {

        try{
            Connection connect= DriverManager.getConnection(url,"root","");
            PreparedStatement stmt=connect.prepareStatement("select * from students order by grade desc");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                data[counter][0]=rs.getString("name");
                data[counter][1]=rs.getString("ID");
                data[counter][2]=rs.getString("grade");
                counter++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
