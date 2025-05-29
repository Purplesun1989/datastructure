package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class loginStart extends JFrame {
	JFrame loginin;
	SpringLayout springLayout = new SpringLayout();
	JPanel jPanel = new JPanel(springLayout);
	JLabel jLabel1 = new JLabel("Username");
	JLabel jLabel2 = new JLabel("Password");
	JLabel name = new JLabel("Students Management sys of SHIT Login");
	JTextField Unm = new JTextField();
	JTextField pwd = new JPasswordField();
	 JButton log = new JButton("Login-in");
	 JButton  regist=new JButton("Roll-in");
	private BufferedImage buffer = null;

	public loginStart() {
		super("Login in");
		Unm.setPreferredSize(new Dimension(200, 30));
		pwd.setPreferredSize(new Dimension(200, 30));
		Container contentpane = getContentPane();
		jPanel.add(jLabel1);
		jPanel.add(Unm);
		jPanel.add(jLabel2);
		jPanel.add(pwd);
		jPanel.add(log);
		jPanel.add(regist);
		name.setFont(new Font("Times New Roman", Font.BOLD, 30));
		name.setPreferredSize(new Dimension(0, 120));
		Spring childwidth = Spring.sum(Spring.sum(Spring.width(jLabel1), Spring.width(Unm)), Spring.constant(20));
		int offsetx = (childwidth.getValue() / 2);
		springLayout.putConstraint(springLayout.WEST, jLabel1, -offsetx, springLayout.HORIZONTAL_CENTER, jPanel);
		springLayout.putConstraint(springLayout.NORTH, jLabel1, 20, springLayout.NORTH, jPanel);
		springLayout.putConstraint(springLayout.WEST, Unm, 20, springLayout.EAST, jLabel1);
		springLayout.putConstraint(springLayout.NORTH, Unm, 0, springLayout.NORTH, jLabel1);
		springLayout.putConstraint(springLayout.EAST, jLabel2, 0, springLayout.EAST, jLabel1);
		springLayout.putConstraint(springLayout.NORTH, jLabel2, 20, springLayout.SOUTH, jLabel1);
		springLayout.putConstraint(springLayout.WEST, pwd, 20, springLayout.EAST, jLabel2);
		springLayout.putConstraint(springLayout.NORTH, pwd, 0, springLayout.NORTH, jLabel2);
		springLayout.putConstraint(springLayout.WEST, log, 50, springLayout.WEST, jLabel2);
		springLayout.putConstraint(springLayout.NORTH, log, 20, springLayout.SOUTH, jLabel2);
		springLayout.putConstraint(springLayout.WEST, regist, 70, springLayout.EAST, log);
		springLayout.putConstraint(springLayout.NORTH, regist, 0, springLayout.NORTH, log);
		contentpane.add(name, BorderLayout.NORTH);
		contentpane.add(jPanel, BorderLayout.CENTER);
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new usersql(Unm.getText(),pwd.getText()).judge()){
					setVisible(false);
					new Menu("menu");
				}
				else{
					Unm.setText("");
					pwd.setText("");
					new imagecl(new ImageIcon("D:\\Mateial\\Ftocreate.png"));
				}
			}
		});
		regist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new lf2();
			}
		});
	}
	public static void main(String[] args) {
		System.setProperty("sun.java2d.noddraw", "true");
		new loginStart();
	}
}
class lf2 extends JFrame{
	JFrame loginin;
	String pwds;
	String unms;
	SpringLayout springLayout = new SpringLayout();
	JPanel jPanel = new JPanel(springLayout);
	JLabel jLabel1 = new JLabel("Username");
	JLabel jLabel2 = new JLabel("Password");
	JLabel name = new JLabel("Students Management sys of SHIT rollIn");
	JTextField Unm = new JTextField();
	JTextField pwd = new JTextField();
	JButton done = new JButton("OK");
	public lf2(){
		super("rollin");
		Unm.setPreferredSize(new Dimension(200, 30));
		pwd.setPreferredSize(new Dimension(200, 30));
		Container contentpane = getContentPane();
		jPanel.add(jLabel1);
		jPanel.add(Unm);
		jPanel.add(jLabel2);
		jPanel.add(pwd);
		jPanel.add(done);
		name.setFont(new Font("Times New Roman", Font.BOLD, 30));
		name.setPreferredSize(new Dimension(0, 120));
		Spring childwidth = Spring.sum(Spring.sum(Spring.width(jLabel1), Spring.width(Unm)), Spring.constant(20));
		int offsetx = (childwidth.getValue() / 2);
		springLayout.putConstraint(springLayout.WEST, jLabel1, -offsetx, springLayout.HORIZONTAL_CENTER, jPanel);
		springLayout.putConstraint(springLayout.NORTH, jLabel1, 20, springLayout.NORTH, jPanel);
		springLayout.putConstraint(springLayout.WEST, Unm, 20, springLayout.EAST, jLabel1);
		springLayout.putConstraint(springLayout.NORTH, Unm, 0, springLayout.NORTH, jLabel1);
		springLayout.putConstraint(springLayout.EAST, jLabel2, 0, springLayout.EAST, jLabel1);
		springLayout.putConstraint(springLayout.NORTH, jLabel2, 20, springLayout.SOUTH, jLabel1);
		springLayout.putConstraint(springLayout.WEST, pwd, 20, springLayout.EAST, jLabel2);
		springLayout.putConstraint(springLayout.NORTH, pwd, 0, springLayout.NORTH, jLabel2);
		springLayout.putConstraint(springLayout.WEST, done, 30, springLayout.EAST, pwd);
		springLayout.putConstraint(springLayout.NORTH, done, 0, springLayout.NORTH, pwd);
		contentpane.add(name, BorderLayout.NORTH);
		contentpane.add(jPanel, BorderLayout.CENTER);
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new registSql(Unm.getText(),pwd.getText()).insert();
				new imagecl(new ImageIcon("D:\\Mateial\\Sucessed.png"));
			}
		});
	}
}