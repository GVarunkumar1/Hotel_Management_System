import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Addcustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfno, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JLabel lbltime;
    JButton addc, cancel;

    Addcustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //heading
        JLabel heading = new JLabel("New Customer Form");
        heading.setBounds(100, 20, 300, 30);
        heading.setFont(new Font("Raleway" , Font.BOLD, 20));
        add(heading);

        //id
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblid);

        String idoptions[] = {"Aadhar Card", "Passport", "Driving License", "Voter-ID Card", "Ration Card"};
        comboid = new JComboBox(idoptions);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        //number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblnumber);

        tfno = new JTextField();
        tfno.setBounds(200, 120, 150, 25);
        add(tfno);

        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblgender);

        //male radio button
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 200, 60, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        //female radio button
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270, 200, 80, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        //country
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        //allocated room
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 100, 20);
        lblroom.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();
        try{
            conn con = new conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200, 280, 150, 25);
        add(croom);

        //Checkin time
        JLabel lblckntime = new JLabel("Check-in Time");
        lblckntime.setBounds(35, 320, 100, 20);
        lblckntime.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lblckntime);

        Date date = new Date();

        lbltime = new JLabel("" + date);
        lbltime.setBounds(200, 320, 150, 25);
        lbltime.setFont(new Font("Raleway" , Font.PLAIN, 16));
        add(lbltime);

        //deposit
        JLabel lbldeopsit = new JLabel("Deposit");
        lbldeopsit.setBounds(35, 360, 100, 20);
        lbldeopsit.setFont(new Font("Raleway" , Font.PLAIN, 20));
        add(lbldeopsit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);

        //add customer button
        addc = new JButton("Add Customer");
        addc.setBounds(50, 410, 120, 30);
        addc.setBackground(Color.BLACK);
        addc.setForeground(Color.WHITE);
        addc.addActionListener(this);
        add(addc);

        //cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 410, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 50, 300, 400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addc){
            String id = (String)comboid.getSelectedItem();
            String no = tfno.getText();
            String name = tfname.getText();
            String gender = null;
            if(rbmale.isSelected()){
                gender = "Male";
            }
            else if(rbfemale.isSelected()){
                gender = "Female";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem().toString();
            String time = lbltime.getText();
            String deposit = tfdeposit.getText();

            try{
                String query = "insert into customer values('"+id+"','"+no+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomno = '"+room+"'";
                conn con = new conn();
                con.s.executeUpdate(query);
                con.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully!!");
                setVisible(false);
                new Reception();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Addcustomer();
    }
}
