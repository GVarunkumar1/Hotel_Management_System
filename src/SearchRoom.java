import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable t1;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblSearchRoom = new JLabel("Search For Room");
        lblSearchRoom.setForeground(Color.BLACK);
        lblSearchRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSearchRoom.setBounds(400, 30, 200, 30);
        add(lblSearchRoom);

        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setBounds(50, 100, 100, 20);
        add(lblBedType);
        bedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("display only available rooms");
        available.setBounds(650, 100, 200, 25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);
        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);

        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 300);
        add(t1);

        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from room");
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
                String query1 = "select * from room where bedType = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' and bedType = '"+bedType.getSelectedItem()+"'";

                conn con = new conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = con.s.executeQuery(query2);
                }else{
                    rs = con.s.executeQuery(query1);

                }
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
