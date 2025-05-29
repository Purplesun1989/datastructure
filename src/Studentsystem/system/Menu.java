package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
	JPanel jPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,80,100));
	JButton jb1=new JButton("Add student");
	JButton jb2=new JButton("Drop student");
	JButton jb3=new JButton("Alter student");
	JButton jb4=new JButton("Select student");
	JButton jb5=new JButton("Checkout All");
	JButton jb6=new JButton("Exit");
	public Menu(String Vname){
		super(Vname);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container container=getContentPane();
		jPanel.add(jb1);
		jPanel.add(jb2);
		jPanel.add(jb3);
		jPanel.add(jb4);
		jPanel.add(jb5);
		jPanel.add(jb6);
		container.add(jPanel);
		ActionListener listener1=new listener1();
		ActionListener listener2=new listener2();
		ActionListener listener3=new listener3();
		ActionListener listener4=new listener4();
		ActionListener listener5=new listener5();
		jb1.addActionListener(listener1);
		jb2.addActionListener(listener2);
		jb3.addActionListener(listener3);
		jb4.addActionListener(listener4);
		jb5.addActionListener(listener5);
		jb6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Exit();
			}
		});
	}
}
class listener1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new Insert();
	}
		
}
class listener2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new Drop();
	}
	
}
class listener3 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new f0();
	}
	
}
class listener4 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new Select();
	}
	
}
class listener5 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new check();
	}
	
}

