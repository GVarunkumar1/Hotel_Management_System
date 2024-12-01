import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchDriver extends JFrame implements ActionListener {
    JTable t1;
    JButton back, submit;
    Choice carType;
    SearchDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblSearchRoom = new JLabel("PickUp Service");
        lblSearchRoom.setForeground(Color.BLACK);
        lblSearchRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSearchRoom.setBounds(400, 30, 200, 30);
        add(lblSearchRoom);

        JLabel lblBedType = new JLabel("Type of Car");
        lblBedType.setBounds(50, 100, 100, 20);
        add(lblBedType);

        carType = new Choice();
        carType.setBounds(150, 100, 200, 25);
        add(carType);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                carType.addItem(rs.getString("brand"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 300);
        add(t1);

        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from driver");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        submit = new JButton("submit");
        submit.setBounds(300, 520, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1000, 600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }else if(e.getSource()==submit){
            try{
                String query = "select * from driver where brand = '"+carType.getSelectedItem()+"'";

                conn con = new conn();
                ResultSet rs;
                rs = con.s.executeQuery(query);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new SearchDriver();
    }
}
