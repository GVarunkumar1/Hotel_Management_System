import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addrooms  extends JFrame implements ActionListener {
    JButton addroomBT, cancel;
    JTextField tfroomno, tfprice;
    JComboBox availablecombo, cleancombo, btypecombo;

    Addrooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Room");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        //Room number
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);

        //availability
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        //cleaning options
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        //Room price
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        //bed type
        JLabel lblbtype = new JLabel("Bed Type");
        lblbtype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblbtype.setBounds(60, 280, 120, 30);
        add(lblbtype);

        String btypeOptions[] = {"Single Bed", "Double Bed"};
        btypecombo = new JComboBox(btypeOptions);
        btypecombo.setBounds(200,280,150,30);
        btypecombo.setBackground(Color.WHITE);
        add(btypecombo);

        //Add room button
        addroomBT = new JButton("Add Room");
        addroomBT.setForeground(Color.WHITE);
        addroomBT.setBackground(Color.BLACK);
        addroomBT.setBounds(60,350,130,30);
        addroomBT.addActionListener(this);
        add(addroomBT);

        //cancel button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,40,500,300);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addroomBT){
            String roomno = tfroomno.getText();
            String available = availablecombo.getSelectedItem().toString();
            String clean = cleancombo.getSelectedItem().toString();
            String price = tfprice.getText();
            String btype = btypecombo.getSelectedItem().toString();

            try{
                conn con = new conn();
                String str = "insert into room values('"+roomno+"','"+available+"','"+clean+"','"+price+"','"+btype+"')";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Addrooms();
    }
}
