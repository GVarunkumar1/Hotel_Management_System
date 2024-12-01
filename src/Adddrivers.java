import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Adddrivers  extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4, t5;
    JComboBox comboBox, comboBox_1;
    JButton b1,b2;

    public Adddrivers() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(400, 30, 500, 370);
        add(image);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 22);
        add(heading);

        //name
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblname.setBounds(64, 70, 102, 22);
        add(lblname);

        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 20);
        add(t1);

        //age
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblage.setBounds(64, 110, 102, 22);
        add(lblage);

        t2 = new JTextField();
        t2.setBounds(174, 110, 156, 20);
        add(t2);

        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblgender.setBounds(64, 150, 102, 22);
        add(lblgender);

        comboBox = new JComboBox(new String[]{"Male", "Female"});
        comboBox.setBounds(176, 150, 154, 20);
        add(comboBox);

        //car company
        JLabel lblccompany = new JLabel("Car Company");
        lblccompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblccompany.setBounds(64, 190, 102, 22);
        add(lblccompany);

        t3 = new JTextField();
        t3.setBounds(174, 190, 156, 20);
        add(t3);

        //car model
        JLabel lblcmodel = new JLabel("Car Model");
        lblcmodel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblcmodel.setBounds(64, 230, 102, 22);
        add(lblcmodel);

        t4 = new JTextField();
        t4.setBounds(174, 230, 156, 20);
        add(t4);

        //available
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblavailable.setBounds(64, 270, 102, 22);
        add(lblavailable);

        comboBox_1 = new JComboBox(new String[]{"Available", "Busy"});
        comboBox_1.setBounds(176, 270, 154, 20);
        add(comboBox_1);

        //location
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbllocation.setBounds(64, 310, 102, 22);
        add(lbllocation);

        t5 = new JTextField();
        t5.setBounds(174, 310, 156, 20);
        add(t5);


        b1 = new JButton("Add Driver");
        b1.addActionListener(this);
        b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);


        setBounds(450, 200, 1000, 500);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                try{
                    conn c = new conn();
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String)comboBox.getSelectedItem();
                    String company  = t3.getText();
                    String brand = t4.getText();
                    String available = (String)comboBox_1.getSelectedItem();
                    String location = t5.getText();

                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }
        public static void main(String[] args) {
            new Adddrivers();
        }
    }