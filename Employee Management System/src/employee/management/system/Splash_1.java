
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Splash extends JFrame implements ActionListener{
 
    
     Splash() {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
         add(heading);
         heading.setBounds(110, 30, 1200, 50);
         heading.setFont(new Font("serif",Font.PLAIN,50));
         heading.setForeground(Color.RED);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.png"));
         Image i2 =i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(50, 100, 1050, 500);
         add(image);
         
         JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
         clickhere.setBounds(400, 400, 300, 70);
         clickhere.setBackground(Color.black);
         clickhere.setForeground(Color.white);
         clickhere.addActionListener(this);
         image.add(clickhere);
         
         
         
     
         setSize(1170,650);
         setLocation(200, 50);
         setVisible(true);
         while (true) {
             heading.setVisible(true);
             try {
                 Thread.sleep(500);
             } catch (Exception e) {
             }
             heading.setVisible(false);
             try {
                 Thread.sleep(500);
             } catch (Exception e) {
             }
         }
         
        
         
         
         
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
         new Splash();
    }

    
    
}
