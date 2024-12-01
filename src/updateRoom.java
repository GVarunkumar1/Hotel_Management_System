import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfclStatus, tfapaid, tfapending;
    JButton check, update, back;
    updateRoom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 25));
        heading.setBounds(30,20,250,30);
        heading.setForeground(Color.BLACK);
        add(heading);

        //customer id
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(30,130,100,20);
        add(roomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30,180,100,20);
        add(lblavailable);

        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblclStatus = new JLabel("Cleaning Status");
        lblclStatus.setBounds(30,230,100,20);
        add(lblclStatus);

        tfclStatus = new JTextField();
        tfclStatus.setBounds(200,230,150,25);
        add(tfclStatus);

        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300, 200, 980, 450);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem().toString();
            String query = "select * from customer where number = '" + id + "'";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '" + tfroom.getText() + "'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfclStatus.setText(rs2.getString("cleaningStatus"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            String id = ccustomer.getSelectedItem().toString();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String clStatus = tfclStatus.getText();
            try{
                conn c = new conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaningStatus = '"+clStatus+"' where roomno = '"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new updateRoom();
    }
}
