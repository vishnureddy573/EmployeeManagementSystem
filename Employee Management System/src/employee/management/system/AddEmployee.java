
package employee.management.system;
import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfphone,tfemail,tfadhar,tfadress,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducTion;
    JLabel labelempId,lblempId;
    JButton add,back;
    

    public AddEmployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Fathers Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary .setBounds(400, 200, 150, 30);
        labelsalary .setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary );
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdres = new JLabel("Adress");
        labeladdres .setBounds(50, 250, 150, 30);
        labeladdres .setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdres );
        tfadress = new JTextField();
        tfadress.setBounds(200, 250, 150, 30);
        add(tfadress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labelqualification = new JLabel("Highest Education");
        labelqualification.setBounds(400, 300, 150, 30);
        labelqualification.setFont(new Font("serif",Font.PLAIN,20));
        add(labelqualification);
        String courses[] = {"BTECH","MBA","BBA","BCA","BA","BSC","B.COM","MCA","PHD","MASTERS"};
        cbeducTion = new JComboBox(courses);
        cbeducTion.setBounds(600, 300, 150, 30);
        cbeducTion.setBackground(Color.WHITE);
        add(cbeducTion);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labeladhar = new JLabel("Adhar Number");
        labeladhar.setBounds(400, 350, 150, 30);
        labeladhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladhar);
        tfadhar = new JTextField();
        tfadhar.setBounds(600, 350, 150, 30);
        add(tfadhar);
        
        labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel(""+number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        add = new JButton("Add Details");
         add.setBounds(250, 550, 150, 40);
         add.addActionListener(this);
         add.setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         add(add);
         
         back = new JButton("Back");
         back.setBounds(450, 550, 150, 40);
         back.addActionListener(this);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         add(back);
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    
    
    
    public static void main(String args[]){
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String adress=tfadress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)cbeducTion.getSelectedItem();
            String designation=tfdesignation.getText();
            String adhar=tfadhar.getText();
            String empId=lblempId.getText();
            
            try {
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+adress+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added succesfully");
                setVisible(false);
                new Home();
                
            } catch (Exception a) {
                a.printStackTrace();
                
            }
            
            
        }else{
            setVisible(false);
            new Home();
            
        }
    }
}
