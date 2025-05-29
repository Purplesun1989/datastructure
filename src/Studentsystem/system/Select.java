package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Select extends JFrame{
    JPanel centeral = new JPanel();
    JLabel proname = new JLabel("Selecting");
    JLabel neW = new JLabel("ID");
    JTextField newt=new JTextField();
    JButton done=new JButton("OK");
    public Select(){
        setSize(new Dimension(400,200));
        setVisible(true);
        setLocationRelativeTo(null);
        newt.setPreferredSize(new Dimension(350,40));
        Container container=this.getContentPane();
        proname.setFont(new Font("Times New Roman",Font.BOLD,30));
        neW.setFont(new Font("Times New Roman",Font.BOLD,20));
        centeral.add(newt,FlowLayout.LEFT);
        centeral.add(neW,FlowLayout.LEFT);
        container.add(proname,BorderLayout.NORTH);
        container.add(done,BorderLayout.SOUTH);
        container.add(centeral);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new findsql(newt.getText()).judge()){
                    setVisible(false);
                    new Selectsql(newt.getText()).select();
                }
                else{
                    setVisible(false);
                    new imagecl(new ImageIcon("D:\\Mateial\\Ftonotfound.png"));
                }
            }
        });
}
}
class sf2 extends JFrame{
    JPanel central=new JPanel();
    JLabel proName=new JLabel("Information Details");
    JLabel stuname=new JLabel("StuName");
    JLabel stugender=new JLabel("StuGender");
    JLabel birth=new JLabel("StuBirth");
    JLabel origin=new JLabel("StuOrigin");
    JLabel grade=new JLabel("StuScores");
    JLabel classN=new JLabel("className");
    JLabel ID1=new JLabel("ID");
    JTextField StuGender=new JTextField();
    JTextField Studename=new JTextField();
    JTextField StuOrigin=new JTextField();
    JTextField Stuscores=new JTextField();
    JTextField ClassName=new JTextField();
    JTextField Studbirth=new JTextField();
    JTextField IDT=new JTextField();
    public sf2(String name,String gender,String ID,String birth1,String origin1,String grade1,String classn){
        JFrame view1=new JFrame("select");
         Studename.setText(name);
         StuOrigin.setText(origin1);
         Stuscores.setText(grade1);
         ClassName.setText(classn);
         Studbirth.setText(birth1);
         IDT.setText(ID);
        StuGender.setText(gender);
        setVisible(true);
        setSize(350,500);
        setResizable(false);
        setLocationRelativeTo(null);
        StuGender.setPreferredSize(new Dimension(350,30));
        Studename.setPreferredSize(new Dimension(350,30));
        StuOrigin.setPreferredSize(new Dimension(350,30));
        Stuscores.setPreferredSize(new Dimension(350,30));
        ClassName.setPreferredSize(new Dimension(350,30));
        Studbirth.setPreferredSize(new Dimension(350,30));
        IDT.setPreferredSize(new Dimension(350,30));
        proName.setFont(new Font("Arial",Font.ITALIC,30));
        central.add(ID1);
        central.add(IDT);
        central.add(stuname);
        central.add(Studename);
        central.add(stugender);
        central.add(StuGender);
        central.add(birth);
        central.add(Studbirth);
        central.add(origin);
        central.add(StuOrigin);
        central.add(grade);
        central.add(Stuscores);
        central.add(classN);
        central.add(ClassName);
        Container container=getContentPane();
        view1.getContentPane();
        container.add(central,BorderLayout.CENTER);
        container.add(proName,BorderLayout.NORTH);
    }
}