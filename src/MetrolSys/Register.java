package MetrolSys;

/**
 * @author shkstart
 * @create 2023-06-06 17:50
 */

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Register extends JFrame{
    private JPanel
            contentPanel = new JPanel();
    private JLabel
            label,
            label2;
    private JButton
            login = new JButton("登录");
    private JTextField
            admin = new JTextField(),
            password = new JTextField();
    private JCheckBox
            rememberAdmin = new JCheckBox("记住账号")
            ;
    public Register(){
        super("智慧泉城，畅达幸福");
        setIconImage(new ImageIcon("src/MetrolSys/tag.png").getImage());
        setTitle("泉城八达通");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 350);
        setVisible(true);
        admin.setText("账号");
        password.setText("密码");
        ImageIcon image1 = new ImageIcon("src/MetrolSys/v2-ea63b90bb1f18fea87310a11fd5c2a17_r.jpg");
        ImageIcon image2 = new ImageIcon("src/MetrolSys/v2-ea63b90bb1f18fea87310a11fd5c2a17_r.jpg");
        JLabel backLabel = new JLabel();
        JLabel backLabel2 = new JLabel();
        backLabel.setIcon(image1);
        backLabel2.setIcon(image2);
        label=new JLabel(image1);
        label2 = new JLabel(image2);
        label.setBounds(0, 0,500,350);
        label2.setBounds(0, 0, 500, 350);
        this.getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        ((JPanel)this.getContentPane()).setOpaque(false);
        contentPanel.setLayout(null);
        add(admin);
        add(password);
        add(login);
        add(rememberAdmin);
        admin.setBounds(95, 130, 300, 25);
        password.setBounds(95, 154, 300, 25);
        rememberAdmin.setBounds(95, 180, 100, 14);
        login.setBounds(315, 225, 90, 20);
        admin.setOpaque(false);
        password.setOpaque(false);
        contentPanel.setOpaque(false);
        rememberAdmin.setOpaque(false);
        getContentPane().add(contentPanel);
        textSet(admin);
        textSet(password);
        admin.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1) {
                    admin.setText(null);
                }
            }
        });
        password.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1) {
                    password.setText(null);
                }
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String acc=admin.getText();
                String pwd=password.getText();
                new Menu();
                dispose();
            }
        });
    }
    public void textSet(JTextField field) {
        field.setBackground(new Color(255, 255, 255));
        field.setPreferredSize(new Dimension(150, 28));
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,
                192));
        field.setBorder(border);
    }
}