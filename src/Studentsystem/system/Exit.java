package Studentsystem.system;

import javax.swing.*;
import java.awt.*;

/**
 * @author shkstart
 * @create 2022-12-09 14:58
 */
public class Exit extends JFrame {JButton done=new JButton("OK");
    JLabel image=new JLabel();
    Container container;
    ImageIcon icon=new ImageIcon("D:\\Mateial\\Bye.png");
    public Exit(){
        super("Page");
        image=new JLabel(icon);
        image.setSize(new Dimension(1375,815));
        image.setFont(new Font("Times New Roman", Font.BOLD, 80));
        setSize(new Dimension(1375,850));
        setVisible(true);
        setLocationRelativeTo(null);
        container=this.getContentPane();
        container.add(image,BorderLayout.CENTER);
        container.add(done,BorderLayout.SOUTH);
    }
}
