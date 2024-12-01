import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateCheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom, tfname, tfcinTime, tfapaid, tfapending;
    JButton check, update, back;
    updateCheck(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Status");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setBounds(90,20,200,30);
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
        roomno.setBounds(30,120,100,20);
        add(roomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblcinTime = new JLabel("Checkin Time");
        lblcinTime.setBounds(30,200,100,20);
        add(lblcinTime);

        tfcinTime = new JTextField();
        tfcinTime.setBounds(200,200,150,25);
        add(tfcinTime);

        JLabel lblapaid = new JLabel("Amount Paid");
        lblapaid.setBounds(30,240,100,20);
        add(lblapaid);

        tfapaid = new JTextField();
        tfapaid.setBounds(200,240,150,25);
        add(tfapaid);

        JLabel lblapending = new JLabel("Amount Pending");
        lblapending.setBounds(30,280,100,20);
        add(lblapending);

        tfapending = new JTextField();
        tfapending.setBounds(200,280,150,25);
        add(tfapending);

        check = new JButton("Check");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300, 200, 980, 500);
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
                    tfname.setText(rs.getString("name"));
                    tfcinTime.setText(rs.getString("checkintime"));
                    tfapaid.setText(rs.getString("deposite"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '" + tfroom.getText() + "'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfapaid.getText());
                    tfapending.setText(amountPaid + "");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            String id = ccustomer.getSelectedItem().toString();
            String room = tfroom.getText();
            String name = tfname.getText();
            String cinTime = tfcinTime.getText();
            String amount = tfapaid.getText();
            try{
                conn c = new conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+cinTime+"', deposite = '"+amount+"' where number = '"+id+"'");
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
        new updateCheck();
    }
}
