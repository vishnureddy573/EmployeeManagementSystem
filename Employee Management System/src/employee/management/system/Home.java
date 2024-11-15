
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,update,view,remove;
    Home(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i2 =i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0, 1120, 630);
         add(image);
         
         
        JLabel heading = new JLabel("Employee Management System");
         image.add(heading);
         heading.setBounds(610, 20, 400, 40);
         heading.setFont(new Font("TAHOMA",Font.BOLD,25));
         heading.setForeground(Color.red);
         
         add = new JButton("Add Employee");
         add.setBounds(650, 80, 150, 40);
         add.addActionListener(this);
         image.add(add);
         view = new JButton("View Employee");
         view.setBounds(820, 80, 150, 40);
         view.addActionListener(this);
         image.add(view); 
         update = new JButton("Update Employee");
         update.setBounds(650, 140, 150, 40);
         update.addActionListener(this);
         image.add(update); 
         remove = new JButton("Remove Employee");
         remove.setBounds(820, 140, 150, 40);
         remove.addActionListener(this);
         image.add(remove); 
         
        setSize(1120,630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            setVisible(false);
            new AddEmployee();
            
        }else if(e.getSource() == view){
            setVisible(false);
            new ViewEmployee();
            
        }else if(e.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
