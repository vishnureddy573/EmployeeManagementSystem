
package employee.management.system;
import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    

    
    JTextField tfname,tfeducation,tffname,tfsalary,tfphone,tfemail,tfadhar,tfadress,tfdesignation;
    
    JLabel labelempId,lblempId;
    JButton add,back;
    String empId;

    public UpdateEmployee(String empId) {
        this.empId=empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
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
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
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
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        tfeducation.setBackground(Color.WHITE);
        add(tfeducation);
        
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
        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600, 350, 150, 30);
        add(lbladhar);
        
        labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
                lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try {
            Conn c=new Conn();
            String query ="select * from employee where empId = '"+empId+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()) {  
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfadress.setText(rs.getString("adress"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lbladhar.setText(rs.getString("adhar"));
                tfdesignation.setText(rs.getString("designation"));
                lblempId.setText(rs.getString("empId"));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        add = new JButton("Update Details Details");
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
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            String fname=tffname.getText();
            String salary=tfsalary.getText();
            String adress=tfadress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
            
            try {
                Conn conn=new Conn();
                String query = "update employee set fname='" + fname + "', salary='" + salary + "', adress='" + adress + "', phone='" + phone + "', email='" + email + "', education='" + education + "', designation='" + designation + "' where empId='" + empId + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated succesfully");
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
