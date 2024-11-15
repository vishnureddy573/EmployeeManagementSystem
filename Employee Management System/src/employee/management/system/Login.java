
package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    
    JTextField tfuser,tfpswd;

     Login()  {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusr = new JLabel("User Name");
         lblusr.setBounds(40, 20, 100, 30);
         add(lblusr);
         tfuser = new JTextField();
         tfuser.setBounds(150, 20, 150, 30);
         add(tfuser);
         
         JLabel pswd = new JLabel("Password");
         pswd.setBounds(40, 70, 100, 30);
         add(pswd);
         tfpswd = new JTextField();
         tfpswd.setBounds(150, 70, 150, 30);
         add(tfpswd);
         
         JButton login = new JButton("LOGIN");
         login.setBounds(80, 140, 150, 30);
         login.setBackground(Color.black);
         login.setForeground(Color.white);
         login.addActionListener(this);
         add(login);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.jpeg"));
         Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(350, 0, 200, 200);
         add(image);
         
         
         
         
         
         
       
         setSize(600,300);
         setLocation(450,200);
         setVisible(true);
    }
     
    
     @Override
    public void actionPerformed(ActionEvent e) {
         try {
             String username = tfuser.getText();
             String password =tfpswd.getText();
             Conn c = new Conn();
             String Query ="select * from login where username ='"+username+"' and password = '"+password+"'";
             
             
             ResultSet rs = c.s.executeQuery(Query);
             if(rs.next()){
                 setVisible(false);
                 new Home();
             }else{
                 JOptionPane.showMessageDialog(null, "invalid username or password");
                 setVisible(false);
             }
         } catch (Exception c) {
             c.printStackTrace();
             
         }
    }
    
    public static void main(String args[]){
        new Login();
    }

   

    
    
}
