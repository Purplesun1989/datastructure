package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class alter extends JFrame implements ActionListener{
	JFrame optionPenal = new JFrame("Option");
	JPanel oPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 80, 30));
	JLabel proname = new JLabel("The traits you wanna change");
	JButton name = new JButton("STNA");
	JButton ID = new JButton("STID");
	JButton birthday = new JButton("STBI");
	JButton gender = new JButton("STGE");
	JButton origin = new JButton("STOR");
	JButton score = new JButton("STSC");
	JButton classname = new JButton("STCL");
	String ID1;
	public alter(String ID2) {
		super("Option");
		this.ID1=ID2;
		proname.setFont(new Font("Times New Roman", Font.BOLD, 25));
		setSize(new Dimension(400, 350));
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		oPanel.add(name);
		oPanel.add(ID);
		oPanel.add(birthday);
		oPanel.add(gender);
		oPanel.add(origin);
		oPanel.add(score);
		oPanel.add(classname);
		oPanel.setSize(new Dimension(400, 200));
		Container container = getContentPane();
		container.add(proname, BorderLayout.NORTH);
		container.add(oPanel);
		name.addActionListener(this);
		classname.addActionListener(this);
		score.addActionListener(this);
		origin.addActionListener(this);
		gender.addActionListener(this);
		birthday.addActionListener(this);
		ID.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		switch(e.getActionCommand()){
			case "STNA":{
				f2 f2=new f2(ID1);
			};break;
			case "STBI":{
				f7 f7=new f7(ID1);
			};break;
			case "STGE":{
				f5 f5=new f5(ID1);
			};break;
			case "STOR":{
				f8 f8=new f8(ID1);
			};break;
			case "STSC":{
				f9 f9=new f9(ID1);
			};break;
			case "STCL":{
				f10 f10=new f10(ID1);
			};break;
			case "STID":{
				f6 f6=new f6(ID1);
			};break;
		}
	}
}
class f2 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Name");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f2(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Altername(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f0 extends JFrame{
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Selecting");
	JLabel neW = new JLabel("ID");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	public f0(){
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
				String news=newt.getText();
				if(new findsql(newt.getText()).judge()){
					setVisible(false);
					new alter(newt.getText());
				}
				else{
					setVisible(false);
					new imagecl(new ImageIcon("D:\\Mateial\\Ftonotfound.png"));
				}
			}
		});
	}
}
class f5 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Gender");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f5(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Altergender(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f6 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("StudentID");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f6(String ID){
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
				setVisible(false);
				news=newt.getText();
				new AlterID(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f7 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Birthday");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f7(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Alterbirth(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f8 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Origin");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f8(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Alterorigin(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f9 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Score");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f9(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Alterscore(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
class f10 extends JFrame  {
	JPanel centeral = new JPanel();
	JLabel proname = new JLabel("Updating");
	JLabel neW = new JLabel("Classname");
	JTextField newt=new JTextField();
	JButton done=new JButton("OK");
	String news;
	public f10(String ID){
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
				setVisible(false);
				news=newt.getText();
				new Alterclass(newt.getText(),ID).update();
				new imagecl(new ImageIcon("D:\\Mateial\\SucessedInsert.png"));
			}
		});
	}
}
