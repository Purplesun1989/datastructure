package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class Insert extends JFrame{
	JLabel proName=new JLabel("Exisit Check");
	JButton done=new JButton("OK");
	JLabel stuID=new JLabel("StudentID");
	JTextField StudentID=new JTextField();
	FlowLayout flowLayout= new FlowLayout(FlowLayout.LEADING);
	JPanel central=new JPanel(flowLayout);
	public Insert(){
		super("Check");
		setVisible(true);
		setSize(400,600);
		setResizable(false);
		setLocationRelativeTo(null);
		proName.setFont(new Font("Arial",Font.ITALIC,30));
		StudentID.setPreferredSize(new Dimension(300,20));
		stuID.setPreferredSize(new Dimension(80,80));
		done.setPreferredSize(new Dimension(400,40));
		central.add(stuID);
		central.add(StudentID);
		Container container=getContentPane();
		container.add(central);
		container.add(proName,BorderLayout.NORTH);
		container.add(done,BorderLayout.SOUTH);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new findsql(StudentID.getText()).judge()){
					setVisible(false);
					new imagecl(new ImageIcon("D:\\Mateial\\Ftoexisted.png"));
				}
				else{
					setVisible(false);
					new if2(StudentID.getText());
				}
			}
		});
	}
}
class if2 extends JFrame{
	JPanel central=new JPanel();
	JButton done=new JButton("OK");
	JLabel proName=new JLabel("Information Details");
	JLabel stuname=new JLabel("StuName");
	JLabel stugender=new JLabel("StuGender");
	JLabel birth=new JLabel("StuBirth");
	JLabel origin=new JLabel("StuOrigin");
	JLabel grade=new JLabel("StuScores");
	JLabel classN=new JLabel("className");
	JTextField StuGender=new JTextField();
	JTextField Studename=new JTextField();
	JTextField StuOrigin=new JTextField();
	JTextField Stuscores=new JTextField();
	JTextField ClassName=new JTextField();
	JTextField Studbirth=new JTextField();
	private String studentid;
	public if2(String ID){
		this.studentid=ID;
		JFrame view1=new JFrame("Add");
		setVisible(true);
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		StuGender.setPreferredSize(new Dimension(300,20));
		Studename.setPreferredSize(new Dimension(300,20));
		StuOrigin.setPreferredSize(new Dimension(300,20));
		Stuscores.setPreferredSize(new Dimension(300,20));
		ClassName.setPreferredSize(new Dimension(300,20));
		Studbirth.setPreferredSize(new Dimension(300,20));
		done.setPreferredSize(new Dimension(400,40));
		proName.setFont(new Font("Arial",Font.ITALIC,30));
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
		container.add(done,BorderLayout.SOUTH);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				String name=Studename.getText();
				String gender=StuGender.getText();
				String birthday=Studbirth.getText();
				String scores=Stuscores.getText();
				String origin=StuOrigin.getText();
				String classname=ClassName.getText();
				try {
					new insertSql(name,gender,studentid,birthday,origin,scores,classname).insert();
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
				new imagecl(new ImageIcon("D:\\Mateial\\Bye.png"));
			}
		});
	}
}
