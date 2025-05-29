package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drop extends JFrame{
	
	public JTextField getIdt() {
		return idt;
	}
	public void setIdt(JTextField idt) {
		this.idt = idt;
	}
	JPanel centeral=new JPanel();
	JButton done=new JButton("OK");
	JLabel proname=new JLabel("Select");
	JLabel ID=new JLabel("StudentID");
	JTextField idt=new JTextField();
	public Drop() {
		super("check");
		setSize(400,200);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		idt.setPreferredSize(new Dimension(350,40));
		proname.setFont(new Font("Times New Roman",Font.BOLD,30));
		ID.setFont(new Font("Times New Roman",Font.BOLD,20));
		centeral.add(ID);
		centeral.add(idt);
		Container container=getContentPane();
		container.add(proname,BorderLayout.NORTH);
		container.add(done,BorderLayout.SOUTH);
		container.add(centeral);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new findsql(idt.getText()).judge()){
					setVisible(false);
					new dropSql(idt.getText()).drop();
					new imagecl(new ImageIcon("D:\\Mateial\\SucessedDrop.png"));
				}
				else{
					setVisible(false);
					new imagecl(new ImageIcon("D:\\Mateial\\Ftonotfound.png"));
				}
			}
		});
	}
}