package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cEmpId;
    JButton delete, back;
    JLabel lblname, lblphone, lblemail;

    public RemoveEmployee() {
        setTitle("Remove Employee");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 50, 100, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try {
            Conn c = new Conn();
            String query = "select empId from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(200, 100, 150, 30);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        lblphone = new JLabel();
        lblphone.setBounds(200, 150, 150, 30);
        add(lblphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        lblemail = new JLabel();
        lblemail.setBounds(200, 200, 150, 30);
        add(lblemail);

        loadEmployeeDetails();

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                loadEmployeeDetails();
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 600, 400);
        add(image);

        setSize(1000, 500);
        setLocation(300, 100);
        setVisible(true);
    }

    private void loadEmployeeDetails() {
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            } else {
                lblname.setText("");
                lblphone.setText("");
                lblemail.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empId = '" + cEmpId.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                cEmpId.remove(cEmpId.getSelectedItem());
                lblname.setText("");
                lblphone.setText("");
                lblemail.setText("");
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]) {
        new RemoveEmployee();
    }
}
