package Studentsystem.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class check extends JFrame{

    DefaultTableModel defaultTableModel;
    Container container=null;
    Object[][]data=new Object[1000][3];
    Object[]column={"name","ID","score"};
    JButton jb1=new JButton("SortbyScore");
    JTable info=new JTable(data,column);
    JScrollPane jScrollPane=new JScrollPane(info);
    public check(){
        super("Table");
        data=new checkout(data).insert();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        info.setRowHeight(30);
        container=getContentPane();
        container.add(jb1,BorderLayout.SOUTH);
        container.add(jScrollPane);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new sort();
            }
        });
    }
}
class checkout{
    Object[][]data=null;
    int counter=0;

    public int getCounter() {
        return counter;
    }

    public static final String url="jdbc:mysql://127.0.0.1/studentdb";
    public checkout(Object[][] objects){
        this.data=objects;
    }
    Object[][] insert() {

        try{
            Connection connect= DriverManager.getConnection(url,"root","");
            PreparedStatement stmt=connect.prepareStatement("select * from students order by grade");
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