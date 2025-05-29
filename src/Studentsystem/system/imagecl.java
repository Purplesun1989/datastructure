package Studentsystem.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shkstart
 * @create 2022-12-10 22:11
 */
public class imagecl extends JFrame {
    JButton done=new JButton("OK");
    JLabel image=new JLabel();
    Container container;
    ImageIcon icon;
    public imagecl(ImageIcon icon){
        super("Page");
        this.icon=icon;
        image=new JLabel(icon);
        image.setSize(new Dimension(1375,815));
        image.setFont(new Font("Times New Roman", Font.BOLD, 80));
        setSize(new Dimension(1350,850));
        setVisible(true);
        setLocationRelativeTo(null);
        container=this.getContentPane();
        container.add(image,BorderLayout.CENTER);
        container.add(done,BorderLayout.SOUTH);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
