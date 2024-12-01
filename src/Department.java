import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    JTable t1;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(130, 10, 100, 20);
        add(l1);
        JLabel l2 = new JLabel("Budjet");
        l2.setBounds(420, 10, 100, 20);
        add(l2);

        t1 = new JTable();
        t1.setBounds(0, 50, 700, 350);
        add(t1);

        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from Department");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280, 400, 120, 30);
        add(back);

        setBounds(400,200,700, 500);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Department();
    }
}
