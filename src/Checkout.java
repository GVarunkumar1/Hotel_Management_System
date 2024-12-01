import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomno, cint, coutt;
    JButton checkout, back;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Checkout");
        heading.setBounds(100,20,150,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

        lblroomno = new JLabel();
        lblroomno.setBounds(150,130,100,30);
        add(lblroomno);

        JLabel lblcinTime = new JLabel("Checkin Time");
        lblcinTime.setBounds(30,180,100,30);
        add(lblcinTime);

        cint = new JLabel();
        cint.setBounds(150,180,100,30);
        add(cint);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomno.setText(rs.getString("room"));
                cint.setText(rs.getString("checkintime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblcoutTime = new JLabel("Checkin Time");
        lblcoutTime.setBounds(30,230,100,30);
        add(lblcoutTime);

        Date date = new Date();

        coutt = new JLabel("" + date);
        coutt.setBounds(150,230,150,30);
        add(coutt);

        checkout = new JButton("Checkout");
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350,50,400,250);
        add(image1);


        setBounds(300,200,800,400);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomno = '"+lblroomno.getText()+"'";

            try{
                conn c = new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Done!");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Checkout();
    }
}
